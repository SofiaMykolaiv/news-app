package com.example.news_app.presentation.search

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.news_app.R
import com.example.news_app.presentation.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_search.*
import org.koin.android.ext.android.inject

class SearchFragment() : BaseFragment<SearchViewModel>() {

    companion object {
        fun newInstance() = SearchFragment()
    }

    override val viewModel by inject<SearchViewModel>()

    override fun getLayoutRes() = R.layout.fragment_search

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        button_minus.setOnClickListener {
            viewModel.setNegativeScoreData()
        }

        button_plus.setOnClickListener {
            viewModel.setPositiveScoreData()
        }

        button_divide_zero.setOnClickListener {
            viewModel.setDivideByZeroScoreData()
        }

        viewModel.scoreLiveData.observe(viewLifecycleOwner, Observer {
            text_result.text = it.toString()
        })

        viewModel.errorMessageLiveData.observe(viewLifecycleOwner, Observer { exceptionMessage ->
            Toast.makeText(context, exceptionMessage, Toast.LENGTH_SHORT).show()
        })

    }
}
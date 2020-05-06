package com.example.news_app.presentation.base

import android.app.AlertDialog
import android.os.Bundle
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import com.example.news_app.R

abstract class BaseFragment<VM : BaseViewModel> : Fragment(), LifecycleOwner {

    protected abstract val viewModel: VM

    protected var progressDialog: AlertDialog? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(getLayoutRes(), container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
//        activity?.onBackPressedDispatcher?.addCallback(viewLifecycleOwner) { onBackPressed() }
    }

    open fun onBackPressed() {
//        findNavController().popBackStack()
    }

    @LayoutRes
    protected abstract fun getLayoutRes(): Int

    protected fun getPrimaryColor() = context?.let {
        val colorValue = TypedValue()
        it.theme.resolveAttribute(R.attr.colorPrimary, colorValue, true)
        colorValue.data
    }

    protected fun navigateSafe(
        @IdRes resId: Int,
        args: Bundle? = null
//        ,
//        navOptions: NavOptions? = null,
//        navExtras: Navigator.Extras? = null
    ) {
//        val action = findNavController().currentDestination?.getAction(resId)
//            ?: findNavController().graph.getAction(resId)
//        if (action != null && findNavController().currentDestination?.id != action.destinationId) {
//            findNavController().navigate(resId, args, navOptions, navExtras)
//        }
    }

//    protected fun showLoading() = context?.let {
//        progressDialog = createProgressBar(it)
//        progressDialog?.show()
//    }
//
//    protected fun hideLoading() {
//        progressDialog?.dismiss()
//        progressDialog = null
//    }
}
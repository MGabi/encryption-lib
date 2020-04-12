package com.mgabbi.encryption.shared.base

import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import com.mgabbi.encryption.BR
import com.mgabbi.encryption.shared.utils.activityBinding
import com.mgabbi.encryption.shared.utils.views.LoadingDialog

abstract class BaseActivity<BINDING : ViewDataBinding, VIEW_MODEL : ViewModel>
constructor(@LayoutRes private val layoutResource: Int) : AppCompatActivity() {

    protected val binding by activityBinding<BINDING>(layoutResource)
    protected abstract val viewModel: VIEW_MODEL
    var loadingDialog: LoadingDialog? = null

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.also {
            it.lifecycleOwner = this
            it.setVariable(BR.viewModel, viewModel)
        }
        loadingDialog = LoadingDialog(this)
        setupViews()
    }

    override fun onDestroy() {
        super.onDestroy()
        loadingDialog = null
    }

    abstract fun setupViews()
}

package com.mgabbi.encryption.shared.utils.views

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import com.mgabbi.encryption.databinding.LoadingDialogBinding

class LoadingDialog(context: Context) : Dialog(context) {
    private val binding = LoadingDialogBinding.inflate(LayoutInflater.from(context))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        window?.decorView?.setBackgroundColor(Color.TRANSPARENT)
        setCancelable(false)
    }
}

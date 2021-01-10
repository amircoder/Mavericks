package com.multithread.dindinntest.ui.custom

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Window
import com.multithread.dindinntest.databinding.DialogLoaderBinding

class LoaderDialog(context: Context) : Dialog(context) {

    private lateinit var binding: DialogLoaderBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        binding = DialogLoaderBinding.inflate(LayoutInflater.from(context))
        window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT));
        setCancelable(false)
        setTitle(null)
        setOnCancelListener(null)
        setContentView(binding.root)
    }

    companion object {
        fun newInstance(context: Context) = LoaderDialog(context)
    }
}
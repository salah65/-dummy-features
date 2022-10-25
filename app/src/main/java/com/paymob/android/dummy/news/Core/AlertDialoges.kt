package com.example.nytimesapp.Core

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface

lateinit var error: AlertDialog


fun showDialog(
    context: Context?,
    message: String?,
    btnString: String? = "ok",
    title: String,
    listener: (DialogInterface) -> Unit = { error.dismiss() }
) {
    error = AlertDialog.Builder(context)
        .setMessage(message)
        .setTitle(title)
        .setNegativeButton(btnString) { dialog, _ ->
            listener(dialog)
        }
        .show()
}







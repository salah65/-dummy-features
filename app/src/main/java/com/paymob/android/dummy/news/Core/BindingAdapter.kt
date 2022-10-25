package com.budiyev.android.libdemoapp.news.Core

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

@BindingAdapter("android:src_Url")
fun loadUrl(view: ImageView, url: String?) {
    if (!url.isNullOrEmpty())
        Glide.with(view.context).load(url).into(view)

}

@BindingAdapter("android:formatToDate")
fun formatDate(view: TextView, date: String) {
    val format: DateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH)
    val dateObj: Date? = format.parse(date)
    //convert date to string
    val pattern = "MMM.dd, yyyy"
    val simpleDateFormat = SimpleDateFormat(pattern, Locale.US)
    view.text = simpleDateFormat.format(dateObj!!)

}
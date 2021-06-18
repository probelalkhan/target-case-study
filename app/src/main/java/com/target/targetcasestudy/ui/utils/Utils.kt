@file:Suppress("DEPRECATION")

package com.target.targetcasestudy.ui.utils

import android.content.Context
import android.net.Uri
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.facebook.drawee.view.SimpleDraweeView
import com.google.android.material.snackbar.Snackbar
import com.target.targetcasestudy.R
import com.target.targetcasestudy.data.network.Resource
import com.target.targetcasestudy.ui.base.BaseRecyclerViewAdapter

fun View.show() {
    this.visibility = View.VISIBLE
}

fun View.hide() {
    this.visibility = View.GONE
}

fun View.enabled(enabled: Boolean) {
    this.isEnabled = enabled
}

fun SimpleDraweeView.loadImage(url: String) {
    this.setImageURI(Uri.parse(url))
}

fun Fragment.snackbar(msg: String, action: (() -> Unit)? = null) {
    Snackbar.make(
        requireView(),
        msg,
        Snackbar.LENGTH_LONG
    ).also {
        it.setAction(
            getString(R.string.retry)
        ) { action?.invoke() }
    }.show()
}

fun Fragment.handleApiError(
    error: Resource.Failure,
    progressBar: ProgressBar? = null,
    retry: (() -> Unit)? = null
) {
    progressBar?.hide()
    if (error.isNetworkError) {
        snackbar(getString(R.string.internet_error))
    } else {
        snackbar(getString(R.string.api_error, error.errorCode, error.errorCode.toString()))
    }
    retry?.invoke()
}

fun <T : Any, VB : ViewBinding> RecyclerView.setUpRecyclerView(
    context: Context,
    adapter: BaseRecyclerViewAdapter<T, VB>,
    layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(context),
    itemClickListener: ((itemView: View, item: T, position: Int) -> Unit)? = null
) {
    this.layoutManager = layoutManager
    this.setHasFixedSize(true)
    this.adapter = adapter
    adapter.itemClickListener = itemClickListener
}
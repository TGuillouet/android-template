package fr.tguillouet.template.common.extensions

import android.view.View
import androidx.annotation.StringRes
import com.google.android.material.snackbar.Snackbar


fun snackbar(@StringRes message: Int, rootView: View) = Snackbar.make(rootView, message, Snackbar.LENGTH_SHORT).show()

fun snackbar(message: String, rootView: View) = Snackbar.make(rootView, message, Snackbar.LENGTH_SHORT).show()
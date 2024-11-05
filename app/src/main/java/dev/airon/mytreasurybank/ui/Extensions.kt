@file:Suppress("DEPRECATION")

package dev.airon.mytreasurybank.ui

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import dev.airon.mytreasurybank.R

fun Fragment.initToolbar(toolbar: Toolbar, homeAsUpEnabled: Boolean = true){
    (activity as AppCompatActivity).setSupportActionBar(toolbar)
    (activity as AppCompatActivity).title = ""
    (activity as AppCompatActivity).supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_arrow_left_s_line)
    (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(homeAsUpEnabled)
    toolbar.setNavigationOnClickListener {
        activity?.onBackPressed()
    }
}
package com.dkexception.newarchitecturewithhilt.extensions

import android.view.View

fun View.setOnClickAction(runnable: Runnable) {
    setOnClickListener {
        runnable.run()
    }
}

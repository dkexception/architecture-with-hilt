package com.dkexception.newarchitecturewithhilt.utils

import android.view.LayoutInflater
import android.view.ViewGroup

typealias Inflate<T> = (LayoutInflater, ViewGroup?, Boolean) -> T

object Utils {
    const val lineSeparator = "line.separator"
}

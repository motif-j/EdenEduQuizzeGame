package com.motifdev.edenedu.listeners

import com.motifdev.edenedu.models.Course

interface ListClickListener<T> {
    fun onItemClicked(item:T){}
}
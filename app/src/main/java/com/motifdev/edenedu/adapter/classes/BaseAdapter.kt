package com.motifdev.edenedu.adapter.classes

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.motifdev.edenedu.listeners.ListClickListener

abstract class BaseAdapter<T,VH:RecyclerView.ViewHolder>(callback:DiffUtil.ItemCallback<T>): ListAdapter<T, VH>(callback) {

    protected var clickListener:ListClickListener<T>?=null

    fun registerClickListener(clickListener: ListClickListener<T>?){
        this.clickListener=clickListener
    }
}

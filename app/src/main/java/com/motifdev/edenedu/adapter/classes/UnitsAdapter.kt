package com.motifdev.edenedu.adapter.classes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.motifdev.edenedu.adapter.views.CourseUnitViewHolder
import com.motifdev.edenedu.databinding.ViewUnitItemBinding

import com.motifdev.edenedu.models.CourseUnit

class UnitsAdapter : BaseAdapter<CourseUnit, CourseUnitViewHolder>(object :
    DiffUtil.ItemCallback<CourseUnit>() {
    override fun areItemsTheSame(oldItem: CourseUnit, newItem: CourseUnit): Boolean {
        return oldItem.unitId == newItem.unitId
    }

    override fun areContentsTheSame(oldItem: CourseUnit, newItem: CourseUnit): Boolean {
        return oldItem.unitId == newItem.unitId
    }

}) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseUnitViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ViewUnitItemBinding.inflate(inflater,parent,false)

        return CourseUnitViewHolder(binding)

    }

    override fun onBindViewHolder(holder: CourseUnitViewHolder, position: Int) {

    }
}
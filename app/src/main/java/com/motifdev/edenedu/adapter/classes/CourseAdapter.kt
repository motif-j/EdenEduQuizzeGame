package com.motifdev.edenedu.adapter.classes

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.motifdev.edenedu.adapter.views.CourseViewHolder
import com.motifdev.edenedu.databinding.ViewSubjectItemBinding
import com.motifdev.edenedu.models.Course

class CourseAdapter : BaseAdapter<Course, CourseViewHolder>(object :
    DiffUtil.ItemCallback<Course>() {
    override fun areContentsTheSame(oldItem: Course, newItem: Course): Boolean {
        return oldItem.subjectId == newItem.subjectId
    }

    override fun areItemsTheSame(oldItem: Course, newItem: Course): Boolean {
        return oldItem.subjectId == newItem.subjectId
    }
}) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ViewSubjectItemBinding.inflate(inflater, parent, false)
        return CourseViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        holder.bindView(getItem(position))
        holder.binding.root.setOnClickListener {
            clickListener?.onItemClicked(getItem(position))
        }
    }
}
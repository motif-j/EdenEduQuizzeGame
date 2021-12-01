package com.motifdev.edenedu.adapter.views

import androidx.recyclerview.widget.RecyclerView
import com.motifdev.edenedu.databinding.ViewSubjectItemBinding
import com.motifdev.edenedu.models.Course

class CourseViewHolder(var binding:ViewSubjectItemBinding):RecyclerView.ViewHolder(binding.root) {

    fun bindView(course:Course){
        binding.courseTitle.text=course.subjectTitle
    }
}
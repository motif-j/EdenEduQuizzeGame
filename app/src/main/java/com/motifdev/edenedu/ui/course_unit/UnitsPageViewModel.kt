package com.motifdev.edenedu.ui.course_unit

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.motifdev.edenedu.models.CourseUnit

class UnitsPageViewModel:ViewModel() {
    val courseUnitsLiveData =MutableLiveData<List<CourseUnit>>()
        .apply {
            value=ArrayList<CourseUnit>()
                .apply {
                    add(CourseUnit("xxx","Calculus"))
                    add(CourseUnit("xxx","Linear Algebra"))
                    add(CourseUnit("xxx","Mutivariate Calculus"))
                    add(CourseUnit("xxx","Loci"))
                    add(CourseUnit("xxx","Statistics"))
                }
        }
}
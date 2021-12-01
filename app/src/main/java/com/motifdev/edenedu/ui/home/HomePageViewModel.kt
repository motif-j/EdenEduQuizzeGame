package com.motifdev.edenedu.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.motifdev.edenedu.models.Course

class HomePageViewModel : ViewModel() {
    val coursesLiveData = MutableLiveData<List<Course>>()
        .apply {
            value = ArrayList<Course>()
                .apply {
                    add(Course("xxx", "Mathematics"))
                    add(Course("xxx", "Chemistry"))
                    add(Course("xxx", "Biology"))
                    add(Course("xxx", "Physics"))
                }
        }


}
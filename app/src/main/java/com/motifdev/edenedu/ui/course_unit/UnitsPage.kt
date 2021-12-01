package com.motifdev.edenedu.ui.course_unit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.motifdev.edenedu.adapter.classes.UnitsAdapter
import com.motifdev.edenedu.databinding.FragmentUnitsPageBinding
import com.motifdev.edenedu.models.Course
import com.motifdev.edenedu.utils.BundleUtils

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [UnitsPage.newInstance] factory method to
 * create an instance of this fragment.
 */
class UnitsPage : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var courseTitle: String = ""
    private var course: Course? = null

    private var _binding: FragmentUnitsPageBinding? = null
    private val binding get() = _binding!!
    private val unitsAdapter by lazy {
        UnitsAdapter()
    }
    private val unitsPageViewModel: UnitsPageViewModel by lazy {
        UnitsPageViewModel()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
            course = it.getSerializable(BundleUtils.COURSE_CONST) as Course
        }
        course?.let {
            courseTitle = it.subjectTitle
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentUnitsPageBinding.inflate(inflater, container, false)
        binding.courseTitle.text = courseTitle

        // Inflate the layout for this fragment
        binding.unitsRecyclerView.adapter = unitsAdapter

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        NavigationUI.setupWithNavController(binding.toolbar, findNavController())

        unitsPageViewModel.courseUnitsLiveData.observe(viewLifecycleOwner,{
            unitsAdapter.submitList(it)

        })

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment UnitsPage.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            UnitsPage().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
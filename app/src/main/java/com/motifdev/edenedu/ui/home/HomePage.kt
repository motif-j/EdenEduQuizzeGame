package com.motifdev.edenedu.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.motifdev.edenedu.R
import com.motifdev.edenedu.adapter.classes.CourseAdapter
import com.motifdev.edenedu.databinding.FragmentHomePageBinding
import com.motifdev.edenedu.listeners.ListClickListener
import com.motifdev.edenedu.models.Course
import com.motifdev.edenedu.utils.BundleUtils
import kotlin.coroutines.coroutineContext

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomePage.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomePage : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var _binding: FragmentHomePageBinding? = null
    private val binding get() = _binding!!
    private val homeViewModel: HomePageViewModel by viewModels()
    private var bundle = Bundle()

    private val courseAdapter by lazy {
        CourseAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
            bundle = it
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentHomePageBinding.inflate(inflater, container, false)

        binding.subjectsRecyclerView.adapter = courseAdapter
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        courseAdapter.registerClickListener(object : ListClickListener<Course> {
            override fun onItemClicked(item: Course) {
                super.onItemClicked(item)
                bundle.putSerializable(BundleUtils.COURSE_CONST, item)
                findNavController().navigate(R.id.action_homePage_to_unitsPage,bundle)

            }
        })
        homeViewModel.coursesLiveData.observe(viewLifecycleOwner, {
            courseAdapter.submitList(it)
        })


    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomePage.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomePage().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
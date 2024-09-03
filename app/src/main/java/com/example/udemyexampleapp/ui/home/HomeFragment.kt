package com.example.udemyexampleapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.udemyexampleapp.MainActivity
import com.example.udemyexampleapp.databinding.FragmentHomeBinding
import com.google.android.material.badge.ExperimentalBadgeUtils

@ExperimentalBadgeUtils class HomeFragment : Fragment() {

private var _binding: FragmentHomeBinding? = null
  // This property is only valid between onCreateView and
  // onDestroyView.
  private val binding get() = _binding!!
    private lateinit var mainActivity: MainActivity

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

    _binding = FragmentHomeBinding.inflate(inflater, container, false)
    val root: View = binding.root

    mainActivity = (activity as MainActivity)
      val addToCartButton1 = binding.addToCartButton1
      addToCartButton1.setOnClickListener{
          val model = mainActivity.GetModel()
          model.addItem("bag")
          mainActivity.HandleBadgeLogic()
      }

      val addToCartButton2 = binding.addToCartButton2
      addToCartButton2.setOnClickListener {
          val model = mainActivity.GetModel()
          model.addItem("ring")
          mainActivity.HandleBadgeLogic()
      }

    return root
  }

override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
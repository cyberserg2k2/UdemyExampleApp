package com.example.udemyexampleapp.ui.gallery

import Model
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.udemyexampleapp.MainActivity
import com.example.udemyexampleapp.databinding.FragmentGalleryBinding
import com.google.android.material.badge.ExperimentalBadgeUtils

@ExperimentalBadgeUtils class GalleryFragment : Fragment() {

private var _binding: FragmentGalleryBinding? = null
  // This property is only valid between onCreateView and
  // onDestroyView.
  private val binding get() = _binding!!
    private lateinit var model: Model
    private lateinit var mainActivity: MainActivity

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    val galleryViewModel =
            ViewModelProvider(this).get(GalleryViewModel::class.java)

    _binding = FragmentGalleryBinding.inflate(inflater, container, false)
    val root: View = binding.root

      mainActivity = (activity as MainActivity)
      model = mainActivity.GetModel()

      val checkoutButton = binding.checkoutButton
      val bagCountText = binding.bagCount
      val ringCountText = binding.ringCount

      val bagCount = model.getCountOfItem("bag")
      bagCountText.text = bagCount!!.toString()

      val ringCount = model.getCountOfItem("ring")
      ringCountText.text = ringCount!!.toString()

      checkoutButton.setOnClickListener {
          model.clearItems()
          bagCountText.text = "0"
          ringCountText.text = "0"
          mainActivity.HandleBadgeLogic()
      }

    return root
  }

override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
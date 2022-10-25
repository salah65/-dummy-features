package com.budiyev.android.libdemoapp.news.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.budiyev.android.libdemoapp.databinding.DetailsFragmentBinding
import com.budiyev.android.libdemoapp.news.model.Article

class DetailsFragment : Fragment() {
    lateinit var binding: DetailsFragmentBinding
    lateinit var article: Article
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        article = arguments?.get("article") as Article
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DetailsFragmentBinding.inflate(layoutInflater)
        binding.article = article
        binding.backBtn.setOnClickListener {
            findNavController().navigateUp()
        }
        return binding.root
    }
}
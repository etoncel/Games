package com.example.sm4sh.ui.intro_walkthrough


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController

import com.example.sm4sh.R
import com.example.sm4sh.domain.WalkThroughUseCase
import kotlinx.android.synthetic.main.fragment_walkthrough_first.*


class WalkThroughFragmentFirst : Fragment() {

    private val walkThroughUseCase = WalkThroughUseCase()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_walkthrough_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        walkThroughFragmentFirstNextButton.setOnClickListener{
            walkThroughUseCase.goToNextSlide(this)
        }
    }


}

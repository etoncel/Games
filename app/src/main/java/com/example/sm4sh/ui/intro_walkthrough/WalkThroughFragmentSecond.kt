package com.example.sm4sh.ui.intro_walkthrough


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController

import com.example.sm4sh.R
import kotlinx.android.synthetic.main.fragment_walkthrough_first.*
import kotlinx.android.synthetic.main.fragment_walkthrough_second.*


class WalkThroughFragmentSecond : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_walkthrough_second, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        walkThroughFragmentSecondNextButton.setOnClickListener{
            findNavController().navigate(R.id.next_action)
        }
    }

}

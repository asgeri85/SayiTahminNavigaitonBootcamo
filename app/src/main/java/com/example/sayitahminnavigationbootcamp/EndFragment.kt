package com.example.sayitahminnavigationbootcamp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.sayitahminnavigationbootcamp.databinding.FragmentEndBinding
import com.example.sayitahminnavigationbootcamp.databinding.FragmentGameBinding

class EndFragment : Fragment() {
    private var _binding: FragmentEndBinding?=null
    private val binding get() = _binding!!
    private val args:EndFragmentArgs by navArgs()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
       _binding= FragmentEndBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(args.durum){
            binding.textViewSon.text="Kazandın"
            binding.imageViewSon.setImageResource(R.drawable.win)
        }else{
            binding.textViewSon.text="Kaybettin"
            binding.imageViewSon.setImageResource(R.drawable.lose)
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }
}
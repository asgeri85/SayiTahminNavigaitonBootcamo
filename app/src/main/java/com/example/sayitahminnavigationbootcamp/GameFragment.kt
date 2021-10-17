package com.example.sayitahminnavigationbootcamp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.sayitahminnavigationbootcamp.databinding.FragmentGameBinding
import com.example.sayitahminnavigationbootcamp.databinding.FragmentHomeBinding
import kotlin.random.Random

class GameFragment : Fragment() {
    private var _binding: FragmentGameBinding?=null
    private val binding get() = _binding!!
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding= FragmentGameBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var hak=5
        var gelen:Int?=null
        val random=Random.nextInt(0,100)
        Log.e("random",random.toString())
        binding.buttonTahmin.setOnClickListener {
            val sayi=binding.editSayi.text.toString()
            if (sayi.isNotEmpty()){
                gelen=sayi.toInt()
            }else{
                Toast.makeText(context,"Sayı giriniz",Toast.LENGTH_SHORT).show()
            }

            if (hak==1){
                val action=GameFragmentDirections.actionGameFragmentToEndFragment(false)
                findNavController().navigate(action)
            }

            when {
                random==gelen -> {
                    val action=GameFragmentDirections.actionGameFragmentToEndFragment(true)
                    findNavController().navigate(action)
                }
                random> gelen!! -> {
                    hak--
                    binding.textViewYardim.text="Artırın"
                    binding.textViewHak.text=hak.toString()
                }
                random<gelen!! -> {
                    hak--
                    binding.textViewYardim.text="Azaltın"
                    binding.textViewHak.text=hak.toString()
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }
}
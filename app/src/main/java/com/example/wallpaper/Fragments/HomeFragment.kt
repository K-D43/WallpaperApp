package com.example.wallpaper.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wallpaper.Adapter.bomAdapter
import com.example.wallpaper.Model.bestofmonthModel
import com.example.wallpaper.databinding.FragmentHomeBinding
import com.google.firebase.firestore.FirebaseFirestore


class HomeFragment : Fragment() {


    lateinit var binding: FragmentHomeBinding
    lateinit var db:FirebaseFirestore

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding=FragmentHomeBinding.inflate(layoutInflater,container,false)

        db=FirebaseFirestore.getInstance()

        db.collection("bestofmonth").addSnapshotListener{value,error->
            var listBestOfMonth= arrayListOf<bestofmonthModel>()
            val data=value?.toObjects(bestofmonthModel::class.java)
            listBestOfMonth.addAll(data!!)

            binding.rcvBom.layoutManager=LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,true)
            binding.rcvBom.adapter= bomAdapter(requireContext(),listBestOfMonth)


        }


        return binding.root
    }

}


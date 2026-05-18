package com.example.onlineshopapp.repository

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.LiveData
import com.google.firebase.database.ValueEventListener
import com.example.onlineshopapp.domain.BannerModel
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DataSnapshot

class MainRepository {
    private val firebaseDatabase= FirebaseDatabase.getInstance()

    fun loadBanner(): LiveData<MutableList<BannerModel>> {
        val liveData= MutableLiveData<MutableList<BannerModel>>()
        val ref=firebaseDatabase.getReference("Banner")
        ref.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
               val list= mutableListOf<BannerModel>()
                for(childSnapshot in snapshot.children){
                    val item=childSnapshot.getValue(BannerModel::class.java)
                    item?.let { list.add(it) }
                }
                liveData.value=list
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })
        return liveData
    }
}
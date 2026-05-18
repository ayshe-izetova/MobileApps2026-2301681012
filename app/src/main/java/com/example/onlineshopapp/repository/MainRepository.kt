package com.example.onlineshopapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.onlineshopapp.domain.BannerModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MainRepository {
    private val firebaseDatabase = FirebaseDatabase.getInstance()

    fun loadBanner(): LiveData<List<BannerModel>> {
        val liveData = MutableLiveData<List<BannerModel>>()

        val ref = firebaseDatabase.getReference("Banner")

        ref.addValueEventListener(
            object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val list = mutableListOf<BannerModel>()

                    for (childSnapshot in snapshot.children) {
                        val item = childSnapshot.getValue(BannerModel::class.java)

                        item?.let {
                            list.add(it)
                        }
                    }

                    liveData.value = list
                }

                override fun onCancelled(error: DatabaseError) {
                }
            },
        )

        return liveData
    }
}

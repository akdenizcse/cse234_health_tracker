package com.cse234.healthtracker.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import com.cse234.healthtracker.data.ActivityData
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.firestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ActivityViewModel : ViewModel(){
    private val db = Firebase.firestore
    private val user = FirebaseAuth.getInstance().currentUser
    val userId = user?.uid
    private val _isLoaded = MutableStateFlow<Boolean?>(null)
    val isLoaded : StateFlow<Boolean?> = _isLoaded.asStateFlow()
    var selectedActivity = ""


    fun loadDataToFireStore(activityData : ActivityData?){
        activityData?.let {
            db.collection("activities")
                .add(it)
                .addOnSuccessListener {
                    Log.d("db", "activity added")
                    _isLoaded.value = true
                }
                .addOnFailureListener {
                    Log.d("db", "activity could not be added")
                    _isLoaded.value = false
                }
        }
    }


}
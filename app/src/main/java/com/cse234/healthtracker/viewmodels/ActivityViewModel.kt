package com.cse234.healthtracker.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cse234.healthtracker.data.ActivityData
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.firestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ActivityViewModel : ViewModel(){
    private val db = Firebase.firestore
    private val user = FirebaseAuth.getInstance().currentUser
    val userId = user?.uid
    private val _isLoaded = MutableStateFlow<Boolean?>(null)
    val isLoaded : StateFlow<Boolean?> = _isLoaded.asStateFlow()
    var selectedActivity = ""
    private val _activities = MutableStateFlow<List<ActivityData>>(emptyList())
    val activities : StateFlow<List<ActivityData>> = _activities.asStateFlow()

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

    fun fetchFromFireStore(selectedActivity : String){
        viewModelScope.launch { db.collection("activities")
            .whereEqualTo("userId", userId)
            .whereEqualTo("activityType", selectedActivity)
            .get()
            .addOnSuccessListener {result ->
                Log.d("db_fetch", "${result.documents.size} activities fetched (${selectedActivity})")
                _activities.value = result.documents.mapNotNull { it.toObject(ActivityData::class.java) }
            }
            .addOnFailureListener {
                Log.d("db_fetch", "could not fetch activities")
                Log.d("db_fetch", it.message.toString())
            }
        }
    }

    fun resetIsLoaded(){
        _isLoaded.value = null
    }


}
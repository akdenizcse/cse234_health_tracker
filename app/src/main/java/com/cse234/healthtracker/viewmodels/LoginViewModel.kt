package com.cse234.healthtracker.viewmodels


import android.content.Context
import android.util.Log
import android.util.Patterns
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.firestore


class LoginViewModel(private val context : Context , private val navController: NavHostController) : ViewModel() {
    private var isLoading = false
    private val auth = FirebaseAuth.getInstance()
    private val db = Firebase.firestore


    fun signUp(email: String , password: String ,firstName : String, lastName : String){
        if (!isLoading && isValidEmail(email)){
            isLoading = true
            Log.d("signUp_procedure","inside signUp , email is valid")
            createUserInFirebase(email, password, firstName, lastName)
        }
    }
    private fun createUserInFirebase(email : String , password : String , firstName : String, lastName : String){

        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    Log.d("SIGNUP", "createUserWithEmail --->")
                    Log.d("SIGNUP", "Is Successful : ${it.isSuccessful}")

                    val user = FirebaseAuth.getInstance().currentUser
                    val userId = user?.uid
                    Log.d("SIGNUP", "User ID : $userId")

                    val userInfo = hashMapOf(
                        "firstName" to firstName,
                        "lastName" to lastName,
                        "email" to email
                    )


                    userId?.let {
                        db.collection("users")
                            .document(it)
                            .set(userInfo)
                            .addOnSuccessListener {
                                Log.d("db_signUp", "user credentials have been stored in the database")
                                Toast.makeText(context, "db operation successful", Toast.LENGTH_SHORT).show()
                                navController.navigate("HomeScreen")
                                isLoading = false
                            }
                            .addOnFailureListener {
                                Log.d("db_signUp", "user credentials could not be stored in the database")
                                Log.d("db_signUp", "error : ${it.message}")
                                Toast.makeText(context, "db operation not successful", Toast.LENGTH_SHORT).show()
                                isLoading = false
                            }

                    }

                } else{
                    Log.d("SIGNUP", "createUserWithEmail:failure")
                    Log.d("SIGNUP", "${it.exception?.message}")
                    Toast.makeText(context, "User Registration Failed : ${it.exception?.message}", Toast.LENGTH_SHORT).show()
                    isLoading = false
                }

            }
    }

    fun signIn(email: String , password: String){
        if (!isLoading && isValidEmail(email)){
            isLoading = true
            Log.d("signIn_procedure","inside signIn , email is valid")
            signInUserInFirebase(email, password)
        }else{
            Log.d("signIn_procedure","Invalid Email")
            if (isLoading)
                Toast.makeText(context, "Please wait", Toast.LENGTH_SHORT).show()
            else if (!isValidEmail(email))
                Toast.makeText(context, "Invalid Email", Toast.LENGTH_SHORT).show()
        }

    }
    private fun signInUserInFirebase(email : String , password : String){

        auth
            .signInWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (it.isSuccessful){
                    Log.d("SIGNIN", "signInWithEmail --->")
                    Log.d("SIGNIN", "Is Successful : ${it.isSuccessful}")

                    Toast.makeText(context, "User Login Successful", Toast.LENGTH_SHORT).show()
                    navController.navigate("HomeScreen")
                }else {
                    Log.d("SIGNIN", "signInWithEmail:failure")
                    Log.d("SIGNIN", "${it.exception?.message}")
                    Toast.makeText(context, "User Login Failed", Toast.LENGTH_SHORT).show()
                }
                isLoading = false
            }
    }

    private fun isValidEmail(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

}
package com.example.sportopia.data



import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.example.sportopia.models.Applicant

import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShareViewModel: ViewModel(){

    //APPLY START
    fun savedData(
        applicantData: Applicant,
        context: Context,
    ) = CoroutineScope(Dispatchers.IO).launch{
        val fireStoreRef = Firebase.firestore
            .collection("applicants")
            .document(applicantData.applicantId.toString())
        try{
            fireStoreRef.set(applicantData)
                .addOnSuccessListener{
                    Toast.makeText(context,"APPLICATION SUCCESSFULLY SENT", Toast.LENGTH_SHORT).show()
                }

        }catch (e : Exception){
            Toast.makeText(context,e.message, Toast.LENGTH_SHORT).show()
        }

    }
    //APPLY END

    // FETCH START
    fun fetchData(
        collectionPath: String,
        context: Context,
        onDataReceived: (List<Applicant>?, String?) -> Unit){
        val firestore = Firebase.firestore
        firestore.collection(collectionPath)
            .get()
            .addOnSuccessListener { result ->
                val dataList = mutableListOf<Applicant>()
                for (document in result){
                    val data = document.toObject(Applicant::class.java)
                    dataList.add(data)
                }
                onDataReceived(dataList, null)
            }

            .addOnFailureListener{ e ->
                onDataReceived(null, e.message)

            }
    }
    //FETCH END


}


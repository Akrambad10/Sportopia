package com.example.sportopia.ui.theme.other

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.sportopia.data.ShareViewModel
import com.example.sportopia.models.Applicant
import com.example.sportopia.navigation.ROUT_HOME


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OthersScreen(navController: NavHostController){


    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        //TopAppBar
        TopAppBar(title = {
            Text(text = "OTHER ATHLETES",
                fontSize = 35.sp,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                color = Color.Black) },
            colors = TopAppBarDefaults.mediumTopAppBarColors(Color.Gray),
            navigationIcon = {
                IconButton(onClick = {
                    navController.navigate(ROUT_HOME)
                }) {
                    Icon(imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Arrowback",
                        tint = Color.White)

                }
            }
        )

        //End of TopAppBar



        val svm = ShareViewModel()
        var fetchedData by remember { mutableStateOf<List<Applicant>?>(null) }
        var errorMessage by remember { mutableStateOf<String?>(null) }

        val mContext = LocalContext.current

        LaunchedEffect(Unit) {
            svm.fetchData("applicants", context = mContext){ data, error ->
                if (error != null){
                    Toast.makeText(mContext,error, Toast.LENGTH_SHORT).show()
                    errorMessage = error
                } else{
                    Toast.makeText(mContext,"Success", Toast.LENGTH_SHORT).show()
                    fetchedData = data
                }
            }
        }


        if (fetchedData != null){
            //Display fetched data

            LazyColumn {
                itemsIndexed(fetchedData!!){index, item ->

                    // START OF CARD
                    Card(
                        modifier = Modifier
                            .padding(8.dp),
                    ) {

                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                        ) {

                            Spacer(modifier = Modifier.width(5.dp))

                            Column {

                                Row {
                                    Text(
                                        text = "First Name: ",
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 15.sp
                                    )
                                    fetchedData!![index].applicantFirstname.let {
                                        it?.let { it1 ->
                                            Text(
                                                text = it1,
                                                color = Color.Black,
                                                textAlign = TextAlign.Center,
                                                fontSize = 15.sp,
                                                fontWeight = FontWeight.Bold
                                            )


                                        }
                                    }

                                }

                                Row {
                                    Text(
                                        text = "Age: ",
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 15.sp
                                    )
                                    fetchedData!![index].applicantAge.let {
                                        it?.let { it1 ->
                                            Text(
                                                text = it1,
                                                color = Color.Black,
                                                textAlign = TextAlign.Center,
                                                fontSize = 15.sp,
                                                fontWeight = FontWeight.Bold
                                            )


                                        }
                                    }

                                }

                                Row {
                                    Text(
                                        text = "Gender: ",
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 15.sp
                                    )
                                    fetchedData!![index].applicantGender.let {
                                        it?.let { it1 ->
                                            Text(
                                                text = it1,
                                                color = Color.Black,
                                                textAlign = TextAlign.Center,
                                                fontSize = 15.sp,
                                                fontWeight = FontWeight.Bold
                                            )


                                        }
                                    }

                                }

                                Row {
                                    Text(
                                        text = "Contact: ",
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 15.sp
                                    )
                                    fetchedData!![index].applicantContact.let {
                                        it?.let { it1 ->
                                            Text(
                                                text = it1,
                                                color = Color.Black,
                                                textAlign = TextAlign.Center,
                                                fontSize = 15.sp,
                                                fontWeight = FontWeight.Bold
                                            )


                                        }
                                    }

                                }

                                Row {
                                    Text(
                                        text = "Game: ",
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 15.sp
                                    )
                                    fetchedData!![index].applicantPosition.let {
                                        it?.let { it1 ->
                                            Text(
                                                text = it1,
                                                color = Color.Black,
                                                textAlign = TextAlign.Center,
                                                fontSize = 15.sp,
                                                fontWeight = FontWeight.Bold
                                            )

                                        }
                                    }

                                }


                            }
                            Spacer(modifier = Modifier.height(5.dp))
                        }
                    } // END OF CARD


                }

            }


        } else if (errorMessage != null) {
            //Display error Message
            Text(text = errorMessage!!)
        } else {
            // Loading indicator while data is being fetched
            CircularProgressIndicator()
        }



    }

}

@Preview
@Composable
fun OthersScreenPreview(){

    OthersScreen(rememberNavController())

}
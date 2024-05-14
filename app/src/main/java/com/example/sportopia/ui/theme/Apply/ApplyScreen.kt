package com.example.sportopia.ui.theme.Apply



import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.sportopia.R
import com.example.sportopia.data.ShareViewModel
import com.example.sportopia.models.Applicant
import com.example.sportopia.navigation.ROUT_HOME
import com.example.sportopia.navigation.ROUT_TEST


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ApplyScreen(navController: NavHostController, shareViewModel: ShareViewModel){

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 5.dp, end = 5.dp)
            .verticalScroll(rememberScrollState())
            .background(color = Color.Gray)
    ) {

        val context = LocalContext.current

        var applicantId: String by remember { mutableStateOf("") }
        var applicantFirstname: String by remember { mutableStateOf("") }
        var applicantLastname: String by remember { mutableStateOf("") }
        var applicantAge: String by remember { mutableStateOf("") }
        var applicantGender: String by remember { mutableStateOf("") }
        var applicantContact: String by remember { mutableStateOf("") }
        var applicantTown: String by remember { mutableStateOf("") }
        var applicantAddress: String by remember { mutableStateOf("") }
        var applicantPosition: String by remember { mutableStateOf("") }

        Spacer(modifier = Modifier.height(30.dp))

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            TopAppBar(title = {
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(Color.Gray),
                navigationIcon = {
                    IconButton(onClick = {
                        navController.navigate(ROUT_HOME)
                    }) {
                        Icon(imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Arrowback",
                            tint = Color.Black)

                    }
                }
            )

            Image(painter = painterResource(id = R.drawable.sports),
                contentDescription = "LOGIN",
                modifier = Modifier
                    .padding(start = 10.dp)
                    .size(70.dp)
                    .clip(shape = CircleShape),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "BE PART OF US NOW",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Monospace
            )

        }




        //FORM START
        Column {

            Spacer(modifier = Modifier.height(15.dp))

            //ID NUMBER
            Row {
                OutlinedTextField(
                    value = applicantId,
                    onValueChange = { applicantId = it },
                    placeholder = {
                        Text(
                            text = "ID NUMBER",
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        ) },
                    modifier = Modifier
                        .padding(5.dp)
                        .size(width = 375.dp, height = 60.dp),
                    textStyle = TextStyle(color = Color.Black, fontSize = 20.sp),
                    singleLine = true,
                )

            }

            Spacer(modifier = Modifier.height(20.dp))

            //NAMES
            Row {

                OutlinedTextField(
                    value = applicantFirstname,
                    onValueChange = { applicantFirstname = it },
                    placeholder = { Text(
                        text = "FIRST NAME",
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    ) },
                    modifier = Modifier
                        .padding(5.dp)
                        .size(width = 180.dp, height = 60.dp),
                    textStyle = TextStyle(color = Color.Black, fontSize = 20.sp),
                    singleLine = true,
                )

                Spacer(modifier = Modifier.width(5.dp))

                OutlinedTextField(
                    value = applicantLastname,
                    onValueChange = { applicantLastname = it },
                    placeholder = { Text(
                        text = "LAST NAME",
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    ) },
                    modifier = Modifier
                        .padding(5.dp)
                        .size(width = 180.dp, height = 60.dp),
                    textStyle = TextStyle(color = Color.Black, fontSize = 20.sp),
                    singleLine = true,
                )

            }

            Spacer(modifier = Modifier.height(20.dp))

            //AGE GENDER NUMBER
            Row {

                OutlinedTextField(
                    value = applicantAge,
                    onValueChange = { applicantAge = it },
                    placeholder = { Text(
                        text = "AGE",
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    ) },
                    modifier = Modifier
                        .padding(5.dp)
                        .size(width = 70.dp, height = 60.dp),
                    textStyle = TextStyle(color = Color.Black, fontSize = 20.sp),
                    singleLine = true,
                )

                Spacer(modifier = Modifier.width(5.dp))

                //GENDER START

                OutlinedTextField(
                    value = applicantGender,
                    onValueChange = { applicantGender = it },
                    placeholder = { Text(
                        text = "SEX",
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    ) },
                    modifier = Modifier
                        .padding(5.dp)
                        .size(width = 120.dp, height = 60.dp),
                    textStyle = TextStyle(color = Color.Black, fontSize = 20.sp),
                    singleLine = true,
                )


                Spacer(modifier = Modifier.width(5.dp))

                OutlinedTextField(
                    value = applicantContact,
                    onValueChange = { applicantContact = it },
                    placeholder = { Text(
                        text = "CONTACT",
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    ) },
                    modifier = Modifier
                        .padding(5.dp)
                        .size(width = 200.dp, height = 60.dp),
                    textStyle = TextStyle(color = Color.Black, fontSize = 20.sp),
                    singleLine = true,
                )


            }





            Spacer(modifier = Modifier.height(20.dp))


            //POSITION START

            val list = listOf("Football","Volleyball","Basketball","Hockey","Golf","Tennis")
            var isExpanded by remember { mutableStateOf(false) }

            Row{
                ExposedDropdownMenuBox(
                    expanded = true,
                    onExpandedChange = {isExpanded = !isExpanded} )
                {
                    OutlinedTextField(
                        value = applicantPosition,
                        onValueChange = { applicantPosition = it },
                        placeholder = { Text(
                            text = "Game",
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        ) },
                        modifier = Modifier
                            .padding(5.dp)
                            .size(width = 375.dp, height = 60.dp)
                            .fillMaxWidth()
                            .menuAnchor(),
                        textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
                        singleLine = true,
                        readOnly = true,
                        trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded)}
                    )

                    ExposedDropdownMenu(expanded = isExpanded, onDismissRequest = { isExpanded = false }) {
                        list.forEachIndexed{ index, text ->
                            DropdownMenuItem(
                                text = { Text(text = text) },
                                onClick = {
                                    applicantPosition = list[index]
                                    isExpanded = false
                                },
                                contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                            )
                        }

                    }

                }

            }

            //POSITION END

        }
        //FORM END

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                val applicantData = Applicant(
                    applicantId = applicantId,
                    applicantFirstname = applicantFirstname,
                    applicantLastname = applicantLastname,
                    applicantAge = applicantAge,
                    applicantGender = applicantGender,
                    applicantContact = applicantContact,
                    applicantTown = applicantTown,
                    applicantAddress = applicantAddress,
                    applicantPosition = applicantPosition,
                )
                shareViewModel.savedData(applicantData,context)

            },

            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            colors = ButtonDefaults.buttonColors(Color.Black),
            shape = RoundedCornerShape(5.dp),
        ) {

            Text(text = "APPLY NOW", modifier = Modifier.padding(8.dp))
        }




        Spacer(modifier = Modifier.height(100.dp))


    }

}


@Preview(showBackground = true)
@Composable
fun ApplyScreenPreview(){

    ApplyScreen(rememberNavController(), ShareViewModel())

}
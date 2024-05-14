package com.example.sportopia.ui.theme.test



import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.ImageDecoder
import android.os.Build
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.launch
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.sportopia.R
import com.example.sportopia.navigation.ROUT_SUCCESS

import com.google.firebase.Firebase
import com.google.firebase.storage.storage

import java.io.ByteArrayOutputStream

@Composable
fun TestScreen(navController: NavHostController){

    Column(modifier = Modifier.fillMaxSize()) {

        val mContext = LocalContext.current

        val isUploading = remember{ mutableStateOf(false) }
        var showDialog by remember { mutableStateOf(false) }
        val img: Bitmap = BitmapFactory.decodeResource(Resources.getSystem(), android.R.drawable.ic_menu_report_image)
        val bitmap = remember { mutableStateOf(img) }


        val launcher = rememberLauncherForActivityResult(
            contract = ActivityResultContracts.TakePicturePreview()
        ) {
            if (it != null) {
                bitmap.value = it
            }
        }


        val launchImage = rememberLauncherForActivityResult(
            contract = ActivityResultContracts.GetContent()
        ) {
            if (Build.VERSION.SDK_INT < 28){
                bitmap.value = MediaStore.Images.Media.getBitmap(mContext.contentResolver, it)
            }
            else{
                val source = it?.let {it1 ->
                    ImageDecoder.createSource(mContext.contentResolver, it1)
                }
                bitmap.value = source?.let { it1 ->
                    ImageDecoder.decodeBitmap(it1)
                }!!
            }
        }

        Text(
            text = "Upload your most recent photo",
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            modifier = Modifier.padding(top = 60.dp),
            textAlign = TextAlign.Center,
            fontFamily = FontFamily.Monospace
        )

        //ID CARD INSERT
        Card(modifier = Modifier
            .height(260.dp)
            .width(350.dp)
            .padding(start = 40.dp, top = 30.dp, bottom = 30.dp)
            .clickable { showDialog = true }
        )
        {

            Box(modifier = Modifier.fillMaxSize()) {
                Image(
                    bitmap = bitmap.value.asImageBitmap(),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }

        Button(
            modifier = Modifier
                .size(width = 300.dp, height = 50.dp)
                .padding(start = 90.dp)
            ,
            onClick = {

                isUploading.value = true
                bitmap.value.let {bitmap ->
                    upLoadImageToFirebase(bitmap,mContext as ComponentActivity){success ->
                        isUploading.value = false
                        if (success){
                            navController.navigate(ROUT_SUCCESS)
                        }
                        else{
                            Toast.makeText(mContext, "Upload Failed", Toast.LENGTH_SHORT).show()
                        }

                    }

                }


            }
        ) {
            Text(text ="UPLOAD PHOTO" )

        }





        //DIALOG BOX
        Column(
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 10.dp),
        ) {

            //IF LOGIC
            if (showDialog){

                //PICK AND CAMERA
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .width(250.dp)
                        .height(100.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color.Gray)
                ) {

                    Column(modifier = Modifier.padding(start = 30.dp)) {
                        Image(
                            painter = painterResource(id = R.drawable.camera),
                            contentDescription = null,
                            modifier = Modifier
                                .size(50.dp)
                                .clickable {
                                    launcher.launch()
                                    showDialog = false
                                }
                        )

                        Text(text = "Camera",
                            color = Color.White
                        )
                    }

                    Spacer(modifier = Modifier.padding(30.dp))

                    Column {
                        Image(
                            painter = painterResource(id = R.drawable.gallery),
                            contentDescription = null,
                            modifier = Modifier
                                .size(50.dp)
                                .clickable {
                                    launchImage.launch("image/*")
                                    showDialog = false
                                }
                        )

                        Text(text = "Gallery",
                            color = Color.White
                        )
                    }

                    Column(
                        modifier = Modifier.padding(start = 50.dp, bottom = 80.dp)
                    ) {
                        Text(text = "X",
                            color = Color.White,
                            fontSize = 20.sp,
                            modifier = Modifier
                                .clickable { showDialog = false }
                        )

                    }




                }
            }

        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .height(450.dp)
                .fillMaxWidth()
        ) {
            if (isUploading.value){
                CircularProgressIndicator(
                    modifier = Modifier.padding(16.dp),
                    color = Color.White
                )
            }

        }



    }


}


fun upLoadImageToFirebase(bitmap: Bitmap, context: ComponentActivity, callback: (Boolean) -> Unit){
    val storageRef = Firebase.storage.reference
    val imageRef = storageRef.child("images/${bitmap}")

    val baos = ByteArrayOutputStream()
    bitmap.compress(Bitmap.CompressFormat.JPEG,100,baos)

    val imageData = baos.toByteArray()

    imageRef.putBytes(imageData).addOnSuccessListener {
        callback(true)
    }.addOnFailureListener {
        callback(false)
    }




}




@Preview(showBackground = true)
@Composable
fun TestPreview(){

    TestScreen(rememberNavController())

}
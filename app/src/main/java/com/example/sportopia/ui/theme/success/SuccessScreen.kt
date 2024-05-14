package com.example.sportopia.ui.theme.success



import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.sportopia.R
import com.example.sportopia.navigation.ROUT_HOME

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@Composable

fun SuccessScreen(navController: NavHostController){

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Blue),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {

        val coroutine = rememberCoroutineScope()
        coroutine.launch {
            delay(1400)
            navController.navigate(ROUT_HOME)
        }

        val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.succcess))
        LottieAnimation(
            composition = composition,
            iterations = Int.MAX_VALUE
        )


    }


}

@Preview(showBackground = true)
@Composable
fun SuccessScreenPreview(){

    SuccessScreen(rememberNavController())

}
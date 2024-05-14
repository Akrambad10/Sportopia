package com.example.sportopia.ui.theme.home




import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
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
import com.example.sportopia.navigation.ROUT_BASKETBALL
import com.example.sportopia.navigation.ROUT_FOOTBALL
import com.example.sportopia.navigation.ROUT_GOLF
import com.example.sportopia.navigation.ROUT_HOCKEY
import com.example.sportopia.navigation.ROUT_HOME
import com.example.sportopia.navigation.ROUT_LOGIN

import com.example.sportopia.navigation.ROUT_OTHERS
import com.example.sportopia.navigation.ROUT_SPLASH
import com.example.sportopia.navigation.ROUT_TENNIS
import com.example.sportopia.navigation.ROUT_VOLLEYBALL


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController){
    Column(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState())

    ) {

        val mContext = LocalContext.current

        //TopAppBar
        TopAppBar(title = {
            Text(text = "Sportopia Club",
                fontSize = 30.sp,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                color = Color.Blue) },
            colors = TopAppBarDefaults.mediumTopAppBarColors(Color.Gray),
            navigationIcon = {
                IconButton(onClick = {navController.navigate(ROUT_LOGIN)
                }) {
                    Icon(imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Arrowback",
                        modifier = Modifier.size(35.dp),
                        tint = Color.Black)

                }
            }
        )

        //End of TopAppBar




        //COLUMN CARDS
        Column(
            modifier = Modifier
                .padding(start = 15.dp)
        ) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(start = 10.dp)
                    .fillMaxWidth()
            ) {

                Text(
                    text = "Available Games",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Monospace
                )

            }

            Spacer(modifier = Modifier.height(10.dp))

            //ROW 1 START
            Row {

                //CARD START
                Card (
                    modifier = Modifier
                        .size(width = 165.dp, height = 150.dp)
                        .clickable {
                            navController.navigate(ROUT_FOOTBALL)
                        }
                ){
                    Column {

                        Box(modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 5.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(painter = painterResource(id = R.drawable.football),
                                contentDescription = "amazon",
                                modifier = Modifier.size(120.dp)
                            )
                        }

                        Text(text = "Football",
                            fontSize = 20.sp,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth()

                        )

                    }

                }
                //CARD END

                Spacer(modifier = Modifier.width(20.dp))

                //CARD START
                Card (
                    modifier = Modifier
                        .size(width = 165.dp, height = 150.dp)
                        .clickable {
                            navController.navigate(ROUT_BASKETBALL)
                        }

                ){
                    Column {

                        Box(modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 5.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(painter = painterResource(id = R.drawable.basketball),
                                contentDescription = "amazon",
                                modifier = Modifier.size(120.dp)
                            )
                        }

                        Text(text = "Basketball",
                            fontSize = 20.sp,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth()

                        )


                    }

                }
                //CARD END


            }

            //ROW 1 END

            Spacer(modifier = Modifier.height(15.dp))


            //ROW 2 START
            Row {

                //CARD START
                Card (
                    modifier = Modifier
                        .size(width = 165.dp, height = 150.dp)
                        .clickable {
                            navController.navigate(ROUT_VOLLEYBALL)
                        }
                ){
                    Column {

                        Box(modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 5.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(painter = painterResource(id = R.drawable.volleyball),
                                contentDescription = "amazon",
                                modifier = Modifier.size(120.dp)
                            )
                        }

                        Text(text = "Volleyball",
                            fontSize = 20.sp,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth()

                        )

                    }

                }
                //CARD END

                Spacer(modifier = Modifier.width(20.dp))

                //CARD START
                Card (
                    modifier = Modifier
                        .size(width = 165.dp, height = 150.dp)
                        .clickable {
                            navController.navigate(ROUT_HOCKEY)
                        }
                ){
                    Column {

                        Box(modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 5.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(painter = painterResource(id = R.drawable.hockey),
                                contentDescription = "amazon",
                                modifier = Modifier.size(120.dp)
                            )
                        }

                        Text(text = "Hockey",
                            fontSize = 20.sp,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth()

                        )


                    }

                }
                //CARD END


            }

            //ROW 2 END

            Spacer(modifier = Modifier.height(15.dp))

            //ROW 3 START
            Row {

                //CARD START
                Card (
                    modifier = Modifier
                        .size(width = 165.dp, height = 150.dp)
                        .clickable {
                            navController.navigate(ROUT_GOLF)
                        }
                ){
                    Column {

                        Box(modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 5.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(painter = painterResource(id = R.drawable.golf),
                                contentDescription = "amazon",
                                modifier = Modifier.size(120.dp)
                            )
                        }

                        Text(text = "Golf",
                            fontSize = 20.sp,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth()

                        )

                    }

                }
                //CARD END

                Spacer(modifier = Modifier.width(20.dp))

                //CARD START
                Card (
                    modifier = Modifier
                        .size(width = 165.dp, height = 150.dp)
                        .clickable {
                            navController.navigate(ROUT_TENNIS)
                        }
                ){
                    Column {

                        Box(modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 5.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(painter = painterResource(id = R.drawable.tennis),
                                contentDescription = "amazon",
                                modifier = Modifier.size(120.dp)
                            )
                        }

                        Text(text = "Tennis",
                            fontSize = 20.sp,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth()

                        )


                    }

                }
                //CARD END

            }
            //ROW 3 END

        }
        //COLUMN CARD END

        Spacer(modifier = Modifier.height(20.dp))

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(start = 10.dp)
                .fillMaxWidth()
        ) {

            Button(
                modifier = Modifier.size(width = 250.dp, height = 50.dp),
                colors = ButtonDefaults.buttonColors(Color.Black),
                onClick = {
                    navController.navigate(ROUT_OTHERS)
                }) {
                Text(text = "VIEW OTHER ATHLETES")
            }

        }

        Spacer(modifier = Modifier.height(30.dp))


    }

}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(){
    HomeScreen(rememberNavController())
}
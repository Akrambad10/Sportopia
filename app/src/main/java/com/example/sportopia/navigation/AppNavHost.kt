package com.example.sportopia.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sportopia.data.ShareViewModel
import com.example.sportopia.ui.theme.Apply.ApplyScreen
import com.example.sportopia.ui.theme.basketball.BasketballScreen
import com.example.sportopia.ui.theme.football.FootballScreen
import com.example.sportopia.ui.theme.golf.GolfScreen
import com.example.sportopia.ui.theme.hockey.HockeyScreen


import com.example.sportopia.ui.theme.home.HomeScreen
import com.example.sportopia.ui.theme.home.HomeScreenPreview
import com.example.sportopia.ui.theme.login.LoginScreen
import com.example.sportopia.ui.theme.other.OthersScreen
import com.example.sportopia.ui.theme.signup.SignupScreen
import com.example.sportopia.ui.theme.splash.SplashScreen
import com.example.sportopia.ui.theme.tennis.TennisScreen
import com.example.sportopia.ui.theme.test.TestScreen
import com.example.sportopia.ui.theme.volleyball.VolleyBallScreen

@Composable
fun AppNavHost(modifier: Modifier = Modifier, navController: NavHostController = rememberNavController(), startDestination:String = ROUT_SPLASH) {
    NavHost(navController = navController, modifier = modifier, startDestination = startDestination) {

        composable(ROUT_SPLASH) {
            SplashScreen(navController)
        }

        composable(ROUT_LOGIN) {
            LoginScreen(navController)
        }

        composable(ROUT_SIGNUP) {
            SignupScreen(navController)
        }
        composable(ROUT_HOME) {
            HomeScreen(navController)
        }
        composable(ROUT_APPLY) {
            ApplyScreen(navController ,shareViewModel = ShareViewModel())
        }
        composable(ROUT_TEST) {
            TestScreen(navController)
        }
        composable(ROUT_FOOTBALL) {
            FootballScreen(navController)
        }
        composable(ROUT_OTHERS) {
            OthersScreen(navController)
        }
        composable(ROUT_BASKETBALL) {
            BasketballScreen(navController)
        }
        composable(ROUT_GOLF) {
            GolfScreen(navController)
        }
        composable(ROUT_HOCKEY) {
            HockeyScreen(navController)
        }
        composable(ROUT_TENNIS) {
            TennisScreen(navController)
        }
        composable(ROUT_VOLLEYBALL) {
            VolleyBallScreen(navController)
        }





    }

}
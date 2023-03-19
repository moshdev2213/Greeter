package com.example.greeter

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.fragment.app.Fragment
import com.example.greeter.Fragment.*
import com.google.android.material.bottomnavigation.BottomNavigationView

class UserIndex : AppCompatActivity() {
    private lateinit var btnNav : BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_index)
        // In Activity's onCreate() for instance this transparents the background
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val w: Window = window
            w.setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS

            )
            val flags = window.decorView.systemUiVisibility
            window.decorView.systemUiVisibility = flags or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }
        replaceAdmBottomNavFragment(HomeFragment())
        btnNav = findViewById(R.id.btmnV)
        btnNav.setOnItemSelectedListener{
            when(it.itemId){
                R.id.homeitem->{
                    replaceAdmBottomNavFragment(HomeFragment())
                }
                R.id.finisheditem->{
                    replaceAdmBottomNavFragment(FinishedFrag())
                }
                R.id.upcomingitem->{
                    replaceAdmBottomNavFragment(UpcomingFrag())
                }
                R.id.settingitem->{
                    replaceAdmBottomNavFragment(ProfileFrag())
                }
                R.id.allitem->{
                    replaceAdmBottomNavFragment(ListOfAll())
                }
            }
            true
        }
    }

    //the below method replaces the fragments that are for the bottom navigation
    private fun replaceAdmBottomNavFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout,fragment)
        fragmentTransaction.commit()


    }
}
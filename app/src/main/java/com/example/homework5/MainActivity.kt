package com.example.homework5

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton


class MainActivity : AppCompatActivity() {

    companion object {
        private var sTheme = 0
        private val THEME_STANDART = 0
        private val THEME_MYTHEME = 1

        fun changeToTheme(activity: Activity, theme: Int) {
            sTheme = theme
            activity.finish()
            activity.startActivity(Intent(activity, activity.javaClass))
            activity.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        }

        fun onActivityCreateSetTheme(activity: Activity) {
            when (sTheme) {
                THEME_STANDART -> activity.setTheme(R.style.Theme_HomeWork5)
                THEME_MYTHEME -> activity.setTheme(R.style.Theme_MyTheme)
                else -> activity.setTheme(R.style.Theme_HomeWork5)
            }
        }
    }

    private lateinit var bottomNavigation: BottomNavigationView
    private lateinit var rcView: RecyclerView
    private val capsList = mutableListOf<AppCap>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onActivityCreateSetTheme(this)
        setContentView(R.layout.activity_main)
        bottomNavigation = findViewById(R.id.bottom_navigation_view)
        bottomNavigation.background = null
        val contentFragment = ContentFragment()
        replaceFragment(contentFragment)

        capsList.add(AppCap(R.drawable.image1))
        capsList.add(AppCap(R.drawable.image2))
        capsList.add(AppCap(R.drawable.image3))
        capsList.add(AppCap(R.drawable.image4))
        capsList.add(AppCap(R.drawable.image5))
        capsList.add(AppCap(R.drawable.image6))
        capsList.add(AppCap(R.drawable.image7))
        capsList.add(AppCap(R.drawable.image8))
        capsList.add(AppCap(R.drawable.image9))

        val changeTheme = findViewById<FloatingActionButton>(R.id.menu)
        changeTheme.setOnClickListener {
            sTheme = if(sTheme == 0) {
                changeToTheme(this, THEME_MYTHEME)
                1
            } else {
                changeToTheme(this, THEME_STANDART)
                0
            }
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.commit()
    }

    override fun onStart() {
        super.onStart()
        rcView = findViewById(R.id.rc_view)
        rcView.layoutManager = StaggeredGridLayoutManager(
                3, LinearLayoutManager.VERTICAL)
        rcView.adapter = CapAdapter(images = capsList,
                onClick = {
                    startActivity(
                            ChosenPhotoActivity.getStartIntent(
                                    context = this, image = it
                            )
                    )
                }
        )
    }
}
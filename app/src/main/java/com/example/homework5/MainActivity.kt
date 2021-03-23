package com.example.homework5

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    private val contentFragment = ContentFragment()
    private lateinit var bottomNavigation: BottomNavigationView
    private lateinit var rcView: RecyclerView
    private val capsList = arrayListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNavigation = findViewById(R.id.bottom_navigation_view)

        bottomNavigation.background = null
        replaceFragment(contentFragment)
        capsList.add(R.drawable.image1)
        capsList.add(R.drawable.image2)
        capsList.add(R.drawable.image3)
        capsList.add(R.drawable.image4)
        capsList.add(R.drawable.image5)
        capsList.add(R.drawable.image6)
        capsList.add(R.drawable.image7)
        capsList.add(R.drawable.image8)
        capsList.add(R.drawable.image9)
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
        rcView.adapter = CapAdapter(capsList, this)
    }
}
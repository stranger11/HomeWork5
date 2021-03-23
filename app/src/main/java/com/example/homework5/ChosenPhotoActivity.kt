package com.example.homework5

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.airbnb.lottie.LottieAnimationView
import com.example.homework5.R.drawable.image1


class ChosenPhotoActivity : AppCompatActivity() {

    private lateinit var photo: ImageView
    private lateinit var likesCount: TextView
    private var isCheckedDone = false
    private var isCheckedDoneForBookmark = false
    private lateinit var lottieLike: LottieAnimationView
    private lateinit var lottieBookmark: LottieAnimationView
    private lateinit var commentsLayout: ViewGroup
    private lateinit var commentsIcon: View
    private var countLikes = 94
    private var countLikesPlus = 95

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chosen_photo)
        photo = findViewById(R.id.photo_cap)
        lottieLike = findViewById(R.id.lottie_like)
        likesCount = findViewById(R.id.count_likes)
        lottieBookmark = findViewById(R.id.lottie_bookmark)
        commentsLayout = findViewById(R.id.comments_layout)
        commentsIcon = findViewById(R.id.comments_icon)
    }

    override fun onStart() {
        super.onStart()
        photo.setImageResource(intent.getIntExtra("photo", image1))
        lottieLike.setOnClickListener {
            if (isCheckedDone) {
                lottieLike.speed = -3f
                lottieLike.playAnimation()
                isCheckedDone = false
                likesCount.text = countLikes.toString()
            } else {
                lottieLike.speed = 3f
                lottieLike.playAnimation()
                isCheckedDone = true
                likesCount.text = countLikesPlus.toString()
            }
        }

        lottieBookmark.setOnClickListener {

            if (isCheckedDoneForBookmark) {
                lottieBookmark.speed = -3f
                lottieBookmark.playAnimation()
                isCheckedDoneForBookmark = false

            } else {
                lottieBookmark.speed = 3f
                lottieBookmark.playAnimation()
                isCheckedDoneForBookmark = true
            }
        }

        commentsIcon.setOnClickListener {
            commentsLayout.visibility = View.VISIBLE
        }

    }
}
package com.example.homework5

import android.annotation.SuppressLint
import android.content.Context
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

    private lateinit var likesCount: TextView
    private var isCheckedDone = false
    private var isCheckedDoneForBookmark = false
    private lateinit var lottieLike: LottieAnimationView
    private lateinit var lottieBookmark: LottieAnimationView
    private lateinit var commentsLayout: ViewGroup
    private lateinit var commentsIcon: View
    private var countLikes = 94
    private var countLikesPlus = 95
    private lateinit var image: AppCap

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_MyTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chosen_photo)

        image = intent.getSerializableExtra(EXTRA_IMAGE) as AppCap
        findViewById<ImageView>(R.id.photo_cap).setImageResource(image.image)

        lottieLike = findViewById(R.id.lottie_like)
        likesCount = findViewById(R.id.count_likes)
        lottieBookmark = findViewById(R.id.lottie_bookmark)
        commentsLayout = findViewById(R.id.comments_layout)
        commentsIcon = findViewById(R.id.comments_icon)
    }

    companion object {

        private const val EXTRA_IMAGE = "EXTRA_IMAGE"

        fun getStartIntent(context: Context, image: AppCap) =
                Intent(context, ChosenPhotoActivity::class.java).apply {
                    putExtra(EXTRA_IMAGE, image)
                }
    }

    override fun onStart() {
        super.onStart()

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
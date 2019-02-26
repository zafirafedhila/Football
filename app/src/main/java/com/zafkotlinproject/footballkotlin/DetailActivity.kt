package com.zafkotlinproject.footballkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        tv_clubdetail.text = intent.getStringExtra("namaClub")
        tv_detail.text = intent.getStringExtra("detailClub")
        Glide.with(this).load(intent.getIntExtra("gambarClub",0)).into(img_clubdetail)

    }
}

package com.zafkotlinproject.footballkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {
    val items: MutableList<Item> = mutableListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //TODO 2
        val namaClub = resources.getStringArray(R.array.club_name)
        val detailClub = resources.getStringArray(R.array.club_name)
        val gambarClub = resources.obtainTypedArray(R.array.club_image)

        //TODO 3 LOPING DATA

        for (i in namaClub.indices) {

            //TODO 4 panggil VARIABEL YANG UDAH DIISI
            items.add(
                Item(
                    namaClub[i], detailClub[i], gambarClub.getResourceId(
                        i, 0
                    )
                )
            )
            rv_main.layoutManager = LinearLayoutManager(this)

            //TODO 5 PANGGIL KELAS ADAPTER
            rv_main.adapter = BolaAdapter(this, items){

                //TODO 9
                startActivity<DetailActivity>(
                    "namaClub" to it.namaClub,
                    "detailClub" to it.detailClub,
                    "gambarClub" to it. gambarClub)
            }

        }
        // masukin ke dalam for rv_main.layoutManager=LinearLayoutManager(this)
        // variabel ini dikirim ke adapter untuk ditampilkan
    }

}


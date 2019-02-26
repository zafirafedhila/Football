package com.zafkotlinproject.footballkotlin

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_club.view.*
import org.jetbrains.anko.sdk25.coroutines.onClick

// mewariskan kelas recycler view

class BolaAdapter(val context: Context, val items: List<Item>, val listener: (Item) -> Unit) : RecyclerView.Adapter<BolaAdapter.ViewHolder>() {
    //dikasi parameter () tapi kosong
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        //TODO 1
        val view = LayoutInflater.from(context).inflate(R.layout.item_club, p0, false)
        return ViewHolder(view)
        //menampilkan, medeklarasikan tampilan
    }

    override fun getItemCount(): Int {
        //TODO 3

        //menghitung datanya berapa
        return items.size
    }

    //TODO 6 ganti positiion dan view holder
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) { //mengolah data

        //TODO 7
        viewHolder.bindItem(items[position],listener)

    }

    //TODO 2
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {  //harus mewarikasn clas recyler view
        //TODO 4
        val namaClub = view.tv_namaclub
        val gambarClub = view.imgClub

        //TODO 5 buat metod //olah data
        fun bindItem(item: Item, listener: (Item) -> Unit) {
            namaClub.text = item.namaClub
            Glide.with(itemView.context).load(item.gambarClub).into(gambarClub)
            //TODO 8
            itemView.onClick{
                listener (item)
            }


        }
    }
}
package com.example.First_App.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.First_App.R
import com.example.First_App.data.Result
import com.example.First_App.view.MoviesActivity
import com.squareup.picasso.Picasso

class CustomAdapter(private val mList: List<Result>?,
                    val mItemClickListener: MoviesActivity
) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    interface ItemClickListener {
        fun onItemClick(position: Int)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_design, parent, false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        mList?.get(position)
        Picasso.get().load("https://image.tmdb.org/t/p/w500"+mList?.get(position)?.poster_path).into(holder.imageView)
    }
    override fun getItemCount(): Int {
        return mList!!.size
    }
   inner class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageview)
        init {
            ItemView.setOnClickListener{
                mList?.get(position)?.id?.let { it-> mItemClickListener.onItemClick(it) }
            }
        }
    }
}
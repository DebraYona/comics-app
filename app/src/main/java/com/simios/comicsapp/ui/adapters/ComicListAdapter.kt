package com.simios.comicsapp.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.simios.comicsapp.R
import com.simios.comicsapp.data.model.Comic
import com.simios.comicsapp.databinding.ComicItemBinding
import com.squareup.picasso.Picasso

class ComicsListAdapter(
    private val list: List<Comic>,
    private val onClickListener: (Comic) -> Unit
) :
    RecyclerView.Adapter<ComicsListAdapter.ViewHolder>() {

    private val TAG = ComicsListAdapter::class.java.name


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        return ViewHolder(layoutInflater.inflate(R.layout.comic_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item, onClickListener)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ComicItemBinding.bind(view)

        fun bind(comic: Comic, onClickListener: (Comic) -> Unit) {
            binding.comicTitle.text = comic.safeTitle
            Picasso.get().load(comic.img).into(binding.comicImage)
            itemView.setOnClickListener {
                onClickListener(comic)
            }
        }
    }

    private fun getItem(position: Int): Comic {
        return list[position]
    }

    override fun getItemCount(): Int {
        return list.size
    }
}
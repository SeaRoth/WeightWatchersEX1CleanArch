package com.searoth.wwe1.ui.browse

import android.support.design.widget.Snackbar
import android.support.v4.widget.CircularProgressDrawable
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.searoth.wwe1.ui.R
import com.searoth.wwe1.ui.model.BufferooViewModel
import javax.inject.Inject

class BrowseAdapter @Inject constructor(): RecyclerView.Adapter<BrowseAdapter.ViewHolder>() {

    var bufferoos: List<BufferooViewModel> = arrayListOf()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val bufferoo = bufferoos[position]
        holder.nameText.text = bufferoo.title
        holder.filterText.text = bufferoo.filter

        val circularProgressDrawable = CircularProgressDrawable(holder.itemView.context)
        circularProgressDrawable.strokeWidth = 5f
        circularProgressDrawable.centerRadius = 30f
        circularProgressDrawable.start()

        val requestOptions = RequestOptions()
                .placeholder(circularProgressDrawable)
                .error(R.drawable.question_mark)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .priority(Priority.HIGH)

        Glide.with(holder.itemView.context)
                .load( holder.itemView.context.getString(R.string.placeholder_image, bufferoo.avatar))
                .apply(requestOptions)
                .into(holder.avatarImage)

        holder.avatarImage.setOnClickListener({
            Snackbar.make(it, "Clicked " + bufferoo.title, Snackbar.LENGTH_SHORT).show()
        })
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_bufferoo, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return bufferoos.size
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var avatarImage: ImageView
        var nameText: TextView
        var filterText: TextView

        init {
            avatarImage = view.findViewById(R.id.image_avatar)
            nameText = view.findViewById(R.id.text_title)
            filterText = view.findViewById(R.id.text_filter)
        }
    }

}
package com.bulbul.bulbulclient.feature.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bulbul.bulbulclient.R
import com.bulbul.bulbulclient.feature.data.model.Bulbul

class PostsAdapter (private var dataSet:List<Bulbul>):
	RecyclerView.Adapter<PostsAdapter.PostViewHolder>(){


	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
		val view = LayoutInflater.from(parent.context)
			.inflate(R.layout.post_item,parent,false)
		return PostViewHolder(view)
	}

	override fun getItemCount(): Int = dataSet.size


	override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
		val item = dataSet[position]
		holder.showNameText.text = item.user.show_Name
		holder.userNameText.text = item.user.name
		holder.createdText.text = item.createTime
		holder.postText.text = item.textContext
		holder.repostCount.text = item.rePostCount.toString()
		holder.favCount.text = item.likeCount.toString()

	}

	class PostViewHolder(view:View) : ViewHolder(view){
		val showNameText = view.findViewById<TextView>(R.id.post_show_name)
		val userNameText = view.findViewById<TextView>(R.id.post_user_name)
		val createdText = view.findViewById<TextView>(R.id.post_created_date)
		val postText = view.findViewById<TextView>(R.id.post_text)
//		val commentBtn = view.findViewById<TextView>(R.id.post_comment_btn)
//		val repostBtn = view.findViewById<TextView>(R.id.post_repost_btn)
		val repostCount = view.findViewById<TextView>(R.id.post_repost_count)
//		val favBtn = view.findViewById<TextView>(R.id.post_fav_btn)
		val favCount = view.findViewById<TextView>(R.id.post_fav_count)
	}
}
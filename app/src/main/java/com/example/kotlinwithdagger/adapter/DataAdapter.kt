package com.example.kotlinwithdagger.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinwithdagger.R
import com.example.kotlinwithdagger.pojo.NewsModel

class DataAdapter : RecyclerView.Adapter<DataAdapter.DataViewHolder>() {
    var listModel: List<NewsModel> = emptyList()
     fun setList(listModel: List<NewsModel>) {
        this.listModel = listModel
        notifyDataSetChanged()
    }

    inner class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txtTitle: TextView = itemView.findViewById(R.id.textTitle)
        var txtSourceTitle: TextView = itemView.findViewById(R.id.sourceTxt)
        var btnSectionTitle: Button = itemView.findViewById(R.id.btnSectionTitle)

        fun bind(Model: NewsModel) {
            txtTitle.text=Model.Title
            btnSectionTitle.text = Model.SectionTitle
            txtSourceTitle.text = Model.SourceTitle

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        var view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.news_item, parent, false)
        return DataViewHolder(view)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        var Model: NewsModel = listModel.get(position)
        holder.bind(Model)
    }

    override fun getItemCount(): Int {
        return listModel.size
    }
}
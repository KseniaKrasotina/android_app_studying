package com.example.twitch_test.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.twitch_test.R
import com.example.twitch_test.api.GameProperties
import com.example.twitch_test.api.TopItem

class GamesAdapter: androidx.recyclerview.widget.RecyclerView.Adapter<GamesAdapter.ViewHolder>() {

    var data =  listOf<TopItem>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }

    class ViewHolder private constructor(itemView: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView){
        val game_title: TextView = itemView.findViewById(R.id.gameTitleTV)
        //val game_picture: TextView = itemView.findViewById(R.id.gamePictureIV)
        val channels_number: TextView = itemView.findViewById(R.id.channelsNumberTV)
        val spectators_nubmer: TextView = itemView.findViewById(R.id.spectatorsNumberTV)


        fun bind(item: TopItem) {

            game_title.text = item.game.name
            //game_picture.text = ""
            channels_number.text = "1"
            spectators_nubmer.text = "1"
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater
                    .inflate(R.layout.games_list, parent, false)

                return ViewHolder(view)
            }
        }
    }
}
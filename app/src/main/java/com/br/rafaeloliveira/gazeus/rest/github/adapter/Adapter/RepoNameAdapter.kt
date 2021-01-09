package com.br.rafaeloliveira.gazeus.rest.github.adapter.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.br.rafaeloliveira.gazeus.rest.github.R
import com.br.rafaeloliveira.gazeus.rest.github.data.remote.userModels.Repos
import kotlinx.android.synthetic.main.item_repo_user.view.*

class RepoNameAdapter(val items : MutableList<Repos>?) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    internal var onRepoClickListener: OnRepoClickListener? = null

    inner class ViewHolderRepo(val view : View) : RecyclerView.ViewHolder(view) {

        fun bindRepo(repos: Repos) {

            itemView.txtValueCode.text = repos.id.toString()
            itemView.txtValueNodeId.text = repos.nodeId
            itemView.txtValueName.text = repos.name
            itemView.txtValueFullName.text = repos.fullName
            itemView.txtValueOwner.text = repos.owner.login

            itemView.setOnClickListener {
                onRepoClickListener?.onClickItemRepo(repos)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return ViewHolderRepo(
            LayoutInflater.from(parent.context)
                .inflate(
                    R.layout.item_repo_user,
                    parent,
                    false
                )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val repo = items?.get(position)
        if(repo != null) {
            val holderRepo = holder as ViewHolderRepo
            holderRepo.bindRepo(repo)
        }

    }

    override fun getItemCount(): Int {
        return items?.count() ?: 0
    }

    interface OnRepoClickListener {
        fun onClickItemRepo(repos: Repos)
    }
}
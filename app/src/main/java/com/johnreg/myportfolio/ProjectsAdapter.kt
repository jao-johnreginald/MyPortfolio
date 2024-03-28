package com.johnreg.myportfolio

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.johnreg.myportfolio.databinding.ItemProjectBinding
import com.johnreg.myportfolio.model.Item

class ProjectsAdapter(
    private val projects: List<Item>
) : RecyclerView.Adapter<ProjectsAdapter.ProjectViewHolder>() {

    private var onClickListener: OnClickListener? = null

    override fun getItemCount(): Int = projects.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProjectViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemProjectBinding.inflate(inflater, parent, false)
        return ProjectViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProjectViewHolder, position: Int) {
        holder.bind(projects[position])
    }

    inner class ProjectViewHolder(
        private val binding: ItemProjectBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(project: Item) {
            binding.tvTitle.text = project.name
            binding.tvDescription.text = project.description
            binding.ivIcon.setImageResource(project.image)
            itemView.setOnClickListener { onClickListener?.onClick(project, adapterPosition) }
        }
    }

    interface OnClickListener {
        fun onClick(project: Item, position: Int)
    }

    fun setOnClickListener(listener: OnClickListener) {
        onClickListener = listener
    }

}
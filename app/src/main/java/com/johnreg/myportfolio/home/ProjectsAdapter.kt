package com.johnreg.myportfolio.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.johnreg.myportfolio.databinding.ItemProjectBinding
import com.johnreg.myportfolio.models.Item

class ProjectsAdapter(
    private val projects: List<Item>,
    private val onItemClick: (Int) -> Unit
) : RecyclerView.Adapter<ProjectsAdapter.ProjectViewHolder>() {

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
            itemView.setOnClickListener { onItemClick(adapterPosition) }
        }
    }

}
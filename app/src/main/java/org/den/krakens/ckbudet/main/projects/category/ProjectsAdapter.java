package org.den.krakens.ckbudet.main.projects.category;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.den.krakens.ckbudet.R;
import org.den.krakens.ckbudet.main.Constants;
import org.den.krakens.ckbudet.main.models.Project;
import org.den.krakens.ckbudet.main.project.ProjectActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Mohru on 15.06.2018.
 */

public class ProjectsAdapter extends RecyclerView.Adapter<ProjectsAdapter.ProjectsViewHolder> {

    private List<Project> projects;

    public ProjectsAdapter(List<Project> projects) {
        this.projects = projects;
    }

    @Override
    public ProjectsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.project_row, null);
        return new ProjectsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProjectsViewHolder holder, int position) {
        Project project = projects.get(position);
        holder.projectTitleTextView.setText(project.getTitle());
        holder.tagsRecyclerView.setAdapter(new TagsAdapter(project.getTags()));

        //todo handle click on RecyclerView
        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), ProjectActivity.class);
            intent.putExtra(Constants.projectId, project.getId());
            view.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return projects.size();
    }

    public void addProjects(List<Project> projects) {
        int index = this.projects.size() - 1;
        this.projects.addAll(projects);
        notifyItemRangeInserted(index, projects.size());
    }

    class ProjectsViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.project_title_tv)
        TextView projectTitleTextView;
        @BindView(R.id.tags_rl)
        RecyclerView tagsRecyclerView;

        public ProjectsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            LinearLayoutManager layoutManager = new LinearLayoutManager(itemView.getContext(), LinearLayoutManager.HORIZONTAL, false);
            tagsRecyclerView.setLayoutManager(layoutManager);
        }
    }
}

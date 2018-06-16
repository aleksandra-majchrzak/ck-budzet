package org.den.krakens.ckbudet.main.yourprojects;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.den.krakens.ckbudet.R;
import org.den.krakens.ckbudet.main.models.Project;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Mohru on 16.06.2018.
 */

public class YouProjectsAdapter extends RecyclerView.Adapter<YouProjectsAdapter.YourProjectsViewHolder> {

    List<Project> projects;

    public YouProjectsAdapter(List<Project> projects) {
        this.projects = projects;
    }

    @Override
    public YourProjectsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.your_project_row, null);
        return new YourProjectsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(YourProjectsViewHolder holder, int position) {
        Project project = projects.get(position);
        holder.projectTitleTextView.setText(project.getTitle());
        holder.editProjectImageView.setOnClickListener((v) -> {

        });
        holder.deleteProjectImageView.setOnClickListener((v) -> {

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

    class YourProjectsViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.project_title_tv)
        TextView projectTitleTextView;
        @BindView(R.id.edit_project_iv)
        ImageView editProjectImageView;
        @BindView(R.id.delete_project_iv)
        ImageView deleteProjectImageView;

        public YourProjectsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

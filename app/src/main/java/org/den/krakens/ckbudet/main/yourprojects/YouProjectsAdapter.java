package org.den.krakens.ckbudet.main.yourprojects;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.den.krakens.ckbudet.R;
import org.den.krakens.ckbudet.main.Constants;
import org.den.krakens.ckbudet.main.models.Project;
import org.den.krakens.ckbudet.main.project.ProjectActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Mohru on 16.06.2018.
 */

public class YouProjectsAdapter extends RecyclerView.Adapter<YouProjectsAdapter.YourProjectsViewHolder> {

    private List<Project> projects;
    private YourProjectListener listener;

    public YouProjectsAdapter(List<Project> projects, YourProjectListener listener) {
        this.projects = projects;
        this.listener = listener;
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
            listener.editProject(project.getId());
        });
        holder.deleteProjectImageView.setOnClickListener((v) -> {
            listener.deleteProject(project.getId());
        });
        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), ProjectActivity.class);
            intent.putExtra(Constants.projectId, project.getId());
            intent.putExtra(Constants.projectCategory, project.getCategory().getName());
            //view.getContext().startActivity(intent);
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

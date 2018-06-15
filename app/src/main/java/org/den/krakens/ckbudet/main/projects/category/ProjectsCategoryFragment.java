package org.den.krakens.ckbudet.main.projects.category;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import org.den.krakens.ckbudet.R;
import org.den.krakens.ckbudet.main.models.Project;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProjectsCategoryFragment extends Fragment implements ProjectsCategoryVP.View {

    private ProjectsCategoryVP.Presenter presenter;

    @BindView(R.id.projects_recyclerView)
    RecyclerView projectsRecyclerView;

    ProjectsAdapter adapter;

    public ProjectsCategoryFragment() {
        // Required empty public constructor
    }

    public void setPresenter(ProjectsCategoryVP.Presenter presenter) {
        this.presenter = presenter;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_projects_category, container, false);

        ButterKnife.bind(this, view);

        initComponents();
        presenter.loadProjects();
        return view;
    }

    private void initComponents() {
        adapter = new ProjectsAdapter(new ArrayList<Project>());
        projectsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        projectsRecyclerView.setAdapter(adapter);
    }

    @Override
    public void updateProjects(List<Project> projects) {
        adapter.addProjects(projects);
    }

    @Override
    public void showProjectsError() {
        Toast.makeText(getContext(), "Could not load projects", Toast.LENGTH_LONG).show();
    }
}

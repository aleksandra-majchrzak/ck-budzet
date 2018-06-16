package org.den.krakens.ckbudet.main.yourprojects;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import org.den.krakens.ckbudet.R;
import org.den.krakens.ckbudet.main.models.Project;
import org.den.krakens.ckbudet.main.newproject.NewProjectActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class YourProjectsFragment extends Fragment implements YourProjectsVP.View, YourProjectListener {

    private YourProjectsVP.Presenter presenter;

    @BindView(R.id.your_projects_rv)
    RecyclerView yourProjectsRecyclerView;

    YouProjectsAdapter adapter;

    public YourProjectsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_your_projects, container, false);
        ButterKnife.bind(this, view);

        initComponents();
        presenter.loadYourProjects();
        return view;
    }

    public void setPresenter(YourProjectsVP.Presenter presenter) {
        this.presenter = presenter;
    }

    private void initComponents() {
        adapter = new YouProjectsAdapter(new ArrayList<Project>(), this);
        yourProjectsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        yourProjectsRecyclerView.setAdapter(adapter);
    }

    @Override
    public void updateYourProjects(List<Project> yourProjects) {
        adapter.addProjects(yourProjects);
    }

    @Override
    public void showProjectsError() {
        Toast.makeText(getContext(), R.string.load_projects_failure, Toast.LENGTH_LONG).show();
    }

    @Override
    public void editProject(int projectId) {
        Intent intent = new Intent(getContext(), NewProjectActivity.class);
        startActivity(intent);
    }

    @Override
    public void deleteProject(int projectId) {
        new AlertDialog.Builder(getContext())
                .setMessage(R.string.delete_project_confirmation)
                .setPositiveButton(getString(R.string.ok), (dialogInterface, i) -> {
                    presenter.deleteProject(projectId);
                })
                .setNegativeButton(getString(R.string.cancel), (dialogInterface, i) -> {
                })
                .show();

    }
}

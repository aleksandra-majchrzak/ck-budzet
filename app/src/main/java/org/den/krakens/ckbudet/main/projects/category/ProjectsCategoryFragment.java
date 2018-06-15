package org.den.krakens.ckbudet.main.projects.category;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import org.den.krakens.ckbudet.R;
import org.den.krakens.ckbudet.main.models.Project;

import java.util.List;

import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProjectsCategoryFragment extends Fragment implements ProjectsCategoryVP.View {

    private ProjectsCategoryVP.Presenter presenter;

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

        return view;
    }

    @Override
    public void updateProjects(List<Project> projects) {

    }

    @Override
    public void showProjectsError() {
        Toast.makeText(getContext(), "Could not load projects", Toast.LENGTH_LONG).show();
    }
}

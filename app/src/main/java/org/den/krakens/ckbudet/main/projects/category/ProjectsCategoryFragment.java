package org.den.krakens.ckbudet.main.projects.category;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.den.krakens.ckbudet.R;

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
        return inflater.inflate(R.layout.fragment_projects_category, container, false);
    }

}

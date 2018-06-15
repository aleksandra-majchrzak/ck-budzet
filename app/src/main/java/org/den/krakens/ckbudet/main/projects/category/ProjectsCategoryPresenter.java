package org.den.krakens.ckbudet.main.projects.category;

import org.den.krakens.ckbudet.main.api.CkService;
import org.den.krakens.ckbudet.main.api.listeners.OnGetProjectsListener;
import org.den.krakens.ckbudet.main.models.Project;

import java.util.List;

/**
 * Created by Mohru on 15.06.2018.
 */

public class ProjectsCategoryPresenter implements ProjectsCategoryVP.Presenter, OnGetProjectsListener {
    private ProjectsCategoryVP.View view;

    private String categoryName;

    public ProjectsCategoryPresenter(ProjectsCategoryVP.View view, String categoryName) {
        this.view = view;
        this.categoryName = categoryName;
    }

    @Override
    public void loadProjects() {
        CkService.getInstance().getProjects(this);
    }

    @Override
    public void onProjectsLoaded(List<Project> projects) {
        view.updateProjects(projects);
    }

    @Override
    public void onError() {
        view.showProjectsError();
    }
}

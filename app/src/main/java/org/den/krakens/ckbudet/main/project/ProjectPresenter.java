package org.den.krakens.ckbudet.main.project;

import org.den.krakens.ckbudet.main.api.CkService;
import org.den.krakens.ckbudet.main.api.listeners.OnGetProjectListener;
import org.den.krakens.ckbudet.main.models.Project;

/**
 * Created by Mohru on 15.06.2018.
 */

public class ProjectPresenter implements ProjectVP.Presenter, OnGetProjectListener {
    private ProjectVP.View view;
    private int projectId;
    private String projectCategory;
    private Project project;

    public ProjectPresenter(ProjectVP.View view, int projectId, String projectCategory) {
        this.view = view;
        this.projectId = projectId;
        this.projectCategory = projectCategory;
    }

    @Override
    public void loadProject() {
        CkService.getInstance().getProject(projectCategory, projectId, this);
    }

    @Override
    public String getProjectName() {
        if (project != null)
            return project.getTitle();
        else
            return "";
    }

    @Override
    public void onGetProjectSuccess(Project project) {
        this.project = project;
        view.updateProject(project);
    }

    @Override
    public void onGetProjectError() {
        view.onProjectError();
    }
}

package org.den.krakens.ckbudet.main.yourprojects;

import org.den.krakens.ckbudet.main.api.CkService;
import org.den.krakens.ckbudet.main.api.listeners.OnGetMyProjectsListener;
import org.den.krakens.ckbudet.main.models.Project;

import java.util.List;

/**
 * Created by Mohru on 16.06.2018.
 */

public class YourProjectsPresenter implements YourProjectsVP.Presenter, OnGetMyProjectsListener {

    private YourProjectsVP.View view;

    public YourProjectsPresenter(YourProjectsVP.View view) {
        this.view = view;
    }

    @Override
    public void loadYourProjects() {
        CkService.getInstance().getMyProjects(this);
    }

    @Override
    public void deleteProject(int projectId) {

    }

    @Override
    public void onMyProjectsSuccess(List<Project> myProjects) {
        view.updateYourProjects(myProjects);
    }

    @Override
    public void onMyProjectsError() {
        view.showProjectsError();
    }
}

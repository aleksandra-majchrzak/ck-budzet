package org.den.krakens.ckbudet.main.yourprojects;

import org.den.krakens.ckbudet.main.models.Project;

import java.util.List;

/**
 * Created by Mohru on 16.06.2018.
 */

public interface YourProjectsVP {
    interface View {
        void updateYourProjects(List<Project> yourProjects);

        void showProjectsError();
    }

    interface Presenter {
        void loadYourProjects();

        void deleteProject(int projectId);

    }
}

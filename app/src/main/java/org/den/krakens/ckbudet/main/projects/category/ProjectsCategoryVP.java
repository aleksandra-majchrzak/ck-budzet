package org.den.krakens.ckbudet.main.projects.category;

import org.den.krakens.ckbudet.main.models.Project;

import java.util.List;

/**
 * Created by Mohru on 15.06.2018.
 */

public interface ProjectsCategoryVP {
    interface View {
        void updateProjects(List<Project> projects);

        void showProjectsError();
    }

    interface Presenter {
        void loadProjects();
    }
}

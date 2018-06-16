package org.den.krakens.ckbudet.main.project;

import org.den.krakens.ckbudet.main.models.Project;

/**
 * Created by Mohru on 15.06.2018.
 */

public interface ProjectVP {
    interface View {
        void updateProject(Project project);

        void onProjectError();

        void onVoted();

        void onVotedError();
    }

    interface Presenter {
        void loadProject();

        String getProjectName();

        boolean isProjectArchived();

        void vote();
    }
}

package org.den.krakens.ckbudet.main.yourprojects;

import org.den.krakens.ckbudet.main.models.Project;
import org.den.krakens.ckbudet.main.models.Tag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Mohru on 16.06.2018.
 */

public class YourProjectsPresenter implements YourProjectsVP.Presenter {

    private YourProjectsVP.View view;

    public YourProjectsPresenter(YourProjectsVP.View view) {
        this.view = view;
    }

    @Override
    public void loadYourProjects() {
        List<Project> projects = new ArrayList<>();
        projects.add(new Project("project 1", "description 1", Arrays.asList(new Tag(1, "mały"))));
        projects.add(new Project("project 2", "description 2", Arrays.asList(new Tag(1, "tag1"), new Tag(2, "tag2"), new Tag(3, "tag3"))));
        projects.add(new Project("project 3", "description 3", Arrays.asList(new Tag(1, "duzy"))));
        projects.add(new Project("project 4", "description 4", Arrays.asList(new Tag(4, "tag4"), new Tag(5, "tag5"), new Tag(6, "tag6"), new Tag(4, "tag4"), new Tag(5, "tag5"), new Tag(6, "tag6"), new Tag(4, "tag4"), new Tag(5, "tag5"), new Tag(6, "tag6"))));

        view.updateYourProjects(projects);
    }
}

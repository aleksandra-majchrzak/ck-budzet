package org.den.krakens.ckbudet.main.projects;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mohru on 15.06.2018.
 */

public class ProjectsPresenter implements ProjectsVP.Presenter {

    private ProjectsVP.View view;

    public ProjectsPresenter(ProjectsVP.View view) {
        this.view = view;
    }

    @Override
    public List<String> getCategories() {
        List<String> categories = new ArrayList<>();
        categories.add("Sport");
        categories.add("Edukacja");
        categories.add("Rozrywka");
        categories.add("Infrastruktura");
        categories.add("Technologie");
        return categories;
    }
}

package org.den.krakens.ckbudet.main.projects.category;

/**
 * Created by Mohru on 15.06.2018.
 */

public class ProjectsCategoryPresenter implements ProjectsCategoryVP.Presenter {
    private ProjectsCategoryVP.View view;

    private String categoryName;

    public ProjectsCategoryPresenter(ProjectsCategoryVP.View view, String categoryName) {
        this.view = view;
        this.categoryName = categoryName;
    }
}

package org.den.krakens.ckbudet.main.projects;

import org.den.krakens.ckbudet.main.api.CkService;
import org.den.krakens.ckbudet.main.api.listeners.OnGetCategoriesListener;
import org.den.krakens.ckbudet.main.models.Category;

import java.util.List;

/**
 * Created by Mohru on 15.06.2018.
 */

public class ProjectsPresenter implements ProjectsVP.Presenter, OnGetCategoriesListener {

    private ProjectsVP.View view;

    public ProjectsPresenter(ProjectsVP.View view) {
        this.view = view;
    }

    @Override
    public void loadCategories() {
        CkService.getInstance().getCategories(this);
    }

    @Override
    public void onCategoriesLoaded(List<Category> categories) {
        view.updateCategories(categories);
    }

    @Override
    public void onError() {
        view.showCategoryError();
    }
}

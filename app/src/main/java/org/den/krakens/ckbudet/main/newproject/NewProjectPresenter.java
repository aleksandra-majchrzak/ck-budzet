package org.den.krakens.ckbudet.main.newproject;

import org.den.krakens.ckbudet.main.api.CkService;
import org.den.krakens.ckbudet.main.api.listeners.OnCreateProjectListener;
import org.den.krakens.ckbudet.main.api.listeners.OnGetCategoriesListener;
import org.den.krakens.ckbudet.main.models.Category;
import org.den.krakens.ckbudet.main.models.Project;
import org.den.krakens.ckbudet.main.models.Tag;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mohru on 16.06.2018.
 */

public class NewProjectPresenter implements NewProjectVP.Presenter, OnGetCategoriesListener, OnCreateProjectListener {

    private NewProjectVP.View view;
    protected List<Category> categories;

    public NewProjectPresenter(NewProjectVP.View view) {
        this.view = view;
    }

    @Override
    public void loadCategories() {
        CkService.getInstance().getCategories(this);
    }

    @Override
    public void loadBudgetTypes() {
        List<String> budgetTypes = new ArrayList<>();
        budgetTypes.add("mały (do 150 tys)");
        budgetTypes.add("duży (powyżej 150 tys)");
        view.updateBudgetType(budgetTypes);
    }

    @Override
    public void addProject(String title, String description, String place, Category category, String budgetType, List<Tag> tags, Double lat, Double lng) {
        tags.add(new Tag(0, budgetType));
        Project project = new Project(title, description, tags);
        project.setPlace(place);
        project.setCategory(category);
        project.setLat(lat);
        project.setLng(lng);

        CkService.getInstance().createProject(project, this);
    }

    @Override
    public void onCategoriesLoaded(List<Category> categories) {
        this.categories = categories;
        view.updateCategories(categories);
    }

    @Override
    public void onError() {
        view.showCategoryError();
    }

    @Override
    public void onProjectCreated() {
        view.onProjectCreated();
    }

    @Override
    public void onProjectError() {
        view.onProjectError();
    }
}

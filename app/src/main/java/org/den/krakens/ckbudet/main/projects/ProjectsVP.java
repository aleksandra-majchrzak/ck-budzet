package org.den.krakens.ckbudet.main.projects;

import org.den.krakens.ckbudet.main.models.Category;

import java.util.List;

/**
 * Created by Mohru on 15.06.2018.
 */

public interface ProjectsVP {
    interface View {
        void updateCategories(List<Category> categories);

        void showCategoryError();
    }

    interface Presenter {
        void loadCategories();
    }
}

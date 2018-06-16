package org.den.krakens.ckbudet.main.newproject;

import org.den.krakens.ckbudet.main.models.Category;
import org.den.krakens.ckbudet.main.models.Tag;

import java.util.List;

/**
 * Created by Mohru on 16.06.2018.
 */

public interface NewProjectVP {
    interface View {
        void updateCategories(List<Category> categories);

        void updateBudgetType(List<String> budgetTypes);

        void showCategoryError();

        void onProjectCreated();

        void onProjectError();
    }

    interface Presenter {
        void loadCategories();

        void loadBudgetTypes();

        void addProject(String title, String description, String place, Category category, int budgetType, List<Tag> tags, Double lat, Double lng);
    }
}

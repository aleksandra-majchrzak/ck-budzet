package org.den.krakens.ckbudet.main.api.listeners;

import org.den.krakens.ckbudet.main.models.Category;

import java.util.List;

/**
 * Created by Mohru on 15.06.2018.
 */

public interface OnGetCategoriesListener {
    void onCategoriesLoaded(List<Category> categories);

    void onError();
}

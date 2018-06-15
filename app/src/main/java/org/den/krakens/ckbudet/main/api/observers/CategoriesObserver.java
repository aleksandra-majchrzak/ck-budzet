package org.den.krakens.ckbudet.main.api.observers;

import org.den.krakens.ckbudet.main.api.listeners.OnGetCategoriesListener;
import org.den.krakens.ckbudet.main.models.Category;

import java.util.List;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

/**
 * Created by Mohru on 15.06.2018.
 */

public class CategoriesObserver implements SingleObserver<List<Category>> {

    private OnGetCategoriesListener listener;

    public CategoriesObserver(OnGetCategoriesListener listener) {
        this.listener = listener;
    }

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onSuccess(List<Category> categories) {
        listener.onCategoriesLoaded(categories);
    }

    @Override
    public void onError(Throwable e) {
        listener.onError();
    }
}

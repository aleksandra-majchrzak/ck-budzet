package org.den.krakens.ckbudet.main.api.observers;

import org.den.krakens.ckbudet.main.api.listeners.OnGetMyProjectsListener;
import org.den.krakens.ckbudet.main.models.Project;

import java.util.List;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

/**
 * Created by Mohru on 16.06.2018.
 */

public class MyProjectsObserver implements SingleObserver<List<Project>> {

    private OnGetMyProjectsListener listener;

    public MyProjectsObserver(OnGetMyProjectsListener listener) {
        this.listener = listener;
    }

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onSuccess(List<Project> projects) {
        listener.onMyProjectsSuccess(projects);
    }

    @Override
    public void onError(Throwable e) {
        listener.onMyProjectsError();
    }
}

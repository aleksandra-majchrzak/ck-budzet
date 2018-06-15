package org.den.krakens.ckbudet.main.api.observers;

import org.den.krakens.ckbudet.main.api.listeners.OnGetProjectsListener;
import org.den.krakens.ckbudet.main.models.Project;

import java.util.List;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

/**
 * Created by Mohru on 15.06.2018.
 */

public class ProjectsObserver implements SingleObserver<List<Project>> {

    private OnGetProjectsListener listener;

    public ProjectsObserver(OnGetProjectsListener listener) {
        this.listener = listener;
    }

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onSuccess(List<Project> projects) {
        listener.onProjectsLoaded(projects);
    }

    @Override
    public void onError(Throwable e) {
        listener.onError();
    }
}

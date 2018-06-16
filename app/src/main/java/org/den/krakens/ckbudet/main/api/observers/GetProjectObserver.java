package org.den.krakens.ckbudet.main.api.observers;

import org.den.krakens.ckbudet.main.api.listeners.OnGetProjectListener;
import org.den.krakens.ckbudet.main.models.Project;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

/**
 * Created by Mohru on 16.06.2018.
 */

public class GetProjectObserver implements SingleObserver<Project> {

    private OnGetProjectListener listener;

    public GetProjectObserver(OnGetProjectListener listener) {
        this.listener = listener;
    }

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onSuccess(Project project) {
        listener.onGetProjectSuccess(project);
    }

    @Override
    public void onError(Throwable e) {
        listener.onGetProjectError();
    }
}

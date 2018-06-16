package org.den.krakens.ckbudet.main.api.observers;

import org.den.krakens.ckbudet.main.api.listeners.OnCreateProjectListener;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import okhttp3.ResponseBody;

/**
 * Created by Mohru on 16.06.2018.
 */

public class CreateProjectObserver implements SingleObserver<ResponseBody> {

    private OnCreateProjectListener listener;

    public CreateProjectObserver(OnCreateProjectListener listener) {
        this.listener = listener;
    }

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onSuccess(ResponseBody responseBody) {
        listener.onProjectCreated();
    }

    @Override
    public void onError(Throwable e) {
        listener.onProjectError();
    }
}

package org.den.krakens.ckbudet.main.api.observers;

import org.den.krakens.ckbudet.main.api.listeners.OnLoginListener;
import org.den.krakens.ckbudet.main.models.Token;

import java.util.List;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

/**
 * Created by Mohru on 16.06.2018.
 */

public class LoginObserver implements SingleObserver<Token> {

    private List<OnLoginListener> listeners;

    public LoginObserver(List<OnLoginListener> listeners) {
        this.listeners = listeners;
    }

    @Override
    public void onSubscribe(Disposable d) {
    }

    @Override
    public void onSuccess(Token token) {
        for (OnLoginListener listener : listeners) {
            listener.onLoginSuccess(token);
        }
    }

    @Override
    public void onError(Throwable e) {
        for (OnLoginListener listener : listeners) {
            listener.onLoginError();
        }
    }
}

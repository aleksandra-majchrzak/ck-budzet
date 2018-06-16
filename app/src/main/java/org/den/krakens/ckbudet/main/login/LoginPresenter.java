package org.den.krakens.ckbudet.main.login;

import org.den.krakens.ckbudet.main.api.CkService;
import org.den.krakens.ckbudet.main.api.listeners.OnLoginListener;
import org.den.krakens.ckbudet.main.models.Token;

/**
 * Created by Mohru on 16.06.2018.
 */

public class LoginPresenter implements LoginVP.Presenter, OnLoginListener {

    private LoginVP.View view;

    public LoginPresenter(LoginVP.View view) {
        this.view = view;
    }

    @Override
    public void login(String email, String password) {
        CkService.getInstance().login(email, password, this);
    }

    @Override
    public void onLoginSuccess(Token token) {
        view.onLoginSuccess();
    }

    @Override
    public void onLoginError() {
        view.onLoginError();
    }
}

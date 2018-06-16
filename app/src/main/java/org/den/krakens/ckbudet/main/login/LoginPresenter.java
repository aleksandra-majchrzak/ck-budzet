package org.den.krakens.ckbudet.main.login;

/**
 * Created by Mohru on 16.06.2018.
 */

public class LoginPresenter implements LoginVP.Presenter {

    private LoginVP.View view;

    public LoginPresenter(LoginVP.View view) {
        this.view = view;
    }

    @Override
    public void login(String email, String password) {
        view.onLoginSuccess();
    }
}

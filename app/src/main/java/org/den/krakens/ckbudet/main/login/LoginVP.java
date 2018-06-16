package org.den.krakens.ckbudet.main.login;

/**
 * Created by Mohru on 16.06.2018.
 */

public interface LoginVP {
    interface View {
        void onLoginSuccess();

        void onLoginError();
    }

    interface Presenter {
        void login(String email, String password);
    }
}

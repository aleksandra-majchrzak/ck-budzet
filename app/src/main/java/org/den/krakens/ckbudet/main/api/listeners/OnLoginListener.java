package org.den.krakens.ckbudet.main.api.listeners;

import org.den.krakens.ckbudet.main.models.Token;

/**
 * Created by Mohru on 16.06.2018.
 */

public interface OnLoginListener {
    void onLoginSuccess(Token token);

    void onLoginError();
}

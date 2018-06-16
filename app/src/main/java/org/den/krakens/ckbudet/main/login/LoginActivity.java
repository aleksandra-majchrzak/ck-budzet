package org.den.krakens.ckbudet.main.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;

import org.den.krakens.ckbudet.R;
import org.den.krakens.ckbudet.main.MainActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements LoginVP.View {

    private LoginVP.Presenter presenter;

    @BindView(R.id.email_et)
    EditText emailEditText;
    @BindView(R.id.password_et)
    EditText passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);
        setPresenter();
    }

    private void setPresenter() {
        presenter = new LoginPresenter(this);
    }

    @OnClick(R.id.login_button)
    public void onLoginClick() {
        presenter.login(emailEditText.getText().toString(), passwordEditText.getText().toString());
    }

    @Override
    public void onLoginSuccess() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onLoginError() {
        Toast.makeText(this, "Nie udało się zalogować.", Toast.LENGTH_LONG).show();
    }
}

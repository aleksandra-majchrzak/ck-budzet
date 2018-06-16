package org.den.krakens.ckbudet.main.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
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
    @BindView(R.id.progress)
    ProgressBar progressBar;

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
        progressBar.setVisibility(View.VISIBLE);
        presenter.login(emailEditText.getText().toString(), passwordEditText.getText().toString());
    }

    @Override
    public void onLoginSuccess() {
        progressBar.setVisibility(View.GONE);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onLoginError() {
        progressBar.setVisibility(View.GONE);
        Toast.makeText(this, R.string.login_failure, Toast.LENGTH_LONG).show();
    }
}

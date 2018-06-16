package org.den.krakens.ckbudet.main.comments;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import org.den.krakens.ckbudet.R;
import org.den.krakens.ckbudet.main.Constants;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class CommentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);

        ButterKnife.bind(this);

        this.setTitle(getIntent().getStringExtra(Constants.projectName));
    }

    @OnClick(R.id.send_button)
    public void onSendButtonClick() {
        Toast.makeText(this, "Komentarz dodany.", Toast.LENGTH_LONG).show();
        this.finish();
    }
}

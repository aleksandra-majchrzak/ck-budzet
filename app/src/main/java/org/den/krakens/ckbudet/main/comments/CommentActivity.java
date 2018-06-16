package org.den.krakens.ckbudet.main.comments;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @OnClick(R.id.send_button)
    public void onSendButtonClick() {
        Toast.makeText(this, R.string.comment_added, Toast.LENGTH_LONG).show();
        this.finish();
    }
}

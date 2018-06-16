package org.den.krakens.ckbudet.main.comments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import org.den.krakens.ckbudet.R;
import org.den.krakens.ckbudet.main.Constants;
import org.den.krakens.ckbudet.main.models.Comment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CommentActivity extends AppCompatActivity implements CommentsVP.View {

    private CommentsVP.Presenter presenter;

    @BindView(R.id.content_et)
    EditText contentEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);

        ButterKnife.bind(this);
        setPresenter();
        this.setTitle(getIntent().getStringExtra(Constants.projectName));
    }

    private void setPresenter() {
        this.presenter = new CommentsPresenter(this);
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
        String category = getIntent().getStringExtra(Constants.projectCategory);
        int projectId = getIntent().getIntExtra(Constants.projectId, 0);
        presenter.addComment(category, projectId, contentEditText.getText().toString());
    }

    @Override
    public void onCommentAdded(Comment comment) {
        Intent intent = new Intent();
        intent.putExtra(Constants.commentExtra, comment);
        setResult(Activity.RESULT_OK, intent);
        this.finish();
    }

    @Override
    public void onCommentError() {

    }
}

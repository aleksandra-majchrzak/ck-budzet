package org.den.krakens.ckbudet.main.project;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexboxLayoutManager;

import org.den.krakens.ckbudet.R;
import org.den.krakens.ckbudet.main.Constants;
import org.den.krakens.ckbudet.main.comments.CommentActivity;
import org.den.krakens.ckbudet.main.models.Project;
import org.den.krakens.ckbudet.main.projects.category.TagsAdapter;
import org.den.krakens.ckbudet.main.report.ReportActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProjectActivity extends AppCompatActivity implements ProjectVP.View {

    private ProjectVP.Presenter presenter;

    @BindView(R.id.title_tv)
    TextView titleTextView;
    @BindView(R.id.category_tv)
    TextView categoryTextView;
    @BindView(R.id.description_tv)
    TextView descriptionTextView;
    @BindView(R.id.place_tv)
    TextView placeTextview;
    @BindView(R.id.tags_rv)
    RecyclerView tagsRecyclerView;
    @BindView(R.id.comments_count_tv)
    TextView commentsCountTextView;
    @BindView(R.id.comments_cl)
    ConstraintLayout commentsConstrainLayout;
    @BindView(R.id.comments_rv)
    RecyclerView commentsRecyclerView;
    @BindView(R.id.vote_button)
    Button voteButton;
    @BindView(R.id.progress)
    ProgressBar progressBar;
    @BindView(R.id.bottom_cl)
    ConstraintLayout bottomConstraintLayout;

    TagsAdapter tagsAapter;
    CommentsAdapter commentsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project);

        ButterKnife.bind(this);

        initComponents();
        setPresenter();
        presenter.loadProject();
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

    private void setPresenter() {
        this.presenter = new ProjectPresenter(this,
                getIntent().getIntExtra(Constants.projectId, 0),
                getIntent().getStringExtra(Constants.projectCategory));
    }

    private void initComponents() {
        tagsAapter = new TagsAdapter(new ArrayList<>());
        FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(this, FlexDirection.ROW);
        tagsRecyclerView.setLayoutManager(layoutManager);
        tagsRecyclerView.setAdapter(tagsAapter);

        commentsAdapter = new CommentsAdapter(new ArrayList<>());
        commentsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        commentsRecyclerView.setAdapter(commentsAdapter);
    }

    @Override
    public void updateProject(Project project) {
        progressBar.setVisibility(View.GONE);
        titleTextView.setText(project.getTitle());
        categoryTextView.setText(project.getCategory().getName());
        descriptionTextView.setText(project.getDescription());
        placeTextview.setText(project.getPlace());
        tagsAapter.addTags(project.getTags());
        commentsAdapter.addComments(project.getComments());
        commentsCountTextView.setText(String.format("(%s)", project.getComments().size()));

        if (!presenter.isProjectArchived())
            bottomConstraintLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void onProjectError() {
        progressBar.setVisibility(View.GONE);
        Toast.makeText(this, R.string.load_project_failure, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onVoted() {
        new AlertDialog.Builder(this)
                .setMessage(R.string.vote_thanks)
                .setPositiveButton(getString(R.string.ok), (dialogInterface, i) -> {
                    voteButton.setEnabled(false);
                })
                .setCancelable(false)
                .show();
    }

    @Override
    public void onVotedError() {
        Toast.makeText(this, R.string.voting_failure, Toast.LENGTH_LONG).show();
    }

    @OnClick(R.id.comments_ll)
    public void onCommentsClick() {
        commentsConstrainLayout.setVisibility(View.VISIBLE);
    }

    @OnClick(R.id.add_comment_button)
    public void onAddCommentClick() {
        Intent intent = new Intent(this, CommentActivity.class);
        intent.putExtra(Constants.projectName, presenter.getProjectName());
        intent.putExtra(Constants.projectId, getIntent().getIntExtra(Constants.projectId, 0));
        startActivity(intent);
    }

    @OnClick(R.id.vote_button)
    public void onVoteButtonClick() {
        new AlertDialog.Builder(this)
                .setMessage(R.string.vote_confirmation)
                .setPositiveButton(getString(R.string.ok), (dialogInterface, i) -> {
                    presenter.vote();
                })
                .setNegativeButton(getString(R.string.cancel), (dialogInterface, i) -> {
                })
                .show();
    }

    @OnClick(R.id.report_button)
    public void onReportButtonClick() {
        Intent intent = new Intent(this, ReportActivity.class);
        intent.putExtra(Constants.projectId, getIntent().getIntExtra(Constants.projectId, 0));
        startActivity(intent);
    }
}

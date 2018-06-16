package org.den.krakens.ckbudet.main.project;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexboxLayoutManager;

import org.den.krakens.ckbudet.R;
import org.den.krakens.ckbudet.main.Constants;
import org.den.krakens.ckbudet.main.models.Project;
import org.den.krakens.ckbudet.main.projects.category.TagsAdapter;

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

    private void setPresenter() {
        this.presenter = new ProjectPresenter(this, getIntent().getIntExtra(Constants.projectId, 0));
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
        titleTextView.setText(project.getTitle());
        categoryTextView.setText(project.getCategory().getName());
        descriptionTextView.setText(project.getDescription());
        placeTextview.setText(project.getPlace());
        tagsAapter.addTags(project.getTags());
        commentsAdapter.addComments(project.getComments());
        commentsCountTextView.setText(String.format("(%s)", project.getComments().size()));
    }

    @OnClick(R.id.comments_ll)
    public void onCommentsClick() {
        commentsConstrainLayout.setVisibility(View.VISIBLE);
    }

    @OnClick(R.id.add_comment_button)
    public void onAddCommentClick() {

    }

    @OnClick(R.id.vote_button)
    public void onVoteButtonClick() {

    }

    @OnClick(R.id.report_button)
    public void onReportButtonClick() {

    }
}

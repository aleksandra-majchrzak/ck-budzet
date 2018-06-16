package org.den.krakens.ckbudet.main.comments;

import org.den.krakens.ckbudet.main.api.CkService;
import org.den.krakens.ckbudet.main.api.listeners.OnAddCommentListener;
import org.den.krakens.ckbudet.main.models.Comment;

/**
 * Created by Mohru on 16.06.2018.
 */

public class CommentsPresenter implements CommentsVP.Presenter, OnAddCommentListener {
    private CommentsVP.View view;

    public CommentsPresenter(CommentsVP.View view) {
        this.view = view;
    }

    @Override
    public void addComment(String category, int projectId, String content) {
        CkService.getInstance().addComment(category, projectId, new Comment(0, content, null), this);
    }

    @Override
    public void onCommentAdded(Comment comment) {
        view.onCommentAdded(comment);
    }

    @Override
    public void onCommentError() {
        view.onCommentError();
    }
}

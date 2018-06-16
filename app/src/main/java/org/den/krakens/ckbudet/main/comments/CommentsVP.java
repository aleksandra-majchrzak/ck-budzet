package org.den.krakens.ckbudet.main.comments;

import org.den.krakens.ckbudet.main.models.Comment;

/**
 * Created by Mohru on 16.06.2018.
 */

public interface CommentsVP {
    interface View {
        void onCommentAdded(Comment comment);

        void onCommentError();
    }

    interface Presenter {
        void addComment(String category, int projectId, String content);
    }
}

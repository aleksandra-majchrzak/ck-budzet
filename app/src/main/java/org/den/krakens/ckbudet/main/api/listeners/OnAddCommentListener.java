package org.den.krakens.ckbudet.main.api.listeners;

import org.den.krakens.ckbudet.main.models.Comment;

/**
 * Created by Mohru on 16.06.2018.
 */

public interface OnAddCommentListener {
    void onCommentAdded(Comment comment);

    void onCommentError();
}

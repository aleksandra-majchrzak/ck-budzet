package org.den.krakens.ckbudet.main.api.observers;

import org.den.krakens.ckbudet.main.api.listeners.OnAddCommentListener;
import org.den.krakens.ckbudet.main.models.Comment;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import okhttp3.ResponseBody;

/**
 * Created by Mohru on 16.06.2018.
 */

public class AddCommentObserver implements SingleObserver<Comment> {

    private OnAddCommentListener listener;

    public AddCommentObserver(OnAddCommentListener listener) {
        this.listener = listener;
    }

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onSuccess(Comment comment) {
        listener.onCommentAdded(comment);
    }

    @Override
    public void onError(Throwable e) {
        listener.onCommentError();
    }
}

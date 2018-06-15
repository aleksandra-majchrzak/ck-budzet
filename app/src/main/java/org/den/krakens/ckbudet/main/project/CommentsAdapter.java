package org.den.krakens.ckbudet.main.project;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import org.den.krakens.ckbudet.R;
import org.den.krakens.ckbudet.main.models.Comment;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Mohru on 15.06.2018.
 */

public class CommentsAdapter extends RecyclerView.Adapter<CommentsAdapter.CommentsViewHolder> {

    private List<Comment> comments;

    public CommentsAdapter(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public CommentsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.comment_row, null);
        return new CommentsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CommentsViewHolder holder, int position) {
        Comment comment = comments.get(position);
        holder.nickTextView.setText(comment.getUser().getNick());
        holder.contentTextView.setText(comment.getContent());
        holder.reportCommentButton.setOnClickListener(view -> {

        });
    }

    @Override
    public int getItemCount() {
        return comments.size();
    }

    public void addComments(List<Comment> comments) {
        int index = this.comments.size() - 1;
        this.comments.addAll(comments);
        notifyItemRangeInserted(index, comments.size());
    }

    class CommentsViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.nick_tv)
        TextView nickTextView;
        @BindView(R.id.content_tv)
        TextView contentTextView;
        @BindView(R.id.report_comment_button)
        ImageButton reportCommentButton;

        public CommentsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

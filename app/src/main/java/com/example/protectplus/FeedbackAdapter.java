package com.example.protectplus;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.protectplus.model.Feedback;

import java.util.List;

public class FeedbackAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_LEFT = 0;
    private static final int TYPE_RIGHT = 1;

    private Context context;
    private List<Feedback> feedbackList;

    public FeedbackAdapter(Context context, List<Feedback> feedbackList) {
        this.context = context;
        this.feedbackList = feedbackList;
    }

    @Override
    public int getItemViewType(int position) {
        Feedback feedback = feedbackList.get(position);
        return feedback.isAvatarLeft() ? TYPE_LEFT : TYPE_RIGHT;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TYPE_LEFT) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_feedback_left, parent, false);
            return new FeedbackLeftViewHolder(view);
        } else {
            View view = LayoutInflater.from(context).inflate(R.layout.item_feedback_right, parent, false);
            return new FeedbackRightViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Feedback feedback = feedbackList.get(position);

        if (holder instanceof FeedbackLeftViewHolder) {
            ((FeedbackLeftViewHolder) holder).avatarImageView.setImageResource(feedback.getAvatarResource());
            ((FeedbackLeftViewHolder) holder).feedbackTextView.setText(feedback.getFeedbackText());
        } else if (holder instanceof FeedbackRightViewHolder) {
            ((FeedbackRightViewHolder) holder).avatarImageView.setImageResource(feedback.getAvatarResource());
            ((FeedbackRightViewHolder) holder).feedbackTextView.setText(feedback.getFeedbackText());
        }
    }

    @Override
    public int getItemCount() {
        return feedbackList.size();
    }

    static class FeedbackLeftViewHolder extends RecyclerView.ViewHolder {
        ImageView avatarImageView;
        TextView feedbackTextView;

        public FeedbackLeftViewHolder(@NonNull View itemView) {
            super(itemView);
            avatarImageView = itemView.findViewById(R.id.avatarImageView);
            feedbackTextView = itemView.findViewById(R.id.feedbackTextView);
        }
    }

    static class FeedbackRightViewHolder extends RecyclerView.ViewHolder {
        ImageView avatarImageView;
        TextView feedbackTextView;

        public FeedbackRightViewHolder(@NonNull View itemView) {
            super(itemView);
            avatarImageView = itemView.findViewById(R.id.avatarImageView);
            feedbackTextView = itemView.findViewById(R.id.feedbackTextView);
        }
    }
}

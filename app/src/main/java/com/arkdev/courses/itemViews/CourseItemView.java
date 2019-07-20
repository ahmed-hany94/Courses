package com.arkdev.courses.itemViews;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.arkdev.courses.R;
import com.arkdev.courses.models.Child;
import com.bumptech.glide.Glide;

public class CourseItemView extends RecyclerView.ViewHolder{

    private ImageView courseIconImageView;
    private TextView courseTitleTextView, courseUrlTextView;

    View itemView;

    public CourseItemView(@NonNull View itemView) {
        super(itemView);
        this.itemView = itemView;
        courseIconImageView = itemView.findViewById(R.id.course_image_view);
        courseTitleTextView = itemView.findViewById(R.id.course_title_text_view);
        courseUrlTextView = itemView.findViewById(R.id.course_url_text_view);
    }

    public void bindView(Child child){
        courseTitleTextView.setText(child.getTitle());
        courseUrlTextView.setText(child.getUrl());
        Glide.with(itemView).load(child.getIcon()).into(courseIconImageView);
    }
}

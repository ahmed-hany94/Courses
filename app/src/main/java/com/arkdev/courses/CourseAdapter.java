package com.arkdev.courses;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class CourseAdapter extends RecyclerView.Adapter<CourseItemView>{

    List<Child> coursesLists;

    @NonNull
    @Override
    public CourseItemView onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.course_item_view, viewGroup, false);
        return new CourseItemView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseItemView courseItemView, int i) {
        courseItemView.bindView(coursesLists.get(i));
    }

    @Override
    public int getItemCount() {
        return coursesLists.size();
    }

    public void setCoursesLists(List<Child> coursesLists) {
        this.coursesLists = coursesLists;
    }
}

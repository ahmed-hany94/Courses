package com.arkdev.courses;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CoursesListActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    LinearLayoutManager mLayoutManager;
    Retrofit retrofit;

    ApiInterface apiInterface;

    List<Child> coursesList;
    CourseAdapter courseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses_list);

        initUI();

        retrieveCourse();
    }

    private void initUI() {
        recyclerView = findViewById(R.id.recycler_view);
        mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);

        retrofit = new Retrofit.Builder()
                .baseUrl(JsonConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiInterface = retrofit.create(ApiInterface.class);

        coursesList = new ArrayList<>();
    }

    private void retrieveCourse() {
        Call<ApiModel> getCourses = this.apiInterface.getCourses();
        getCourses.enqueue(new Callback<ApiModel>() {
            @Override
            public void onResponse(Call<ApiModel> call, Response<ApiModel> response) {
                // Uncomment if you want to debug
                int x = 10;

                if(response.isSuccessful()){
                    if(response.body().getChildren().size() != 0 &&
                        response.body().getChildren() != null){
                        for(int i = 0; i < response.body().getChildren().size(); i++){
                            // Note: Not all the info
                            coursesList.add(new Child(
                                    response.body().getChildren().get(i).getDescription(),
                                    response.body().getChildren().get(i).getIcon(),
                                    response.body().getChildren().get(i).getTitle(),
                                    response.body().getChildren().get(i).getUrl()
                            ));
                        }
                        courseAdapter = new CourseAdapter();
                        courseAdapter.setCoursesLists(coursesList);
                        recyclerView.setAdapter(courseAdapter);
                    }
                }
            }

            @Override
            public void onFailure(Call<ApiModel> call, Throwable t) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}

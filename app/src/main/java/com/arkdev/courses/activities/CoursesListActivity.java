package com.arkdev.courses.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.arkdev.courses.R;
import com.arkdev.courses.adapters.CourseAdapter;
import com.arkdev.courses.constants.JsonConstants;
import com.arkdev.courses.handlers.DatabaseHandler;
import com.arkdev.courses.interfaces.ApiInterface;
import com.arkdev.courses.models.ApiModel;
import com.arkdev.courses.models.Child;
import com.arkdev.courses.models.CourseAttendees;
import com.arkdev.courses.models.User;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CoursesListActivity extends AppCompatActivity {

    // Models
    User user;
    CourseAttendees courseAttendees;
    List<Child> coursesList;
    // Adapters
    CourseAdapter courseAdapter;
    // Handlers
    DatabaseHandler databaseHandler;
    // Interfaces
    ApiInterface apiInterface;
    // Libraries
    RecyclerView recyclerView;
    LinearLayoutManager mLayoutManager;
    Retrofit retrofit;

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
        databaseHandler = DatabaseHandler.getInstance();
        user = new User();

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
                            Child child = new Child(
                                    response.body().getChildren().get(i).getCourseID(),
                                    response.body().getChildren().get(i).getTitle(),
                                    response.body().getChildren().get(i).getIcon(),
                                    response.body().getChildren().get(i).getIconLarge(),
                                    response.body().getChildren().get(i).getUrl(),
                                    response.body().getChildren().get(i).getDescription()
                                    );
                            coursesList.add(child);

                            databaseHandler.addData(child, "courses");

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

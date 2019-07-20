package com.arkdev.courses.interfaces;

import com.arkdev.courses.models.ApiModel;
import com.arkdev.courses.constants.JsonConstants;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET(JsonConstants.COMPUTING_URL)
    Call<ApiModel> getCourses();
}

package com.arkdev.courses;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET(JsonConstants.COMPUTING_URL)
    Call<ApiModel> getCourses();
}

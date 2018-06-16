package org.den.krakens.ckbudet.main.api;

import org.den.krakens.ckbudet.main.models.Category;
import org.den.krakens.ckbudet.main.models.Project;

import java.util.List;

import io.reactivex.Single;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by Mohru on 15.06.2018.
 */

public interface CkApi {

    @GET("api/categories")
    Single<List<Category>> getCategories();

    @GET("api/categories/{category}/projects")
    Single<List<Project>> getProjects(@Path("category") String category);

    @POST("api/categories/{category}")
    Single<ResponseBody> createProject(@Path("category") String category, @Body Project project);
}

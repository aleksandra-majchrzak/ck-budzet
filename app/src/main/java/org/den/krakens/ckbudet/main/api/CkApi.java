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
import retrofit2.http.Query;

/**
 * Created by Mohru on 15.06.2018.
 */

public interface CkApi {

    @GET("api/categories")
    Single<List<Category>> getCategories();

    @GET("api/categories/{category}/projects")
    Single<List<Project>> getProjects(@Path("category") String category, @Query("per_page") int perPage, @Query("page") int page);

    @GET("api/categories/{category}/projects/archived")
    Single<List<Project>> getArchiveProjects(@Path("category") String category, @Query("per_page") int perPage, @Query("page") int page);

    @GET("api/categories/{category}/projects/{id}")
    Single<Project> getProject(@Path("category") String category, @Path("id") int projectId);

    @POST("api/categories/{category}")
    Single<ResponseBody> createProject(@Path("category") String category, @Body Project project);
}

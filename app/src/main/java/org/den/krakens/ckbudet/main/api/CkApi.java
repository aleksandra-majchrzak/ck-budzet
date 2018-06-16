package org.den.krakens.ckbudet.main.api;

import org.den.krakens.ckbudet.main.models.Category;
import org.den.krakens.ckbudet.main.models.Comment;
import org.den.krakens.ckbudet.main.models.Project;
import org.den.krakens.ckbudet.main.models.Token;

import java.util.List;

import io.reactivex.Single;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Mohru on 15.06.2018.
 */

public interface CkApi {
    String AUTHORIZATION_TOKEN = "AuthorizationUserToken";

    @POST("api/sessions")
    Single<Token> login(@Query("email") String email, @Query("password") String password);

    @GET("api/categories")
    Single<List<Category>> getCategories(@Header(AUTHORIZATION_TOKEN) String token);

    @GET("api/categories/{category}/projects")
    Single<List<Project>> getProjects(@Header(AUTHORIZATION_TOKEN) String token, @Path("category") String category, @Query("per_page") int perPage, @Query("page") int page);

    @GET("api/categories/{category}/projects/archived")
    Single<List<Project>> getArchiveProjects(@Header(AUTHORIZATION_TOKEN) String token, @Path("category") String category, @Query("per_page") int perPage, @Query("page") int page);

    @GET("api/categories/{category}/projects/{id}")
    Single<Project> getProject(@Header(AUTHORIZATION_TOKEN) String token, @Path("category") String category, @Path("id") int projectId);

    @GET("/api/my/projects")
    Single<List<Project>> getMyProjects(@Header(AUTHORIZATION_TOKEN) String token);

    @POST("api/categories/{category}")
    Single<ResponseBody> createProject(@Header(AUTHORIZATION_TOKEN) String token, @Path("category") String category, @Body Project project);

    @POST("api/categories/{category}/projects/{id}/comments")
    Single<Comment> addComment(@Header(AUTHORIZATION_TOKEN) String token, @Path("category") String category, @Path("id") int projectId, @Body Comment comment);
}

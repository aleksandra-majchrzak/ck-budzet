package org.den.krakens.ckbudet.main.api;

import org.den.krakens.ckbudet.main.models.Category;
import org.den.krakens.ckbudet.main.models.Project;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;

/**
 * Created by Mohru on 15.06.2018.
 */

public interface CkApi {

    @GET("api/categories")
    Single<List<Category>> getCategories();


    @GET("api/projects")
    Single<List<Project>> getProjects();
}

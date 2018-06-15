package org.den.krakens.ckbudet.main.api;

import org.den.krakens.ckbudet.main.api.listeners.OnGetCategoriesListener;
import org.den.krakens.ckbudet.main.api.listeners.OnGetProjectsListener;
import org.den.krakens.ckbudet.main.api.observers.CategoriesObserver;
import org.den.krakens.ckbudet.main.api.observers.ProjectsObserver;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Mohru on 15.06.2018.
 */

public class CkService {

    private static CkService service;
    private CkApi api;

    private final String BASE_URL = "https://ck-budget.herokuapp.com";

    private CkService() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api = retrofit.create(CkApi.class);
    }

    public static CkService getInstance() {
        if (service == null)
            service = new CkService();

        return service;
    }

    public void getCategories(OnGetCategoriesListener listener) {
        api.getCategories().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new CategoriesObserver(listener));
    }

    public void getProjects(OnGetProjectsListener listener) {
        api.getProjects().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new ProjectsObserver(listener));
    }


}

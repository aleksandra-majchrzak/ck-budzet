package org.den.krakens.ckbudet.main.api;

import org.den.krakens.ckbudet.main.api.listeners.OnCreateProjectListener;
import org.den.krakens.ckbudet.main.api.listeners.OnGetCategoriesListener;
import org.den.krakens.ckbudet.main.api.listeners.OnGetMyProjectsListener;
import org.den.krakens.ckbudet.main.api.listeners.OnGetProjectListener;
import org.den.krakens.ckbudet.main.api.listeners.OnGetProjectsListener;
import org.den.krakens.ckbudet.main.api.listeners.OnLoginListener;
import org.den.krakens.ckbudet.main.api.observers.CategoriesObserver;
import org.den.krakens.ckbudet.main.api.observers.CreateProjectObserver;
import org.den.krakens.ckbudet.main.api.observers.GetProjectObserver;
import org.den.krakens.ckbudet.main.api.observers.LoginObserver;
import org.den.krakens.ckbudet.main.api.observers.MyProjectsObserver;
import org.den.krakens.ckbudet.main.api.observers.ProjectsObserver;
import org.den.krakens.ckbudet.main.models.Project;
import org.den.krakens.ckbudet.main.models.Token;

import java.util.ArrayList;
import java.util.List;

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

public class CkService implements OnLoginListener {

    private static CkService service;
    private CkApi api;
    private Token token;

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

    public void login(String email, String password, OnLoginListener listener) {
        List<OnLoginListener> listeners = new ArrayList<>();
        listeners.add(listener);
        listeners.add(this);
        api.login(email, password).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new LoginObserver(listeners));
    }

    public void getCategories(OnGetCategoriesListener listener) {
        api.getCategories(token.getToken()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new CategoriesObserver(listener));
    }

    public void getProjects(String category, OnGetProjectsListener listener) {
        api.getProjects(token.getToken(), category, 20, 1).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new ProjectsObserver(listener));
    }

    public void getArchiveProjects(String category, OnGetProjectsListener listener) {
        api.getArchiveProjects(token.getToken(), category, 20, 1).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new ProjectsObserver(listener));
    }

    public void getProject(String category, int projectId, OnGetProjectListener listener) {
        api.getProject(token.getToken(), category, projectId).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new GetProjectObserver(listener));
    }

    public void getMyProjects(OnGetMyProjectsListener listener) {
        api.getMyProjects(token.getToken()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new MyProjectsObserver(listener));
    }

    public void createProject(Project project, OnCreateProjectListener listener) {
        api.createProject(token.getToken(), project.getCategory().getName(), project).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new CreateProjectObserver(listener));
    }

    @Override
    public void onLoginSuccess(Token token) {
        this.token = token;
    }

    @Override
    public void onLoginError() {

    }
}

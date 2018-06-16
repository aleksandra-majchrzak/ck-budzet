package org.den.krakens.ckbudet.main.api.listeners;

import org.den.krakens.ckbudet.main.models.Project;

import java.util.List;

/**
 * Created by Mohru on 16.06.2018.
 */

public interface OnGetMyProjectsListener {
    void onMyProjectsSuccess(List<Project> myProjects);

    void onMyProjectsError();
}

package org.den.krakens.ckbudet.main.api.listeners;

import org.den.krakens.ckbudet.main.models.Project;

import java.util.List;

/**
 * Created by Mohru on 15.06.2018.
 */

public interface OnGetProjectsListener {
    void onProjectsLoaded(List<Project> projects);

    void onError();
}

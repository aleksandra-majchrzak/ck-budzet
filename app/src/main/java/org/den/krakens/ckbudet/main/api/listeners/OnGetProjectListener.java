package org.den.krakens.ckbudet.main.api.listeners;

import org.den.krakens.ckbudet.main.models.Project;

/**
 * Created by Mohru on 16.06.2018.
 */

public interface OnGetProjectListener {
    void onGetProjectSuccess(Project project);

    void onGetProjectError();
}

package org.den.krakens.ckbudet.main.projects;

import java.util.List;

/**
 * Created by Mohru on 15.06.2018.
 */

public interface ProjectsVP {
    interface View {

    }

    interface Presenter {
        List<String> getCategories();
    }
}

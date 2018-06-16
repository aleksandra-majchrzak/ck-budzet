package org.den.krakens.ckbudet.main.report;

/**
 * Created by Mohru on 16.06.2018.
 */

public interface ReportVP {
    interface View {
        void onProjectReported();

        void onProjectError();
    }

    interface Presenter {
        void reportProject(int projectId, String reason);
    }
}

package org.den.krakens.ckbudet.main.report;

/**
 * Created by Mohru on 16.06.2018.
 */

public class ReportPresenter implements ReportVP.Presenter {

    private ReportVP.View view;

    public ReportPresenter(ReportVP.View view) {
        this.view = view;
    }

    @Override
    public void reportProject(int projectId, String reason) {

    }
}

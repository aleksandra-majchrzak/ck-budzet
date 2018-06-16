package org.den.krakens.ckbudet.main.report;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import org.den.krakens.ckbudet.R;

public class ReportActivity extends AppCompatActivity implements ReportVP.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        this.setTitle(getString(R.string.report_project));
    }

    @Override
    public void onProjectReported() {
        Toast.makeText(this, "Projekt został zgłoszony do administratora.", Toast.LENGTH_LONG).show();
        finish();
    }

    @Override
    public void onProjectError() {
        Toast.makeText(this, "Nie można zgłosić projektu.", Toast.LENGTH_LONG).show();
    }
}

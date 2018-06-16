package org.den.krakens.ckbudet.main.report;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
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
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onProjectReported() {
        Toast.makeText(this, R.string.project_reported, Toast.LENGTH_LONG).show();
        finish();
    }

    @Override
    public void onProjectError() {
        Toast.makeText(this, R.string.report_project_failure, Toast.LENGTH_LONG).show();
    }
}

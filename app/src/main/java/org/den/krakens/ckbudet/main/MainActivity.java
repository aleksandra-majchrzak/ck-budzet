package org.den.krakens.ckbudet.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import org.den.krakens.ckbudet.R;
import org.den.krakens.ckbudet.main.contact.ContactFragment;
import org.den.krakens.ckbudet.main.newproject.NewProjectActivity;
import org.den.krakens.ckbudet.main.projects.ProjectsFragment;
import org.den.krakens.ckbudet.main.projects.ProjectsPresenter;
import org.den.krakens.ckbudet.main.yourprojects.YourProjectsFragment;
import org.den.krakens.ckbudet.main.yourprojects.YourProjectsPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import uk.co.deanwild.materialshowcaseview.MaterialShowcaseView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.nav_view)
    NavigationView navigationView;
    @BindView(R.id.container)
    FrameLayout container;
    @BindView(R.id.add_project_fab)
    FloatingActionButton addProjectFab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_projects);

        ProjectsFragment fragment = new ProjectsFragment();
        fragment.setPresenter(new ProjectsPresenter(fragment, false));
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();

        this.setTitle(R.string.projects);
        initShowcase();
    }

    private void initShowcase() {
        new MaterialShowcaseView.Builder(this)
                .setTarget(addProjectFab)
                .setMaskColour(R.color.colorPrimaryDark)
                .setDismissText("Rozumiem")
                .setContentText("Każdy użytkownik może dodać 3 swoje projekty. Nowy projekt utworzysz klikając na ten przycisk.")
                .setDelay(500)
                .singleUse(Constants.createProjectShowcase)
                .show();
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_search) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_projects) {
            this.setTitle(R.string.projects);
            addProjectFab.setVisibility(View.VISIBLE);
            ProjectsFragment fragment = new ProjectsFragment();
            fragment.setPresenter(new ProjectsPresenter(fragment, false));
            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
        } else if (id == R.id.nav_archive) {
            this.setTitle(getString(R.string.archive_projects));
            addProjectFab.setVisibility(View.GONE);
            ProjectsFragment fragment = new ProjectsFragment();
            fragment.setPresenter(new ProjectsPresenter(fragment, true));
            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();

        } else if (id == R.id.nav_yours) {
            this.setTitle(R.string.your_projects);
            addProjectFab.setVisibility(View.GONE);
            YourProjectsFragment fragment = new YourProjectsFragment();
            fragment.setPresenter(new YourProjectsPresenter(fragment));
            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();

        } else if (id == R.id.nav_contact) {
            this.setTitle(R.string.contact);
            addProjectFab.setVisibility(View.GONE);
            ContactFragment fragment = new ContactFragment();
            //fragment.setPresenter(new ProjectsPresenter(fragment));
            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @OnClick(R.id.add_project_fab)
    public void onNewProjectClick() {
        Intent intent = new Intent(this, NewProjectActivity.class);
        startActivity(intent);
    }
}

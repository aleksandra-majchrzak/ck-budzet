package org.den.krakens.ckbudet.main.projects;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import org.den.krakens.ckbudet.R;
import org.den.krakens.ckbudet.main.models.Category;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProjectsFragment extends Fragment implements ProjectsVP.View, TabLayout.OnTabSelectedListener {

    private ProjectsVP.Presenter presenter;

    @BindView(R.id.projects_tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.projects_viewPager)
    ViewPager viewPager;
    @BindView(R.id.progress)
    ProgressBar progressBar;

    public ProjectsFragment() {
        // Required empty public constructor
    }

    public void setPresenter(ProjectsVP.Presenter presenter) {
        this.presenter = presenter;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_projects, container, false);

        ButterKnife.bind(this, view);

        initComponents();
        presenter.loadCategories();
        return view;
    }

    private void initComponents() {
        viewPager.setAdapter(new ProjectsPagerAdapter(getFragmentManager(), tabLayout, presenter.isArchive()));
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(
                tabLayout));
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {
    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {
    }

    @Override
    public void updateCategories(List<Category> categories) {
        progressBar.setVisibility(View.GONE);
        for (Category category : categories) {
            tabLayout.addTab(tabLayout.newTab().setText(category.getName()));
        }
        tabLayout.addOnTabSelectedListener(this);
        viewPager.getAdapter().notifyDataSetChanged();
    }

    @Override
    public void showCategoryError() {
        progressBar.setVisibility(View.GONE);
        Toast.makeText(getContext(), R.string.load_categories_failure, Toast.LENGTH_LONG).show();
    }
}

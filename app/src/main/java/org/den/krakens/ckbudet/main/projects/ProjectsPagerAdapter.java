package org.den.krakens.ckbudet.main.projects;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import org.den.krakens.ckbudet.main.projects.category.ProjectsCategoryFragment;
import org.den.krakens.ckbudet.main.projects.category.ProjectsCategoryPresenter;

/**
 * Created by Mohru on 15.06.2018.
 */

public class ProjectsPagerAdapter extends FragmentStatePagerAdapter {

    private TabLayout tabLayout;

    public ProjectsPagerAdapter(FragmentManager fm, TabLayout tabLayout) {
        super(fm);
        this.tabLayout = tabLayout;
    }

    @Override
    public int getCount() {
        return tabLayout.getTabCount();
    }

    @Override
    public Fragment getItem(int position) {
        ProjectsCategoryFragment fragment = new ProjectsCategoryFragment();

        fragment.setPresenter(new ProjectsCategoryPresenter(fragment, tabLayout.getTabAt(position).getText().toString()));
        return fragment;
    }
}

package com.amalyuhin.myshows.ui.activity;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;

import com.amalyuhin.myshows.R;
import com.amalyuhin.myshows.ui.fragment.EpisodesFragment;
import com.amalyuhin.myshows.ui.view.SlidingTabLayout;

/**
 * Created by amalyuhin on 14.01.2015.
 */
public class EpisodesActivity extends ActionBarActivity {

    private Toolbar mainToolbar;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;

    ViewPager mViewPager = null;
    EpisodesViewPagerAdapter mViewPagerAdapter = null;
    SlidingTabLayout mSlidingTabLayout = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_episodes);

        mViewPager = (ViewPager) findViewById(R.id.view_pager);

        mViewPagerAdapter = new EpisodesViewPagerAdapter(getFragmentManager());
        mViewPager.setAdapter(mViewPagerAdapter);

        mSlidingTabLayout = (SlidingTabLayout) findViewById(R.id.sliding_tabs);
        mSlidingTabLayout.setCustomTabView(R.layout.tab_indicator, android.R.id.text1);

        setSlidingTabLayoutContentDescriptions();

        Resources res = getResources();
        mSlidingTabLayout.setSelectedIndicatorColors(res.getColor(R.color.accent));
        mSlidingTabLayout.setDistributeEvenly(true);
        mSlidingTabLayout.setViewPager(mViewPager);

        configureToolbar();
        configureDrawer();
    }

    private void setSlidingTabLayoutContentDescriptions() {
        for (int i = 0; i < 2; i++) {
            mSlidingTabLayout.setContentDescription(i, i == 0 ? "New" : "Coming soon");
        }
    }

    private void configureToolbar() {
        mainToolbar = (Toolbar) findViewById(R.id.toolbar);
        mainToolbar.setTitleTextColor(getResources().getColor(R.color.toolbar_text));
        setSupportActionBar(mainToolbar);
        getSupportActionBar().setTitle("Episodes");

//        mainToolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                if (mDrawerLayout.isDrawerOpen(Gravity.START)) {
//                    mDrawerLayout.closeDrawer(Gravity.START);
//
//                } else {
//                    mDrawerLayout.openDrawer(Gravity.START);
//                }
//            }
//        });
    }

    private void configureDrawer() {
        // Configure drawer
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mainToolbar,
                R.string.drawer_open,
                R.string.drawer_closed) {

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                // when drawer closed
                mainToolbar.setTitle("Episodes");
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                // when drawer open
                mainToolbar.setTitle("Episodes");
            }
        };

        mDrawerLayout.setDrawerListener(mDrawerToggle);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    private class EpisodesViewPagerAdapter extends FragmentPagerAdapter {

        public EpisodesViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            EpisodesFragment frag = new EpisodesFragment();
            Bundle args = new Bundle();
            args.putInt(EpisodesFragment.FRAGMENT_TYPE_INDEX, position);
            frag.setArguments(args);
            return frag;
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return (position == 0) ? "New" : "Coming soon";
        }
    }
}

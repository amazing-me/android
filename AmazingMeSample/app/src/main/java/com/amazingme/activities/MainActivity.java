package com.amazingme.activities;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import amazingme.model.EnumeratedActivity;
import amazingme.model.AmazingMeAppCompatActivity;

public class MainActivity extends AmazingMeAppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

        public EnumeratedActivity activityName() {
            return EnumeratedActivity.MAIN_MENU;
        }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("onCreate MainActivity, before super");
        super.onCreate(savedInstanceState);
        System.out.println("onCreate MainActivity, after super");
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        //NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        //navigationView.setNavigationItemSelectedListener(this);

        System.out.println("creating db");
        amazingme.database.FireBase db = new amazingme.database.FireBase();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    //TODO -> rename these everywhere since they don't mean those things
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        ConstraintLayout mainLayout = (ConstraintLayout) findViewById(R.id.content_main);
        ConstraintLayout menuLayout = (ConstraintLayout) findViewById(R.id.content_menu);


        /*if (id == R.id.nav_camera) {
            // Handle the camera action
        } else*/ if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {
            mainLayout.setVisibility(View.VISIBLE);
            menuLayout.setVisibility(View.GONE);
        } else if (id == R.id.nav_manage) {
            mainLayout.setVisibility(View.GONE);
            menuLayout.setVisibility(View.VISIBLE);
        } else if (id == R.id.nav_share) {

        //} else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}

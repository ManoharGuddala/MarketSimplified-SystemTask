package com.tilicho.marketsimplifiedsystemtask.ui;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.tilicho.marketsimplifiedsystemtask.R;
import com.tilicho.marketsimplifiedsystemtask.databinding.ActivityRepositoriesBinding;
import com.tilicho.marketsimplifiedsystemtask.di.components.ActivityComponent;
import com.tilicho.marketsimplifiedsystemtask.ui.ui.RepositoryViewModel;
import com.tilicho.marketsimplifiedsystemtask.ui.ui.base.BaseActivity;
import com.tilicho.marketsimplifiedsystemtask.ui.ui.dashboard.DetailsFragment;
import com.tilicho.marketsimplifiedsystemtask.ui.ui.home.RepositoriesFragment;
import com.tilicho.marketsimplifiedsystemtask.ui.ui.notifications.SettingsFragment;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class RepositoriesActivity extends BaseActivity<ActivityRepositoriesBinding, RepositoryViewModel> {

    BottomNavigationView navView;
    boolean detailsRendered;

    @Override
    public int getBindingVariable() {
        return -1;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_repositories;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        navView = findViewById(R.id.nav_view);
        /*AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);*/
        pushFragment(new RepositoriesFragment(), RepositoriesFragment.TAG, false);
    }

    @Override
    public void performDependencyInjection(ActivityComponent buildComponent) {
        buildComponent.inject(this);
    }

    @Override
    protected void onResume(){
        super.onResume();

        navView.findViewById(R.id.navigation_home).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pushFragment(new RepositoriesFragment(), RepositoriesFragment.TAG, false);
            }
        });

        navView.findViewById(R.id.navigation_dashboard).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pushFragment(new DetailsFragment(),DetailsFragment.TAG, true);
            }
        });

        navView.findViewById(R.id.navigation_notifications).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pushFragment(new SettingsFragment(), SettingsFragment.TAG, false);
            }
        });
    }

    public void pushFragment(Fragment fragment, Bundle args, String nameTag, boolean addToBackStack) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        fragment.setArguments(args);
        if(detailsRendered){
            Fragment detailsFragment = getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
            getSupportFragmentManager().popBackStack(DetailsFragment.TAG, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            if(detailsFragment != null){
                ft.hide(detailsFragment);
                ft.add(R.id.nav_host_fragment, fragment);
            } else{
                ft.remove(fragment);
            }
        } else{
            ft.replace(R.id.nav_host_fragment, fragment);
        }
        if(fragment instanceof DetailsFragment){
            detailsRendered = true;
        }
        ft.commit();
    }

    public void pushFragment(Fragment fragment, String nameTag, boolean addToBackStack) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        if(detailsRendered){
            Fragment detailsFragment = getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
            getSupportFragmentManager().popBackStack(DetailsFragment.TAG, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            if(detailsFragment != null){
                ft.hide(detailsFragment);
                ft.add(R.id.nav_host_fragment, fragment);
            } else{
                ft.remove(fragment);
            }
        } else{
            ft.replace(R.id.nav_host_fragment, fragment);
        }
        if(fragment instanceof DetailsFragment){
            detailsRendered = true;
        }
        ft.commit();
    }

    /*@Override
    public void onBackPressed()
    {
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(DetailsFragment.TAG);
        if(!(fragment instanceof RepositoriesFragment)){
            getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);;
            pushFragment(new RepositoriesFragment(), RepositoriesFragment.TAG, true);
        } else{
            finish();
        }
    }*/

}
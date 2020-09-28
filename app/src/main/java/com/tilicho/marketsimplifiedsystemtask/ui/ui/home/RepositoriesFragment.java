package com.tilicho.marketsimplifiedsystemtask.ui.ui.home;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.tilicho.marketsimplifiedsystemtask.R;
import com.tilicho.marketsimplifiedsystemtask.databinding.FragmentHomeBinding;
import com.tilicho.marketsimplifiedsystemtask.di.components.FragmentComponent;
import com.tilicho.marketsimplifiedsystemtask.ui.ui.base.BaseFragment;

import java.util.Objects;

public class RepositoriesFragment extends BaseFragment<FragmentHomeBinding, RepositoriesViewModel> {

    public static String TAG = "RepositoriesFragment";

    @Override
    public int getBindingVariable() {
        return -1;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onResume(){
        super.onResume();
        init();
    }

    @Override
    public void performDependencyInjection(FragmentComponent buildComponent) {
        buildComponent.inject(this);
    }

    private void init() {

        getViewDataBinding().list.setLayoutManager(new LinearLayoutManager(this.getContext()));
        RepositoryListAdapter adapter = new RepositoryListAdapter(getActivity());
        getViewDataBinding().list.setAdapter(adapter);

        getmViewModel().getListLiveData().observe(getViewLifecycleOwner(), adapter::submitList);

        getmViewModel().getProgressLoadStatus().observe(getViewLifecycleOwner(), status -> {
            if (Objects.requireNonNull(status).equalsIgnoreCase("Loading...")) {
                //getViewDataBinding().progress.setVisibility(View.VISIBLE);
            } else if (status.equalsIgnoreCase("Loaded")) {
                //getViewDataBinding().progress.setVisibility(View.GONE);
            }
        });

    }

}
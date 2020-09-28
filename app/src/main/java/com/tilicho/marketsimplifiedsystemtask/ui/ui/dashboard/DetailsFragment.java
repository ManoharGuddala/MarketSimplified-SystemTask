package com.tilicho.marketsimplifiedsystemtask.ui.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.tilicho.marketsimplifiedsystemtask.BR;
import com.tilicho.marketsimplifiedsystemtask.R;
import com.tilicho.marketsimplifiedsystemtask.data.remote.models.PublicRepository;
import com.tilicho.marketsimplifiedsystemtask.databinding.FragmentDashboardBinding;
import com.tilicho.marketsimplifiedsystemtask.di.components.FragmentComponent;
import com.tilicho.marketsimplifiedsystemtask.ui.ui.base.BaseFragment;

import java.util.Objects;


public class DetailsFragment extends BaseFragment<FragmentDashboardBinding, RepoDetailsViewModel> {

    public static String TAG = "DetailsFragment";

    PublicRepository mPublicRepository;

    @Override
    public int getBindingVariable() {
        return BR.model;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_dashboard;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null && getArguments().getParcelable("REPO") != null){
            mPublicRepository = getArguments().getParcelable("REPO");
        }
    }

    @Override
    public void onResume(){
        super.onResume();
        if(mPublicRepository != null){
            getmViewModel().initialise(mPublicRepository);
        }
    }

    @Override
    public void performDependencyInjection(FragmentComponent buildComponent) {
        buildComponent.inject(this);
    }
}
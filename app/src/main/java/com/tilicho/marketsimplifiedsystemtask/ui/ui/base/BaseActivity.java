package com.tilicho.marketsimplifiedsystemtask.ui.ui.base;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.viewbinding.ViewBinding;

import com.tilicho.marketsimplifiedsystemtask.MSApp;
import com.tilicho.marketsimplifiedsystemtask.di.components.ActivityComponent;
import com.tilicho.marketsimplifiedsystemtask.di.components.DaggerActivityComponent;
import com.tilicho.marketsimplifiedsystemtask.di.modules.ActivityModule;

import javax.inject.Inject;

public abstract class BaseActivity<T extends ViewDataBinding, V extends BaseViewModel> extends AppCompatActivity
        implements BaseFragment.Callback{

    private T mViewDataBinding;

    @Inject
    protected V mViewModel;

    public abstract int getBindingVariable();

    public abstract @LayoutRes int getLayoutId();

    @Override
    public void onFragmentAttached() {

    }

    @Override
    public void onFragmentDetached(String tag) {

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        performDependencyInjection(getBuildComponent());
        super.onCreate(savedInstanceState);
        performDataBinding();
    }

    private ActivityComponent getBuildComponent() {
        return DaggerActivityComponent.builder()
                .appComponent(((MSApp)getApplication()).appComponent)
                .activityModule(new ActivityModule(this))
                .build();
    }

    public abstract void performDependencyInjection(ActivityComponent buildComponent);

    private void performDataBinding() {
        mViewDataBinding = DataBindingUtil.setContentView(this, getLayoutId());
        mViewDataBinding.setVariable(getBindingVariable(), mViewModel);
        mViewDataBinding.executePendingBindings();
    }

    public V getmViewModel() {
        return mViewModel;
    }

    public void setmViewModel(V mViewModel) {
        this.mViewModel = mViewModel;
    }
}

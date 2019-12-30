package com.rahul.dagger.ui.base;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;

import dagger.android.support.DaggerAppCompatActivity;

/**
 * created by lenovo on 4/4/2018.
 */

@SuppressLint("Registered")
public  abstract class BaseActivity<V extends ViewDataBinding, T extends ViewModel> extends DaggerAppCompatActivity {
    
    private V mViewBinding;
    private T mViewModel;


    protected abstract int getLayoutId();
    protected abstract T getViewModel();

    public V getmViewBinding() {
        return mViewBinding;
    }

    public T getmViewModel() {
        return mViewModel;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setDataBinding();
    }

    private void setDataBinding() {
        mViewBinding = DataBindingUtil.setContentView(this, getLayoutId());
        mViewModel = (mViewModel == null? getViewModel() : mViewModel);
        mViewBinding.executePendingBindings();
    }



}

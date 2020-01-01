package com.rahul.dagger.di.module;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.MainThread;

import com.rahul.dagger.ui.main.APIInterface;
import com.rahul.dagger.ui.main.MainRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class MainViewModel extends ViewModel {
    private String URL = "http://eduinsight.edunexttechnologies.com/mobapps/management/schoolmailbox";

    MainRepository apiInterface;
    CompositeDisposable compositeDisposable;
    private MutableLiveData<String> outputObservable = new MutableLiveData<>();


    @Inject
    public MainViewModel(MainRepository apiInterface) {
        this.apiInterface = apiInterface;
        compositeDisposable=new CompositeDisposable();
        executeLogin();
    }

    public MutableLiveData<String> getOutputObservable() {
        return outputObservable;
    }

    public void executeLogin() {

        compositeDisposable.add(apiInterface.getRepositories(URL)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableSingleObserver<String>() {
                    @Override
                    public void onSuccess(String value) {
                        outputObservable.setValue(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                    }
                }));

    }
}

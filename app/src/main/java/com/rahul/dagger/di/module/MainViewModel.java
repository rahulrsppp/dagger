package com.rahul.dagger.di.module;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.MainThread;

import com.rahul.dagger.di.utility.Library;
import com.rahul.dagger.di.utility.MessageResponseModel;
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
    private String URL2 = "http://eduinsight.edunexttechnologies.com/mobapps/management/LibraryService";

    MainRepository.APIInterface apiInterface;
    CompositeDisposable compositeDisposable;
    private MutableLiveData<String> scalarOutputObservable = new MutableLiveData<>();
    private MutableLiveData<Library> gsonOutputObservable = new MutableLiveData<>();
    private MutableLiveData<String> toastObservable = new MutableLiveData<>();


    @Inject
    public MainViewModel(MainRepository.APIInterface apiInterface) {
        this.apiInterface = apiInterface;
        compositeDisposable=new CompositeDisposable();
    }

    public MutableLiveData<Library> getGsonOutputObservable() {
        return gsonOutputObservable;
    }

    public MutableLiveData<String> getOutputObservable() {
        return scalarOutputObservable;
    }

    public MutableLiveData<String> getToastObservable() {
        return toastObservable;
    }

    public void executeGson() {
       // Gson
        compositeDisposable.add(
                apiInterface.getLibraryBook()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<Library>() {
                    @Override
                    public void onSuccess(Library value) {

                        if(value!=null && value.getLibrary_data()!=null){
                             gsonOutputObservable.setValue(value);
                        }else{
                            toastObservable.setValue("An error occurred.");
                        }
                    }

                    @Override
                    public void onError(Throwable e) { }
                }));

    }

    public void executeScalar() {
        // Scalar
        compositeDisposable.add(
                apiInterface.getNewsData(URL)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<String>() {
                    @Override
                    public void onSuccess(String value) {
                        scalarOutputObservable.setValue(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                            toastObservable.setValue("An error occurred.");

                    }
                }));
    }
}

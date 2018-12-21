package id.web.dstwn.retrofitrx.main;

import android.util.Log;

import id.web.dstwn.retrofitrx.data.DataModel;
import id.web.dstwn.retrofitrx.data.RestClient;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class MainPresenter {
    MainView view;

    public MainPresenter(MainView view) {
        this.view = view;
    }

    public void getData(){
        getObserveable().subscribeWith(getObserver());
    }
    public Observable<DataModel> getObserveable(){
        return RestClient.getService().getData().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
    public DisposableObserver<DataModel>getObserver(){
        return  new DisposableObserver<DataModel>() {
            @Override
            public void onNext(DataModel dataModel) {
                Log.d("MainAct", "onNext: "+ dataModel.toString());
                view.showData(dataModel);
            }

            @Override
            public void onError(Throwable e) {
                Log.d("MainAct", "onError: "+e.getLocalizedMessage());
            }

            @Override
            public void onComplete() {
                Log.d("MainAct", "onComplete: complete");
            }
        };
    }


}

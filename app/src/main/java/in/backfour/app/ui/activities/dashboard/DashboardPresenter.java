package in.backfour.app.ui.activities.dashboard;

import android.app.Activity;
import android.content.Context;

import in.backfour.app.BackFourApplication;
import in.backfour.app.api.ApiFactory;
import in.backfour.app.api.ApiService;
import in.backfour.app.base.BasePresenter;

public class DashboardPresenter extends BasePresenter<DashboardContract.View> implements DashboardContract.Presenter {


    private Context context;
    private ApiService mApiService;

    DashboardPresenter(Context context) {
        this.context = context;
        mApiService = ApiFactory.create(BackFourApplication.get((Activity) context).getRetrofit());

    }

}

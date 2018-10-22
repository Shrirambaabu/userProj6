package in.backfour.app.ui.activities.register;

import android.app.Activity;
import android.content.Context;

import in.backfour.app.BackFourApplication;
import in.backfour.app.api.ApiFactory;
import in.backfour.app.api.ApiService;
import in.backfour.app.base.BasePresenter;

public class RegisterPresenter  extends BasePresenter<RegisterContract.View> implements RegisterContract.Presenter  {


    private Context context;
    private ApiService mApiService;

    RegisterPresenter(Context context) {
        this.context = context;
        mApiService = ApiFactory.create(BackFourApplication.get((Activity) context).getRetrofit());

    }

    @Override
    public void registerSuccess(String name, String email, String mobile, String password) {

        getView().registerDOne();
    }
}

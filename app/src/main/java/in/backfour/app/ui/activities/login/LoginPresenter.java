package in.backfour.app.ui.activities.login;

import android.app.Activity;
import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.widget.EditText;

import in.backfour.app.BackFourApplication;
import in.backfour.app.api.ApiFactory;
import in.backfour.app.api.ApiService;
import in.backfour.app.base.BasePresenter;

public class LoginPresenter extends BasePresenter<LoginContract.View> implements LoginContract.Presenter {


    private Context context;
    private ApiService mApiService;

    LoginPresenter(Context context) {
        this.context = context;
        mApiService = ApiFactory.create(BackFourApplication.get((Activity) context).getRetrofit());

    }


    @Override
    public void loginAttempt(String emailText, String passwordText) {
        getView().loginSuccess();

    }
}

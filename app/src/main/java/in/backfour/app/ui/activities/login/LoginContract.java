package in.backfour.app.ui.activities.login;



import in.backfour.app.base.BaseMvpPresenter;

public interface LoginContract {


    interface Presenter extends BaseMvpPresenter<View> {

        void loginAttempt(String emailText, String passwordText);

    }

    interface View {
        void loginSuccess();

    }
}

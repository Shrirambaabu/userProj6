package in.backfour.app.ui.activities.register;

import in.backfour.app.base.BaseMvpPresenter;

public interface RegisterContract {

    interface Presenter extends BaseMvpPresenter<RegisterContract.View> {

        void registerSuccess(String name, String email, String mobile, String password);

    }

    interface View {
        void signInPage();

        void registerDOne();
    }

}

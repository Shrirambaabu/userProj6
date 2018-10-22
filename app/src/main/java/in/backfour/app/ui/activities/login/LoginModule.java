package in.backfour.app.ui.activities.login;


import android.content.Context;

import dagger.Module;
import dagger.Provides;
import in.backfour.app.base.ActivityContext;
import in.backfour.app.base.PerActivityScope;

@Module(includes = {ActivityContext.class})
@PerActivityScope
public class LoginModule {


    @Provides
    @PerActivityScope
    LoginPresenter loginPresenter(Context context) {
        return new LoginPresenter(context);
    }
}

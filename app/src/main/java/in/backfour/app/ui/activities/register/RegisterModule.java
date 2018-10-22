package in.backfour.app.ui.activities.register;


import android.content.Context;

import dagger.Module;
import dagger.Provides;
import in.backfour.app.base.ActivityContext;
import in.backfour.app.base.PerActivityScope;

@Module(includes = {ActivityContext.class})
@PerActivityScope
public class RegisterModule {

    @Provides
    @PerActivityScope
    RegisterPresenter registerPresenter(Context context) {
        return new RegisterPresenter(context);
    }
}

package in.backfour.app;


import android.app.Application;

import dagger.Module;
import dagger.Provides;

@Module
@BackFourScope
public class BackFourAppModule {

    private Application mApplication;

    BackFourAppModule(Application mApplication) {
        this.mApplication = mApplication;
    }

    @Provides
    @BackFourScope
    Application provideApplication() {
        return mApplication;
    }
}

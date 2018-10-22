package in.backfour.app;


import android.content.Context;

import dagger.Module;
import dagger.Provides;

@Module
public class ContextModule {

    private Context context;

    ContextModule(Context context) {
        this.context = context;
    }

    @Provides
    @BackFourScope
    public Context getContext() {
        return context;
    }
}

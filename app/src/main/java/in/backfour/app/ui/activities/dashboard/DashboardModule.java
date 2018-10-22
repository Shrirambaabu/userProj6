package in.backfour.app.ui.activities.dashboard;


import android.content.Context;

import dagger.Module;
import dagger.Provides;
import in.backfour.app.base.ActivityContext;
import in.backfour.app.base.PerActivityScope;

@Module(includes = {ActivityContext.class})
@PerActivityScope
public class DashboardModule {


    @Provides
    @PerActivityScope
    DashboardPresenter dashboardPresenter(Context context) {
        return new DashboardPresenter(context);
    }
}

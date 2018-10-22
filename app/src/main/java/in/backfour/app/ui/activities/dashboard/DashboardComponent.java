package in.backfour.app.ui.activities.dashboard;


import dagger.Component;
import in.backfour.app.base.PerActivityScope;

@Component(modules = {DashboardModule.class})
@PerActivityScope
public interface DashboardComponent {
    void inject(DashboardActivity dashboardActivity);
}

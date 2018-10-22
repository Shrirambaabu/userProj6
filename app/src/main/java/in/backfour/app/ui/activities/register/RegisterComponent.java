package in.backfour.app.ui.activities.register;


import dagger.Component;
import in.backfour.app.base.PerActivityScope;

@Component(modules = {RegisterModule.class})
@PerActivityScope
public interface RegisterComponent {
    void inject(RegisterActivity registerActivity);
}

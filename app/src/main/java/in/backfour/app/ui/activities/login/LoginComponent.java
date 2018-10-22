package in.backfour.app.ui.activities.login;


import dagger.Component;
import in.backfour.app.base.PerActivityScope;

@Component(modules = {LoginModule.class})
@PerActivityScope
public interface LoginComponent {
    void inject(LoginActivity loginActivity);
}

package in.backfour.app;


import dagger.Component;

@Component(modules = {RetrofitModule.class, BackFourAppModule.class})
@BackFourScope
public interface BackFourComponent {
    void inject(BackFourApplication backFourApplication);
}

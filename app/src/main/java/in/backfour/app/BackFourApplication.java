package in.backfour.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.StrictMode;

import com.google.gson.Gson;

import javax.inject.Inject;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

public class BackFourApplication extends Application {

    public static final String BASE_URL ="http://demo.techzarinfo.com/backfour/";


    private static Context context;
    @Inject
    Retrofit retrofit;
    @Inject
    Gson gson;
    @Inject
    SharedPreferences sharedPreferences;
    @Inject
    OkHttpClient okHttpClient;
    private BackFourComponent backFourComponent;


    public static BackFourApplication get(Activity activity) {
        return (BackFourApplication) activity.getApplication();
    }

    public static BackFourApplication getApplication(Application application) {
        return (BackFourApplication) application;
    }

    public static Context getAppContext() {
        return context;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        // LeakCanary.install(this);
        // JodaTimeAndroid.init(this);

        context = this;

        backFourComponent = DaggerBackFourComponent.builder()
                .contextModule(new ContextModule(context))
                .backFourAppModule(new BackFourAppModule(this))
                .build();

        backFourComponent.inject(this);
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());

    }


    public Retrofit getRetrofit() {
        return retrofit;
    }

    public Gson getGson() {
        return gson;
    }

    public SharedPreferences getSharedPreferences() {
        return sharedPreferences;
    }

    public BackFourComponent getSwsComponent() {
        return backFourComponent;
    }

    public OkHttpClient getOkHttpClient() {
        return okHttpClient;
    }

}

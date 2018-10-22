package in.backfour.app.api;

import retrofit2.Retrofit;

public class ApiFactory {
    public static ApiService create(Retrofit retrofit) {
        return retrofit.create(ApiService.class);
    }

}

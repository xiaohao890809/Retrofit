package me.hz89.retrofit.api;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import io.realm.RealmObject;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by h.xiao on 2016/6/20.
 */
public class ExpressApiService
{
    public ExpressApiService() {
    }

    private static volatile ExpressApi sExpressApi;

    public static ExpressApi getInstace() {
        if (sExpressApi == null) {
            synchronized (ExpressApiService.class) {
                if (sExpressApi == null)
                    sExpressApi = retrofit.create(ExpressApi.class);
            }
        }
        return sExpressApi;
    }

    private static final Gson gson = new GsonBuilder()
            .setDateFormat(ExpressApi.DATA_FORMAT_WHOLE)
            .setExclusionStrategies(new ExclusionStrategy()
            {
                @Override
                public boolean shouldSkipField(FieldAttributes f) {
                    return f.getDeclaringClass().equals(RealmObject.class);
                }

                @Override
                public boolean shouldSkipClass(Class<?> clazz) {
                    return false;
                }
            }).create();

    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(ExpressApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .build();

}

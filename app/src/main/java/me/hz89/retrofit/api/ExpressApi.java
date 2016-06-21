package me.hz89.retrofit.api;

import me.hz89.retrofit.db.Data;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by h.xiao on 2016/6/20.
 */
public interface ExpressApi
{
    String BASE_URL = "http://www.kuaidi100.com/";
    String DATA_FORMAT_WHOLE = "yyyy-MM-dd HH:mm:ss";

//    @GET("query")
//    Observable<Data> result(@Query("type") String company, @Query("postid") String number);

    @GET("query")
    Call<Data> result(@Query("type") String company, @Query("postid") String number);

}

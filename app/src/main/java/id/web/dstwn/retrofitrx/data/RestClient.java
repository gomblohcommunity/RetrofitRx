package id.web.dstwn.retrofitrx.data;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestClient {
    public static Retrofit getClient(){
        return new Retrofit.Builder().baseUrl("https://api.myjson.com/bins/").addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create()).build();
    }
    public static RestService getService(){
        return getClient().create(RestService.class);
    }

}

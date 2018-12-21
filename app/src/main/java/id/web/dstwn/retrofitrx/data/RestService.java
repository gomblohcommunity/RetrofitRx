package id.web.dstwn.retrofitrx.data;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface RestService {
    @GET("vspzs")
    Observable<DataModel>getData();
}

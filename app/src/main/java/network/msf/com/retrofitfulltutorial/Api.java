package network.msf.com.retrofitfulltutorial;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Api {

    String BASE_URl="http://whistledevelopers.com/joju/api/";
    @GET("category")
    Call<Category> getHeroes();


    @GET("category")
    Call<ResponseBody> getSubCategory(@Query("filter[name]") String name);
    @GET("category/{id}")
    Call<ResponseBody> getOneCategory(@Path("id") String id);
}

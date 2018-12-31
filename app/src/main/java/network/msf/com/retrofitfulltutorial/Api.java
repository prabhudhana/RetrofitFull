package network.msf.com.retrofitfulltutorial;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Api {

    String BASE_URl = "http://whistledevelopers.com/joju/api/";

    @GET("category")
    Call<Category> getHeroes();


    @GET("category")
    Call<ResponseBody> getSubCategory(@Query("filter[name]") String name);

    @GET("category/{id}")
    Call<ResponseBody> getOneCategory(@Path("id") String id);

    @FormUrlEncoded
    @POST("signup")
    Call<ResponseBody> userLogin(@Field("name") String name,
                                 @Field("email") String email,
                                 @Field("phone") String phone,
                                 @Field("alt_phone") String alt_phone,
                                 @Field("password") String password);
}

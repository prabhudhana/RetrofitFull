package network.msf.com.retrofitfulltutorial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    TextView responseText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        responseText = (TextView) findViewById(R.id.response);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        final Api api = retrofit.create(Api.class);
        Call<Category> call = api.getHeroes();

        /*call.enqueue(new Callback<Category>() {
            @Override
            public void onResponse(Call<Category> call, Response<Category> response) {
                // responseText.setText(response.body().string());
                LinearLayout linearLayout=(LinearLayout)findViewById(R.id.relative);
                List<Category> movies = response.body().getData();
                Log.d(getPackageName(), "Number of movies received: " + movies.size());
               // responseText.setText(String.valueOf(movies.size()));
                TextView[] textView=new TextView[movies.size()];

                for(int i=0;i<movies.size();i++){
                    TextView textView1=new TextView(getApplicationContext());
                    textView1.setText(movies.get(i).getName());
                    linearLayout.addView(textView1);

                }



            }

            @Override
            public void onFailure(Call<Category> call, Throwable t) {
                responseText.setText(t.getMessage());

            }
        });
        Call<ResponseBody> responseBodyCall=api.getSubCategory("elect1");

        responseBodyCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    //responseText.setText(response.body().string());
                    Toast.makeText(MainActivity.this, response.body().string(), Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
            responseText.setText(t.getMessage());
            }
        });
        Call<ResponseBody> bodyCall=api.getOneCategory("12");

        bodyCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    //responseText.setText(response.body().string());
                    //Toast.makeText(MainActivity.this, response.body().string(), Toast.LENGTH_SHORT).show();
                    responseText.setText(response.body().string());


                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                responseText.setText(t.getMessage());
            }
        });
*/
        Call<ResponseBody> postCall = api.userLogin("test","hjaghgdf@gmail.com","4656446544","15455454","123456");

        postCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    responseText.setText(response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                responseText.setText(t.getMessage());

            }
        });

    }
}

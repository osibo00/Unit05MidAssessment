package productions.darthplagueis.unit05midassessment.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by oleg on 1/24/18.
 */

public class RandomUserRetrofit {

    private static Retrofit retrofit;

    private static RandomUserRetrofit instanceOfRetrofit;

    private RandomUserRetrofit() {
        String baseUrl = "https://randomuser.me/";
        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static RandomUserRetrofit getInstanceOfRetrofit() {
        if (instanceOfRetrofit != null) {
            return instanceOfRetrofit;
        }
        instanceOfRetrofit = new RandomUserRetrofit();
        return instanceOfRetrofit;
    }

    public static RandomUserGetter randomUserGetter() {
        return retrofit.create(RandomUserGetter.class);
    }
}

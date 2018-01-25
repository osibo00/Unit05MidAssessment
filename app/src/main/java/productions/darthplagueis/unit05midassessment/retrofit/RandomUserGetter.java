package productions.darthplagueis.unit05midassessment.retrofit;

import productions.darthplagueis.unit05midassessment.model.RandomUsers;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by oleg on 1/24/18.
 */

public interface RandomUserGetter {

    String endPoint = "api/?nat=us&inc=name,location,cell,email,dob,picture&results=20";

    @GET(endPoint)
    Call<RandomUsers> getRandomUsers();
}

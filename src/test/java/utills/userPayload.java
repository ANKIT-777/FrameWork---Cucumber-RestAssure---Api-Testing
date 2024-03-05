package utills;

import java.util.HashMap;
import java.util.Map;

public class userPayload {
    public static Map<String,Object> createPayload(String id, String username, String firstname, String lastname, String email, String password ,
                                                   String phone, String userStatus  ){
        Map<String , Object> payload = new HashMap<>();
        payload.put("id",id);
        payload.put("username", username);
        payload.put("firstname",firstname);
        payload.put("lastname",lastname);
        payload.put("email",email);
        payload.put("password",password);
        payload.put("phone",phone);
        payload.put("userStatus",userStatus);

        return payload;
    }
}
package utills;

import org.checkerframework.checker.units.qual.C;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class petPayload {

    public HashMap<String,Object> petPayload(int id,int catId, String catName,String name,
                                             List<String> photoUrls,List<HashMap<String,Object>> Tags,String status){
        HashMap<String,Object> petBody = new HashMap<>();
        petBody.put("id",id);

        HashMap<String,Object> Category = new HashMap<>();
        Category.put("id",catId);
        Category.put("name",catName);

        petBody.put("category", Category);
        petBody.put("name",name);

        petBody.put("photoUrls",photoUrls);
        petBody.put("tags",Tags);
        petBody.put("status",status);
        return  petBody;
    }
}

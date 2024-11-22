package modules;

import com.google.gson.Gson;

public class Serializer {
    private Gson gson = new Gson();

    public String toJson(Object obj) {
        return gson.toJson(obj);
    }


}

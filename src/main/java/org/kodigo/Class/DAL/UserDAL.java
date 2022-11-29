package org.kodigo.Class.DAL;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import org.kodigo.Class.User;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Objects;

public class UserDAL {

    final static private String jsonPath = "./src/main/java/org/kodigo/Persistence/user.json";
    public static JSONArray getJsonArray(){
        JSONParser parser = new JSONParser();
        try {
            return (JSONArray) parser.parse(new FileReader(jsonPath));
        }catch(Exception ex){
            return null;
        }
    }


    public static User getUser(String toMatch){
        try {
            for (Object entry : Objects.requireNonNull(getJsonArray())){
                JSONObject jo = (JSONObject) entry;
                if (jo.get("username").equals(toMatch)) {
                    return new User(jo.get("username").toString(),
                            jo.get("password").toString(),
                            jo.get("email").toString());
                }
            }
            return null;
        }catch(Exception ex){
            return null;
        }
    }

    public static boolean addUser(User userToAdd){
        if(getUser(userToAdd.getUsername()) != null){
            return false;
        }

        JSONArray users = Objects.requireNonNull(getJsonArray());

        try(FileWriter writer = new FileWriter(jsonPath)){
            JSONObject jsonToAdd = (JSONObject) new JSONParser().parse(userToAdd.toString());
            users.add(jsonToAdd);
            writer.write(users.toJSONString());
            writer.flush();
            return true;
        }catch(Exception ex){
            return false;
        }
    }


}



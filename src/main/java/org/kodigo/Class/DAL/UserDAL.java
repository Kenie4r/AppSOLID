package org.kodigo.Class.DAL;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import org.kodigo.Class.User;
import java.io.FileReader;
import java.util.Objects;

public class UserDAL {


    public static JSONArray getJsonArray(){
        JSONParser parser = new JSONParser();
        try {
            return (JSONArray) parser.parse(new FileReader("./src/main/java/org/kodigo/Persistence/user.json"));
        }catch(Exception ex){
            return null;
        }
    }


    public static User getUser(String toMatch) throws Exception{
        try {
            for (Object entry : Objects.requireNonNull(getJsonArray())){
                JSONObject jo = (JSONObject) entry;
                if (jo.get("username").equals(toMatch)) {
                    return new User(jo.get("username").toString(),
                            jo.get("password").toString(),
                            jo.get("email").toString());
                }
            }
            throw new Exception("UserNotFound");
        }catch(Exception ex){
            System.out.println("Data layer issue");
            throw ex;
        }
    }

    public static boolean addUser(User userToAdd){
        //TODO
        return true;
    }


}



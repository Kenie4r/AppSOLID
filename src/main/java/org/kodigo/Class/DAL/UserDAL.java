package org.kodigo.Class.DAL;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

import org.json.simple.JSONObject;
import org.kodigo.Class.User;
import org.kodigo.Utils.PauseScreen;
import java.io.FileReader;
import java.util.Objects;

public class UserDAL {


    public static JSONArray getJsonArray(){
        JSONParser parser = new JSONParser();
        try{
            return (JSONArray) parser.parse(new FileReader("./src/main/java/org/kodigo/Persistence/user.json"));
        }catch(Exception e){
            return null;
        }
    }


    public static User getUser(String toMatch){
        for (Object entry : Objects.requireNonNull(getJsonArray())){
            JSONObject jo = (JSONObject) entry;
            if (jo.get("username").equals(toMatch)) {
                System.out.println(jo.get("username").toString()+", "+jo.get("password").toString()+", "+jo.get("email").toString());
                PauseScreen.pause(20);
                return new User(jo.get("username").toString(),
                        jo.get("password").toString(),
                        jo.get("email").toString());
            }
        }
        return null;
    }

    public static boolean addUser(User userToAdd){
        //TODO
        return true;
    }


}



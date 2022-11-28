package org.kodigo.Class.DAL;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.kodigo.Class.User;
import org.kodigo.Utils.PauseScreen;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

public class UserDAL {


    public static JSONArray getJsonArray(){
        JSONParser parser = new JSONParser();
        try{
            return (JSONArray) parser.parse(new FileReader("./src/main/java/org/kodigo/Persistence/user.json"));
        }catch(Exception e){
            try {
                return (JSONArray) parser.parse(new FileReader("user.json"));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (ParseException ex) {
                throw new RuntimeException(ex);
            }
        }
    }


    public static User getUser(String toMatch){
        for (Object entry : Objects.requireNonNull(getJsonArray())){
            JSONObject jo = (JSONObject) entry;
            if (jo.get("username").equals(toMatch)) {
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



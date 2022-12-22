package org.kodigo.Class.DAL;

import org.json.simple.JSONArray;
import org.junit.jupiter.api.Test;
import org.kodigo.Class.DAL.UserDAL;
import org.kodigo.Class.User;

import static org.junit.jupiter.api.Assertions.*;

public class UserDalTest {

    @Test
    void getJsonTest(){
        JSONArray json = UserDAL.getJsonArray();
        assertNotNull(json.toJSONString());
    }

    @Test
    void getUserTest(){
        String username = "dan123";
        User user = UserDAL.getUser(username);
        assertEquals("dan123",user.getUsername());
        assertEquals("email@mail.com",user.getEmail());
    }

    @Test
    void addUserTest(){
        assertTrue(UserDAL.addUser(new User("testUser","☺↓4ì♀♥♦ß","mail@mail.com")));
    }


}

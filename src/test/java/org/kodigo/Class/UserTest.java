package org.kodigo.Class;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {
    @Test
    void equalUserTest(){
        User testUser = new User("test","test");
        assertEquals(testUser,new User("test","test"));
    }
}

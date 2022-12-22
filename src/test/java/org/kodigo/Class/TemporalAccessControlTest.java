package org.kodigo.Class;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TemporalAccessControlTest {

    @Test
    @Disabled
    void tryLoginTest(){
        TemporalAccessControl accessControl = new TemporalAccessControl(new User("molina","test"));
        assertTrue(accessControl.TryLogin());
    }

}

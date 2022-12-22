package org.kodigo.Class;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AccessControlTest {
    public AccessControl accessControl;

    @BeforeEach
    void setUpAccessControl(){
        accessControl = new AccessControl();
    }

    @Test
    @Disabled
    void verifyLoginTest(){
        assertTrue(accessControl.TryLogin());
    }
}

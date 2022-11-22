package org.kodigo.Class;

import lombok.Getter;
import lombok.Setter;

public class AccessControl {
    @Getter
    @Setter
    private User loggedUser;

    private boolean verifyLoggin(User user){
        //TODO;
        return true;
    }


    public boolean Login(){
        //TODO;
        return true;
    }
}

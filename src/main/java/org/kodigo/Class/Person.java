package org.kodigo.Class;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @AllArgsConstructor
public class Person {
    @Getter
    @Setter
    private String personCode;
    @Getter
    @Setter
    private String personName;
    @Getter
    @Setter
    private String mail;


}

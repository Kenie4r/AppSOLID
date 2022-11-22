package org.kodigo.Class;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class Charge {
    @Getter@Setter
    private String name;
    @Getter@Setter
    private double price;
}
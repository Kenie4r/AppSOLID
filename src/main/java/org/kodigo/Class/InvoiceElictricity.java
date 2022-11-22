package org.kodigo.Class;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class InvoiceElictricity extends Invoice {


    @Override
    public String toString(){
        return "Cuenta de electricidad de la fecha de:  " + this.getDataOfCreate();
    }
}

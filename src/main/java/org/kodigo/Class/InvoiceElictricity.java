package org.kodigo.Class;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


public class InvoiceElictricity extends Invoice {
    public InvoiceElictricity(Object service) {
        super(service);
    }

    /*@Override
    public String toString(){
        return "Cuenta de electricidad de la fecha de:  " + this.getDataOfCreate();
    }*/
}

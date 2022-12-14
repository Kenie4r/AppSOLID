package org.kodigo.Class;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;


public class InvoiceElictricity extends Invoice {
    //Create a little constant that it's the IMPUESTO
    private static final double IMPUESTO = 0.13;
    public InvoiceElictricity(Servicio service) {
        super(service);
    }

    public  InvoiceElictricity(Servicio servicio , List<Charge> charges){
        super(servicio, charges);
    }
    //We have to change the function updateTotal, cuz we have to add the
    //IMPUESTO to the total
    @Override
    protected void updateTotal(){
        //As the orignal function
        double subtotal = 0.0;
        for(Charge charge : this.getCharges()){
            subtotal += charge.getPrice();
        }

        //THE CHANGE
        //We multiply the IMPUESTO by the subtotal, the with that result
        //Just add it to the subttotal
        subtotal = subtotal + (IMPUESTO * subtotal);
        this.setTotal( Math.round(subtotal* 100.0) / 100.0);

    }

}

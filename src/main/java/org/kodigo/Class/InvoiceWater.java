package org.kodigo.Class;

import java.util.List;

public class InvoiceWater extends Invoice
{
    private static final double IMPUESTO = 0.10;
    public InvoiceWater(Servicio service) {
        super(service);
    }

    public InvoiceWater(Servicio service, List<Charge> charges) {
        super(service, charges);
    }

    //We have to change the function updateTotal, cuz we have to add the
    //IMPUESTO to the total
    @Override
    protected void updateTotal(){
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

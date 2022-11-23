package org.kodigo.Class;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


public class InvoiceElictricity extends Invoice {
    private static final double IMPUESTO = 0.13;
    public InvoiceElictricity(Servicio service) {
        super(service);
    }
    @Override
    protected void updateTotal(){
        double subtotal = 0.0;
        for(Charge charge : this.getCharges()){
            subtotal += charge.getPrice();
        }
        subtotal = subtotal + (IMPUESTO * subtotal);
        this.setTotal( subtotal);

    }

}

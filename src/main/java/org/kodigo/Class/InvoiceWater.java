package org.kodigo.Class;

public class InvoiceWater extends Invoice
{
    private static final double IMPUESTO = 0.10;
    public InvoiceWater(Servicio service) {
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

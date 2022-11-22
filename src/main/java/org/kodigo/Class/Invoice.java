package org.kodigo.Class;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@AllArgsConstructor
public abstract class Invoice<E> {


    @Setter
    @Getter
    private Date dataOfCreate;
    @Setter
    @Getter
    private double total;
    @Setter
    @Getter
    private E service;
    @Setter
    @Getter
    private List<Charge> charges;

    public Invoice() {
        //incializamos la lista para que no sea null
        this.charges = new ArrayList<>();
    }

    private void updateTotal(){
        double subtotal = 0.0;

        for(Charge charge : this.charges){
            subtotal += charge.getPrice();
        }
        this.total = subtotal;
    }

    public boolean setNewChargeInInvoice(Charge charge){
        //Trying to add the charge on the invoice
        try{
            this.charges.add(charge);
            //the we have to update de total of the invoice
            this.updateTotal();
            return true;
        }catch (Exception e){
            return false;
        }
    }

}
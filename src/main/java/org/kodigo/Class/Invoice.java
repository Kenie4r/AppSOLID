package org.kodigo.Class;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.kodigo.Utils.ConsoleScanner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@AllArgsConstructor @NoArgsConstructor
public abstract class Invoice{


    @Setter
    @Getter
    private Date dataOfCreate;
    @Setter
    @Getter
    private double total;
    @Setter
    @Getter
    private Servicio service;
    @Setter
    @Getter
    private List<Charge> charges;

    public Invoice(Servicio service) {
        //incializamos la lista para que no sea null
        this.charges = new ArrayList<>();
        this.service = service;
        System.out.println("+------------------------------------------+");
        System.out.println("|        NUEVA FACTURA DE SERVICIO         |");
        System.out.println("+------------------------------------------+");
        System.out.println("El servicio es :  " + this.service);
        System.out.println("# de cargos de la factura " );
        int chargeNumber = ConsoleScanner.getInteger();
        for(int index = 0 ; index<chargeNumber; index++){
           setNewChargeInInvoice(new Charge());
        }

        System.out.println("");




    }

    protected void updateTotal(){
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

    @Override
    public String toString() {
        String text = "+------------------------------------------+\n";
        text += "|           FACTURA DE SERVICIO            |\n";
        text +="+ - - - - - - - - - - -- - - - - - - - - - +\n";
        text+="El servicio es :  " + this.service.getNombre()+"\n";
        text +="Esta factura tiene " + this.charges.size() + " cargos \n";
        text+= "Los cargos son los siguientes:\n";
        for (Charge cargo:
             this.charges) {
            text+="* " + cargo.getName() + " : $" + cargo.getPrice() +"\n";
        }
        text +="TOTAL: $" + this.total + "\n";
        text+="+------------------------------------------+";

       return text;
    }
}
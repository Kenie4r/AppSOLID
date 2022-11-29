package org.kodigo.Class;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.kodigo.Interfaces.InvoiceInterface;
import org.kodigo.Utils.ConsoleScanner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@AllArgsConstructor @NoArgsConstructor
public  class Invoice implements InvoiceInterface {


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

    //With this constructor we can create a new invoice of a service
    public Invoice(Servicio service) {
        this.dataOfCreate = new Date(System.currentTimeMillis());
        //Initialized the arrayList of the charges, in order to no get a null list
        this.charges = new ArrayList<>();
        //get the service that we created when we call this function
        this.service = service;
        //print a little form to get all the data
        System.out.println("+------------------------------------------+");
        System.out.println("|        NUEVA FACTURA DE SERVICIO         |");
        System.out.println("+------------------------------------------+");
        //print the name of the services to show more information to the client

        System.out.println("El servicio es :  " + this.service.getNombre() + "  proporcionado por " + this.service.getProveedor());
        //get the count of charges that the invoice will have
        System.out.println("# de cargos de la factura " );
        //get the number with the ConsoleScanner class
        int chargeNumber = ConsoleScanner.getInteger();
        //a for that will help us to create and add all the charges in the invoice
        for(int index = 0 ; index<chargeNumber; index++){
           setNewChargeInInvoice(new Charge());
        }

    }
    //A function that will update the total of the invoice,
    protected void updateTotal(){

        double subtotal = 0.0;
        //We will check all the charges in order to get their subtotal or price
        for(Charge charge : this.charges){
            //then just add the price to the subtotal
            subtotal += charge.getPrice();//just get the price
        }
        this.total = subtotal;//just update the total of the invoice
    }

    //insert a new charge in the list, just send the charge to add it
    public boolean setNewChargeInInvoice(Charge charge){
        //Trying to add the charge on the invoice
        try{
            this.charges.add(charge);
            //then we have to update de total of the invoice
            this.updateTotal();
            //if we haven't found any problem just return true
            return true;
        }catch (Exception e){
            //If we have found a problem return false
            return false;
        }
    }



    //Override the function to string to get all the information of the invoice
    //We can get all the information to print it on the console
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
            text+=cargo.toString() + "\n";
        }
        text +="TOTAL: $" + this.total + "\n";
        text+="+------------------------------------------+";

       return text;
    }

    public void listarCargos(){
        int index = 0;
        System.out.println("Cargos Registradas");
        System.out.println("No. -  Nombre           - Total");
        for (Charge charge : charges) {
            System.out.println(index + "   -  "+charge.getName()+"  -   "+charge.getPrice());
            index++;
        }
    }

    public void eliminarCargo(int index) {
        charges.remove(index);
    }

    public boolean sobrepasaIndexServicio(int index) {
        return index < charges.size() && charges.size() >0;
    }
}
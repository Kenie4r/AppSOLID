package org.kodigo.Class;

import lombok.Getter;
import lombok.Setter;
import org.kodigo.Interfaces.ILoginInterface;
import org.kodigo.Utils.ConsoleScanner;

/*Control de Accesso que Toma un usuario Predefinido por Valores guardados en RunTime*/

public class TemporalAccessControl implements ILoginInterface {
    @Getter
    @Setter
    private User loggedUser;

    public TemporalAccessControl(){
        this.loggedUser = new User("admin","admin");
    }

    public TemporalAccessControl(User loggedUser) {
        this.loggedUser = loggedUser;
    }

    @Override
    public boolean TryLogin() {
        //Voy a utilizar TryLogin para tomar los Datos de Consola y verify para Realizar la Verificacion.
        //Dejare el While Loop como un comportamiento de MenuLogin.
        String usuario ="";
        String contraseña="";
        System.out.println("Ingrese el Usuario:");
        usuario = ConsoleScanner.getSingleString();
        System.out.println("Ingrese la Contraseña:");
        contraseña = ConsoleScanner.getSingleString();
        return verifyLogin(new User(usuario,contraseña));
    }
    private boolean verifyLogin(User user){
        return this.loggedUser.equals(user);
    }

}
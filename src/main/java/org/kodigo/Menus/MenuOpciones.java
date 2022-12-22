package org.kodigo.Menus;

public abstract class MenuOpciones extends MenuConcatenado{

    @Override
    public void lanzarEsteMenu() {
        imprimirOpciones();
        tomarOpcion();
    }

    abstract void imprimirOpciones();
    abstract void tomarOpcion();

    abstract void validarOpcion(String opcion);

    abstract void opcionSeleccionanda(int index);

}

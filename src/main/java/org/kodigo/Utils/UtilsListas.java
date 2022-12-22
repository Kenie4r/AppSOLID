package org.kodigo.Utils;

import org.kodigo.Class.Casa;

import java.util.List;

public class UtilsListas {

    public static <T> boolean sobrepasaIndex(int index, List<T> list){
        return index < list.size() && list.size() >0;
    }

    public static <T> void añadirALista(T object, List<T> list){
        list.add(object);
    }


}

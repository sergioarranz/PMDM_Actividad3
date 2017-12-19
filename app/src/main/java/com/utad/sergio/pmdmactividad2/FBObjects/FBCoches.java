package com.utad.sergio.pmdmactividad2.FBObjects;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by sergio on 19/12/17.
 */

@IgnoreExtraProperties
public class FBCoches {

    public int Fabricado;
    public String Marca, Nombre;
    public double lat, lon;

    public FBCoches() {

    }
    public FBCoches(int Fabricado,String Marca,String Nombre,double lat,double lon) {
        this.Fabricado=Fabricado;
        this.Marca=Marca;
        this.Nombre=Nombre;
        this.lat=lat;
        this.lon=lon;
    }
}

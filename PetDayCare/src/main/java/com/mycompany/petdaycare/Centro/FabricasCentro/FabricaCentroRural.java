package com.mycompany.petdaycare.Centro.FabricasCentro;

import com.mycompany.petdaycare.Centro.*;

public class FabricaCentroRural extends FabricaCentro{

    @Override
    public Centro createCentro() {
        return new CentroRural();
    }

}

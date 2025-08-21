package com.mycompany.petdaycare.Centro.FabricasCentro;

import com.mycompany.petdaycare.Centro.*;

public class FabricaCentroUrbano extends FabricaCentro{

    @Override
    public Centro createCentro() {
        return new CentroUrbano();
    }

}

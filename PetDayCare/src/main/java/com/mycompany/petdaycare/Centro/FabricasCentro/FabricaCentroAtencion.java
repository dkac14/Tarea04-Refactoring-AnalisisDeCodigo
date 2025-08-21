package com.mycompany.petdaycare.Centro.FabricasCentro;

import com.mycompany.petdaycare.Centro.*;

public class FabricaCentroAtencion extends FabricaCentro{

    @Override
    public Centro createCentro() {
        
        return new CentroAtencion();
    }

}

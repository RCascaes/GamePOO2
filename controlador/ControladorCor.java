package controlador;

import battleconquer.model.Cor;
import battleconquer.persistencia.DBCorPersistencia;
import java.util.ArrayList;

public class ControladorCor {
    private DBCorPersistencia corp;
    
    public ControladorCor(DBCorPersistencia corp) {
        this.corp = corp;
    }
    
    public ArrayList<Cor> carregarCores(){
        return new ArrayList<Cor>(corp.carregarCores());
    }
}

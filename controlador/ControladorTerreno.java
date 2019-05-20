package controlador;

import battleconquer.model.Terreno;
import battleconquer.persistencia.DBTerrenoPersistencia;
import java.util.ArrayList;

public class ControladorTerreno {
    private DBTerrenoPersistencia terrenop;
    public ControladorTerreno(DBTerrenoPersistencia terrenop) {
        this.terrenop = terrenop;
    }
    
    public ArrayList<Terreno> carregarTerrenos() {
        return new ArrayList<Terreno> (terrenop.carregarTerrenos());
    }
}

package controlador;

import battleconquer.model.Mapa;
import battleconquer.persistencia.DBMapaPersistencia;
import java.util.ArrayList;

public class ControladorMapa {
    private DBMapaPersistencia mapap;
    
    public ControladorMapa(DBMapaPersistencia mapap) {
        this.mapap = mapap;
    }
    
    public ArrayList<Mapa> liberarMapa(ArrayList<Mapa> mapas){
        for (int i=0; i < mapas.size(); i++) {
            if (!mapas.get(i).isLiberado()) {
                mapap.liberarMapa(mapas.get(i));
                return carregarMapas();
            }
        }
        return mapas;
    }
    
    public ArrayList<Mapa> carregarMapas(){
        return new ArrayList<Mapa> (mapap.carregarMapas());
    }    
}

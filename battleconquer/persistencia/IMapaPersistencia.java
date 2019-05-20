package battleconquer.persistencia;

import battleconquer.model.Mapa;
import java.util.ArrayList;

public interface IMapaPersistencia {
    public void liberarMapa(Mapa mapa);
    public ArrayList<Mapa> carregarMapas();
}

package controlador;

import battleconquer.model.Peca;
import battleconquer.persistencia.DBPecaPersistencia;
import java.util.ArrayList;

public class ControladorPeca {
    private DBPecaPersistencia pecap;
    
    public ControladorPeca(DBPecaPersistencia pecap) {
        this.pecap = pecap;
    }
    
    public void gravarPecas(ArrayList<Peca> pecas){
        pecap.gravarPecas(pecas);
    }
    
    public void deletarPecas(ArrayList<Peca> pecas){
        pecap.deletarPecas(pecas);
    }
    
    public ArrayList<Peca> carregarPecas(){
        return new ArrayList<Peca> (pecap.carregarPecas());
    }
}

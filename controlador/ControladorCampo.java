package controlador;

import battleconquer.model.Campo;
import battleconquer.persistencia.DBCampoPersistencia;
import java.util.ArrayList;

public class ControladorCampo {
    private DBCampoPersistencia campop;
    
    public ControladorCampo (DBCampoPersistencia campop){
        this.campop = campop;
    }
    
    public void gravarCampos(ArrayList<Campo> campos){
        campop.gravarCampos(campos);
    }
    
    public void deletarCampos(ArrayList<Campo> campos){
        campop.deletarCampos(campos);
    }
    
    public ArrayList<Campo> carregarCampos(){
        return new ArrayList<Campo>(campop.carregarCampos());
    }
}

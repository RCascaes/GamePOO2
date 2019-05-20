package battleconquer.persistencia;

import battleconquer.model.Campo;
import java.util.ArrayList;

public interface ICampoPersistencia {
    public void gravarCampos(ArrayList<Campo> campos);
    public void deletarCampos(ArrayList<Campo> campos);
    public ArrayList<Campo> carregarCampos();
}

package battleconquer.persistencia;

import battleconquer.model.Peca;
import java.util.ArrayList;

public interface IPecaPersistencia {
    public void gravarPecas(ArrayList<Peca> pecas);
    public void deletarPecas(ArrayList<Peca> pecas);
    public ArrayList<Peca> carregarPecas();
}

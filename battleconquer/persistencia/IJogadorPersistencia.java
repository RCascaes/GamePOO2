package battleconquer.persistencia;

import battleconquer.model.Jogador;
import java.util.ArrayList;

public interface IJogadorPersistencia {
    public void gravarJogadores(ArrayList<Jogador> jogadores);
    public void deletarJogadores(ArrayList<Jogador> jogadores);
    public ArrayList<Jogador> carregarJogadores();
}

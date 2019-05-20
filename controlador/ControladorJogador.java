package controlador;

import battleconquer.model.Jogador;
import battleconquer.persistencia.DBJogadorPersistencia;
import java.util.ArrayList;

public class ControladorJogador {
    private DBJogadorPersistencia jogadorp;
    
    public ControladorJogador(DBJogadorPersistencia jogadorp) {
        this.jogadorp = jogadorp;
    }
    
    public void gravarJogadores(ArrayList<Jogador> jogadores){
        jogadorp.gravarJogadores(jogadores);
    }
    
    public void deletarJogadores(ArrayList<Jogador> jogadores){
        jogadorp.deletarJogadores(jogadores);
    }
    
    public ArrayList<Jogador> carregarJogadores(){
        return new ArrayList<Jogador> (jogadorp.carregarJogadores());
    }
    
}

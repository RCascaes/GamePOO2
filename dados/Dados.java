package dados;

import battleconquer.model.Campo;
import battleconquer.model.Cor;
import battleconquer.model.Exercito;
import battleconquer.model.Jogador;
import battleconquer.model.Mapa;
import battleconquer.model.Peca;
import battleconquer.model.Terreno;
import java.util.ArrayList;
import javafx.scene.Scene;

public class Dados {
    public static Scene multiplayerScene;
    public static Scene matchScene;
    public static Scene winnerScene;
    
    public static ArrayList<Campo> campos = new ArrayList();
    public static ArrayList<Cor> cores = new ArrayList();
    public static ArrayList<Exercito> exercitos = new ArrayList();
    public static ArrayList<Jogador> jogadores = new ArrayList();
    public static ArrayList<Mapa> mapas = new ArrayList();
    public static ArrayList<Peca> pecasBlue = new ArrayList();
    public static ArrayList<Peca> pecasBlack = new ArrayList();
    public static ArrayList<Terreno> terrenos = new ArrayList();
    
    public static int idMapMatch;
    public static int rodada;
    public static int vezJog;
    public static int contClick;    
    public static int qtdCampBlue;
    public static int qtdCampBlack;
}

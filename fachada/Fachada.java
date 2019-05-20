package fachada;

import battleconquer.model.Campo;
import battleconquer.model.Cor;
import battleconquer.model.Exercito;
import battleconquer.model.Jogador;
import battleconquer.model.Mapa;
import battleconquer.model.Peca;
import battleconquer.model.Terreno;
import battleconquer.persistencia.DBBancoPersistencia;
import battleconquer.persistencia.DBCampoPersistencia;
import battleconquer.persistencia.DBCorPersistencia;
import battleconquer.persistencia.DBExercitoPersistencia;
import battleconquer.persistencia.DBJogadorPersistencia;
import battleconquer.persistencia.DBMapaPersistencia;
import battleconquer.persistencia.DBPecaPersistencia;
import battleconquer.persistencia.DBTerrenoPersistencia;
import controlador.ControladorBanco;
import controlador.ControladorCampo;
import controlador.ControladorCor;
import controlador.ControladorExercito;
import controlador.ControladorJogador;
import controlador.ControladorMapa;
import controlador.ControladorPeca;
import controlador.ControladorTerreno;
import java.util.ArrayList;

public class Fachada {
    private static Fachada fachada;
    
    private ControladorBanco ctlBanco;
    private ControladorCampo ctlCampo;
    private ControladorCor ctlCor;
    private ControladorExercito ctlExercito;
    private ControladorJogador ctlJogador;
    private ControladorMapa ctlMapa;
    private ControladorPeca ctlPeca;
    private ControladorTerreno ctlTerreno;
    
    private Fachada () {
        ctlBanco = new ControladorBanco(new DBBancoPersistencia());
        ctlCampo = new ControladorCampo(new DBCampoPersistencia());
        ctlCor = new ControladorCor(new DBCorPersistencia());
        ctlExercito = new ControladorExercito(new DBExercitoPersistencia());
        ctlJogador = new ControladorJogador(new DBJogadorPersistencia());
        ctlMapa = new ControladorMapa(new DBMapaPersistencia());
        ctlPeca = new ControladorPeca(new DBPecaPersistencia());
        ctlTerreno = new ControladorTerreno(new DBTerrenoPersistencia());
    }
    
    public static Fachada getInstancia() {
        if (fachada == null) {
            fachada = new Fachada();
        }
        return fachada;
    }

//===== F U N Ç Õ E S   D E   C O N T R O L E   B A N C O ====================//
    public boolean primeiraExecucao(){
        return ctlBanco.primeiraExecucao();
    }
    public void createTables(){
        ctlBanco.createTables();
    }    
    public void inserts(Jogador j){
        ctlBanco.inserts(j);
    }    
    public void uninstall(){
        ctlBanco.uninstall();
    }    
    
//===== F U N Ç Õ E S   D E   C O N T R O L E   C A M P O ====================//
    public void gravarCampos(ArrayList<Campo> campos){
        ctlCampo.gravarCampos(campos);
    }    
    public void deletarCampos(ArrayList<Campo> campos){
        ctlCampo.deletarCampos(campos);
    }    
    public ArrayList<Campo> carregarCampos(){
        return ctlCampo.carregarCampos();
    }
    
//===== F U N Ç Õ E S   D E   C O N T R O L E   C O R ========================//
    public ArrayList<Cor> carregarCores(){
        return ctlCor.carregarCores();
    }
    
//===== F U N Ç Õ E S   D E   C O N T R O L E   E X E R C I T O ==============//
    public void gravarExercitos(ArrayList<Exercito> exercitos){
        ctlExercito.gravarExercitos(exercitos);
    }    
    public void deletarExercitos(ArrayList<Exercito> exercitos){
        ctlExercito.deletarExercitos(exercitos);
    }    
    public ArrayList<Exercito> carregarExercitos(){
        return ctlExercito.carregarExercitos();
    }
    
//===== F U N Ç Õ E S   D E   C O N T R O L E   J O G A D O R ================//
    public void gravarJogadores(ArrayList<Jogador> jogadores){
        ctlJogador.gravarJogadores(jogadores);
    }    
    public void deletarJogadores(ArrayList<Jogador> jogadores){
        ctlJogador.deletarJogadores(jogadores);
    }    
    public ArrayList<Jogador> carregarJogadores(){
        return ctlJogador.carregarJogadores();
    }    
    
//===== F U N Ç Õ E S   D E   C O N T R O L E   M A P A ======================//
    public ArrayList<Mapa> liberarMapa(ArrayList<Mapa> mapas){
        return ctlMapa.liberarMapa(mapas);
    }    
    public ArrayList<Mapa> carregarMapas(){
        return ctlMapa.carregarMapas();
    } 
    
//===== F U N Ç Õ E S   D E   C O N T R O L E   P E Ç A ======================//
    public void gravarPecas(ArrayList<Peca> pecas){
        ctlPeca.gravarPecas(pecas);
    }    
    public void deletarPecas(ArrayList<Peca> pecas){
        ctlPeca.deletarPecas(pecas);
    }    
    public ArrayList<Peca> carregarPecas(){
        return ctlPeca.carregarPecas();
    }
    
//===== F U N Ç Õ E S   D E   C O N T R O L E   T E R R E N O ================//
    public ArrayList<Terreno> carregarTerrenos() {
        return ctlTerreno.carregarTerrenos();
    }   
}

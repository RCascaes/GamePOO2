package battleconquer.model;
public class Jogador {
    private int id_jogador;
    private String nome;
    
    public Jogador (){}
    public Jogador (int id_jogador, String nome) {
        setId_jogador(id_jogador);
        setNome(nome);
    }

//=================== G E T T E R S ==========================================//
    public int getId_jogador() {
        return id_jogador;
    }
    public String getNome() {
        return nome;
    }
    
//=================== S E T T E R S ==========================================//
    public void setId_jogador(int id_jogador) {
        this.id_jogador = id_jogador;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
}

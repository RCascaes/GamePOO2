package battleconquer.model;
public class Mapa {
    private int id_mapa;
    private String descricao;
    private boolean liberado;
    
    public Mapa (int id_mapa, String descricao, boolean liberado){
        setId_mapa(id_mapa);
        setDescricao(descricao);
        setLiberado(liberado);
    }

//=================== G E T T E R S ==========================================//
    public int getId_mapa() {
        return id_mapa;
    }
    public String getDescricao() {
        return descricao;
    }
    public boolean isLiberado() {
        return liberado;
    }

//=================== S E T T E R S ==========================================//
    public void setId_mapa(int id_mapa) {
        this.id_mapa = id_mapa;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public void setLiberado(boolean liberado) {
        this.liberado = liberado;
    }
}

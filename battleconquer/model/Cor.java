package battleconquer.model;
public class Cor {
    private int id_cor;
    private String descricao;
    
    public Cor (int id_cor, String descricao){
        setId_cor(id_cor);
        setDescricao(descricao);
    }

//=================== G E T T E R S ==========================================//
    public int getId_cor() {
        return id_cor;
    }
    public String getDescricao() {
        return descricao;
    }

//=================== S E T T E R S ==========================================//
    public void setId_cor(int id_cor) {
        this.id_cor = id_cor;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}

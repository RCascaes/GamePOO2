package battleconquer.model;
public class Terreno {
    private int id_terreno;
    private String descricao;
    
    public Terreno (int id_terreno, String descricao){
        setId_terreno(id_terreno);
        setDescricao(descricao);
    }

//=================== G E T T E R S ==========================================//
    public int getId_terreno() {
        return id_terreno;
    }
    public String getDescricao() {
        return descricao;
    }

//=================== S E T T E R S ==========================================//
    public void setId_terreno(int id_terreno) {
        this.id_terreno = id_terreno;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}

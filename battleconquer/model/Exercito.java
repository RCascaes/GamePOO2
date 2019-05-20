package battleconquer.model;
public class Exercito {
    private int id_exercito;
    private int id_jogador;
    private int id_cor;
    private int forca_terra;
    private int forca_areia;
    private int forca_pedra;
    
    public Exercito (){}
    public Exercito (int id_exercito, int id_jogador, int id_cor, int forca_terra, int forca_areia, int forca_pedra){
        setId_exercito(id_exercito);
        setId_jogador(id_jogador);
        setId_cor(id_cor);
        setForca_terra(forca_terra);
        setForca_areia(forca_areia);
        setForca_pedra(forca_pedra);
    }

//=================== G E T T E R S ==========================================//
    public int getId_exercito() {
        return id_exercito;
    }
    public int getId_jogador() {
        return id_jogador;
    }
    public int getId_cor() {
        return id_cor;
    }
    public int getForca_terra() {
        return forca_terra;
    }
    public int getForca_areia() {
        return forca_areia;
    }
    public int getForca_pedra() {
        return forca_pedra;
    }

//=================== S E T T E R S ==========================================//
    public void setId_exercito(int id_exercito) {
        this.id_exercito = id_exercito;
    }
    public void setId_jogador(int id_jogador) {
        this.id_jogador = id_jogador;
    }
    public void setId_cor(int id_cor) {
        this.id_cor = id_cor;
    }
    public void setForca_terra(int forca_terra) {
        this.forca_terra = forca_terra;
    }
    public void setForca_areia(int forca_areia) {
        this.forca_areia = forca_areia;
    }
    public void setForca_pedra(int forca_pedra) {
        this.forca_pedra = forca_pedra;
    }
}

package battleconquer.model;
public class Peca {
    private int id_exercito;
    private int x;
    private int y;
    private int numero;
    private boolean qg;
    
    public Peca() {}
    public Peca(int id_exercito, int x, int y, int numero, boolean qg){
        setId_exercito(id_exercito);
        setX(x);
        setY(y);
        setNumero(numero);
        setQg(qg);
    }

//=================== G E T T E R S ==========================================//
    public int getId_exercito() {
        return id_exercito;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public int getNumero() {
        return numero;
    }
    public boolean isQg() {
        return qg;
    }

//=================== S E T T E R S ==========================================//
    public void setId_exercito(int id_exercito) {
        this.id_exercito = id_exercito;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public void setQg(boolean qg) {
        this.qg = qg;
    }
}

package battleconquer.model;
public class Campo {
    private int x;
    private int y;
    private int id_mapa;
    private int id_terreno;
    
    public Campo() {}
    public Campo(int x, int y, int id_mapa, int id_terreno) {
        setX(x);
        setY(y);
        setId_mapa(id_mapa);
        setId_terreno(id_terreno);
    }

//=================== G E T T E R S ==========================================//
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public int getId_mapa() {
        return id_mapa;
    }
    public int getId_terreno() {
        return id_terreno;
    }

//=================== S E T T E R S ==========================================//
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void setId_mapa(int id_mapa) {
        this.id_mapa = id_mapa;
    }
    public void setId_terreno(int id_terreno) {
        this.id_terreno = id_terreno;
    }
}

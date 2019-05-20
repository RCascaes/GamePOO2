package battleconquer.persistencia;

import battleconquer.model.Peca;
import battleconquer.util.DBUtil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBPecaPersistencia implements IPecaPersistencia {

    private PreparedStatement ps;
    private ResultSet rs;
    private static final int LARGURA_MAPA = 20;
    private static final int ALTURA_MAPA = 16;
    
    @Override
    public void gravarPecas(ArrayList<Peca> pecas) {
        String sql = "INSERT INTO PECA VALUES ( ?, ?, ?, ?, ?)";
        try {
            ps = DBUtil.getConnetion().prepareStatement(sql);
            for (int i=0; i < pecas.size(); i++) {
                ps.setInt(1, pecas.get(i).getId_exercito());
                ps.setInt(2, pecas.get(i).getX());
                ps.setInt(3, pecas.get(i).getY());
                ps.setInt(4, pecas.get(i).getNumero());
                ps.setBoolean(5, pecas.get(i).isQg());
                ps.execute();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBPecaPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deletarPecas(ArrayList<Peca> pecas) {
        String sql = "DELETE FROM PECA WHERE id_exercito = ? AND x = ? AND y = ?";
        try {
            ps = DBUtil.getConnetion().prepareStatement(sql);
            for (int i=0; i < ALTURA_MAPA; i++) {
                for (int j=0; j < LARGURA_MAPA; j++) {
                    ps.setInt(1, pecas.get(0).getId_exercito());
                    ps.setInt(2, j);
                    ps.setInt(3, i);
                    ps.execute();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBPecaPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<Peca> carregarPecas() {
        ArrayList<Peca> pecas = new ArrayList();
        String sql = "SELECT * FROM PECA";
        try {
            ps = DBUtil.getConnetion().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                pecas.add(new Peca(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getBoolean(5)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBPecaPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pecas;
    }
    
}

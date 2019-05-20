package battleconquer.persistencia;

import battleconquer.model.Campo;
import battleconquer.util.DBUtil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBCampoPersistencia implements ICampoPersistencia {

    private PreparedStatement ps;
    private ResultSet rs;
    private static final int MAPA_LARGURA = 20;
    private static final int MAPA_ALTURA = 16;
    
    @Override
    public void gravarCampos(ArrayList<Campo> campos) {
        String sql = "INSERT INTO CAMPO VALUES ( ?, ?, ?, ?)";
        
        try {
            ps = DBUtil.getConnetion().prepareStatement(sql);
            for (int i = 1; i < campos.size(); i++) {
                ps.setInt(1, campos.get(i).getX());
                ps.setInt(2, campos.get(i).getY());
                ps.setInt(3, campos.get(i).getId_mapa());
                ps.setInt(4, campos.get(i).getId_terreno());
                ps.execute();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBCampoPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deletarCampos(ArrayList<Campo> campos) {
        String sql = "DELETE FROM CAMPO WHERE x = ? AND y = ? AND id_mapa = ?";
        
        try {
            ps = DBUtil.getConnetion().prepareStatement(sql);
            for (int i=0; i < MAPA_ALTURA; i++) {
                for (int j=0; j < MAPA_LARGURA; j++) {
                    ps.setInt(1, j);
                    ps.setInt(2, i);
                    ps.setInt(3, campos.get(0).getId_mapa());
                    ps.execute();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBCampoPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<Campo> carregarCampos() {
        ArrayList<Campo> campos = new ArrayList();
        String sql = "SELECT * FROM CAMPO";
        try {
            ps = DBUtil.getConnetion().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                campos.add(new Campo(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBCampoPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return campos;
    }    
}

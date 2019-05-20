package battleconquer.persistencia;

import battleconquer.model.Exercito;
import battleconquer.util.DBUtil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBExercitoPersistencia implements IExercitoPersistencia {

    private PreparedStatement ps;
    private ResultSet rs;
    
    @Override
    public void gravarExercitos(ArrayList<Exercito> exercitos) {
        String sql = "INSERT INTO EXERCITO VALUES ( ?, ?, ?, ?, ?, ?)";
        
        try {
            ps = DBUtil.getConnetion().prepareStatement(sql);
            for (int i = 1; i < exercitos.size(); i++) {
                ps.setInt(1, exercitos.get(i).getId_exercito());
                ps.setInt(2, exercitos.get(i).getId_jogador());
                ps.setInt(3, exercitos.get(i).getId_cor());
                ps.setInt(4, exercitos.get(i).getForca_terra());
                ps.setInt(5, exercitos.get(i).getForca_areia());
                ps.setInt(6, exercitos.get(i).getForca_pedra());
                ps.execute();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBExercitoPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deletarExercitos(ArrayList<Exercito> exercitos) {
        String sql = "DELETE FROM EXERCITO WHERE id_exercito = ?";
        
        try {
            ps = DBUtil.getConnetion().prepareStatement(sql);
            for (int i = 0; i < exercitos.size(); i++) {
                ps.setInt(1, exercitos.get(i).getId_exercito());
                ps.execute();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBExercitoPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }

    @Override
    public ArrayList<Exercito> carregarExercitos() {
        ArrayList<Exercito> exercitos = new ArrayList();
        String sql = "SELECT * FROM EXERCITO";
        
        try {
            ps = DBUtil.getConnetion().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                exercitos.add(new Exercito(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(6)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBExercitoPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }  
        
        return exercitos;
    }
    
}

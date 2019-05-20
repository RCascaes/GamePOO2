package battleconquer.persistencia;

import battleconquer.model.Mapa;
import battleconquer.util.DBUtil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBMapaPersistencia implements IMapaPersistencia {

    private PreparedStatement ps;
    private ResultSet rs;
    
    @Override
    public void liberarMapa(Mapa mapa) {
        String sql = "UPDATE MAPA SET liberado = true WHERE id_mapa = ?";
        
        try {
            ps = DBUtil.getConnetion().prepareStatement(sql);
            ps.setInt(1, mapa.getId_mapa());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DBMapaPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }                
    }
    
    @Override
    public ArrayList<Mapa> carregarMapas() {
        ArrayList<Mapa> mapas = new ArrayList();
        String sql = "SELECT * FROM MAPA";
        
        try {
            ps = DBUtil.getConnetion().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                mapas.add(new Mapa(rs.getInt(1), rs.getString(2), rs.getBoolean(3)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBMapaPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return mapas;
    }    
}

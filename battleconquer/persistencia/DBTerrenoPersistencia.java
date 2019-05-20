package battleconquer.persistencia;

import battleconquer.model.Terreno;
import battleconquer.util.DBUtil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBTerrenoPersistencia implements ITerrenoPersistencia {

    private PreparedStatement ps;
    private ResultSet rs;
    
    @Override
    public ArrayList<Terreno> carregarTerrenos() {
        ArrayList<Terreno> terrenos = new ArrayList();
        String sql = "SELECT * FROM TERRENO";
        
        try {
            ps = DBUtil.getConnetion().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                terrenos.add(new Terreno(rs.getInt(1), rs.getString(2)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBTerrenoPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return terrenos;
    }
    
}

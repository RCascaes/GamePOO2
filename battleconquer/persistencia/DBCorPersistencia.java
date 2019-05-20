package battleconquer.persistencia;

import battleconquer.model.Cor;
import battleconquer.util.DBUtil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBCorPersistencia implements ICorPersistencia {

    private PreparedStatement ps;
    private ResultSet rs;
    
    @Override
    public ArrayList<Cor> carregarCores() {
        ArrayList<Cor> cores = new ArrayList();
        String sql = "SELECT * FROM COR";
        
        try {
            ps = DBUtil.getConnetion().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                cores.add(new Cor(rs.getInt(1), rs.getString(2)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBCorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return cores;
    }
    
}

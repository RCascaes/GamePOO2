package battleconquer.persistencia;

import battleconquer.model.Jogador;
import battleconquer.util.DBUtil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBJogadorPersistencia implements IJogadorPersistencia {

    private PreparedStatement ps;
    private ResultSet rs;
    
    @Override
    public void gravarJogadores(ArrayList<Jogador> jogadores) {
        String sql = "INSERT INTO JOGADOR VALUES ( ?, ?)";
        
        try {
            ps = DBUtil.getConnetion().prepareStatement(sql);
            for (int i = 1; i < jogadores.size(); i++) {
                ps.setInt(1, jogadores.get(i).getId_jogador());
                ps.setString(2, jogadores.get(i).getNome() );
                ps.execute();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBJogadorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    @Override
    public void deletarJogadores(ArrayList<Jogador> jogadores) {
        String sql = "DELETE FROM JOGADOR WHERE id_jogador = ?";
        
        try {
            ps = DBUtil.getConnetion().prepareStatement(sql);
            for (int i = 1; i < jogadores.size(); i++) {
                ps.setInt(1, jogadores.get(i).getId_jogador());
                ps.execute();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBJogadorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }

    @Override
    public ArrayList<Jogador> carregarJogadores() {
        ArrayList<Jogador> jogadores = new ArrayList();
        String sql = "SELECT * FROM JOGADOR";
        
        try {
            ps = DBUtil.getConnetion().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                jogadores.add(new Jogador(rs.getInt(1), rs.getString(2)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBJogadorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return jogadores;
    }
    
}

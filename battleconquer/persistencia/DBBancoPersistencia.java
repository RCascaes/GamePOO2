package battleconquer.persistencia;

import battleconquer.model.Jogador;
import battleconquer.util.DBUtil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBBancoPersistencia implements IBancoPersistencia {

    private PreparedStatement ps;
    private ResultSet rs;

    @Override
    public boolean primeiraExecucao(){
        String sql = "select count(*) from jogador";
        try {
            ps = DBUtil.getConnetion().prepareStatement(sql);
            rs = ps.executeQuery();
            rs.next();
            if (rs.getInt(1) > 0){
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBancoPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
    @Override
    public void createTables() {
// ============ C R E A T E   T A B L E   T E R R E N O ===================== //        
        String sql = "create table if not exists terreno (" +
            " id_terreno int not null auto_increment," +
            " descricao varchar(30) not null," +
            " primary key (id_terreno)" +
        ")";
        try {
            ps = DBUtil.getConnetion().prepareStatement(sql);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DBBancoPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
// ============ C R E A T E   T A B L E   M A P A =========================== //
        sql = "create table if not exists mapa (" +
            " id_mapa int not null auto_increment," +
            " descricao varchar(30) not null," +
            " liberado bit not null," +
            " primary key (id_mapa)" +
        ")";
        try {
            ps = DBUtil.getConnetion().prepareStatement(sql);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DBBancoPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
// ============ C R E A T E   T A B L E   J O G A D O R ===================== //
        sql = "create table if not exists jogador (" +
            " id_jogador int not null," +
            " nome varchar(30) not null," +
            " primary key (id_jogador)" +
        ")";
        try {
            ps = DBUtil.getConnetion().prepareStatement(sql);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DBBancoPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
// ============ C R E A T E   T A B L E   C O R ============================= //
        sql = "create table if not exists cor (" +
            " id_cor int not null auto_increment," +
            " descricao varchar(30) not null," +
            " primary key (id_cor)" +
        ")";
        try {
            ps = DBUtil.getConnetion().prepareStatement(sql);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DBBancoPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
// ============ C R E A T E   T A B L E   E X E R C I T O =================== //
        sql = "create table if not exists exercito (" +
            " id_exercito int not null," +
            " id_jogador int," +
            " id_cor int not null," +
            " forca_terra int not null," +
            " forca_areia int not null," +
            " forca_pedra int not null," +
            " primary key (id_exercito)," +
            " foreign key (id_jogador) references jogador (id_jogador)," +
            " foreign key (id_cor) references cor (id_cor)" +
        ")";
        try {
            ps = DBUtil.getConnetion().prepareStatement(sql);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DBBancoPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
// ============ C R E A T E   T A B L E   C A M P O ========================= //
        sql = "create table if not exists campo (" +
            " x int not null," +
            " y int not null," +
            " id_mapa int not null," +
            " id_terreno int," +
            " primary key (x, y, id_mapa)," +
            " foreign key (id_mapa) references mapa (id_mapa)," +
            " foreign key (id_terreno) references terreno (id_terreno)" +
        ")";
        try {
            ps = DBUtil.getConnetion().prepareStatement(sql);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DBBancoPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
// ============ C R E A T E   T A B L E   P E Ç A =========================== //
        sql = "create table if not exists peca (" +
            " id_exercito int not null," +
            " x int not null," +
            " y int not null," +
            " numero int not null," +
            " qg bit not null," +
            " primary key (id_exercito, x, y)," +
            " foreign key (id_exercito) references exercito (id_exercito)," +
            " foreign key (x, y) references campo (x, y)" +
        ")";
        try {
            ps = DBUtil.getConnetion().prepareStatement(sql);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DBBancoPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void inserts(Jogador j) {
// ============ I N S E R T S   T A B L E   J O G A D O R =================== // 
        String sql = "insert into jogador (id_jogador, nome) values (?, ?)";
        try {
            ps = DBUtil.getConnetion().prepareStatement(sql);
            ps.setInt(1, j.getId_jogador());
            ps.setString(2, j.getNome());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DBBancoPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        
// ============ I N S E R T S   T A B L E   T E R R E N O =================== // 
        sql = "insert into terreno (descricao) values ('Terra')";
        try {
            ps = DBUtil.getConnetion().prepareStatement(sql);
            ps.execute();
            sql = "insert into terreno (descricao) values ('Areia')";
            ps = DBUtil.getConnetion().prepareStatement(sql);
            ps.execute();
            sql = "insert into terreno (descricao) values ('Pedra')";
            ps = DBUtil.getConnetion().prepareStatement(sql);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DBBancoPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        
// ============ I N S E R T S   T A B L E   M A P A ========================= // 
        sql = "insert into mapa (descricao, liberado) values ('Mapa 1', true)";
        try {
            ps = DBUtil.getConnetion().prepareStatement(sql);
            ps.execute();
            sql = " insert into mapa (descricao, liberado) values ('Mapa 2', false)";
            ps = DBUtil.getConnetion().prepareStatement(sql);
            ps.execute();
            sql = " insert into mapa (descricao, liberado) values ('Mapa 3', false)";
            ps = DBUtil.getConnetion().prepareStatement(sql);
            ps.execute();
            sql = " insert into mapa (descricao, liberado) values ('Mapa 4', false)";
            ps = DBUtil.getConnetion().prepareStatement(sql);
            ps.execute();
            sql = " insert into mapa (descricao, liberado) values ('Mapa 5', false)";
            ps = DBUtil.getConnetion().prepareStatement(sql);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DBBancoPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        
// ============ I N S E R T S   T A B L E   C O R =========================== // 
        sql = "insert into cor (descricao) values ('Blue')";
        try {
            ps = DBUtil.getConnetion().prepareStatement(sql);
            ps.execute();
            sql = " insert into cor (descricao) values ('Black')";
            ps = DBUtil.getConnetion().prepareStatement(sql);
            ps.execute();
            sql = " insert into cor (descricao) values ('Red')";
            ps = DBUtil.getConnetion().prepareStatement(sql);
            ps.execute();
            sql = " insert into cor (descricao) values ('Orange')";
            ps = DBUtil.getConnetion().prepareStatement(sql);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DBBancoPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void uninstall() {
        String sql = "DROP TABLE  PECA, CAMPO, EXERCITO, JOGADOR, COR, TERRENO, MAPA";
        try {
            ps = DBUtil.getConnetion().prepareStatement(sql);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DBBancoPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

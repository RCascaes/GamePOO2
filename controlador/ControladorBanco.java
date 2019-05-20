package controlador;

import battleconquer.model.Jogador;
import battleconquer.persistencia.DBBancoPersistencia;
import static java.lang.System.in;
import java.util.Scanner;

public class ControladorBanco {
    private DBBancoPersistencia bancop;
    Scanner in = new Scanner(System.in);
    
    public ControladorBanco (DBBancoPersistencia bancop) {
        this.bancop = bancop;
    }
    
    public boolean primeiraExecucao(){
        return bancop.primeiraExecucao();
    }
    
    public void createTables(){
        bancop.createTables();
    }
    
    public void inserts(Jogador j){
        if (bancop.primeiraExecucao()) {
            bancop.inserts(j);
        }
    }
    
    public void uninstall(){
        bancop.uninstall();
    }
    
}

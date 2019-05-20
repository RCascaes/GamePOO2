package controlador;

import battleconquer.model.Exercito;
import battleconquer.persistencia.DBExercitoPersistencia;
import java.util.ArrayList;

public class ControladorExercito {
    private DBExercitoPersistencia exercitop;
    
    public ControladorExercito(DBExercitoPersistencia exercitop) {
        this.exercitop = exercitop;
    }
    
    public void gravarExercitos(ArrayList<Exercito> exercitos){
        exercitop.gravarExercitos(exercitos);
    }
    
    public void deletarExercitos(ArrayList<Exercito> exercitos){
        exercitop.deletarExercitos(exercitos);
    }
    
    public ArrayList<Exercito> carregarExercitos(){
        return new ArrayList<Exercito> (exercitop.carregarExercitos());
    }
}

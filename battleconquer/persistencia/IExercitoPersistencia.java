package battleconquer.persistencia;

import battleconquer.model.Exercito;
import java.util.ArrayList;

public interface IExercitoPersistencia {
    public void gravarExercitos(ArrayList<Exercito> exercitos);
    public void deletarExercitos(ArrayList<Exercito> exercitos);
    public ArrayList<Exercito> carregarExercitos();
}

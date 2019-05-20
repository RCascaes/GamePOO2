package battleconquer.persistencia;

import battleconquer.model.Jogador;

public interface IBancoPersistencia {
    public boolean primeiraExecucao();
    public void createTables();
    public void inserts(Jogador j);
    public void uninstall();
}

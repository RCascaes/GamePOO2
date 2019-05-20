package guiJFX;

import static dados.Dados.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class WinnerControlador {
    @FXML
    private Label lblPlayer;
    
    @FXML
    private void initialize() {
        lblPlayer.setText(jogadores.get(vezJog-1).getNome());
    }
    
    @FXML
    public void actionMenu(ActionEvent event) {
        campos.clear();
        exercitos.clear();
        jogadores.clear();
        mapas.clear();
        pecasBlue.clear();
        pecasBlack.clear();
        terrenos.clear();
        idMapMatch = 0;
        rodada = 0;
        vezJog = 1;
        contClick = 0;    
        qtdCampBlue = 0;
        qtdCampBlack = 0;
        battleconquer.BattleConquer.mudaTela("menu");
    }
}

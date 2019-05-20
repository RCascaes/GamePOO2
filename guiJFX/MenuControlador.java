package guiJFX;

import static dados.Dados.*;
import fachada.Fachada;
import java.io.IOException;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class MenuControlador {
    Fachada fachada = Fachada.getInstancia();
    
    @FXML
    public void actionCarrer(ActionEvent event) {
        // Versão Demo, esta versão não possuí modo carreira.
    }
    
    @FXML
    public void actionMultiplayer (ActionEvent event) throws IOException {
     // Cache da tela Multiplayer.
        Parent fxmlMultiplayer = FXMLLoader.load(getClass().getResource("/guiJFX/Multiplayer.fxml"));
        multiplayerScene = new Scene(fxmlMultiplayer);
        battleconquer.BattleConquer.mudaTela("multiplayer");
    }
    
    @FXML
    public void actionLoad(ActionEvent event) throws IOException {
     // Cache da tela Match.
        Parent fxmlMatch = FXMLLoader.load(getClass().getResource("/guiJFX/Match.fxml"));
        matchScene = new Scene(fxmlMatch);
        battleconquer.BattleConquer.mudaTela("match");
    }
    
    @FXML
    public void actionUninstall(ActionEvent event) {
        fachada.uninstall();
        Platform.exit();
    }
}

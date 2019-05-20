package battleconquer;

import static dados.Dados.*;
import fachada.Fachada;
import java.util.Scanner;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BattleConquer extends Application {
    private static Stage stage;
    
    private static Scene loginScene;
    private static Scene menuScene;
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        Fachada fachada = Fachada.getInstancia();
        
        stage = primaryStage;
        
        primaryStage.setTitle("Battle Conquer");
        
     // Cache da tela de Login.
        Parent fxmlLogin = FXMLLoader.load(getClass().getResource("/guiJFX/Login.fxml"));
        loginScene = new Scene(fxmlLogin);
        
     // Cache da tela Menu.
        Parent fxmlMenu = FXMLLoader.load(getClass().getResource("/guiJFX/Menu.fxml"));
        menuScene = new Scene(fxmlMenu);
        
        if (fachada.primeiraExecucao()) {
            primaryStage.setScene(loginScene);         
        }
        else {
            primaryStage.setScene(menuScene);
        }
        primaryStage.show();
    }
    
    public static void mudaTela(String screen) {
        switch (screen) {
            case "inicio": {
                stage.setScene(loginScene);
                break;
            }
            case "menu": {
                stage.setScene(menuScene);
                break;
            }
            case "multiplayer": {
                stage.setScene(multiplayerScene);
                break;
            }
            case "match": {
                stage.setScene(matchScene);
                break;
            }
            case "winner": {
                stage.setScene(winnerScene);
                break;
            }
        }
    }
    
    public static void main(String[] args) {
        Fachada fachada = Fachada.getInstancia();
        
        Scanner in = new Scanner(System.in);
        
        fachada.createTables();
        launch(args);
    }    
}

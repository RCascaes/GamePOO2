package guiJFX;

import battleconquer.model.Jogador;
import fachada.Fachada;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.fxml.FXML;

public class LoginControlador {
    
    Fachada fachada = Fachada.getInstancia();    
    
    @FXML
    private TextField txtNome;
    @FXML
    private Label lblMensagem;
    
    @FXML
    public void actionLogin(ActionEvent event) throws IOException {
        Jogador j = new Jogador();
        j.setId_jogador(1);
        if (txtNome.getText().length() > 0) {
            j.setNome(txtNome.getText());
            fachada.inserts(j);
            battleconquer.BattleConquer.mudaTela("menu");
        }      
        else {
            lblMensagem.setText("Campo obrigatório");
        }
    } 
}

package guiJFX;

import battleconquer.model.Exercito;
import static dados.Dados.*;
import battleconquer.model.Jogador;
import fachada.Fachada;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MultiplayerControlador {
    private Fachada fachada = Fachada.getInstancia();
    
    private Jogador jogador1 = new Jogador();
    private Jogador jogador2 = new Jogador();
    
    private Exercito exercito1;
    private Exercito exercito2;
    
    @FXML
    private TextField txtPlayer1;
    @FXML
    private TextField txtPlayer2;
    
    @FXML
    private Label lblCor1;
    @FXML
    private Label lblCor2;
    @FXML
    private Label lblMensagem;
    
    @FXML
    private ComboBox<String> cmbMapa;
    private ObservableList<String> dadosCmbMapa = FXCollections.observableArrayList();
    
    public MultiplayerControlador(){   
        jogador1 = fachada.carregarJogadores().get(0);
        cores = fachada.carregarCores(); 
        mapas = fachada.carregarMapas();
        for (int i=0; i < mapas.size(); i++) {
            if (mapas.get(i).isLiberado()) {
                dadosCmbMapa.add(mapas.get(i).getDescricao());
            }
        }
    }
    
    @FXML
    private void initialize() {
        txtPlayer1.setText(jogador1.getNome());
        
        lblCor1.setText(cores.get(0).getDescricao());
        lblCor2.setText(cores.get(1).getDescricao());
        
        cmbMapa.setItems(dadosCmbMapa);
        
        cmbMapa.setValue(mapas.get(0).getDescricao());
        
        cmbMapa.setOnAction((event) -> {
            idMapMatch = cmbMapa.getSelectionModel().getSelectedIndex();
        });
    }
    
    @FXML
    public void actionJogar(ActionEvent event) throws IOException {
        if (txtPlayer2.getText().length() > 0) {
            
            jogador2.setId_jogador(2);
            jogador2.setNome(txtPlayer2.getText());
            
            jogadores.add(jogador1);
            jogadores.add(jogador2);
            
            exercito1 = new Exercito(1, 1, 1, 0, 0, 0);
            exercito2 = new Exercito(2, 2, 2, 0, 0, 0);
            
            exercitos.add(exercito1);
            exercitos.add(exercito2); 
            
         // Adicionando parametros na classe "Dados".
            rodada = 1;
            vezJog = 1;
            contClick = 0;
            qtdCampBlue = 1;
            qtdCampBlack = 1;
            
         // Cache da tela Match.
            Parent fxmlMatch = FXMLLoader.load(getClass().getResource("/guiJFX/Match.fxml"));
            matchScene = new Scene(fxmlMatch);
            battleconquer.BattleConquer.mudaTela("match");
        }      
        else {
            lblMensagem.setText("Campo obrigatório");
        }
    }
    
    @FXML
    public void actionVoltar(ActionEvent event) {
        battleconquer.BattleConquer.mudaTela("menu");
    }
}

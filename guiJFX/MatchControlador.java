package guiJFX;

import battleconquer.model.Campo;
import battleconquer.model.Peca;
import static dados.Dados.*;
import java.io.IOException;
import java.util.Random;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import static javafx.scene.paint.Color.BLACK;
import static javafx.scene.paint.Color.BLUE;

public class MatchControlador {
    
    @FXML
    private Label lblPlayer;
    @FXML
    private Label lblTerritorio;
    @FXML
    private Label lblQtdTerritorio;
    
    @FXML
    private Button btnEndTurn;
    @FXML
    private Button btnSurrender;
    
    @FXML
    private GridPane grdMapa;
    
    @FXML
    private Button cmp00, cmp01, cmp02, cmp03, cmp04, cmp05, cmp06, cmp07, cmp08, cmp09,
                   cmp10, cmp11, cmp12, cmp13, cmp14, cmp15, cmp16, cmp17, cmp18, cmp19,
                   cmp20, cmp21, cmp22, cmp23, cmp24, cmp25, cmp26, cmp27, cmp28, cmp29,
                   cmp30, cmp31, cmp32, cmp33, cmp34, cmp35, cmp36, cmp37, cmp38, cmp39,
                   cmp40, cmp41, cmp42, cmp43, cmp44, cmp45, cmp46, cmp47, cmp48, cmp49,
                   cmp50, cmp51, cmp52, cmp53, cmp54, cmp55, cmp56, cmp57, cmp58, cmp59,
                   cmp60, cmp61, cmp62, cmp63, cmp64, cmp65, cmp66, cmp67, cmp68, cmp69,
                   cmp70, cmp71, cmp72, cmp73, cmp74, cmp75, cmp76, cmp77, cmp78, cmp79,
                   cmp80, cmp81, cmp82, cmp83, cmp84, cmp85, cmp86, cmp87, cmp88, cmp89,
                   cmp90, cmp91, cmp92, cmp93, cmp94, cmp95, cmp96, cmp97, cmp98, cmp99;
    
    @FXML
    private Button [][] btnMapa = new Button[10][10];
    
    int xOrig, yOrig, valPeca;
    
    @FXML
    private void initialize() {
        btnMapa [0][0] = cmp00; btnMapa [0][1] = cmp01; btnMapa [0][2] = cmp02; btnMapa [0][3] = cmp03; btnMapa [0][4] = cmp04; btnMapa [0][5] = cmp05; btnMapa [0][6] = cmp06; btnMapa [0][7] = cmp07; btnMapa [0][8] = cmp08; btnMapa [0][9] = cmp09;
        btnMapa [1][0] = cmp10; btnMapa [1][1] = cmp11; btnMapa [1][2] = cmp12; btnMapa [1][3] = cmp13; btnMapa [1][4] = cmp14; btnMapa [1][5] = cmp15; btnMapa [1][6] = cmp16; btnMapa [1][7] = cmp17; btnMapa [1][8] = cmp18; btnMapa [1][9] = cmp19;
        btnMapa [2][0] = cmp20; btnMapa [2][1] = cmp21; btnMapa [2][2] = cmp22; btnMapa [2][3] = cmp23; btnMapa [2][4] = cmp24; btnMapa [2][5] = cmp25; btnMapa [2][6] = cmp26; btnMapa [2][7] = cmp27; btnMapa [2][8] = cmp28; btnMapa [2][9] = cmp29;
        btnMapa [3][0] = cmp30; btnMapa [3][1] = cmp31; btnMapa [3][2] = cmp32; btnMapa [3][3] = cmp33; btnMapa [3][4] = cmp34; btnMapa [3][5] = cmp35; btnMapa [3][6] = cmp36; btnMapa [3][7] = cmp37; btnMapa [3][8] = cmp38; btnMapa [3][9] = cmp39;
        btnMapa [4][0] = cmp40; btnMapa [4][1] = cmp41; btnMapa [4][2] = cmp42; btnMapa [4][3] = cmp43; btnMapa [4][4] = cmp44; btnMapa [4][5] = cmp45; btnMapa [4][6] = cmp46; btnMapa [4][7] = cmp47; btnMapa [4][8] = cmp48; btnMapa [4][9] = cmp49;
        btnMapa [5][0] = cmp50; btnMapa [5][1] = cmp51; btnMapa [5][2] = cmp52; btnMapa [5][3] = cmp53; btnMapa [5][4] = cmp54; btnMapa [5][5] = cmp55; btnMapa [5][6] = cmp56; btnMapa [5][7] = cmp57; btnMapa [5][8] = cmp58; btnMapa [5][9] = cmp59;
        btnMapa [6][0] = cmp60; btnMapa [6][1] = cmp61; btnMapa [6][2] = cmp62; btnMapa [6][3] = cmp63; btnMapa [6][4] = cmp64; btnMapa [6][5] = cmp65; btnMapa [6][6] = cmp66; btnMapa [6][7] = cmp67; btnMapa [6][8] = cmp68; btnMapa [6][9] = cmp69;
        btnMapa [7][0] = cmp70; btnMapa [7][1] = cmp71; btnMapa [7][2] = cmp72; btnMapa [7][3] = cmp73; btnMapa [7][4] = cmp74; btnMapa [7][5] = cmp75; btnMapa [7][6] = cmp76; btnMapa [7][7] = cmp77; btnMapa [7][8] = cmp78; btnMapa [7][9] = cmp79;
        btnMapa [8][0] = cmp80; btnMapa [8][1] = cmp81; btnMapa [8][2] = cmp82; btnMapa [8][3] = cmp83; btnMapa [8][4] = cmp84; btnMapa [8][5] = cmp85; btnMapa [8][6] = cmp86; btnMapa [8][7] = cmp87; btnMapa [8][8] = cmp88; btnMapa [8][9] = cmp89;
        btnMapa [9][0] = cmp90; btnMapa [9][1] = cmp91; btnMapa [9][2] = cmp92; btnMapa [9][3] = cmp93; btnMapa [9][4] = cmp94; btnMapa [9][5] = cmp95; btnMapa [9][6] = cmp96; btnMapa [9][7] = cmp97; btnMapa [9][8] = cmp98; btnMapa [9][9] = cmp99;


        lblPlayer.setText(jogadores.get(0).getNome());
        lblPlayer.setTextFill(BLUE);

        lblTerritorio.setTextFill(BLUE);

        lblQtdTerritorio.setText("1");
        lblQtdTerritorio.setTextFill(BLUE);

        btnEndTurn.setTextFill(BLUE);

        btnSurrender.setTextFill(BLUE);   

        for (int i=0; i < 10; i++) {
            for (int j=0; j < 10; j++) {
                campos.add(new Campo(i, j, 1, 1));
            }    
        }

        pecasBlue.add(new Peca(1, 1, 1, 5, false));
        cmp11.setText("5");
        cmp11.setTextFill(BLUE);

        pecasBlack.add(new Peca(2, 8, 8, 5, false));
        cmp88.setText("5");
        cmp88.setTextFill(BLACK);

        desabilitaGrid();
    }
    
    @FXML
    public void actionSave(ActionEvent event) {
        // O botão "Save" esta desabilitado para esta versão.
    }
    
    @FXML
    public void actionQuit(ActionEvent event) {
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
    
    @FXML
    public void actionSurrender(ActionEvent event) throws IOException {
        if (vezJog == 1){
            vezJog = 2;
        } else {
            vezJog = 1;
        }
        finalizaGame();
    }
    
    @FXML
    public void actionEndTurn(ActionEvent event) {
        distribuiExercito();
        if (vezJog == 1) {
            vezJog = 2;
            lblPlayer.setTextFill(BLACK);

            lblTerritorio.setTextFill(BLACK);

            lblQtdTerritorio.setText(qtdCampBlack+"");
            lblQtdTerritorio.setTextFill(BLACK);

            btnEndTurn.setTextFill(BLACK);

            btnSurrender.setTextFill(BLACK); 
        } else {
            vezJog = 1;
            lblPlayer.setTextFill(BLUE);

            lblTerritorio.setTextFill(BLUE);

            lblQtdTerritorio.setText(qtdCampBlue+"");
            lblQtdTerritorio.setTextFill(BLUE);

            btnEndTurn.setTextFill(BLUE);

            btnSurrender.setTextFill(BLUE); 
        } 
        lblPlayer.setText(jogadores.get(vezJog-1).getNome());
        contClick = 0;
        desabilitaGrid();
        habilitaJogador();
    }
    
    @FXML
    public void clickButton(ActionEvent event) throws IOException {
        String c = ((Control)event.getSource()).getId();
        int x = Character.getNumericValue(c.charAt(3));
        int y = Character.getNumericValue(c.charAt(4));
        if (contClick == 0){
            liberaCampo(x, y);
        } else {
            batalhaCampo(x, y);
        }
    }
    
    private void desabilitaGrid () {
        for (int i=0; i < 100; i++) {
            int aux = i%10;
            int x = (i-aux) / 10;
            int y = aux;
            if (btnMapa[x][y].getText().length() == 0){
                btnMapa[x][y].setDisable(true);
            }
        }
        if (vezJog == 1){
            for (int i=0; i<pecasBlack.size(); i++){
                btnMapa[pecasBlack.get(i).getX()][pecasBlack.get(i).getY()].setDisable(true);
            }
            for (int i=0; i<pecasBlue.size(); i++){
                if (pecasBlue.get(i).getNumero() == 1) {
                    btnMapa[pecasBlue.get(i).getX()][pecasBlue.get(i).getY()].setDisable(true);
                }
            }
        }
        else {
            for (int i=0; i<pecasBlue.size(); i++){
                btnMapa[pecasBlue.get(i).getX()][pecasBlue.get(i).getY()].setDisable(true);
            }
            for (int i=0; i<pecasBlack.size(); i++){
                if (pecasBlack.get(i).getNumero() == 1) {
                    btnMapa[pecasBlack.get(i).getX()][pecasBlack.get(i).getY()].setDisable(true);
                }
            }
        }
    }
    
    private void desabilitaJogador(){
        if (vezJog == 1){
            for (int i=0; i<pecasBlue.size(); i++){
                if (pecasBlue.get(i).getX() != xOrig || pecasBlue.get(i).getY() != yOrig) {
                    btnMapa[pecasBlue.get(i).getX()][pecasBlue.get(i).getY()].setDisable(true);
                }
            }
        }
        else {
            for (int i=0; i<pecasBlack.size(); i++){
                if (pecasBlack.get(i).getX() != xOrig || pecasBlack.get(i).getY() != yOrig) {
                    btnMapa[pecasBlack.get(i).getX()][pecasBlack.get(i).getY()].setDisable(true);
                }
            }
        }
    }
    
    private void habilitaJogador(){
        if (vezJog == 1){
            for (int i=0; i<pecasBlue.size(); i++){
                if (pecasBlue.get(i).getNumero() > 1) {
                    if (pecasBlue.get(i).getX() > 0) {
                        if (btnMapa[pecasBlue.get(i).getX()-1][pecasBlue.get(i).getY()].getText().length() == 0 ||
                                btnMapa[pecasBlue.get(i).getX()-1][pecasBlue.get(i).getY()].getTextFill() != BLUE) {
                            btnMapa[pecasBlue.get(i).getX()][pecasBlue.get(i).getY()].setDisable(false);
                        }
                    }
                    if (pecasBlue.get(i).getX() < 9) {
                        if (btnMapa[pecasBlue.get(i).getX()+1][pecasBlue.get(i).getY()].getText().length() == 0 ||
                                btnMapa[pecasBlue.get(i).getX()+1][pecasBlue.get(i).getY()].getTextFill() != BLUE) {
                            btnMapa[pecasBlue.get(i).getX()][pecasBlue.get(i).getY()].setDisable(false);
                        }
                    }
                    if (pecasBlue.get(i).getY() > 0) {
                        if (btnMapa[pecasBlue.get(i).getX()][pecasBlue.get(i).getY()-1].getText().length() == 0 ||
                                btnMapa[pecasBlue.get(i).getX()][pecasBlue.get(i).getY()-1].getTextFill() != BLUE) {
                            btnMapa[pecasBlue.get(i).getX()][pecasBlue.get(i).getY()].setDisable(false);
                        }
                    }
                    if (pecasBlue.get(i).getY() < 9) {
                        if (btnMapa[pecasBlue.get(i).getX()][pecasBlue.get(i).getY()+1].getText().length() == 0 ||
                                btnMapa[pecasBlue.get(i).getX()][pecasBlue.get(i).getY()+1].getTextFill() != BLUE) {
                            btnMapa[pecasBlue.get(i).getX()][pecasBlue.get(i).getY()].setDisable(false);
                        }
                    }
                }
            }
        }
        else {
            for (int i=0; i<pecasBlack.size(); i++){
                if (pecasBlack.get(i).getNumero() > 1) {
                    if (pecasBlack.get(i).getX() > 0) {
                        if (btnMapa[pecasBlack.get(i).getX()-1][pecasBlack.get(i).getY()].getText().length() == 0 ||
                                btnMapa[pecasBlack.get(i).getX()-1][pecasBlack.get(i).getY()].getTextFill() != BLACK) {
                            btnMapa[pecasBlack.get(i).getX()][pecasBlack.get(i).getY()].setDisable(false);
                        }
                    }
                    if (pecasBlack.get(i).getX() < 9) {
                        if (btnMapa[pecasBlack.get(i).getX()+1][pecasBlack.get(i).getY()].getText().length() == 0 ||
                                btnMapa[pecasBlack.get(i).getX()+1][pecasBlack.get(i).getY()].getTextFill() != BLACK) {
                            btnMapa[pecasBlack.get(i).getX()][pecasBlack.get(i).getY()].setDisable(false);
                        }
                    }
                    if (pecasBlack.get(i).getY() > 0) {
                        if (btnMapa[pecasBlack.get(i).getX()][pecasBlack.get(i).getY()-1].getText().length() == 0 ||
                                btnMapa[pecasBlack.get(i).getX()][pecasBlack.get(i).getY()-1].getTextFill() != BLACK) {
                            btnMapa[pecasBlack.get(i).getX()][pecasBlack.get(i).getY()].setDisable(false);
                        }
                    }
                    if (pecasBlack.get(i).getY() < 9) {
                        if (btnMapa[pecasBlack.get(i).getX()][pecasBlack.get(i).getY()+1].getText().length() == 0 ||
                                btnMapa[pecasBlack.get(i).getX()][pecasBlack.get(i).getY()+1].getTextFill() != BLACK) {
                            btnMapa[pecasBlack.get(i).getX()][pecasBlack.get(i).getY()].setDisable(false);
                        }
                    }
                }
            }
        }
    } 
    
    private void distribuiExercito(){
        Random numRandom = new Random();
        boolean todasMax = true;
        if (vezJog == 1) {
            for (int i=0; i<qtdCampBlue; i++){
                int pecaSort = numRandom.nextInt(pecasBlue.size());
                if (pecasBlue.get(pecaSort).getNumero() < 10) {
                    pecasBlue.get(pecaSort).setNumero(pecasBlue.get(pecaSort).getNumero()+1);
                    btnMapa[pecasBlue.get(pecaSort).getX()][pecasBlue.get(pecaSort).getY()].setText(pecasBlue.get(pecaSort).getNumero()+"");
                } else {
                    for (int j=0; j<pecasBlue.size(); j++){
                        if (pecasBlue.get(j).getNumero() < 10 && todasMax) {
                            todasMax = false;
                            i--;
                        }
                    }
                } 
                todasMax = true;                
            }
        } else {
            for (int i=0; i<qtdCampBlack; i++){
                int pecaSort = numRandom.nextInt(pecasBlack.size());
                if (pecasBlack.get(pecaSort).getNumero() < 10) {
                    pecasBlack.get(pecaSort).setNumero(pecasBlack.get(pecaSort).getNumero()+1);
                    btnMapa[pecasBlack.get(pecaSort).getX()][pecasBlack.get(pecaSort).getY()].setText(pecasBlack.get(pecaSort).getNumero()+"");
                } else {
                    for (int j=0; j<pecasBlack.size(); j++){
                        if (pecasBlack.get(j).getNumero() < 10 && todasMax) {
                            todasMax = false;
                            i--;
                        }
                    }
                }
                todasMax = true; 
            }
        }
    }
    
    private void liberaCampo(int x, int y) {
        contClick = 1;
        xOrig = x;
        yOrig = y;
        
        if (x > 0) {
            btnMapa[x-1][y].setDisable(false);
        }
        if (x < 9) {
            btnMapa[x+1][y].setDisable(false);
        }
        if (y > 0) {
            btnMapa[x][y-1].setDisable(false);
        }
        if (y < 9) {
            btnMapa[x][y+1].setDisable(false);
        }
        
        desabilitaJogador();
    }
    
    private void batalhaCampo(int x, int y) throws IOException {
        boolean conquistou = false;
        valPeca = Integer.parseInt(btnMapa[xOrig][yOrig].getText()) - 1;
        
        if (x == xOrig && y == yOrig) {
            desabilitaGrid();
            desabilitaJogador();
            habilitaJogador();
            contClick = 0;
            return;
        } 
        else if (btnMapa[x][y].getText().length() == 0){
            btnMapa[x][y].setText(valPeca+"");
            if (vezJog == 1) {
                pecasBlue.add(new Peca(vezJog, x, y, valPeca, false));
                btnMapa[x][y].setTextFill(BLUE);
                btnMapa[xOrig][yOrig].setText(1+"");
                
                conquistou = true;
            } else {
                pecasBlack.add(new Peca(vezJog, x, y, valPeca, false));
                btnMapa[x][y].setTextFill(BLACK);
                btnMapa[xOrig][yOrig].setText(1+"");
                conquistou = true;
            }
        } else {
            int sortBlue=0, sortBlack=0;
            Peca pecaAux = new Peca();
            Random numRandom = new Random();
            if (vezJog == 1) {
                for (int i=0; i<valPeca; i++) {
                    sortBlue += numRandom.nextInt(10); 
                }
                for (int i=0; i<(Integer.parseInt(btnMapa[x][y].getText())); i++) {
                    sortBlack += numRandom.nextInt(10); 
                }
                if (sortBlue > sortBlack) {
                    pecasBlue.add(new Peca(vezJog, x, y, valPeca, false));
                    for (int i=0; i<pecasBlack.size(); i++) {
                        if (pecasBlack.get(i).getX() == x && pecasBlack.get(i).getY() == y){
                            pecaAux = pecasBlack.get(i);
                        }
                    }
                    pecasBlack.remove(pecaAux);
                    btnMapa[xOrig][yOrig].setText("1");
                    btnMapa[x][y].setText(valPeca+"");
                    btnMapa[x][y].setTextFill(BLUE);
                    qtdCampBlack--;
                    if (qtdCampBlack == 0) {
                        finalizaGame();
                    }
                    conquistou = true;
                }
                else {
                    for (int i=0; i<pecasBlue.size(); i++) {
                        if (pecasBlue.get(i).getX() == xOrig && pecasBlue.get(i).getY() == yOrig){
                            pecasBlue.get(i).setNumero(1);
                        }
                    }
                    btnMapa[xOrig][yOrig].setText("1");
                }
            } else {
                for (int i=0; i<valPeca; i++) {
                    sortBlack += numRandom.nextInt(10); 
                }
                for (int i=0; i<(Integer.parseInt(btnMapa[x][y].getText())); i++) {
                    sortBlue += numRandom.nextInt(10); 
                }
                if (sortBlack > sortBlue) {
                    pecasBlack.add(new Peca(vezJog, x, y, valPeca, false));
                    for (int i=0; i<pecasBlue.size(); i++) {
                        if (pecasBlue.get(i).getX() == x && pecasBlue.get(i).getY() == y){
                            pecaAux = pecasBlue.get(i);
                        }
                    }
                    pecasBlue.remove(pecaAux);
                    btnMapa[xOrig][yOrig].setText("1");
                    btnMapa[x][y].setText(valPeca+"");
                    btnMapa[x][y].setTextFill(BLACK);
                    qtdCampBlue--;
                    if (qtdCampBlue == 0) {
                        finalizaGame();
                    }
                    conquistou = true;
                }
                else {
                    for (int i=0; i<pecasBlack.size(); i++) {
                        if (pecasBlack.get(i).getX() == xOrig && pecasBlack.get(i).getY() == yOrig){
                            pecasBlack.get(i).setNumero(1);
                        }
                    }
                    btnMapa[xOrig][yOrig].setText("1");
                }
            }
        }
        if (vezJog == 1) {
            for (int i=0; i<pecasBlue.size(); i++){
                if (pecasBlue.get(i).getX() == xOrig && pecasBlue.get(i).getY() == yOrig) {
                    pecasBlue.get(i).setNumero(1);
                }
            }
        } else {
            for (int i=0; i<pecasBlack.size(); i++){
                if (pecasBlack.get(i).getX() == xOrig && pecasBlack.get(i).getY() == yOrig) {
                    pecasBlack.get(i).setNumero(1);
                }
            }            
        }
        if (conquistou){
            if (vezJog == 1) {
                qtdCampBlue++;
                lblQtdTerritorio.setText(qtdCampBlue+"");
            } else {
                qtdCampBlack++;
                lblQtdTerritorio.setText(qtdCampBlack+"");
            }
        }
        desabilitaGrid();
        desabilitaJogador();
        habilitaJogador();
        contClick = 0;
    }
    
    private void finalizaGame() throws IOException {
     // Cache da tela Menu.
        Parent fxmlWinner = FXMLLoader.load(getClass().getResource("/guiJFX/Winner.fxml"));
        winnerScene = new Scene(fxmlWinner);
        
        battleconquer.BattleConquer.mudaTela("winner");
    }
}

package blackjack.blackjack.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class IdiomaController {


    static String idioma;

    @FXML
    private Label idioma_label;

    @FXML
    private Button btn_CHN_grande;

    @FXML
    private Button btn_CHN_peque;

    @FXML
    private Button btn_ESP_grande;

    @FXML
    private Button btn_ESP_peque;

    @FXML
    private Button btn_FRA_grande;

    @FXML
    private Button btn_FRA_peque;

    @FXML
    private Button btn_ING_grande;

    @FXML
    private Button btn_ING_peque;

    @FXML
    private Button btn_RUS_grande;

    @FXML
    private Button btn_RUS_peque;

    @FXML
    private Button btn_continuar;

    @FXML
    private Button btn_continuar_grande;

    @FXML
    void click_CHN() {
        reset();
        btn_CHN_grande.setOpacity(0.5);
        btn_CHN_peque.setOpacity(0.5);
        idioma = "CHN";
        idioma_label.setText("语言");
        btn_continuar.setText("法语");
        btn_continuar_grande.setText("法语");
        btn_continuar.setDisable(false);
        btn_continuar_grande.setDisable(false);
        System.out.println(idioma);
    }

    @FXML
    void click_ESP() {
        reset();
        btn_ESP_grande.setOpacity(0.5);
        btn_ESP_peque.setOpacity(0.5);
        idioma = "ESP";
        idioma_label.setText("Idioma");
        btn_continuar.setText("Continuar");
        btn_continuar_grande.setText("Continuar");
        btn_continuar.setDisable(false);
        btn_continuar_grande.setDisable(false);
        System.out.println(idioma);
    }

    @FXML
    void click_FRA() {
        reset();
        btn_FRA_grande.setOpacity(0.5);
        btn_FRA_peque.setOpacity(0.5);
        idioma = "FRA";
        idioma_label.setText("Langage");
        btn_continuar.setText("Continuer");
        btn_continuar_grande.setText("Continuer");
        btn_continuar.setDisable(false);
        btn_continuar_grande.setDisable(false);
        System.out.println(idioma);
    }

    @FXML
    void click_ING() {
        reset();
        btn_ING_grande.setOpacity(0.5);
        btn_ING_peque.setOpacity(0.5);
        idioma = "ING";
        idioma_label.setText("Language");
        btn_continuar.setText("Continue");
        btn_continuar_grande.setText("Continue");
        btn_continuar.setDisable(false);
        btn_continuar_grande.setDisable(false);
        System.out.println(idioma);
    }

    @FXML
    void click_RUS() {
        reset();
        btn_RUS_grande.setOpacity(0.5);
        btn_RUS_peque.setOpacity(0.5);
        idioma = "RUS";
        idioma_label.setText("язык");
        btn_continuar.setText("следующий");
        btn_continuar_grande.setText("следующий");
        btn_continuar.setDisable(false);
        btn_continuar_grande.setDisable(false);
        System.out.println(idioma);
    }

    @FXML
    void mouse_off_CHN_grande() {
        btn_CHN_grande.setVisible(false);
        btn_CHN_peque.setVisible(true);
    }

    @FXML
    void mouse_off_ESP_grande() {
        btn_ESP_grande.setVisible(false);
        btn_ESP_peque.setVisible(true);
    }

    @FXML
    void mouse_off_FRA_grande() {
        btn_FRA_grande.setVisible(false);
        btn_FRA_peque.setVisible(true);
    }

    @FXML
    void mouse_off_ING_grande() {
        btn_ING_grande.setVisible(false);
        btn_ING_peque.setVisible(true);
    }

    @FXML
    void mouse_off_RUS_grande() {
        btn_RUS_grande.setVisible(false);
        btn_RUS_peque.setVisible(true);
    }

    @FXML
    void mouse_on_CHN_peque() {
        btn_CHN_grande.setVisible(true);
        btn_CHN_peque.setVisible(false);
    }

    @FXML
    void mouse_on_ESP_peque() {
        btn_ESP_grande.setVisible(true);
        btn_ESP_peque.setVisible(false);
    }

    @FXML
    void mouse_on_FRA_peque() {
        btn_FRA_grande.setVisible(true);
        btn_FRA_peque.setVisible(false);
    }

    @FXML
    void mouse_on_ING_peque() {
        btn_ING_grande.setVisible(true);
        btn_ING_peque.setVisible(false);
    }

    @FXML
    void mouse_on_RUS_peque() {
        btn_RUS_grande.setVisible(true);
        btn_RUS_peque.setVisible(false);
    }

    @FXML
    void mouse_on_btn_iniciar(){
        btn_continuar_grande.setVisible(true);
        btn_continuar.setVisible(false);
    }

    @FXML
    void mouse_off_btn_iniciar(){
        btn_continuar_grande.setVisible(false);
        btn_continuar.setVisible(true);
    }

    @FXML
    void btn_continuar_click(ActionEvent event){
        try {
            // Cargar el archivo FXML de la nueva escena
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/blackjack/blackjack/nombre-view.fxml"));
            Parent root = loader.load();

            // Obtener el controlador de la nueva escena si necesitas interactuar con él
            NombreController controlador = loader.getController();

            // Crear la nueva escena
            Scene nuevaEscena = new Scene(root);

            // Obtener el Stage actual
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setTitle("BlackJack - Mario Bueno López");
            stage.setScene(nuevaEscena);
            stage.show();
            stage.centerOnScreen();
            stage.setResizable(false);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void reset(){
        btn_CHN_grande.setOpacity(1);
        btn_CHN_peque.setOpacity(1);
        btn_ESP_grande.setOpacity(1);
        btn_ESP_peque.setOpacity(1);
        btn_FRA_grande.setOpacity(1);
        btn_FRA_peque.setOpacity(1);
        btn_ING_grande.setOpacity(1);
        btn_ING_peque.setOpacity(1);
        btn_RUS_grande.setOpacity(1);
        btn_RUS_peque.setOpacity(1);
    }
}

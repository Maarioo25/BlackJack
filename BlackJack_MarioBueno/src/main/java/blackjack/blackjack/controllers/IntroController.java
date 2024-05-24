package blackjack.blackjack.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Controlador para la pantalla de introducción del juego Blackjack.
 * Esta clase gestiona las interacciones del usuario en la pantalla de introducción,
 * como hacer clic en el botón de iniciar juego o ver la información del juego.
 */
public class IntroController {

    @FXML
    private ImageView btn_info_peque;

    @FXML
    private ImageView btn_info_grande;

    @FXML
    private Button btn_iniciar;

    @FXML
    private Button btn_iniciar_grande;

    /**
     * Método que se activa cuando el mouse se coloca sobre el botón de iniciar juego.
     * Oculta el botón de iniciar juego pequeño y muestra el botón de iniciar juego grande.
     */
    @FXML
    private void mouse_on_btn_iniciar() {
        btn_iniciar.setVisible(false);
        btn_iniciar_grande.setVisible(true);
    }

    /**
     * Método que se activa cuando el mouse sale del área del botón de iniciar juego.
     * Muestra el botón de iniciar juego pequeño y oculta el botón de iniciar juego grande.
     */
    @FXML
    void mouse_off_btn_iniciar() {
        btn_iniciar.setVisible(true);
        btn_iniciar_grande.setVisible(false);
    }

    /**
     * Método que se activa al hacer clic en el botón de iniciar juego.
     * Carga la pantalla de selección de idioma del juego.
     *
     * @param event Evento de clic del botón de iniciar juego.
     */
    @FXML
    private void btn_iniciar_click(ActionEvent event) {
        try {
            // Cargar el archivo FXML de la nueva escena
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/blackjack/blackjack/idioma-view.fxml"));
            Parent root = loader.load();

            // Obtener el controlador de la nueva escena si necesitas interactuar con él
            IdiomaController controlador = loader.getController();

            // Crear la nueva escena
            Scene nuevaEscena = new Scene(root);

            // Obtener el Stage actual
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("BlackJack - Mario Bueno López");
            stage.setScene(nuevaEscena);
            stage.show();
            stage.centerOnScreen();
            stage.setResizable(false);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método que se activa al hacer clic en el botón de información del juego.
     * Muestra una ventana emergente con información sobre el juego.
     */
    @FXML
    void click_info() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/blackjack/blackjack/info-view.fxml"));
            Parent root = loader.load();

            Scene newScene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("Información");
            stage.setScene(newScene);
            stage.show();
            stage.setResizable(false);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método que se activa cuando el mouse se coloca sobre la miniatura del botón de información.
     * Oculta la miniatura del botón de información y muestra la versión grande del botón de información.
     */
    @FXML
    void mouse_on_info_peque() {
        btn_info_peque.setVisible(false);
        btn_info_grande.setVisible(true);
    }

    /**
     * Método que se activa cuando el mouse sale del área de la versión grande del botón de información.
     * Muestra la miniatura del botón de información y oculta la versión grande del botón de información.
     */
    @FXML
    void mouse_off_info_grande() {
        btn_info_peque.setVisible(true);
        btn_info_grande.setVisible(false);
    }
}

package blackjack.blackjack.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Controlador para la selección de avatar y nombre en la interfaz de usuario.
 */
public class NombreController {

    /** Avatar seleccionado por defecto. */
    static int avatar = 3;

    /** Idioma actual de la aplicación. */
    String idioma = IdiomaController.idioma;

    /** Nombre del usuario. */
    public static String nombre;

    /** Indica si el nombre está disponible. */
    boolean nombre_avaible = false;

    /** Indica si el avatar está disponible. */
    boolean avatar_avaible = false;

    @FXML
    private TextField nombre_field;

    @FXML
    private Button btn_jugar;

    @FXML
    private Label label_principal;

    @FXML
    private ImageView hombre1_grande;

    @FXML
    private ImageView hombre1_peque;

    @FXML
    private ImageView hombre2_grande;

    @FXML
    private ImageView hombre2_peque;

    @FXML
    private ImageView hombre3_grande;

    @FXML
    private ImageView hombre3_peque;

    @FXML
    private ImageView hombre4_grande;

    @FXML
    private ImageView hombre4_peque;

    @FXML
    private ImageView hombre5_grande;

    @FXML
    private ImageView hombre5_peque;

    @FXML
    private ImageView mujer1_grande;

    @FXML
    private ImageView mujer1_peque;

    @FXML
    private ImageView mujer2_grande;

    @FXML
    private ImageView mujer2_peque;

    @FXML
    private ImageView mujer3_grande;

    @FXML
    private ImageView mujer3_peque;

    /**
     * Inicializa el controlador y establece los textos según el idioma.
     */
    @FXML
    private void initialize() {
        switch (idioma) {
            case "ESP" -> {
                nombre_field.setPromptText("Nombre");
                btn_jugar.setText("Jugar");
                label_principal.setText("Introduce tu nombre y selecciona un avatar");
            }
            case "ING" -> {
                nombre_field.setPromptText("Name");
                btn_jugar.setText("Play");
                label_principal.setText("Introduce your name and select an avatar");
            }
            case "CHN" -> {
                nombre_field.setPromptText("名字");
                btn_jugar.setText("开始");
                label_principal.setText("请输入你的名字并选择一个头像");
            }
            case "RUS" -> {
                nombre_field.setPromptText("Имя");
                btn_jugar.setText("Играть");
                label_principal.setText("Введите свое имя и выберите аватар");
            }
            case "FRA" -> {
                nombre_field.setPromptText("Nom");
                btn_jugar.setText("Jouer");
                label_principal.setText("Entrez votre nom et sélectionnez un avatar");
            }
        }
    }

    /**
     * Método que se ejecuta cuando el texto del campo de nombre cambia.
     */
    @FXML
    void text_changed() {
        nombre = nombre_field.getText();
        nombre_avaible = !nombre.isEmpty();
        checkBTN();
    }

    /**
     * Método que se ejecuta cuando se hace clic en el avatar hombre 1 grande.
     */
    @FXML
    void mouse_click_hombre1_grande() {
        resetOpacity();
        hombre1_grande.opacityProperty().set(0.5);
        hombre1_peque.opacityProperty().set(0.5);
        avatar = 1;
        avatar_avaible = true;
        checkBTN();
    }

    /**
     * Método que se ejecuta cuando el ratón pasa sobre el avatar hombre 1 pequeño.
     */
    @FXML
    void mouse_on_hombre1_peque() {
        hombre1_grande.setVisible(true);
        hombre1_peque.setVisible(false);
    }

    /**
     * Método que se ejecuta cuando el ratón sale del avatar hombre 1 grande.
     */
    @FXML
    void mouse_off_hombre1_grande() {
        hombre1_grande.setVisible(false);
        hombre1_peque.setVisible(true);
    }

    @FXML
    void mouse_click_hombre2_grande() {
        resetOpacity();
        hombre2_grande.opacityProperty().set(0.5);
        hombre2_peque.opacityProperty().set(0.5);
        avatar = 2;
        avatar_avaible = true;
        checkBTN();
    }

    @FXML
    void mouse_on_hombre2_peque() {
        hombre2_grande.setVisible(true);
        hombre2_peque.setVisible(false);
    }

    @FXML
    void mouse_off_hombre2_grande() {
        hombre2_grande.setVisible(false);
        hombre2_peque.setVisible(true);
    }

    @FXML
    void mouse_click_hombre3_grande() {
        resetOpacity();
        hombre3_grande.opacityProperty().set(0.5);
        hombre3_peque.opacityProperty().set(0.5);
        avatar = 3;
        avatar_avaible = true;
        checkBTN();
    }

    @FXML
    void mouse_on_hombre3_peque() {
        hombre3_grande.setVisible(true);
        hombre3_peque.setVisible(false);
    }

    @FXML
    void mouse_off_hombre3_grande() {
        hombre3_grande.setVisible(false);
        hombre3_peque.setVisible(true);
    }

    @FXML
    void mouse_click_hombre4_grande() {
        resetOpacity();
        hombre4_grande.opacityProperty().set(0.5);
        hombre4_peque.opacityProperty().set(0.5);
        avatar = 4;
        avatar_avaible = true;
        checkBTN();
    }

    @FXML
    void mouse_on_hombre4_peque() {
        hombre4_grande.setVisible(true);
        hombre4_peque.setVisible(false);
    }

    @FXML
    void mouse_off_hombre4_grande() {
        hombre4_grande.setVisible(false);
        hombre4_peque.setVisible(true);
    }

    @FXML
    void mouse_click_hombre5_grande() {
        resetOpacity();
        hombre5_grande.opacityProperty().set(0.5);
        hombre5_peque.opacityProperty().set(0.5);
        avatar = 5;
        avatar_avaible = true;
        checkBTN();
    }

    @FXML
    void mouse_on_hombre5_peque() {
        hombre5_grande.setVisible(true);
        hombre5_peque.setVisible(false);
    }

    @FXML
    void mouse_off_hombre5_grande() {
        hombre5_grande.setVisible(false);
        hombre5_peque.setVisible(true);
    }

    @FXML
    void mouse_click_mujer1_grande() {
        resetOpacity();
        mujer1_grande.opacityProperty().set(0.5);
        mujer1_peque.opacityProperty().set(0.5);
        avatar = 6;
        avatar_avaible = true;
        checkBTN();
    }

    @FXML
    void mouse_on_mujer1_peque() {
        mujer1_grande.setVisible(true);
        mujer1_peque.setVisible(false);
    }

    @FXML
    void mouse_off_mujer1_grande() {
        mujer1_grande.setVisible(false);
        mujer1_peque.setVisible(true);
    }

    @FXML
    void mouse_click_mujer2_grande() {
        resetOpacity();
        mujer2_grande.opacityProperty().set(0.5);
        mujer2_peque.opacityProperty().set(0.5);
        avatar = 7;
        avatar_avaible = true;
        checkBTN();
    }

    @FXML
    void mouse_on_mujer2_peque() {
        mujer2_grande.setVisible(true);
        mujer2_peque.setVisible(false);
    }

    @FXML
    void mouse_off_mujer2_grande() {
        mujer2_grande.setVisible(false);
        mujer2_peque.setVisible(true);
    }

    @FXML
    void mouse_click_mujer3_grande() {
        resetOpacity();
        mujer3_grande.opacityProperty().set(0.5);
        mujer3_peque.opacityProperty().set(0.5);
        avatar = 8;
        avatar_avaible = true;
        checkBTN();
    }

    @FXML
    void mouse_on_mujer3_peque() {
        mujer3_grande.setVisible(true);
        mujer3_peque.setVisible(false);
    }

    @FXML
    void mouse_off_mujer3_grande() {
        mujer3_grande.setVisible(false);
        mujer3_peque.setVisible(true);
    }

    /**
     * Método que se ejecuta cuando se hace clic en el botón "Jugar".
     *
     * @param event El evento de acción.
     */
    @FXML
    void btn_click(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/blackjack/blackjack/tablero-view.fxml"));
            Parent root = loader.load();

            TableroController controlador = loader.getController();

            Scene nuevaEscena = new Scene(root);

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

    /**
     * Verifica si se puede habilitar el botón de jugar.
     */
    void checkBTN() {
        btn_jugar.setDisable(!nombre_avaible || !avatar_avaible);
    }

    /**
     * Restablece la opacidad de todas las imágenes de avatares.
     */
    void resetOpacity() {
        hombre1_grande.opacityProperty().set(1);
        hombre1_peque.opacityProperty().set(1);
        hombre2_peque.opacityProperty().set(1);
        hombre2_grande.opacityProperty().set(1);
        hombre3_peque.opacityProperty().set(1);
        hombre3_grande.opacityProperty().set(1);
        hombre4_peque.opacityProperty().set(1);
        hombre4_grande.opacityProperty().set(1);
        hombre5_peque.opacityProperty().set(1);
        hombre5_grande.opacityProperty().set(1);
        mujer1_peque.opacityProperty().set(1);
        mujer1_grande.opacityProperty().set(1);
        mujer2_peque.opacityProperty().set(1);
        mujer2_grande.opacityProperty().set(1);
        mujer3_peque.opacityProperty().set(1);
        mujer3_grande.opacityProperty().set(1);
    }
}

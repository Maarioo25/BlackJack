package blackjack.blackjack;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

/**
 * MainApp es la clase principal que lanza la aplicación de Blackjack.
 * Configura la etapa inicial y carga la vista inicial desde el archivo FXML.
 * La ventana de la aplicación se configura con un título, un icono y otras propiedades.
 * <p>
 * Autor: Mario Bueno López
 */
public class MainApp extends Application {

    /**
     * El método start es el punto de entrada principal para todas las aplicaciones JavaFX.
     * Inicializa y muestra la etapa primaria con la escena especificada.
     *
     * @param primaryStage la etapa primaria para esta aplicación, en la que se puede establecer la escena de la aplicación.
     */
    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("intro-view.fxml"));
            Pane ventana = loader.load();
            Scene scene = new Scene(ventana);
            primaryStage.setScene(scene);
            primaryStage.setTitle("BlackJack - Mario Bueno López");
            primaryStage.show();
            primaryStage.centerOnScreen();
            primaryStage.setResizable(false);
            primaryStage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/icon.png"))));

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * El método main es el punto de entrada para la aplicación Java.
     * Lanza la aplicación JavaFX.
     *
     * @param args los argumentos de la línea de comandos
     */
    public static void main(String[] args) {
        launch(args);
    }
}

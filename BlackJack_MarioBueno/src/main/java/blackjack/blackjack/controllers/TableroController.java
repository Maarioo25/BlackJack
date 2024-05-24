package blackjack.blackjack.controllers;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import blackjack.blackjack.Models.*;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TableroController{

    private final Object espera = new Object();
    public String idioma;
    public static int avatar = NombreController.avatar;
    Jugador[] mesa = new Jugador[5];
    Dealer dealer = new Dealer();
    Carta[] baraja = new Carta[52];
    Apuesta apuestaCentral = new Apuesta();
    Apuesta apuestaCentralIzquierda = new Apuesta();
    Ficha[] fichasCentral = new Ficha[7];
    Ficha[] fichasCentralIzquierda = new Ficha[7];
    int fichasApostadasEnApuestaCentral = 0;
    int x = 1;
    int cartasJugadasCentro = 2;

    String[] avataresArray = {
            "src/main/resources/Images/Avatares/hombre1.png",
            "src/main/resources/Images/Avatares/hombre2.png",
            "src/main/resources/Images/Avatares/hombre3.png",
            "src/main/resources/Images/Avatares/hombre4.png",
            "src/main/resources/Images/Avatares/hombre5.png",
            "src/main/resources/Images/Avatares/mujer1.png",
            "src/main/resources/Images/Avatares/mujer2.png",
            "src/main/resources/Images/Avatares/mujer3.png"
    };

    // Anotaciones de JavaFX
    @FXML
    private ImageView ficha_1_grande;
    @FXML
    private ImageView ficha_5_grande;
    @FXML
    private ImageView ficha_25_grande;
    @FXML
    private ImageView ficha_50_grande;
    @FXML
    private ImageView ficha_100_grande;

    @FXML
    private Label realiza_tu_apuesta;
    @FXML
    private Label apuesta_centro_jugador_1;
    @FXML
    private Label apuesta_centro_jugador_2;
    @FXML
    private Label apuesta_centro_jugador_3;
    @FXML
    private Label apuesta_centro_jugador_4;
    @FXML
    private Label apuesta_centro_jugador_5;
    @FXML
    private Label apuesta_izquierda_jugador_3;

    @FXML
    private ImageView avatar_dealer;
    @FXML
    private ImageView avatar_jugador_1;
    @FXML
    private ImageView avatar_jugador_2;
    @FXML
    private ImageView avatar_jugador_3;
    @FXML
    private ImageView avatar_jugador_4;
    @FXML
    private ImageView avatar_jugador_5;

    @FXML
    private Button btn_doblar;
    @FXML
    private Button btn_enviarApuesta;
    @FXML
    private Button btn_pedir;
    @FXML
    private Button btn_plantarse;

    @FXML
    private ImageView carta_1_centro_jugador_1;
    @FXML
    private ImageView carta_1_centro_jugador_2;
    @FXML
    private ImageView carta_1_centro_jugador_3;
    @FXML
    private ImageView carta_1_centro_jugador_4;
    @FXML
    private ImageView carta_1_centro_jugador_5;

    @FXML
    private ImageView carta_2_centro_jugador_1;
    @FXML
    private ImageView carta_2_centro_jugador_2;
    @FXML
    private ImageView carta_2_centro_jugador_3;
    @FXML
    private ImageView carta_2_centro_jugador_4;
    @FXML
    private ImageView carta_2_centro_jugador_5;

    @FXML
    private ImageView carta_3_centro_jugador_1;
    @FXML
    private ImageView carta_3_centro_jugador_2;
    @FXML
    private ImageView carta_3_centro_jugador_3;
    @FXML
    private ImageView carta_3_centro_jugador_4;
    @FXML
    private ImageView carta_3_centro_jugador_5;

    @FXML
    private ImageView carta_4_centro_jugador_1;
    @FXML
    private ImageView carta_4_centro_jugador_2;
    @FXML
    private ImageView carta_4_centro_jugador_3;
    @FXML
    private ImageView carta_4_centro_jugador_4;
    @FXML
    private ImageView carta_4_centro_jugador_5;

    @FXML
    private ImageView carta_5_centro_jugador_1;
    @FXML
    private ImageView carta_5_centro_jugador_2;
    @FXML
    private ImageView carta_5_centro_jugador_3;
    @FXML
    private ImageView carta_5_centro_jugador_4;
    @FXML
    private ImageView carta_5_centro_jugador_5;

    @FXML
    private ImageView carta_6_centro_jugador_1;
    @FXML
    private ImageView carta_6_centro_jugador_2;
    @FXML
    private ImageView carta_6_centro_jugador_3;
    @FXML
    private ImageView carta_6_centro_jugador_4;
    @FXML
    private ImageView carta_6_centro_jugador_5;

    @FXML
    private ImageView carta_7_centro_jugador_1;
    @FXML
    private ImageView carta_7_centro_jugador_2;
    @FXML
    private ImageView carta_7_centro_jugador_3;
    @FXML
    private ImageView carta_7_centro_jugador_4;
    @FXML
    private ImageView carta_7_centro_jugador_5;

    @FXML
    private ImageView carta_dealer_1;
    @FXML
    private ImageView carta_dealer_2;
    @FXML
    private ImageView carta_dealer_3;
    @FXML
    private ImageView carta_dealer_4;
    @FXML
    private ImageView carta_dealer_5;
    @FXML
    private ImageView carta_dealer_6;
    @FXML
    private ImageView carta_dealer_7;
    @FXML
    private ImageView carta_dealer_8;

    @FXML
    private ImageView ficha_1;
    @FXML
    private ImageView ficha_100;

    @FXML
    private ImageView ficha_1_apuesta_centro_jugador_1;
    @FXML
    private ImageView ficha_1_apuesta_centro_jugador_2;
    @FXML
    private ImageView ficha_1_apuesta_centro_jugador_3;
    @FXML
    private ImageView ficha_1_apuesta_centro_jugador_4;
    @FXML
    private ImageView ficha_1_apuesta_centro_jugador_5;
    @FXML
    private ImageView ficha_1_apuesta_izquierda_jugador_3;

    @FXML
    private ImageView ficha_25;

    @FXML
    private ImageView ficha_2_apuesta_centro_jugador_1;
    @FXML
    private ImageView ficha_2_apuesta_centro_jugador_2;
    @FXML
    private ImageView ficha_2_apuesta_centro_jugador_3;
    @FXML
    private ImageView ficha_2_apuesta_centro_jugador_4;
    @FXML
    private ImageView ficha_2_apuesta_centro_jugador_5;
    @FXML
    private ImageView ficha_2_apuesta_izquierda_jugador_3;

    @FXML
    private ImageView ficha_3_apuesta_centro_jugador_1;
    @FXML
    private ImageView ficha_3_apuesta_centro_jugador_2;
    @FXML
    private ImageView ficha_3_apuesta_centro_jugador_3;
    @FXML
    private ImageView ficha_3_apuesta_centro_jugador_4;
    @FXML
    private ImageView ficha_3_apuesta_centro_jugador_5;
    @FXML
    private ImageView ficha_3_apuesta_izquierda_jugador_3;

    @FXML
    private ImageView ficha_4_apuesta_centro_jugador_1;
    @FXML
    private ImageView ficha_4_apuesta_centro_jugador_2;
    @FXML
    private ImageView ficha_4_apuesta_centro_jugador_3;
    @FXML
    private ImageView ficha_4_apuesta_centro_jugador_4;
    @FXML
    private ImageView ficha_4_apuesta_centro_jugador_5;
    @FXML
    private ImageView ficha_4_apuesta_izquierda_jugador_3;

    @FXML
    private ImageView ficha_5;
    @FXML
    private ImageView ficha_50;

    @FXML
    private ImageView ficha_5_apuesta_centro_jugador_1;
    @FXML
    private ImageView ficha_5_apuesta_centro_jugador_2;
    @FXML
    private ImageView ficha_5_apuesta_centro_jugador_3;
    @FXML
    private ImageView ficha_5_apuesta_centro_jugador_4;
    @FXML
    private ImageView ficha_5_apuesta_centro_jugador_5;
    @FXML
    private ImageView ficha_5_apuesta_izquierda_jugador_3;

    @FXML
    private ImageView ficha_6_apuesta_centro_jugador_1;
    @FXML
    private ImageView ficha_6_apuesta_centro_jugador_2;
    @FXML
    private ImageView ficha_6_apuesta_centro_jugador_3;
    @FXML
    private ImageView ficha_6_apuesta_centro_jugador_4;
    @FXML
    private ImageView ficha_6_apuesta_centro_jugador_5;
    @FXML
    private ImageView ficha_6_apuesta_izquierda_jugador_3;

    @FXML
    private ImageView ficha_7_apuesta_centro_jugador_1;
    @FXML
    private ImageView ficha_7_apuesta_centro_jugador_2;
    @FXML
    private ImageView ficha_7_apuesta_centro_jugador_3;
    @FXML
    private ImageView ficha_7_apuesta_centro_jugador_4;
    @FXML
    private ImageView ficha_7_apuesta_centro_jugador_5;
    @FXML
    private ImageView ficha_7_apuesta_izquierda_jugador_3;

    @FXML
    private Label fichas_jugador_1;
    @FXML
    private Label fichas_jugador_2;
    @FXML
    private Label fichas_jugador_3;
    @FXML
    private Label fichas_jugador_4;
    @FXML
    private Label fichas_jugador_5;

    @FXML
    private Label suma_de_cartas_dealer;
    @FXML
    private Label suma_de_cartas_jugador_1_centro;
    @FXML
    private Label suma_de_cartas_jugador_2_centro;
    @FXML
    private Label suma_de_cartas_jugador_3_centro;
    @FXML
    private Label suma_de_cartas_jugador_4_centro;
    @FXML
    private Label suma_de_cartas_jugador_5_centro;

    @FXML
    private ImageView tablero;

    @FXML
    private ImageView turno_jugador_1;
    @FXML
    private ImageView turno_jugador_2;
    @FXML
    private ImageView turno_jugador_3;
    @FXML
    private ImageView turno_jugador_4;
    @FXML
    private ImageView turno_jugador_5;
    @FXML
    private ImageView turno_dealer;

    ImageView[] avatares;
    ImageView[] avataresURL;
    ImageView[] cartas;
    Label[] sumas;
    ImageView[] apuestasImagenes;
    Label[] apuestasLabels;
    Label[] cantidadFichas;
    ImageView[] cartasJugador1;
    ImageView[] cartasJugador2;
    ImageView[] cartasJugador3;
    ImageView[] cartasJugador4;
    ImageView[] cartasJugador5;
    ImageView[] turnos;
    ImageView[] cartasDealer;
    ImageView[] avataresJugadores;

    /**
     * Inicializa el juego al cargar la interfaz gráfica.
     * Realiza las siguientes acciones:
     * - Borra archivos anteriores.
     * - Configura el idioma del juego.
     * - Deshabilita los botones.
     * - Crea las cartas de la baraja.
     * - Inicializa los jugadores en la mesa.
     * - Asigna las imágenes de las cartas, sumas, apuestas, avatares y turnos.
     * - Configura el tablero y los textos de los botones según el idioma seleccionado.
     * - Reinicia la apariencia de los elementos visuales.
     * - Establece los jugadores disponibles.
     * - Almacena el dinero de los jugadores.
     * - Establece las apuestas.
     * - Actualiza la visualización de las apuestas y el dinero.
     */
    public void initialize() {
        // Borra archivos anteriores, configura idioma y deshabilita botones
        borrarArchivosAnteriores(); // Método para borrar archivos anteriores
        idioma = IdiomaController.idioma; // Obtiene el idioma seleccionado por el usuario
        deshabilitarBotones(); // Método para deshabilitar botones

        // Inicializa la baraja de cartas
        for (int i = 0; i < 52; i++) {
            baraja[i] = new Carta(i + 1);
        }

        // Inicializa los jugadores en la mesa
        for (int i = 0; i < 5; i++) {
            mesa[i] = new Jugador(x);
            x++;
        }

        // Inicializa arreglos de objetos visuales para representar cartas, sumas, apuestas, avatares, turnos, etc.

        cartas = new ImageView[]{
                carta_1_centro_jugador_1, carta_1_centro_jugador_2, carta_1_centro_jugador_3, carta_1_centro_jugador_4, carta_1_centro_jugador_5,
                carta_2_centro_jugador_1, carta_2_centro_jugador_2, carta_2_centro_jugador_3, carta_2_centro_jugador_4, carta_2_centro_jugador_5,
                carta_3_centro_jugador_1, carta_3_centro_jugador_2, carta_3_centro_jugador_3, carta_3_centro_jugador_4, carta_3_centro_jugador_5,
                carta_4_centro_jugador_1, carta_4_centro_jugador_2, carta_4_centro_jugador_3, carta_4_centro_jugador_4, carta_4_centro_jugador_5,
                carta_5_centro_jugador_1, carta_5_centro_jugador_2, carta_5_centro_jugador_3, carta_5_centro_jugador_4, carta_5_centro_jugador_5,
                carta_6_centro_jugador_1, carta_6_centro_jugador_2, carta_6_centro_jugador_3, carta_6_centro_jugador_4, carta_6_centro_jugador_5,
                carta_7_centro_jugador_1, carta_7_centro_jugador_2, carta_7_centro_jugador_3, carta_7_centro_jugador_4, carta_7_centro_jugador_5,
                carta_dealer_1, carta_dealer_2, carta_dealer_3, carta_dealer_4, carta_dealer_5, carta_dealer_6, carta_dealer_7, carta_dealer_8
        };

        sumas = new Label[]{
                suma_de_cartas_dealer, suma_de_cartas_jugador_1_centro, suma_de_cartas_jugador_2_centro, suma_de_cartas_jugador_3_centro,
                suma_de_cartas_jugador_4_centro, suma_de_cartas_jugador_5_centro
        };

        apuestasImagenes = new ImageView[]{
                ficha_1_apuesta_centro_jugador_1, ficha_1_apuesta_centro_jugador_2, ficha_1_apuesta_centro_jugador_3, ficha_1_apuesta_centro_jugador_4,
                ficha_1_apuesta_centro_jugador_5, ficha_1_apuesta_izquierda_jugador_3, ficha_2_apuesta_centro_jugador_1, ficha_2_apuesta_centro_jugador_2,
                ficha_2_apuesta_centro_jugador_3, ficha_2_apuesta_centro_jugador_4, ficha_2_apuesta_centro_jugador_5, ficha_2_apuesta_izquierda_jugador_3,
                ficha_3_apuesta_centro_jugador_1, ficha_3_apuesta_centro_jugador_2, ficha_3_apuesta_centro_jugador_3, ficha_3_apuesta_centro_jugador_4,
                ficha_3_apuesta_centro_jugador_5, ficha_3_apuesta_izquierda_jugador_3, ficha_4_apuesta_centro_jugador_1, ficha_4_apuesta_centro_jugador_2,
                ficha_4_apuesta_centro_jugador_3, ficha_4_apuesta_centro_jugador_4, ficha_4_apuesta_centro_jugador_5, ficha_4_apuesta_izquierda_jugador_3,
                ficha_5_apuesta_centro_jugador_1, ficha_5_apuesta_centro_jugador_2, ficha_5_apuesta_centro_jugador_3, ficha_5_apuesta_centro_jugador_4,
                ficha_5_apuesta_centro_jugador_5, ficha_5_apuesta_izquierda_jugador_3, ficha_6_apuesta_centro_jugador_1, ficha_6_apuesta_centro_jugador_2,
                ficha_6_apuesta_centro_jugador_3, ficha_6_apuesta_centro_jugador_4, ficha_6_apuesta_centro_jugador_5, ficha_6_apuesta_izquierda_jugador_3,
                ficha_7_apuesta_centro_jugador_1, ficha_7_apuesta_centro_jugador_2, ficha_7_apuesta_centro_jugador_3, ficha_7_apuesta_centro_jugador_4,
                ficha_7_apuesta_centro_jugador_5, ficha_7_apuesta_izquierda_jugador_3
        };

        apuestasLabels = new Label[]{
                apuesta_centro_jugador_1, apuesta_centro_jugador_2, apuesta_centro_jugador_3, apuesta_centro_jugador_4, apuesta_centro_jugador_5,
                apuesta_izquierda_jugador_3
        };

        avatares = new ImageView[]{
                avatar_jugador_1, avatar_jugador_2, avatar_jugador_3, avatar_jugador_4, avatar_jugador_5
        };

        turnos = new ImageView[]{
                turno_jugador_1, turno_jugador_2, turno_jugador_3, turno_jugador_4, turno_jugador_5, turno_dealer
        };

        cantidadFichas = new Label[]{
                fichas_jugador_1, fichas_jugador_2, fichas_jugador_3, fichas_jugador_4, fichas_jugador_5
        };

        cartasJugador1 = new ImageView[]{
                carta_1_centro_jugador_1, carta_2_centro_jugador_1, carta_3_centro_jugador_1, carta_4_centro_jugador_1, carta_5_centro_jugador_1,
                carta_6_centro_jugador_1, carta_7_centro_jugador_1
        };

        cartasJugador2 = new ImageView[]{
                carta_1_centro_jugador_2, carta_2_centro_jugador_2, carta_3_centro_jugador_2, carta_4_centro_jugador_2, carta_5_centro_jugador_2,
                carta_6_centro_jugador_2, carta_7_centro_jugador_2
        };

        cartasJugador3 = new ImageView[]{
                carta_1_centro_jugador_3, carta_2_centro_jugador_3, carta_3_centro_jugador_3, carta_4_centro_jugador_3, carta_5_centro_jugador_3,
                carta_6_centro_jugador_3, carta_7_centro_jugador_3
        };

        cartasJugador4 = new ImageView[]{
                carta_1_centro_jugador_4, carta_2_centro_jugador_4, carta_3_centro_jugador_4, carta_4_centro_jugador_4, carta_5_centro_jugador_4,
                carta_6_centro_jugador_4, carta_7_centro_jugador_4
        };

        cartasJugador5 = new ImageView[]{
                carta_1_centro_jugador_5, carta_2_centro_jugador_5, carta_3_centro_jugador_5, carta_4_centro_jugador_5, carta_5_centro_jugador_5,
                carta_6_centro_jugador_5, carta_7_centro_jugador_5
        };

        cartasDealer = new ImageView[]{
                carta_dealer_1, carta_dealer_2, carta_dealer_3, carta_dealer_4, carta_dealer_5, carta_dealer_6, carta_dealer_7, carta_dealer_8
        };

        // Configura el tablero y los textos de los botones según el idioma
        try {
            switch (idioma) {
                case "ESP" -> configurarTablero("src/main/resources/Images/Tablero_ESP.jpg", "Doblar", "Enviar Apuesta", "Pedir", "Plantarse", "Realiza tu apuesta ->");
                case "ING" -> configurarTablero("src/main/resources/Images/Tablero_ING.jpg", "Double", "Send Bet", "Hit", "Stand", "Make your bet ->");
                case "FRA" -> configurarTablero("src/main/resources/Images/Tablero_FRA.jpg", "Doubler", "Envoyer une mise", "Prendre", "Sauter", "Faire votre mise ->");
                case "RUS" -> configurarTablero("src/main/resources/Images/Tablero_RUS.jpg", "Двойной", "Отправить ставку", "Получить", "Стоять", "Сделайте свою ставку ->");
                case "CHN" -> configurarTablero("src/main/resources/Images/Tablero_CHN.jpg", "双倍", "发送赌注", "拿", "站立", "做你的赌注 ->");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Reinicia la visualización y establece jugadores y apuestas
        reiniciarVisuals(); // Método para reiniciar la visualización
        setJugadores(); // Método para establecer los jugadores
        almacenarDinero(); // Método para almacenar el dinero
        setApuestas(); // Método para establecer las apuestas
        actualizarApuestas(); // Método para actualizar las apuestas
        actualizarDinero(); // Método para actualizar el dinero
    }


    /**
     * Configura la apariencia del tablero de juego y los textos de los botones.
     * @param imagenTablero La ruta de la imagen que se mostrará en el tablero.
     * @param textoDoblar El texto que se mostrará en el botón de doblar.
     * @param textoEnviarApuesta El texto que se mostrará en el botón de enviar apuesta.
     * @param textoPedir El texto que se mostrará en el botón de pedir carta.
     * @param textoPlantarse El texto que se mostrará en el botón de plantarse.
     * @param textoRealizaApuesta El texto que se mostrará en el área de realizar apuesta.
     * @throws Exception Si ocurre algún error al configurar la imagen del tablero.
     */
    public void configurarTablero(String imagenTablero, String textoDoblar, String textoEnviarApuesta, String textoPedir, String textoPlantarse, String textoRealizaApuesta) throws Exception {
        tablero.setImage(new Image(new File(imagenTablero).toURI().toURL().toExternalForm()));
        btn_doblar.setText(textoDoblar);
        btn_enviarApuesta.setText(textoEnviarApuesta);
        btn_pedir.setText(textoPedir);
        btn_plantarse.setText(textoPlantarse);
        realiza_tu_apuesta.setText(textoRealizaApuesta);
    }



    /**
     * Método llamado cuando el cursor sale de la ficha de 1 unidad.
     */
    @FXML
    void mouse_off_ficha_1() {
        toggleFicha(ficha_1, ficha_1_grande, true);
    }



    /**
     * Método llamado cuando el cursor entra en la ficha de 1 unidad.
     */
    @FXML
    void mouse_on_ficha_1() {
        toggleFicha(ficha_1, ficha_1_grande, false);
    }



    /**
     * Método llamado cuando el cursor sale de la ficha de 5 unidad.
     */
    @FXML
    void mouse_off_ficha_5() {
        toggleFicha(ficha_5, ficha_5_grande, true);
    }



    /**
     * Método llamado cuando el cursor entra en la ficha de 5 unidad.
     */
    @FXML
    void mouse_on_ficha_5() {
        toggleFicha(ficha_5, ficha_5_grande, false);
    }



    /**
     * Método llamado cuando el cursor sale de la ficha de 25 unidad.
     */
    @FXML
    void mouse_off_ficha_25() {
        toggleFicha(ficha_25, ficha_25_grande, true);
    }



    /**
     * Método llamado cuando el cursor entra en la ficha de 25 unidad.
     */
    @FXML
    void mouse_on_ficha_25() {
        toggleFicha(ficha_25, ficha_25_grande, false);
    }



    /**
     * Método llamado cuando el cursor sale de la ficha de 50 unidad.
     */
    @FXML
    void mouse_off_ficha_50() {
        toggleFicha(ficha_50, ficha_50_grande, true);
    }



    /**
     * Método llamado cuando el cursor entra en la ficha de 50 unidad.
     */
    @FXML
    void mouse_on_ficha_50() {
        toggleFicha(ficha_50, ficha_50_grande, false);
    }



    /**
     * Método llamado cuando el cursor sale de la ficha de 100 unidad.
     */
    @FXML
    void mouse_off_ficha_100() {
        toggleFicha(ficha_100, ficha_100_grande, true);
    }



    /**
     * Método llamado cuando el cursor entra en la ficha de 100 unidad.
     */
    @FXML
    void mouse_on_ficha_100() {
        toggleFicha(ficha_100, ficha_100_grande, false);
    }



    /**
     * Alterna la visibilidad de las imágenes de la ficha pequeña y grande.
     * @param smallFicha La imagen de la ficha pequeña.
     * @param largeFicha La imagen de la ficha grande.
     * @param isMouseOff Indica si el cursor está fuera (true) o dentro (false) de la ficha.
     */
    private void toggleFicha(ImageView smallFicha, ImageView largeFicha, boolean isMouseOff) {
        smallFicha.setVisible(isMouseOff);
        largeFicha.setVisible(!isMouseOff);
    }





    /**
     * Este método se activa cuando se hace clic en la ficha de 1 unidad para realizar una apuesta.
     * Llama al método apostarFicha(valor) con el valor de la ficha como argumento.
     */
    @FXML
    void ficha_1_click() {
        apostarFicha(1);
    }



    /**
     * Este método se activa cuando se hace clic en la ficha de 5 unidades para realizar una apuesta.
     * Llama al método apostarFicha(valor) con el valor de la ficha como argumento.
     */
    @FXML
    void ficha_5_click() {
        apostarFicha(5);
    }



    /**
     * Este método se activa cuando se hace clic en la ficha de 25 unidades para realizar una apuesta.
     * Llama al método apostarFicha(valor) con el valor de la ficha como argumento.
     */
    @FXML
    void ficha_25_click() {
        apostarFicha(25);
    }



    /**
     * Este método se activa cuando se hace clic en la ficha de 50 unidades para realizar una apuesta.
     * Llama al método apostarFicha(valor) con el valor de la ficha como argumento.
     */
    @FXML
    void ficha_50_click() {
        apostarFicha(50);
    }



    /**
     * Este método se activa cuando se hace clic en la ficha de 100 unidades para realizar una apuesta.
     * Llama al método apostarFicha(valor) con el valor de la ficha como argumento.
     */
    @FXML
    void ficha_100_click() {
        apostarFicha(100);
    }



    /**
     * Este método realiza una apuesta con la ficha de un determinado valor.
     * Verifica si se han apostado menos de 7 fichas en la apuesta central.
     * Si es así, deshabilita el botón de enviar apuesta, resta el valor de la ficha al dinero del jugador,
     * crea una nueva ficha con el valor especificado, actualiza la apuesta central y las fichas apostadas,
     * y actualiza la visualización de las fichas en el centro de la mesa.
     * Si ya se han apostado 7 fichas, imprime un mensaje de advertencia en la consola.
     * @param valor El valor de la ficha a apostar.
     */
    private void apostarFicha(int valor) {
        if (fichasApostadasEnApuestaCentral < 7) {
            btn_enviarApuesta.setDisable(false);
            mesa[2].setDinero(-valor);
            actualizarDinero();
            try {
                fichasCentral[fichasApostadasEnApuestaCentral] = new Ficha(valor);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
            apuestaCentral.setFichas(fichasCentral);
            fichasApostadasEnApuestaCentral++;
            actualizarFichasCentro();
            actualizarApuestas();
        } else {
            System.out.println("No se puede apostar más de 7 fichas");
        }
    }



    /**
     * Este método se activa cuando se hace clic en el botón de enviar apuesta.
     * Deshabilita el botón de enviar apuesta, oculta el botón para realizar la apuesta,
     * registra la apuesta realizada y el dinero restante del jugador en un archivo,
     * deshabilita las opciones de apuesta y establece las primeras cartas del juego.
     */
    @FXML
    void btn_enviarApuesta_click() {
        btn_enviarApuesta.setDisable(true);
        realiza_tu_apuesta.setVisible(false);
        mesa[2].escribirLineaEnArchivo("Apuesta realizada: " + apuestaCentral.getValorTotal() + " ----- " + "Dinero Sobrante: " + mesa[2].getDinero());
        deshabilitarApuestas();
        setPrimerasCartas();
    }



    /**
     * Este método se activa cuando se hace clic en el botón de pedir una carta.
     * Deshabilita el botón de doblar, añade una carta a la mano del jugador,
     * actualiza la visualización de la carta jugada en el centro, y actualiza la suma de puntos.
     * Si la suma de puntos del jugador supera 21, se activa el evento de plantarse automáticamente.
     */
    @FXML
    void btn_pedir_click() {
        btn_doblar.setDisable(true);
        mesa[2].setCarta();
        cartasJugadasCentro++;
        actualizarCartaCentro(cartasJugadasCentro);
        actualizarLabelSumaDeCartas();
        if (mesa[2].getSumaCartas() > 21) {
            btn_plantarse_click();
        }
    }



    /**
     * Este método actualiza la visualización de una carta jugada en el centro de la mesa.
     * Recibe un índice que indica qué carta debe mostrarse y establece la imagen correspondiente en la interfaz.
     * @param index El índice de la carta jugada en el centro de la mesa.
     */
    private void actualizarCartaCentro(int index) {
        switch (index) {
            case 3 -> carta_3_centro_jugador_3.setImage(mesa[2].getCarta(2).getImagen());
            case 4 -> carta_4_centro_jugador_3.setImage(mesa[2].getCarta(3).getImagen());
            case 5 -> carta_5_centro_jugador_3.setImage(mesa[2].getCarta(4).getImagen());
            case 6 -> carta_6_centro_jugador_3.setImage(mesa[2].getCarta(5).getImagen());
            case 7 -> carta_7_centro_jugador_3.setImage(mesa[2].getCarta(6).getImagen());
        }
    }



    /**
     * Este método se activa cuando se hace clic en el botón de plantarse.
     * Deshabilita los botones de juego, oculta el indicador de turno del jugador actual,
     * y activa el turno del siguiente jugador en la mesa o del dealer si todos los jugadores han terminado.
     */
    @FXML
    void btn_plantarse_click() {
        deshabilitarBotones();
        turno_jugador_3.setVisible(false);
        if (mesa[3].isDisponible()) {
            turnoJugador4();
        } else if (mesa[4].isDisponible()) {
            turnoJugador5();
        } else {
            turnoDealer();
        }
    }



    /**
     * Este método se activa cuando se hace clic en el botón de doblar la apuesta.
     * Deshabilita los botones de juego, duplica la apuesta central, añade una carta a la mano del jugador,
     * actualiza la visualización de la carta jugada en el centro, actualiza la suma de puntos,
     * y activa el evento de plantarse automáticamente.
     */
    @FXML
    void btn_doblar_click() {
        deshabilitarBotones();
        duplicarApuesta();
        mesa[2].setCarta();
        cartasJugadasCentro++;
        actualizarCartaCentro(cartasJugadasCentro);
        mesa[2].escribirLineaEnArchivo("Se ha doblado la apuesta. Apuesta: " + (apuestaCentral.getValorTotal() * 2) + " ----- " + "Dinero sobrante: " + mesa[2].getDinero());
        actualizarLabelSumaDeCartas();
        btn_plantarse_click();
    }



    /**
     * Este método duplica la apuesta central y muestra las fichas duplicadas en la parte izquierda de la mesa.
     * Se utiliza al hacer clic en el botón de doblar la apuesta.
     */
    private void duplicarApuesta() {
        for (int i = 0; i < 7; i++) {
            if (apuestaCentral.getFichas()[i] != null) {
                switch (i) {
                    case 0 -> ficha_1_apuesta_izquierda_jugador_3.setImage(ficha_1_apuesta_centro_jugador_3.getImage());
                    case 1 -> ficha_2_apuesta_izquierda_jugador_3.setImage(ficha_2_apuesta_centro_jugador_3.getImage());
                    case 2 -> ficha_3_apuesta_izquierda_jugador_3.setImage(ficha_3_apuesta_centro_jugador_3.getImage());
                    case 3 -> ficha_4_apuesta_izquierda_jugador_3.setImage(ficha_4_apuesta_centro_jugador_3.getImage());
                    case 4 -> ficha_5_apuesta_izquierda_jugador_3.setImage(ficha_5_apuesta_centro_jugador_3.getImage());
                    case 5 -> ficha_6_apuesta_izquierda_jugador_3.setImage(ficha_6_apuesta_centro_jugador_3.getImage());
                    case 6 -> ficha_7_apuesta_izquierda_jugador_3.setImage(ficha_7_apuesta_centro_jugador_3.getImage());
                }
            }
        }
        apuesta_izquierda_jugador_3.setVisible(true);
        apuesta_izquierda_jugador_3.setText(apuesta_centro_jugador_3.getText());
        fichasCentralIzquierda = fichasCentral;
        apuestaCentralIzquierda = apuestaCentral;
        mesa[2].setDinero(-apuestaCentral.getValorTotal());
        actualizarDinero();
    }



    /**
     * Este método reinicia la visualización de la interfaz de usuario del juego.
     * Establece las imágenes de las cartas, las sumas de puntos, las imágenes de las apuestas y las etiquetas de las apuestas a nulo o invisibles.
     * También oculta la visualización del turno y muestra el botón para realizar la apuesta.
     */
    void reiniciarVisuals() {
        for (ImageView carta : cartas) {
            carta.setImage(null);
        }

        for (Label suma : sumas) {
            suma.setVisible(false);
        }

        for (ImageView apuesta : apuestasImagenes) {
            apuesta.setImage(null);
        }

        for (Label apuesta : apuestasLabels) {
            apuesta.setVisible(false);
        }

        for (ImageView turno : turnos){
            turno.setVisible(false);
        }

        realiza_tu_apuesta.setVisible(true);
    }



    /**
     * Este método deshabilita las fichas de apuesta basado en el dinero disponible del jugador en la mesa.
     * Además, reduce la opacidad de las fichas si el jugador tiene menos dinero que el valor de la ficha.
     */
    void deshabilitarApuestas() {
        ficha_1.setDisable(true);
        ficha_1_grande.setDisable(true);
        ficha_5.setDisable(true);
        ficha_5_grande.setDisable(true);
        ficha_25.setDisable(true);
        ficha_25_grande.setDisable(true);
        ficha_50.setDisable(true);
        ficha_50_grande.setDisable(true);
        ficha_100.setDisable(true);
        ficha_100_grande.setDisable(true);
        if (mesa[2].getDinero() >= 1){
            ficha_1.setOpacity(0.5);
        }
        if (mesa[2].getDinero() >= 5){
            ficha_5.setOpacity(0.5);
        }
        if (mesa[2].getDinero() >= 25){
            ficha_25.setOpacity(0.5);
        }
        if (mesa[2].getDinero() >= 50){
            ficha_50.setOpacity(0.5);
        }
        if (mesa[2].getDinero() >= 100){
            ficha_100.setOpacity(0.5);
        }
    }



    /**
     * Este método habilita las fichas de apuesta basado en el dinero disponible del jugador en la mesa.
     * Ajusta la opacidad de las fichas para indicar si el jugador tiene suficiente dinero para realizar la apuesta.
     */
    void habilitarApuestas(){
        if (mesa[2].getDinero() >= 1){
            ficha_1.setDisable(false);
            ficha_1_grande.setDisable(false);
            ficha_1.setOpacity(1);
        }
        if (mesa[2].getDinero() >= 5){
             ficha_5.setDisable(false);
             ficha_5_grande.setDisable(false);
             ficha_5.setOpacity(1);
        }
         if (mesa[2].getDinero() >= 25){
             ficha_25.setDisable(false);
             ficha_25_grande.setDisable(false);
             ficha_25.setOpacity(1);
        }
         if (mesa[2].getDinero() >= 50){
             ficha_50.setDisable(false);
             ficha_50_grande.setDisable(false);
             ficha_50.setOpacity(1);
        }
         if (mesa[2].getDinero() >= 100){
             ficha_100.setDisable(false);
             ficha_100_grande.setDisable(false);
             ficha_100.setOpacity(1);
        }
    }



    /**
     * Este método deshabilita los botones de juego (doblar, enviar apuesta, pedir y plantarse).
     * Esto se realiza cuando no es el turno del jugador.
     */
    void deshabilitarBotones() {
        btn_doblar.setDisable(true);
        btn_enviarApuesta.setDisable(true);
        btn_pedir.setDisable(true);
        btn_plantarse.setDisable(true);
    }



    /**
     * Este método habilita los botones de juego (doblar, enviar apuesta, pedir y plantarse).
     * Esto se realiza cuando es el turno del jugador.
     */
    void habilitarBotones(){
        btn_doblar.setDisable(true);
        btn_enviarApuesta.setDisable(true);
        btn_pedir.setDisable(true);
        btn_plantarse.setDisable(true);
    }



    /**
     * Este método asigna los avatares de los jugadores a las ImageView correspondientes en la interfaz de usuario.
     * Recorre cada jugador y asigna su avatar a la ImageView correspondiente según su posición en la mesa.
     */
    void setJugadores() {
        for (Jugador jugador : mesa) {
            if (jugador.isDisponible()){
                    switch (jugador.getId()){
                        case 1 -> avatar_jugador_1.setImage(jugador.getAvatar());
                        case 2 -> avatar_jugador_2.setImage(jugador.getAvatar());
                        case 3 -> avatar_jugador_3.setImage(jugador.getAvatar());
                        case 4 -> avatar_jugador_4.setImage(jugador.getAvatar());
                        case 5 -> avatar_jugador_5.setImage(jugador.getAvatar());
                    }
            }
        }
    }



    /**
     * Este método establece las apuestas de los jugadores en la mesa.
     * Recorre cada jugador en la mesa y establece su apuesta si está disponible.
     * Utiliza la función `realizarApuesta()` para determinar la cantidad a apostar.
     * No hace nada si un jugador no está disponible.
     */
    void setApuestas() {
        for (Jugador jugador : mesa){
            if (jugador.getId() != 3 && jugador.isDisponible()){
                jugador.setApuesta(realizarApuesta(jugador.getId()));
                jugador.escribirLineaEnArchivo("Apuesta realizada: " + jugador.getApuesta().getValorTotal() + " ----- " + "Dinero Sobrante: " + jugador.getDinero());
            }else if (jugador.isDisponible() == false){
            }
        }
    }



    /**
     * Este método realiza una apuesta para un jugador específico.
     * Genera una apuesta aleatoria basada en el dinero disponible del jugador.
     * Utiliza un objeto `Random` para generar valores aleatorios y ajusta la cantidad de apuesta según el dinero restante del jugador.
     * Devuelve la apuesta realizada.
     */
    Apuesta realizarApuesta(int id) {
        Apuesta apuesta = new Apuesta();
        Ficha[] fichas = new Ficha[7];
        int apuestaTotal = 0;
        Random r = new Random();
        int fichasApostadas = 1;
        int y = 0;
        try{
            while(mesa[id-1].getDinero() > 0 && fichasApostadas < 8) {
                if (mesa[id-1].getDinero() >= 100){
                    y = 5;
                } else if (mesa[id-1].getDinero() >= 50){
                    y = 4;
                } else if (mesa[id-1].getDinero() >= 25){
                    y = 3;
                } else if (mesa[id-1].getDinero() >= 5){
                    y = 2;
                } else if (mesa[id-1].getDinero() >= 1){
                    y = 1;
                }
                switch (r.nextInt(y)){
                    case 0 -> {
                        ficha(id,fichasApostadas).setImage(new Image(new File("src/main/resources/Images/Fichas/1_lateral.png").toURI().toURL().toExternalForm()));
                        mesa[id-1].setDinero(-1);
                        fichas[fichasApostadas-1] = new Ficha(1);
                        apuestaTotal += 1;
                    }
                    case 1 -> {
                        ficha(id,fichasApostadas).setImage(new Image(new File("src/main/resources/Images/Fichas/5_lateral.png").toURI().toURL().toExternalForm()));
                        mesa[id-1].setDinero(-5);
                        fichas[fichasApostadas-1] = new Ficha(5);
                        apuestaTotal += 5;
                    }
                    case 2 -> {
                        ficha(id,fichasApostadas).setImage(new Image(new File("src/main/resources/Images/Fichas/25_lateral.png").toURI().toURL().toExternalForm()));
                        mesa[id-1].setDinero(-25);
                        fichas[fichasApostadas-1] = new Ficha(25);
                        apuestaTotal += 25;
                    }
                    case 3 -> {
                        ficha(id,fichasApostadas).setImage(new Image(new File("src/main/resources/Images/Fichas/50_lateral.png").toURI().toURL().toExternalForm()));
                        mesa[id-1].setDinero(-50);
                        fichas[fichasApostadas-1] = new Ficha(50);
                        apuestaTotal += 50;
                    }
                    case 4 -> {
                        ficha(id,fichasApostadas).setImage(new Image(new File("src/main/resources/Images/Fichas/100_lateral.png").toURI().toURL().toExternalForm()));
                        mesa[id-1].setDinero(-100);
                        fichas[fichasApostadas-1] = new Ficha(100);
                        apuestaTotal += 100;
                    }
                }
                apuesta.setFichas(fichas);
                actualizarDinero();
                fichasApostadas++;
                if (r.nextInt(100) == 27){
                    break;
                }
            }
        }catch (Exception e){}
        return apuesta;
    }



    /**
     * Este método actualiza la representación visual de las apuestas en la interfaz de usuario.
     * Recorre cada jugador y actualiza la cantidad de apuesta mostrada.
     */
    public void actualizarApuestas(){
        for (Jugador jugador : mesa){
            if (jugador.isDisponible()){
                switch (jugador.getId()){
                    case 1 -> {
                        for (int i = 0; i < jugador.getApuesta().getFichas().length; i++){
                            if(jugador.getApuesta().getFichas()[i] != null){
                                switch (i){
                                    case 0 -> {ficha_1_apuesta_centro_jugador_1.setImage(jugador.getApuesta().getFichas()[i].getImagen());}
                                    case 1 -> {ficha_2_apuesta_centro_jugador_1.setImage(jugador.getApuesta().getFichas()[i].getImagen());}
                                    case 2 -> {ficha_3_apuesta_centro_jugador_1.setImage(jugador.getApuesta().getFichas()[i].getImagen());}
                                    case 3 -> {ficha_4_apuesta_centro_jugador_1.setImage(jugador.getApuesta().getFichas()[i].getImagen());}
                                    case 4 -> {ficha_5_apuesta_centro_jugador_1.setImage(jugador.getApuesta().getFichas()[i].getImagen());}
                                    case 5 -> {ficha_6_apuesta_centro_jugador_1.setImage(jugador.getApuesta().getFichas()[i].getImagen());}
                                    case 6 -> {ficha_7_apuesta_centro_jugador_1.setImage(jugador.getApuesta().getFichas()[i].getImagen());}
                                }
                            }else {
                                switch (i){
                                    case 0 -> {ficha_1_apuesta_centro_jugador_1.setImage(null);}
                                    case 1 -> {ficha_2_apuesta_centro_jugador_1.setImage(null);}
                                    case 2 -> {ficha_3_apuesta_centro_jugador_1.setImage(null);}
                                    case 3 -> {ficha_4_apuesta_centro_jugador_1.setImage(null);}
                                    case 4 -> {ficha_5_apuesta_centro_jugador_1.setImage(null);}
                                    case 5 -> {ficha_6_apuesta_centro_jugador_1.setImage(null);}
                                    case 6 -> {ficha_7_apuesta_centro_jugador_1.setImage(null);}
                                }
                            }
                        }
                    }
                    case 2 -> {
                        for (int i = 0; i < jugador.getApuesta().getFichas().length; i++){
                            if(jugador.getApuesta().getFichas()[i] != null){
                                switch (i){
                                    case 0 -> {ficha_1_apuesta_centro_jugador_2.setImage(jugador.getApuesta().getFichas()[i].getImagen());}
                                    case 1 -> {ficha_2_apuesta_centro_jugador_2.setImage(jugador.getApuesta().getFichas()[i].getImagen());}
                                    case 2 -> {ficha_3_apuesta_centro_jugador_2.setImage(jugador.getApuesta().getFichas()[i].getImagen());}
                                    case 3 -> {ficha_4_apuesta_centro_jugador_2.setImage(jugador.getApuesta().getFichas()[i].getImagen());}
                                    case 4 -> {ficha_5_apuesta_centro_jugador_2.setImage(jugador.getApuesta().getFichas()[i].getImagen());}
                                    case 5 -> {ficha_6_apuesta_centro_jugador_2.setImage(jugador.getApuesta().getFichas()[i].getImagen());}
                                    case 6 -> {ficha_7_apuesta_centro_jugador_2.setImage(jugador.getApuesta().getFichas()[i].getImagen());}
                                }
                            }else {
                                switch (i){
                                    case 0 -> {ficha_1_apuesta_centro_jugador_2.setImage(null);}
                                    case 1 -> {ficha_2_apuesta_centro_jugador_2.setImage(null);}
                                    case 2 -> {ficha_3_apuesta_centro_jugador_2.setImage(null);}
                                    case 3 -> {ficha_4_apuesta_centro_jugador_2.setImage(null);}
                                    case 4 -> {ficha_5_apuesta_centro_jugador_2.setImage(null);}
                                    case 5 -> {ficha_6_apuesta_centro_jugador_2.setImage(null);}
                                    case 6 -> {ficha_7_apuesta_centro_jugador_2.setImage(null);}
                                }
                            }
                        }
                    }
                    case 3 -> {
                        for (int i = 0; i < apuestaCentral.getFichas().length; i++){
                            if(apuestaCentral.getFichas()[i] != null){
                                switch (i){
                                    case 0 -> {ficha_1_apuesta_centro_jugador_3.setImage(apuestaCentral.getFichas()[i].getImagen());}
                                    case 1 -> {ficha_2_apuesta_centro_jugador_3.setImage(apuestaCentral.getFichas()[i].getImagen());}
                                    case 2 -> {ficha_3_apuesta_centro_jugador_3.setImage(apuestaCentral.getFichas()[i].getImagen());}
                                    case 3 -> {ficha_4_apuesta_centro_jugador_3.setImage(apuestaCentral.getFichas()[i].getImagen());}
                                    case 4 -> {ficha_5_apuesta_centro_jugador_3.setImage(apuestaCentral.getFichas()[i].getImagen());}
                                    case 5 -> {ficha_6_apuesta_centro_jugador_3.setImage(apuestaCentral.getFichas()[i].getImagen());}
                                    case 6 -> {ficha_7_apuesta_centro_jugador_3.setImage(apuestaCentral.getFichas()[i].getImagen());}
                                }
                            }else {
                                switch (i){
                                    case 0 -> {ficha_1_apuesta_centro_jugador_3.setImage(null);}
                                    case 1 -> {ficha_2_apuesta_centro_jugador_3.setImage(null);}
                                    case 2 -> {ficha_3_apuesta_centro_jugador_3.setImage(null);}
                                    case 3 -> {ficha_4_apuesta_centro_jugador_3.setImage(null);}
                                    case 4 -> {ficha_5_apuesta_centro_jugador_3.setImage(null);}
                                    case 5 -> {ficha_6_apuesta_centro_jugador_3.setImage(null);}
                                    case 6 -> {ficha_7_apuesta_centro_jugador_3.setImage(null);}
                                }
                            }
                        }
                    }
                    case 4 -> {
                        for (int i = 0; i < jugador.getApuesta().getFichas().length; i++){
                            if(jugador.getApuesta().getFichas()[i] != null){
                                switch (i){
                                    case 0 -> {ficha_1_apuesta_centro_jugador_4.setImage(jugador.getApuesta().getFichas()[i].getImagen());}
                                    case 1 -> {ficha_2_apuesta_centro_jugador_4.setImage(jugador.getApuesta().getFichas()[i].getImagen());}
                                    case 2 -> {ficha_3_apuesta_centro_jugador_4.setImage(jugador.getApuesta().getFichas()[i].getImagen());}
                                    case 3 -> {ficha_4_apuesta_centro_jugador_4.setImage(jugador.getApuesta().getFichas()[i].getImagen());}
                                    case 4 -> {ficha_5_apuesta_centro_jugador_4.setImage(jugador.getApuesta().getFichas()[i].getImagen());}
                                    case 5 -> {ficha_6_apuesta_centro_jugador_4.setImage(jugador.getApuesta().getFichas()[i].getImagen());}
                                    case 6 -> {ficha_7_apuesta_centro_jugador_4.setImage(jugador.getApuesta().getFichas()[i].getImagen());}
                                }
                            }else {
                                switch (i){
                                    case 0 -> {ficha_1_apuesta_centro_jugador_4.setImage(null);}
                                    case 1 -> {ficha_2_apuesta_centro_jugador_4.setImage(null);}
                                    case 2 -> {ficha_3_apuesta_centro_jugador_4.setImage(null);}
                                    case 3 -> {ficha_4_apuesta_centro_jugador_4.setImage(null);}
                                    case 4 -> {ficha_5_apuesta_centro_jugador_4.setImage(null);}
                                    case 5 -> {ficha_6_apuesta_centro_jugador_4.setImage(null);}
                                    case 6 -> {ficha_7_apuesta_centro_jugador_4.setImage(null);}
                                }
                            }
                        }
                    }
                    case 5 -> {
                        for (int i = 0; i < jugador.getApuesta().getFichas().length; i++){
                            if(jugador.getApuesta().getFichas()[i] != null){
                                switch (i){
                                    case 0 -> {ficha_1_apuesta_centro_jugador_5.setImage(jugador.getApuesta().getFichas()[i].getImagen());}
                                    case 1 -> {ficha_2_apuesta_centro_jugador_5.setImage(jugador.getApuesta().getFichas()[i].getImagen());}
                                    case 2 -> {ficha_3_apuesta_centro_jugador_5.setImage(jugador.getApuesta().getFichas()[i].getImagen());}
                                    case 3 -> {ficha_4_apuesta_centro_jugador_5.setImage(jugador.getApuesta().getFichas()[i].getImagen());}
                                    case 4 -> {ficha_5_apuesta_centro_jugador_5.setImage(jugador.getApuesta().getFichas()[i].getImagen());}
                                    case 5 -> {ficha_6_apuesta_centro_jugador_5.setImage(jugador.getApuesta().getFichas()[i].getImagen());}
                                    case 6 -> {ficha_7_apuesta_centro_jugador_5.setImage(jugador.getApuesta().getFichas()[i].getImagen());}
                                }
                            }else {
                                switch (i){
                                    case 0 -> {ficha_1_apuesta_centro_jugador_5.setImage(null);}
                                    case 1 -> {ficha_2_apuesta_centro_jugador_5.setImage(null);}
                                    case 2 -> {ficha_3_apuesta_centro_jugador_5.setImage(null);}
                                    case 3 -> {ficha_4_apuesta_centro_jugador_5.setImage(null);}
                                    case 4 -> {ficha_5_apuesta_centro_jugador_5.setImage(null);}
                                    case 5 -> {ficha_6_apuesta_centro_jugador_5.setImage(null);}
                                    case 6 -> {ficha_7_apuesta_centro_jugador_5.setImage(null);}
                                }
                            }
                        }
                    }
                }
            }else {
                for (int i = 0; i < 7; i++){
                    switch (i){
                        case 0 -> {
                            switch (jugador.getId()){
                                case 1 -> {ficha_1_apuesta_centro_jugador_1.setImage(null);}
                                case 2 -> {ficha_1_apuesta_centro_jugador_2.setImage(null);}
                                case 3 -> {ficha_1_apuesta_centro_jugador_3.setImage(null);}
                                case 4 -> {ficha_1_apuesta_centro_jugador_4.setImage(null);}
                                case 5 -> {ficha_1_apuesta_centro_jugador_5.setImage(null);}
                            }
                        }
                        case 1 -> {
                            switch (jugador.getId()){
                                case 1 -> {ficha_2_apuesta_centro_jugador_1.setImage(null);}
                                case 2 -> {ficha_2_apuesta_centro_jugador_2.setImage(null);}
                                case 3 -> {ficha_2_apuesta_centro_jugador_3.setImage(null);}
                                case 4 -> {ficha_2_apuesta_centro_jugador_4.setImage(null);}
                                case 5 -> {ficha_2_apuesta_centro_jugador_5.setImage(null);}
                            }
                        }
                        case 2 -> {
                            switch (jugador.getId()){
                                case 1 -> {ficha_3_apuesta_centro_jugador_1.setImage(null);}
                                case 2 -> {ficha_3_apuesta_centro_jugador_2.setImage(null);}
                                case 3 -> {ficha_3_apuesta_centro_jugador_3.setImage(null);}
                                case 4 -> {ficha_3_apuesta_centro_jugador_4.setImage(null);}
                                case 5 -> {ficha_3_apuesta_centro_jugador_5.setImage(null);}
                            }
                        }
                        case 3 -> {
                            switch (jugador.getId()){
                                case 1 -> {ficha_4_apuesta_centro_jugador_1.setImage(null);}
                                case 2 -> {ficha_4_apuesta_centro_jugador_2.setImage(null);}
                                case 3 -> {ficha_4_apuesta_centro_jugador_3.setImage(null);}
                                case 4 -> {ficha_4_apuesta_centro_jugador_4.setImage(null);}
                                case 5 -> {ficha_4_apuesta_centro_jugador_5.setImage(null);}
                            }
                        }
                        case 4 -> {
                            switch (jugador.getId()){
                                case 1 -> {ficha_5_apuesta_centro_jugador_1.setImage(null);}
                                case 2 -> {ficha_5_apuesta_centro_jugador_2.setImage(null);}
                                case 3 -> {ficha_5_apuesta_centro_jugador_3.setImage(null);}
                                case 4 -> {ficha_5_apuesta_centro_jugador_4.setImage(null);}
                                case 5 -> {ficha_5_apuesta_centro_jugador_5.setImage(null);}
                            }
                        }
                        case 5 -> {
                            switch (jugador.getId()){
                                case 1 -> {ficha_6_apuesta_centro_jugador_1.setImage(null);}
                                case 2 -> {ficha_6_apuesta_centro_jugador_2.setImage(null);}
                                case 3 -> {ficha_6_apuesta_centro_jugador_3.setImage(null);}
                                case 4 -> {ficha_6_apuesta_centro_jugador_4.setImage(null);}
                                case 5 -> {ficha_6_apuesta_centro_jugador_5.setImage(null);}
                            }
                        }
                        case 6 -> {
                            switch (jugador.getId()){
                                case 1 -> {ficha_7_apuesta_centro_jugador_1.setImage(null);}
                                case 2 -> {ficha_7_apuesta_centro_jugador_2.setImage(null);}
                                case 3 -> {ficha_7_apuesta_centro_jugador_3.setImage(null);}
                                case 4 -> {ficha_7_apuesta_centro_jugador_4.setImage(null);}
                                case 5 -> {ficha_7_apuesta_centro_jugador_5.setImage(null);}
                            }
                        }
                    }
                }
            }
        }
        for (Jugador jugador : mesa){
            if (jugador.isDisponible()){
                switch (jugador.getId()){
                    case 1 -> {
                        apuesta_centro_jugador_1.setText(String.valueOf(jugador.getApuesta().getValorTotal()));
                        apuesta_centro_jugador_1.setVisible(true);
                    }
                    case 2 -> {
                        apuesta_centro_jugador_2.setText(String.valueOf(jugador.getApuesta().getValorTotal()));
                        apuesta_centro_jugador_2.setVisible(true);
                    }
                    case 3 -> {
                        apuesta_centro_jugador_3.setText(String.valueOf(apuestaCentral.getValorTotal()));
                        apuesta_centro_jugador_3.setVisible(true);
                    }
                    case 4 -> {
                        apuesta_centro_jugador_4.setText(String.valueOf(jugador.getApuesta().getValorTotal()));
                        apuesta_centro_jugador_4.setVisible(true);
                    }
                    case 5 -> {
                        apuesta_centro_jugador_5.setText(String.valueOf(jugador.getApuesta().getValorTotal()));
                        apuesta_centro_jugador_5.setVisible(true);
                    }
                }
            }else {
                switch (jugador.getId()){
                    case 1 -> {apuesta_centro_jugador_1.setVisible(false);}
                    case 2 -> {apuesta_centro_jugador_2.setVisible(false);}
                    case 3 -> {apuesta_centro_jugador_3.setVisible(false);}
                    case 4 -> {apuesta_centro_jugador_4.setVisible(false);}
                    case 5 -> {apuesta_centro_jugador_5.setVisible(false);}
                }
            }
        }
    }



    /**
     * Este método calcula y actualiza el valor total de las cartas para cada jugador y el crupier.
     * Recorre cada jugador y actualiza el valor total de sus cartas que se muestra.
     */
    void actualizarLabelSumaDeCartas() {
        for (Jugador jugador : mesa) {
            if (jugador.isDisponible()) {
                switch (jugador.getId()) {
                    case 1 -> {
                        int total = 0;
                        for (int i = 0; i<cartasJugador1.length;i++){
                            if (cartasJugador1[i].getImage() != null){
                                total += mesa[0].getCarta(i).getValor();
                            }else{
                                break;
                            }
                        }
                        suma_de_cartas_jugador_1_centro.setText(String.valueOf(total));
                        suma_de_cartas_jugador_1_centro.setVisible(true);
                    }
                    case 2 -> {
                        int total = 0;
                        for (int i = 0; i<cartasJugador2.length;i++){
                            if (cartasJugador2[i].getImage() != null){
                                total += mesa[1].getCarta(i).getValor();
                            }else{
                                break;
                            }
                        }
                        suma_de_cartas_jugador_2_centro.setText(String.valueOf(total));
                        suma_de_cartas_jugador_2_centro.setVisible(true);
                    }
                    case 3 -> {
                        int total = 0;
                        for (int i = 0; i<cartasJugador3.length;i++){
                            if (cartasJugador3[i].getImage() != null){
                                total += mesa[2].getCarta(i).getValor();
                            }else{
                                break;
                            }
                        }
                        suma_de_cartas_jugador_3_centro.setText(String.valueOf(total));
                        suma_de_cartas_jugador_3_centro.setVisible(true);
                    }
                    case 4 -> {
                        int total = 0;
                        for (int i = 0; i<cartasJugador4.length;i++){
                            if (cartasJugador4[i].getImage() != null){
                                total += mesa[3].getCarta(i).getValor();
                            }else{
                                break;
                            }
                        }
                        suma_de_cartas_jugador_4_centro.setText(String.valueOf(total));
                        suma_de_cartas_jugador_4_centro.setVisible(true);
                    }
                    case 5 -> {
                        int total = 0;
                        for (int i = 0; i<cartasJugador5.length;i++){
                            if (cartasJugador5[i].getImage() != null){
                                total += mesa[4].getCarta(i).getValor();
                            }else{
                                break;
                            }
                        }
                        suma_de_cartas_jugador_5_centro.setText(String.valueOf(total));
                        suma_de_cartas_jugador_5_centro.setVisible(true);
                    }
                }
            }else{
                switch (jugador.getId()){
                    case 1 -> {suma_de_cartas_jugador_1_centro.setVisible(false);}
                    case 2 -> {suma_de_cartas_jugador_2_centro.setVisible(false);}
                    case 3 -> {suma_de_cartas_jugador_3_centro.setVisible(false);}
                    case 4 -> {suma_de_cartas_jugador_4_centro.setVisible(false);}
                    case 5 -> {suma_de_cartas_jugador_5_centro.setVisible(false);}
                }
            }
        }
        int total = 0;
        for (int i = 0; i<cartasDealer.length;i++){
            if (cartasDealer[i].getImage() != null){
                total += dealer.getCarta(i).getValor();
            }else{
                break;
            }
        }
        suma_de_cartas_dealer.setText(String.valueOf(total));
        suma_de_cartas_dealer.setVisible(true);

    }



    /**
     * Este método obtiene la ImageView asociada con la apuesta de un jugador en una posición específica.
     * Devuelve la ImageView asociada con la apuesta del jugador en la posición especificada.
     */
    ImageView ficha(int id, int valor){
        ImageView x = null;
        switch (id){
            case 1 -> {switch (valor){
                    case 1 -> {x = ficha_1_apuesta_centro_jugador_1;}
                    case 2 -> {x = ficha_2_apuesta_centro_jugador_1;}
                    case 3 -> {x = ficha_3_apuesta_centro_jugador_1;}
                    case 4 -> {x = ficha_4_apuesta_centro_jugador_1;}
                    case 5 -> {x = ficha_5_apuesta_centro_jugador_1;}
                    case 6 -> {x = ficha_6_apuesta_centro_jugador_1;}
                    case 7 -> {x = ficha_7_apuesta_centro_jugador_1;}

                }
            }
            case 2 -> {switch (valor){
                    case 1 -> {x = ficha_1_apuesta_centro_jugador_2;}
                    case 2 -> {x = ficha_2_apuesta_centro_jugador_2;}
                    case 3 -> {x = ficha_3_apuesta_centro_jugador_2;}
                    case 4 -> {x = ficha_4_apuesta_centro_jugador_2;}
                    case 5 -> {x = ficha_5_apuesta_centro_jugador_2;}
                    case 6 -> {x = ficha_6_apuesta_centro_jugador_2;}
                    case 7 -> {x = ficha_7_apuesta_centro_jugador_2;}
                }
            }
            case 3 -> {switch (valor){
                    case 1 -> {x = ficha_1_apuesta_centro_jugador_3;}
                    case 2 -> {x = ficha_2_apuesta_centro_jugador_3;}
                    case 3 -> {x = ficha_3_apuesta_centro_jugador_3;}
                    case 4 -> {x = ficha_4_apuesta_centro_jugador_3;}
                    case 5 -> {x = ficha_5_apuesta_centro_jugador_3;}
                    case 6 -> {x = ficha_6_apuesta_centro_jugador_3;}
                    case 7 -> {x = ficha_7_apuesta_centro_jugador_3;}
                }
            }
            case 4 -> {switch (valor){
                    case 1 -> {x = ficha_1_apuesta_centro_jugador_4;}
                    case 2 -> {x = ficha_2_apuesta_centro_jugador_4;}
                    case 3 -> {x = ficha_3_apuesta_centro_jugador_4;}
                    case 4 -> {x = ficha_4_apuesta_centro_jugador_4;}
                    case 5 -> {x = ficha_5_apuesta_centro_jugador_4;}
                    case 6 -> {x = ficha_6_apuesta_centro_jugador_4;}
                    case 7 -> {x = ficha_7_apuesta_centro_jugador_4;}
                }
            }
            case 5 -> {switch (valor){
                case 1 -> {x =  ficha_1_apuesta_centro_jugador_5;}
                case 2 -> {x = ficha_2_apuesta_centro_jugador_5;}
                case 3 -> {x = ficha_3_apuesta_centro_jugador_5;}
                case 4 -> {x = ficha_4_apuesta_centro_jugador_5;}
                case 5 -> {x = ficha_5_apuesta_centro_jugador_5;}
                case 6 -> {x = ficha_6_apuesta_centro_jugador_5;}
                case 7 -> {x = ficha_7_apuesta_centro_jugador_5;}
            }}
        }
        return x;
    }



    /**
     * Actualiza la visualización del dinero de los jugadores en la mesa.
     * Si un jugador está disponible, muestra su cantidad de dinero actual;
     * de lo contrario, oculta la visualización de fichas.
     */
    void actualizarDinero(){
        if (mesa[0].isDisponible() == true){
            fichas_jugador_1.setText(String.valueOf(mesa[0].getDinero()));
        }else {
            fichas_jugador_1.setVisible(false);
        }
        if (mesa[1].isDisponible() == true){
            fichas_jugador_2.setText(String.valueOf(mesa[1].getDinero()));
        }else {
            fichas_jugador_2.setVisible(false);
        }
        if (mesa[2].getDinero() < 1){
            ficha_1.setDisable(true);
            ficha_1_grande.setDisable(true);
            ficha_1.setOpacity(0);
            ficha_5.setDisable(true);
            ficha_5_grande.setDisable(true);
            ficha_5.setOpacity(0);
            ficha_25.setDisable(true);
            ficha_25_grande.setDisable(true);
            ficha_25.setOpacity(0);
            ficha_50.setDisable(true);
            ficha_50_grande.setDisable(true);
            ficha_50.setOpacity(0);
            ficha_100.setDisable(true);
            ficha_100_grande.setDisable(true);
            ficha_100.setOpacity(0);
            fichas_jugador_3.setText(String.valueOf(mesa[2].getDinero()));
        }else if (mesa[2].getDinero() < 5){
            ficha_5.setDisable(true);
            ficha_5_grande.setDisable(true);
            ficha_5.setOpacity(0);
            ficha_25.setDisable(true);
            ficha_25_grande.setDisable(true);
            ficha_25.setOpacity(0);
            ficha_50.setDisable(true);
            ficha_50_grande.setDisable(true);
            ficha_50.setOpacity(0);
            ficha_100.setDisable(true);
            ficha_100_grande.setDisable(true);
            ficha_100.setOpacity(0);
            fichas_jugador_3.setText(String.valueOf(mesa[2].getDinero()));
        }else if(mesa[2].getDinero() < 25){
            ficha_25.setDisable(true);
            ficha_25_grande.setDisable(true);
            ficha_25.setOpacity(0);
            ficha_50.setDisable(true);
            ficha_50_grande.setDisable(true);
            ficha_50.setOpacity(0);
            ficha_100.setDisable(true);
            ficha_100_grande.setDisable(true);
            ficha_100.setOpacity(0);
            fichas_jugador_3.setText(String.valueOf(mesa[2].getDinero()));
        }else if(mesa[2].getDinero() < 50){
            ficha_50.setDisable(true);
            ficha_50_grande.setDisable(true);
            ficha_50.setOpacity(0);
            ficha_100.setDisable(true);
            ficha_100_grande.setDisable(true);
            ficha_100.setOpacity(0);
            fichas_jugador_3.setText(String.valueOf(mesa[2].getDinero()));
        }else if(mesa[2].getDinero() < 100){
            ficha_100.setDisable(true);
            ficha_100_grande.setDisable(true);
            ficha_100.setOpacity(0);
            fichas_jugador_3.setText(String.valueOf(mesa[2].getDinero()));
        }else {
            fichas_jugador_3.setText(String.valueOf(mesa[2].getDinero()));
        }
        if (mesa[3].isDisponible() != false){
            fichas_jugador_4.setText(String.valueOf(mesa[3].getDinero()));
        }else{
            fichas_jugador_4.setVisible(false);
        }
        if (mesa[4].isDisponible() != false){
            fichas_jugador_5.setText(String.valueOf(mesa[4].getDinero()));
        }else {
            fichas_jugador_5.setVisible(false);
        }
    }



    /**
     * Actualiza los avatares de los jugadores en la mesa.
     * Si un jugador está disponible, muestra su avatar;
     * de lo contrario, muestra un avatar vacío.
     */
    void actualizarAvatar() {
        for (int i = 0; i < 5; i++){
            if (!mesa[i].isDisponible()){
                try {
                    switch (i){
                        case 0 -> {avatar_jugador_1.setImage(new Image(new File("src/main/resources/Images/Avatares/vacio.png").toURI().toURL().toExternalForm()));}
                        case 1 -> {avatar_jugador_2.setImage(new Image(new File("src/main/resources/Images/Avatares/vacio.png").toURI().toURL().toExternalForm()));}
                        case 2 -> {avatar_jugador_3.setImage(new Image(new File("src/main/resources/Images/Avatares/vacio.png").toURI().toURL().toExternalForm()));}
                        case 3 -> {avatar_jugador_4.setImage(new Image(new File("src/main/resources/Images/Avatares/vacio.png").toURI().toURL().toExternalForm()));}
                        case 4 -> {avatar_jugador_5.setImage(new Image(new File("src/main/resources/Images/Avatares/vacio.png").toURI().toURL().toExternalForm()));}
                    }
                }catch (Exception e){}

            }else {
                switch (i){
                    case 0 -> {avatar_jugador_1.setImage(mesa[i].getAvatar());}
                    case 1 -> {avatar_jugador_2.setImage(mesa[i].getAvatar());}
                    case 2 -> {avatar_jugador_3.setImage(mesa[i].getAvatar());}
                    case 3 -> {avatar_jugador_4.setImage(mesa[i].getAvatar());}
                    case 4 -> {avatar_jugador_5.setImage(mesa[i].getAvatar());}
                }
            }
        }
    }



    /**
     * Reparte las primeras cartas a los jugadores y al crupier.
     * Después de repartir las cartas, comienza el turno del primer jugador disponible.
     */
    public void setPrimerasCartas() {
        List<Runnable> tasks = new ArrayList<>();
        for (int carta = 1; carta <= 2; carta++) {
            for (Jugador jugador : mesa) {
                if (jugador.isDisponible()) {
                    int finalCarta = carta;
                    tasks.add(() -> {
                        jugador.setCarta();
                        actualizarImagenCarta(jugador, finalCarta);
                        actualizarLabelSumaDeCartas();
                    });
                }
            }
            int finalCarta1 = carta;
            tasks.add(() -> {
                dealer.setCarta();
                actualizarImagenCartaDealer(finalCarta1);
                actualizarLabelSumaDeCartas();
            });
        }
        ejecutarTareasConPausa(tasks, 1000, () -> {
            if (mesa[0].isDisponible()){
                turnoJugador1();
            }else if (mesa[1].isDisponible()){
                turnoJugador2();
            }else{
                if (mesa[2].getSumaCartas() >= 21){
                    btn_plantarse_click();
                }else{
                    turno_jugador_3.setVisible(true);
                    btn_pedir.setDisable(false);
                    btn_plantarse.setDisable(false);
                    if (apuestaCentral.getValorTotal() > mesa[2].getDinero()){
                        btn_doblar.setDisable(true);
                    }else {
                        btn_doblar.setDisable(false);
                    }
                }
            }
        });
    }



    /**
     * Realiza el turno del jugador 1, mostrando las cartas y actualizando la suma de cartas.
     * Después de que el jugador 1 complete su turno, determina si es el turno del jugador 2,
     * si el jugador 2 ya ha jugado, o si es el turno del crupier.
     */
    private void turnoJugador1() {
        turno_jugador_1.setVisible(true);
        Timeline timeline = new Timeline();
        int cartasJugadas = 2;
        while (mesa[0].getSumaCartas() <= 15) {
            mesa[0].setCarta();
            cartasJugadas++;
            int finalCartasJugadas = cartasJugadas;
            timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(2), event -> {
                switch (finalCartasJugadas) {
                    case 3 -> carta_3_centro_jugador_1.setImage(mesa[0].getCarta(2).getImagen());
                    case 4 -> carta_4_centro_jugador_1.setImage(mesa[0].getCarta(3).getImagen());
                    case 5 -> carta_5_centro_jugador_1.setImage(mesa[0].getCarta(4).getImagen());
                    case 6 -> carta_6_centro_jugador_1.setImage(mesa[0].getCarta(5).getImagen());
                    case 7 -> carta_7_centro_jugador_1.setImage(mesa[0].getCarta(6).getImagen());
                }
                actualizarLabelSumaDeCartas();
            }));
        }

        timeline.setOnFinished(event -> {
            turno_jugador_1.setVisible(false);
            if (mesa[1].isDisponible()) {
                turnoJugador2();
            } else {
                if (mesa[2].getSumaCartas() >= 21) {
                    btn_plantarse_click();
                } else {
                    turno_jugador_3.setVisible(true);
                    btn_pedir.setDisable(false);
                    btn_plantarse.setDisable(false);
                    if (apuestaCentral.getValorTotal() > mesa[2].getDinero()) {
                        btn_doblar.setDisable(true);
                    } else {
                        btn_doblar.setDisable(false);
                    }
                }
            }
        });

        timeline.play();
    }



    /**
     * Realiza el turno del jugador 2, mostrando las cartas y actualizando la suma de cartas.
     * Después de que el jugador 2 complete su turno, determina si es el turno del crupier.
     */
    private void turnoJugador2() {
        turno_jugador_2.setVisible(true);
        Timeline timeline = new Timeline();
        int cartasJugadas = 2;
        while (mesa[1].getSumaCartas() <= 15) {
            mesa[1].setCarta();
            cartasJugadas++;
            int finalCartasJugadas = cartasJugadas;
            timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(finalCartasJugadas - 1), event -> {
                switch (finalCartasJugadas) {
                    case 3 -> carta_3_centro_jugador_2.setImage(mesa[1].getCarta(2).getImagen());
                    case 4 -> carta_4_centro_jugador_2.setImage(mesa[1].getCarta(3).getImagen());
                    case 5 -> carta_5_centro_jugador_2.setImage(mesa[1].getCarta(4).getImagen());
                    case 6 -> carta_6_centro_jugador_2.setImage(mesa[1].getCarta(5).getImagen());
                    case 7 -> carta_7_centro_jugador_2.setImage(mesa[1].getCarta(6).getImagen());
                }
                actualizarLabelSumaDeCartas();
            }));
        }

        timeline.setOnFinished(event -> {
            turno_jugador_2.setVisible(false);
            if (mesa[2].getSumaCartas() >= 21) {
                btn_plantarse_click();
            } else {
                turno_jugador_3.setVisible(true);
                btn_pedir.setDisable(false);
                btn_plantarse.setDisable(false);
                if (apuestaCentral.getValorTotal() > mesa[2].getDinero()) {
                    btn_doblar.setDisable(true);
                } else {
                    btn_doblar.setDisable(false);
                }
            }
        });

        timeline.play();
    }



    /**
     * Realiza el turno del jugador 4, mostrando las cartas y actualizando la suma de cartas.
     * Después de que el jugador 4 complete su turno, determina si es el turno del jugador 5
     * o si es el turno del crupier.
     */
    private void turnoJugador4() {
        turno_jugador_4.setVisible(true);
        Timeline timeline = new Timeline();
        int cartasJugadas = 2;
        while (mesa[3].getSumaCartas() <= 15) {
            mesa[3].setCarta();
            cartasJugadas++;
            int finalCartasJugadas = cartasJugadas;
            timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(2), event -> {
                switch (finalCartasJugadas) {
                    case 3 -> carta_3_centro_jugador_4.setImage(mesa[3].getCarta(2).getImagen());
                    case 4 -> carta_4_centro_jugador_4.setImage(mesa[3].getCarta(3).getImagen());
                    case 5 -> carta_5_centro_jugador_4.setImage(mesa[3].getCarta(4).getImagen());
                    case 6 -> carta_6_centro_jugador_4.setImage(mesa[3].getCarta(5).getImagen());
                    case 7 -> carta_7_centro_jugador_4.setImage(mesa[3].getCarta(6).getImagen());
                }
                actualizarLabelSumaDeCartas();
            }));
        }
        timeline.setOnFinished(event -> {
            turno_jugador_4.setVisible(false);
            if (mesa[4].isDisponible()){
                turnoJugador5();
            }else{
                turnoDealer();
            }
        });
        timeline.play();
    }



    /**
     * Realiza el turno del jugador 5, mostrando las cartas y actualizando la suma de cartas.
     * Después de que el jugador 5 complete su turno, es el turno del crupier.
     */
    private void turnoJugador5() {
        turno_jugador_5.setVisible(true);
        Timeline timeline = new Timeline();
        int cartasJugadas = 2;
        while (mesa[4].getSumaCartas() <= 15) {
            mesa[4].setCarta();
            cartasJugadas++;
            int finalCartasJugadas = cartasJugadas;
            timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(2), event -> {
                switch (finalCartasJugadas) {
                    case 3 -> carta_3_centro_jugador_5.setImage(mesa[4].getCarta(2).getImagen());
                    case 4 -> carta_4_centro_jugador_5.setImage(mesa[4].getCarta(3).getImagen());
                    case 5 -> carta_5_centro_jugador_5.setImage(mesa[4].getCarta(4).getImagen());
                    case 6 -> carta_6_centro_jugador_5.setImage(mesa[4].getCarta(5).getImagen());
                    case 7 -> carta_7_centro_jugador_5.setImage(mesa[4].getCarta(6).getImagen());
                }
                actualizarLabelSumaDeCartas();
            }));
        }
        timeline.setOnFinished(event -> {
            turno_jugador_5.setVisible(false);
            turnoDealer();
        });
        timeline.play();
    }



    /**
     * Realiza el turno del crupier, mostrando las cartas y actualizando la suma de cartas.
     * Después de que el crupier complete su turno, se reparte el dinero, se actualiza el dinero
     * de los jugadores, se reinician las visualizaciones y se configuran las apuestas.
     */
    private void turnoDealer() {
        turno_dealer.setVisible(true);
        Timeline timeline = new Timeline();
        int cartasJugadas = 2;
        while (dealer.getSumaCartas() < 17) {
            dealer.setCarta();
            cartasJugadas++;
            int finalCartasJugadas = cartasJugadas;
            timeline.getKeyFrames().add(new KeyFrame(Duration.seconds((finalCartasJugadas - 2) * 2), event -> {
                switch (finalCartasJugadas) {
                    case 3 -> actualizarImagenCartaDealer(2);
                    case 4 -> actualizarImagenCartaDealer(3);
                    case 5 -> actualizarImagenCartaDealer(4);
                    case 6 -> actualizarImagenCartaDealer(5);
                    case 7 -> actualizarImagenCartaDealer(6);
                    case 8 -> actualizarImagenCartaDealer(7);
                    case 9 -> actualizarImagenCartaDealer(8);
                }
                actualizarLabelSumaDeCartas();
            }));
        }
        int finalDelay = (cartasJugadas - 2) * 2 + 2;
        timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(finalDelay), event -> {}));
        timeline.setOnFinished(event -> {
            turno_dealer.setVisible(false);
            repartirDinero();
            actualizarDinero();
            repasarJugadores();
            addJugadorRandom();
            reiniciarVisuals();
            almacenarDinero();
            setApuestas();
            actualizarApuestas();
            habilitarApuestas();
        });
        timeline.play();
    }



    /**
     * Actualiza la imagen de una carta para un jugador específico en la interfaz gráfica.
     * @param jugador El jugador al que se le actualiza la carta.
     * @param carta El número de la carta que se va a actualizar.
     */
    private void actualizarImagenCarta(Jugador jugador, int carta) {
        ImageView imageView = null;
        int cartaIndex = carta - 1;
        switch (carta) {
            case 1 -> {
                switch (jugador.getId()) {
                    case 1 -> imageView = carta_1_centro_jugador_1;
                    case 2 -> imageView = carta_1_centro_jugador_2;
                    case 3 -> imageView = carta_1_centro_jugador_3;
                    case 4 -> imageView = carta_1_centro_jugador_4;
                    case 5 -> imageView = carta_1_centro_jugador_5;
                }
            }
            case 2 -> {
                switch (jugador.getId()) {
                    case 1 -> imageView = carta_2_centro_jugador_1;
                    case 2 -> imageView = carta_2_centro_jugador_2;
                    case 3 -> imageView = carta_2_centro_jugador_3;
                    case 4 -> imageView = carta_2_centro_jugador_4;
                    case 5 -> imageView = carta_2_centro_jugador_5;
                }
            }
            case 3 -> {
                switch (jugador.getId()) {
                    case 1 -> imageView = carta_3_centro_jugador_1;
                    case 2 -> imageView = carta_3_centro_jugador_2;
                    case 3 -> imageView = carta_3_centro_jugador_3;
                    case 4 -> imageView = carta_3_centro_jugador_4;
                    case 5 -> imageView = carta_3_centro_jugador_5;
                }
            }
            case 4 -> {
                switch (jugador.getId()) {
                    case 1 -> imageView = carta_4_centro_jugador_1;
                    case 2 -> imageView = carta_4_centro_jugador_2;
                    case 3 -> imageView = carta_4_centro_jugador_3;
                    case 4 -> imageView = carta_4_centro_jugador_4;
                    case 5 -> imageView = carta_4_centro_jugador_5;
                }
            }
            case 5 -> {
                switch (jugador.getId()) {
                    case 1 -> imageView = carta_5_centro_jugador_1;
                    case 2 -> imageView = carta_5_centro_jugador_2;
                    case 3 -> imageView = carta_5_centro_jugador_3;
                    case 4 -> imageView = carta_5_centro_jugador_4;
                    case 5 -> imageView = carta_5_centro_jugador_5;
                }
            }
            case 6 -> {
                switch (jugador.getId()) {
                    case 1 -> imageView = carta_6_centro_jugador_1;
                    case 2 -> imageView = carta_6_centro_jugador_2;
                    case 3 -> imageView = carta_6_centro_jugador_3;
                    case 4 -> imageView = carta_6_centro_jugador_4;
                    case 5 -> imageView = carta_6_centro_jugador_5;
                }
            }
            case 7 -> {
                switch (jugador.getId()) {
                    case 1 -> imageView = carta_7_centro_jugador_1;
                    case 2 -> imageView = carta_7_centro_jugador_2;
                    case 3 -> imageView = carta_7_centro_jugador_3;
                    case 4 -> imageView = carta_7_centro_jugador_4;
                    case 5 -> imageView = carta_7_centro_jugador_5;
                }
            }
        }

        if (imageView != null) {
            imageView.setImage(jugador.getCarta(cartaIndex).getImagen());
        }
    }



    /**
     * Actualiza la imagen de una carta para el dealer en la interfaz gráfica.
     * @param carta El número de la carta que se va a actualizar.
     */
    private void actualizarImagenCartaDealer(int carta){
        ImageView imageview = null;
        int cartaIndex = carta - 1;
        switch(carta){
            case 1 -> {imageview = carta_dealer_1;}
            case 2 -> {imageview = carta_dealer_2;}
            case 3 -> {imageview = carta_dealer_3;}
            case 4 -> {imageview = carta_dealer_4;}
            case 5 -> {imageview = carta_dealer_5;}
            case 6 -> {imageview = carta_dealer_6;}
            case 7 -> {imageview = carta_dealer_7;}
            case 8 -> {imageview = carta_dealer_8;}
        }

        if (imageview != null){
            imageview.setImage(dealer.getCarta(cartaIndex).getImagen());
        }
    }



    /**
     * Actualiza las imágenes de las fichas apostadas en la apuesta central.
     */
    void actualizarFichasCentro(){
        try {
            switch (fichasApostadasEnApuestaCentral){
                case 1 -> {
                    switch (fichasCentral[0].getValor()){
                        case 1 -> {ficha_1_apuesta_centro_jugador_3.setImage(new Image(new File("src/main/resources/Images/Fichas/1_lateral.png").toURI().toURL().toExternalForm()));}
                        case 5 -> {ficha_1_apuesta_centro_jugador_3.setImage(new Image(new File("src/main/resources/Images/Fichas/5_lateral.png").toURI().toURL().toExternalForm()));}
                        case 25 -> {ficha_1_apuesta_centro_jugador_3.setImage(new Image(new File("src/main/resources/Images/Fichas/25_lateral.png").toURI().toURL().toExternalForm()));}
                        case 50 -> {ficha_1_apuesta_centro_jugador_3.setImage(new Image(new File("src/main/resources/Images/Fichas/50_lateral.png").toURI().toURL().toExternalForm()));}
                        case 100 -> {ficha_1_apuesta_centro_jugador_3.setImage(new Image(new File("src/main/resources/Images/Fichas/100_lateral.png").toURI().toURL().toExternalForm()));}
                    }
                }
                case 2 -> {
                    switch (fichasCentral[1].getValor()){
                        case 1 -> {ficha_2_apuesta_centro_jugador_3.setImage(new Image(new File("src/main/resources/Images/Fichas/1_lateral.png").toURI().toURL().toExternalForm()));}
                        case 5 -> {ficha_2_apuesta_centro_jugador_3.setImage(new Image(new File("src/main/resources/Images/Fichas/5_lateral.png").toURI().toURL().toExternalForm()));}
                        case 25 -> {ficha_2_apuesta_centro_jugador_3.setImage(new Image(new File("src/main/resources/Images/Fichas/25_lateral.png").toURI().toURL().toExternalForm()));}
                        case 50 -> {ficha_2_apuesta_centro_jugador_3.setImage(new Image(new File("src/main/resources/Images/Fichas/50_lateral.png").toURI().toURL().toExternalForm()));}
                        case 100 -> {ficha_2_apuesta_centro_jugador_3.setImage(new Image(new File("src/main/resources/Images/Fichas/100_lateral.png").toURI().toURL().toExternalForm()));}
                    }
                }
                case 3 -> {
                    switch (fichasCentral[2].getValor()){
                        case 1 -> {ficha_3_apuesta_centro_jugador_3.setImage(new Image(new File("src/main/resources/Images/Fichas/1_lateral.png").toURI().toURL().toExternalForm()));}
                        case 5 -> {ficha_3_apuesta_centro_jugador_3.setImage(new Image(new File("src/main/resources/Images/Fichas/5_lateral.png").toURI().toURL().toExternalForm()));}
                        case 25 -> {ficha_3_apuesta_centro_jugador_3.setImage(new Image(new File("src/main/resources/Images/Fichas/25_lateral.png").toURI().toURL().toExternalForm()));}
                        case 50 -> {ficha_3_apuesta_centro_jugador_3.setImage(new Image(new File("src/main/resources/Images/Fichas/50_lateral.png").toURI().toURL().toExternalForm()));}
                        case 100 -> {ficha_3_apuesta_centro_jugador_3.setImage(new Image(new File("src/main/resources/Images/Fichas/100_lateral.png").toURI().toURL().toExternalForm()));}
                    }
                }
                case 4 -> {
                    switch (fichasCentral[3].getValor()){
                        case 1 -> {ficha_4_apuesta_centro_jugador_3.setImage(new Image(new File("src/main/resources/Images/Fichas/1_lateral.png").toURI().toURL().toExternalForm()));}
                        case 5 -> {ficha_4_apuesta_centro_jugador_3.setImage(new Image(new File("src/main/resources/Images/Fichas/5_lateral.png").toURI().toURL().toExternalForm()));}
                        case 25 -> {ficha_4_apuesta_centro_jugador_3.setImage(new Image(new File("src/main/resources/Images/Fichas/25_lateral.png").toURI().toURL().toExternalForm()));}
                        case 50 -> {ficha_4_apuesta_centro_jugador_3.setImage(new Image(new File("src/main/resources/Images/Fichas/50_lateral.png").toURI().toURL().toExternalForm()));}
                        case 100 -> {ficha_4_apuesta_centro_jugador_3.setImage(new Image(new File("src/main/resources/Images/Fichas/100_lateral.png").toURI().toURL().toExternalForm()));}
                    }
                }
                case 5 -> {
                    switch (fichasCentral[4].getValor()){
                        case 1 -> {ficha_5_apuesta_centro_jugador_3.setImage(new Image(new File("src/main/resources/Images/Fichas/1_lateral.png").toURI().toURL().toExternalForm()));}
                        case 5 -> {ficha_5_apuesta_centro_jugador_3.setImage(new Image(new File("src/main/resources/Images/Fichas/5_lateral.png").toURI().toURL().toExternalForm()));}
                        case 25 -> {ficha_5_apuesta_centro_jugador_3.setImage(new Image(new File("src/main/resources/Images/Fichas/25_lateral.png").toURI().toURL().toExternalForm()));}
                        case 50 -> {ficha_5_apuesta_centro_jugador_3.setImage(new Image(new File("src/main/resources/Images/Fichas/50_lateral.png").toURI().toURL().toExternalForm()));}
                        case 100 -> {ficha_5_apuesta_centro_jugador_3.setImage(new Image(new File("src/main/resources/Images/Fichas/100_lateral.png").toURI().toURL().toExternalForm()));}

                    }
                }
                case 6 -> {
                    switch (fichasCentral[5].getValor()){
                        case 1 -> {ficha_6_apuesta_centro_jugador_3.setImage(new Image(new File("src/main/resources/Images/Fichas/1_lateral.png").toURI().toURL().toExternalForm()));}
                        case 5 -> {ficha_6_apuesta_centro_jugador_3.setImage(new Image(new File("src/main/resources/Images/Fichas/5_lateral.png").toURI().toURL().toExternalForm()));}
                        case 25 -> {ficha_6_apuesta_centro_jugador_3.setImage(new Image(new File("src/main/resources/Images/Fichas/25_lateral.png").toURI().toURL().toExternalForm()));}
                        case 50 -> {ficha_6_apuesta_centro_jugador_3.setImage(new Image(new File("src/main/resources/Images/Fichas/50_lateral.png").toURI().toURL().toExternalForm()));}
                        case 100 -> {ficha_6_apuesta_centro_jugador_3.setImage(new Image(new File("src/main/resources/Images/Fichas/100_lateral.png").toURI().toURL().toExternalForm()));}
                    }
                }
                case 7 -> {
                    switch (fichasCentral[6].getValor()){
                        case 1 -> {ficha_7_apuesta_centro_jugador_3.setImage(new Image(new File("src/main/resources/Images/Fichas/1_lateral.png").toURI().toURL().toExternalForm()));}
                        case 5 -> {ficha_7_apuesta_centro_jugador_3.setImage(new Image(new File("src/main/resources/Images/Fichas/5_lateral.png").toURI().toURL().toExternalForm()));}
                        case 25 -> {ficha_7_apuesta_centro_jugador_3.setImage(new Image(new File("src/main/resources/Images/Fichas/25_lateral.png").toURI().toURL().toExternalForm()));}
                        case 50 -> {ficha_7_apuesta_centro_jugador_3.setImage(new Image(new File("src/main/resources/Images/Fichas/50_lateral.png").toURI().toURL().toExternalForm()));}
                        case 100 -> {ficha_7_apuesta_centro_jugador_3.setImage(new Image(new File("src/main/resources/Images/Fichas/100_lateral.png").toURI().toURL().toExternalForm()));}
                    }
                }
            }
        }catch (Exception e){}
    }



    /**
     * Reparte el dinero a los jugadores después de una ronda.
     * Calcula las ganancias o pérdidas de los jugadores.
     */
    void repartirDinero(){
        for (Jugador jugador : mesa){
            if (jugador.isDisponible() && jugador.getId() != 3){
                if(jugador.blackjack() && dealer.getSumaCartas() != 21){
                    jugador.setDinero((int) (jugador.getApuesta().getValorTotal() * 2.5));
                    jugador.escribirLineaEnArchivo("Apuesta ganada con Blackjack. Paga 3 a 2");
                }else if (jugador.getSumaCartas() > dealer.getSumaCartas() && jugador.getSumaCartas() <= 21){
                    jugador.setDinero(jugador.getApuesta().getValorTotal() * 2);
                    jugador.escribirLineaEnArchivo("Apuesta ganada. Paga 2 a 1");
                }else if (jugador.getSumaCartas() < dealer.getSumaCartas() && dealer.getSumaCartas() > 21 && jugador.getSumaCartas() <= 21){
                    jugador.setDinero(jugador.getApuesta().getValorTotal() * 2);
                    jugador.escribirLineaEnArchivo("Apuesta ganada. Paga 2 a 1");
                }else if (jugador.getSumaCartas() == dealer.getSumaCartas() && jugador.getSumaCartas() <= 21){
                    jugador.setDinero(jugador.getApuesta().getValorTotal());
                    jugador.escribirLineaEnArchivo("Apuesta Empatada. Paga 1 a 1");
                }else{
                    jugador.escribirLineaEnArchivo("Apuesta Perdida.");
                }
            }else if (jugador.getId() == 3){
                int valor = 0;
                for (Ficha ficha : fichasCentral){
                    if (ficha != null){
                        valor += ficha.getValor();
                    }
                }
                for (int i = 0; i < 7; i++){
                    switch(i){
                        case 0 -> {
                            if (ficha_1_apuesta_izquierda_jugador_3.getImage() != null){
                                valor += fichasCentralIzquierda[i].getValor();
                            }
                        }
                        case 1 -> {
                            if (ficha_2_apuesta_izquierda_jugador_3.getImage() != null){
                                valor += fichasCentralIzquierda[i].getValor();
                            }
                        }
                        case 2 -> {
                            if (ficha_3_apuesta_izquierda_jugador_3.getImage() != null){
                                valor += fichasCentralIzquierda[i].getValor();
                            }
                        }
                        case 3 -> {
                            if (ficha_4_apuesta_izquierda_jugador_3.getImage() != null){
                                valor += fichasCentralIzquierda[i].getValor();
                            }
                        }
                        case 4 -> {
                            if (ficha_5_apuesta_izquierda_jugador_3.getImage() != null){
                                valor += fichasCentralIzquierda[i].getValor();
                            }
                        }
                        case 5 -> {
                            if (ficha_6_apuesta_izquierda_jugador_3.getImage() != null){
                                valor += fichasCentralIzquierda[i].getValor();
                            }
                        }
                        case 6 -> {
                            if (ficha_7_apuesta_izquierda_jugador_3.getImage() != null){
                                valor += fichasCentralIzquierda[i].getValor();
                            }
                        }
                    }
                }
                if(jugador.blackjack() && dealer.getSumaCartas() != 21){
                    jugador.setDinero((int) (valor * 2.5));
                    jugador.escribirLineaEnArchivo("Apuesta ganada con Blackjack. Paga 3 a 2");
                }else if (jugador.getSumaCartas() > dealer.getSumaCartas() && jugador.getSumaCartas() <= 21){
                    jugador.setDinero(valor * 2);
                    jugador.escribirLineaEnArchivo("Apuesta ganada. Paga 2 a 1");
                }else if (jugador.getSumaCartas() < dealer.getSumaCartas() && dealer.getSumaCartas() > 21 && jugador.getSumaCartas() <= 21){
                    jugador.setDinero(valor * 2);
                    jugador.escribirLineaEnArchivo("Apuesta ganada. Paga 2 a 1");
                }else if (jugador.getSumaCartas() == dealer.getSumaCartas() && jugador.getSumaCartas() <= 21){
                    jugador.setDinero(valor);
                    jugador.escribirLineaEnArchivo("Apuesta empatada. Paga 1 a 1");
                }else{
                    jugador.escribirLineaEnArchivo("Apuesta perdida.");
                }
            }
            if (jugador.isDisponible()){
                jugador.escribirLineaEnArchivo("------------------------------");
            }
        }
        apuestaCentral = new Apuesta();
        apuestaCentralIzquierda = new Apuesta();
        fichasCentral = new Ficha[7];
        fichasCentralIzquierda = new Ficha[7];
        fichasApostadasEnApuestaCentral = 0;
        cartasJugadasCentro = 2;

        for (Jugador jugador : mesa) {
            if (jugador.isDisponible()) {
                jugador.setCartas(new Carta[7]);
                jugador.setApuesta(new Apuesta());
            }
        }
        dealer.setCartas(new Carta[9]);
        reiniciarVisuals();
    }



    /**
     * Actualiza las imágenes de las cartas en la interfaz gráfica.
     */
    void actualizarCartas(){
        for (int j = 0; j < 5; j++){
            for (int i = 0; i < 7; i++){
                if (mesa[j].getCarta(i) != null){
                    switch(j){
                        case 0 -> {
                            switch(i){
                                case 0 -> {carta_1_centro_jugador_1.setImage(mesa[j].getCarta(i).getImagen());}
                                case 1 -> {carta_2_centro_jugador_1.setImage(mesa[j].getCarta(i).getImagen());}
                                case 2 -> {carta_3_centro_jugador_1.setImage(mesa[j].getCarta(i).getImagen());}
                                case 3 -> {carta_4_centro_jugador_1.setImage(mesa[j].getCarta(i).getImagen());}
                                case 4 -> {carta_5_centro_jugador_1.setImage(mesa[j].getCarta(i).getImagen());}
                                case 5 -> {carta_6_centro_jugador_1.setImage(mesa[j].getCarta(i).getImagen());}
                                case 6 -> {carta_7_centro_jugador_1.setImage(mesa[j].getCarta(i).getImagen());}
                            }
                        }
                        case 1 -> {
                            switch(i){
                                case 0 -> {carta_1_centro_jugador_2.setImage(mesa[j].getCarta(i).getImagen());}
                                case 1 -> {carta_2_centro_jugador_2.setImage(mesa[j].getCarta(i).getImagen());}
                                case 2 -> {carta_3_centro_jugador_2.setImage(mesa[j].getCarta(i).getImagen());}
                                case 3 -> {carta_4_centro_jugador_2.setImage(mesa[j].getCarta(i).getImagen());}
                                case 4 -> {carta_5_centro_jugador_2.setImage(mesa[j].getCarta(i).getImagen());}
                                case 5 -> {carta_6_centro_jugador_2.setImage(mesa[j].getCarta(i).getImagen());}
                                case 6 -> {carta_7_centro_jugador_2.setImage(mesa[j].getCarta(i).getImagen());}
                            }
                        }
                        case 2 -> {
                            switch(i){
                                case 0 -> {carta_1_centro_jugador_3.setImage(mesa[j].getCarta(i).getImagen());}
                                case 1 -> {carta_2_centro_jugador_3.setImage(mesa[j].getCarta(i).getImagen());}
                                case 2 -> {carta_3_centro_jugador_3.setImage(mesa[j].getCarta(i).getImagen());}
                                case 3 -> {carta_4_centro_jugador_3.setImage(mesa[j].getCarta(i).getImagen());}
                                case 4 -> {carta_5_centro_jugador_3.setImage(mesa[j].getCarta(i).getImagen());}
                                case 5 -> {carta_6_centro_jugador_3.setImage(mesa[j].getCarta(i).getImagen());}
                                case 6 -> {carta_7_centro_jugador_3.setImage(mesa[j].getCarta(i).getImagen());}
                            }
                        }
                        case 3 -> {
                            switch(i){
                                case 0 -> {carta_1_centro_jugador_4.setImage(mesa[j].getCarta(i).getImagen());}
                                case 1 -> {carta_2_centro_jugador_4.setImage(mesa[j].getCarta(i).getImagen());}
                                case 2 -> {carta_3_centro_jugador_4.setImage(mesa[j].getCarta(i).getImagen());}
                                case 3 -> {carta_4_centro_jugador_4.setImage(mesa[j].getCarta(i).getImagen());}
                                case 4 -> {carta_5_centro_jugador_4.setImage(mesa[j].getCarta(i).getImagen());}
                                case 5 -> {carta_6_centro_jugador_4.setImage(mesa[j].getCarta(i).getImagen());}
                                case 6 -> {carta_7_centro_jugador_4.setImage(mesa[j].getCarta(i).getImagen());}
                            }
                        }
                        case 4 -> {
                            switch(i){
                                case 0 -> {carta_1_centro_jugador_5.setImage(mesa[j].getCarta(i).getImagen());}
                                case 1 -> {carta_2_centro_jugador_5.setImage(mesa[j].getCarta(i).getImagen());}
                                case 2 -> {carta_3_centro_jugador_5.setImage(mesa[j].getCarta(i).getImagen());}
                                case 3 -> {carta_4_centro_jugador_5.setImage(mesa[j].getCarta(i).getImagen());}
                                case 4 -> {carta_5_centro_jugador_5.setImage(mesa[j].getCarta(i).getImagen());}
                                case 5 -> {carta_6_centro_jugador_5.setImage(mesa[j].getCarta(i).getImagen());}
                                case 6 -> {carta_7_centro_jugador_5.setImage(mesa[j].getCarta(i).getImagen());}
                            }
                        }
                    }
                }else {
                    switch (j){
                        case 0 -> {
                            switch (i) {
                                case 0 -> {carta_1_centro_jugador_1.setImage(null);}
                                case 1 -> {carta_2_centro_jugador_1.setImage(null);}
                                case 2 -> {carta_3_centro_jugador_1.setImage(null);}
                                case 3 -> {carta_4_centro_jugador_1.setImage(null);}
                                case 4 -> {carta_5_centro_jugador_1.setImage(null);}
                                case 5 -> {carta_6_centro_jugador_1.setImage(null);}
                                case 6 -> {carta_7_centro_jugador_1.setImage(null);}
                            }
                        }
                        case 1 -> {
                            switch (i) {
                                case 0 -> {carta_1_centro_jugador_2.setImage(null);}
                                case 1 -> {carta_2_centro_jugador_2.setImage(null);}
                                case 2 -> {carta_3_centro_jugador_2.setImage(null);}
                                case 3 -> {carta_4_centro_jugador_2.setImage(null);}
                                case 4 -> {carta_5_centro_jugador_2.setImage(null);}
                                case 5 -> {carta_6_centro_jugador_2.setImage(null);}
                                case 6 -> {carta_7_centro_jugador_2.setImage(null);}
                            }
                        }
                        case 2 -> {
                            switch (i) {
                                case 0 -> {carta_1_centro_jugador_3.setImage(null);}
                                case 1 -> {carta_2_centro_jugador_3.setImage(null);}
                                case 2 -> {carta_3_centro_jugador_3.setImage(null);}
                                case 3 -> {carta_4_centro_jugador_3.setImage(null);}
                                case 4 -> {carta_5_centro_jugador_3.setImage(null);}
                                case 5 -> {carta_6_centro_jugador_3.setImage(null);}
                                case 6 -> {carta_7_centro_jugador_3.setImage(null);}
                            }
                        }
                        case 3 -> {
                            switch (i) {
                                case 0 -> {carta_1_centro_jugador_4.setImage(null);}
                                case 1 -> {carta_2_centro_jugador_4.setImage(null);}
                                case 2 -> {carta_3_centro_jugador_4.setImage(null);}
                                case 3 -> {carta_4_centro_jugador_4.setImage(null);}
                                case 4 -> {carta_5_centro_jugador_4.setImage(null);}
                                case 5 -> {carta_6_centro_jugador_4.setImage(null);}
                                case 6 -> {carta_7_centro_jugador_4.setImage(null);}
                            }
                        }
                        case 4 -> {
                            switch (i) {
                                case 0 -> {carta_1_centro_jugador_5.setImage(null);}
                                case 1 -> {carta_2_centro_jugador_5.setImage(null);}
                                case 2 -> {carta_3_centro_jugador_5.setImage(null);}
                                case 3 -> {carta_4_centro_jugador_5.setImage(null);}
                                case 4 -> {carta_5_centro_jugador_5.setImage(null);}
                                case 5 -> {carta_6_centro_jugador_5.setImage(null);}
                                case 6 -> {carta_7_centro_jugador_5.setImage(null);}
                            }
                        }
                    }
                }
            }
        }
    }



    /**
     * Expulsa a un jugador de la mesa reiniciando sus datos y actualizando el estado del juego.
     *
     * @param idJugador el ID del jugador que se va a expulsar.
     */
    void expulsarJugador(int idJugador) {
        for (int i = 0; i < mesa.length; i++) { // Usa mesa.length para manejar el tamaño dinámico de la mesa
            if (mesa[i].getId() == idJugador) {
                mesa[i] = new Jugador(idJugador); // Reinicia los datos del jugador
                mesa[i].setCartas(new Carta[7]); // Reinicia las cartas del jugador
                mesa[i].setDisponible(false); // Marca al jugador como no disponible
            }
        }
        // Actualiza el estado del juego
        actualizarCartas();
        actualizarDinero();
        actualizarLabelSumaDeCartas();
        actualizarApuestas();
        actualizarAvatar();
    }



    /**
     * Verifica a todos los jugadores y expulsa a aquellos que no tienen dinero restante.
     * Finaliza el juego si el jugador principal es expulsado.
     */
    void repasarJugadores() {
        for (Jugador jugador : mesa) {
            if (jugador.getDinero() <= 0) {
                expulsarJugador(jugador.getId()); // Expulsa al jugador si no tiene dinero restante
            }
        }
        if (!mesa[2].isDisponible()) { // Verifica si el jugador principal sigue disponible
            finDelJuego(); // Finaliza el juego si el jugador principal es expulsado
        }
    }



    /**
     * Añade un jugador aleatorio a la mesa con dinero y un avatar aleatorios.
     */
    void addJugadorRandom() {
        Random random = new Random();
        int randomNumber = random.nextInt(20);
        int randomDinero = random.nextInt(8000);
        Image randomAvatar = new Image(new File(avataresArray[random.nextInt(7)]).toURI().toString());
        int randomJugador;
        if  (randomNumber == 7){
            boolean added = false;
            do {
                randomJugador = random.nextInt(4);
                if (mesa[randomJugador].isDisponible() == false){
                    mesa[randomJugador].setDinero(randomDinero);
                    mesa[randomJugador].setDisponible(true);
                    mesa[randomJugador].crearArchivo();
                    mesa[randomJugador].setAvatar(randomAvatar);
                    switch (randomJugador){
                        case 0 -> {
                            fichas_jugador_1.setVisible(true);
                            avatar_jugador_1.setImage(mesa[randomJugador].getAvatar());
                        }
                        case 1 -> {
                            fichas_jugador_2.setVisible(true);
                            avatar_jugador_2.setImage(mesa[randomJugador].getAvatar());
                        }
                        case 2 -> {
                            fichas_jugador_3.setVisible(true);
                            avatar_jugador_3.setImage(mesa[randomJugador].getAvatar());
                        }
                        case 3 -> {
                            fichas_jugador_4.setVisible(true);
                            avatar_jugador_4.setImage(mesa[randomJugador].getAvatar());
                        }
                        case 4 -> {
                            fichas_jugador_5.setVisible(true);
                            avatar_jugador_5.setImage(mesa[randomJugador].getAvatar());
                        }
                    }
                    added = true;
                }
            } while (!added);
        }
    }



    /**
     * Finaliza el juego y expulsa al jugador principal de la sala.
     */
    void finDelJuego() {
        System.out.println("Te has quedado sin fichas, se te ha expulsado de la sala.");
        mesa[2].borrarArchivo();
        Platform.exit();
    }



    /**
     * Almacena el dinero de los jugadores en archivos de registro.
     */
    void almacenarDinero() {
        for (Jugador jugador : mesa) {
            if (jugador.isDisponible()) {
                jugador.escribirLineaEnArchivo("Partida " + jugador.getManosJugadas());
                jugador.escribirLineaEnArchivo("Fichas Totales: " + jugador.getDinero());
            }
        }
    }



    /**
     * Ejecuta una lista de tareas con pausas entre ellas.
     *
     * @param tasks           la lista de tareas a ejecutar.
     * @param pausaMilisegundos el tiempo de pausa en milisegundos entre cada tarea.
     * @param afterTimeline   la tarea que se ejecutará después de todas las tareas.
     */
    private void ejecutarTareasConPausa(List<Runnable> tasks, int pausaMilisegundos, Runnable afterTimeline) {
        Timeline timeline = new Timeline();
        for (int i = 0; i < tasks.size(); i++) {
            Runnable task = tasks.get(i);
            KeyFrame keyFrame = new KeyFrame(Duration.millis(i * pausaMilisegundos), event -> task.run());
            timeline.getKeyFrames().add(keyFrame);
        }
        timeline.setOnFinished(event -> afterTimeline.run());
        timeline.play();
    }



    /**
     * Borra todos los archivos con extensión ".txt" en el directorio actual.
     */
    void borrarArchivosAnteriores() {
        File directorio = new File("E:/Disco_Duro/DAM/Programacion/Proyectos/BlackJack_MarioBueno/src/main/resources/FicherosOutput/");
        File[] archivos = directorio.listFiles((dir, name) -> name.endsWith(".txt"));
        if (archivos != null) {
            for (File archivo : archivos) {
                if (archivo.delete()) {
                    System.out.println("Archivo eliminado: " + archivo.getName());
                } else {
                    System.out.println("No se pudo eliminar el archivo: " + archivo.getName());
                }
            }
        }
    }
}
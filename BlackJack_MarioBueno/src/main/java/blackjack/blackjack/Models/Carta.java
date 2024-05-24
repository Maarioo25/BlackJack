package blackjack.blackjack.Models;

import javafx.scene.image.Image;

import java.io.File;

/**
 * Clase que representa una carta en el juego de Blackjack.
 */
public class Carta {
    private final int valor;
    private final Image imagen;

    /**
     * Constructor de la clase Carta.
     *
     * @param x El número de la carta (0 para la carta por detrás, 1-52 para las cartas normales).
     */
    public Carta(int x) {
        if (x == 0){
            this.valor = 0;
            this.imagen = setImagen(x);
            return;
        }
        this.valor = setValor(x);
        this.imagen = setImagen(x);
    }

    private Image setImagen(int numero) {
        return switch (numero) {
            case 0 -> new Image(new File("src/main/resources/Images/Cartas/Carta_Por_Detras.png").toURI().toString());
            case 1 -> new Image(new File("src/main/resources/Images/Cartas/ace_of_hearts.png").toURI().toString());
            case 2 -> new Image(new File("src/main/resources/Images/Cartas/2_of_hearts.png").toURI().toString());
            case 3 -> new Image(new File("src/main/resources/Images/Cartas/3_of_hearts.png").toURI().toString());
            case 4 -> new Image(new File("src/main/resources/Images/Cartas/4_of_hearts.png").toURI().toString());
            case 5 -> new Image(new File("src/main/resources/Images/Cartas/5_of_hearts.png").toURI().toString());
            case 6 -> new Image(new File("src/main/resources/Images/Cartas/6_of_hearts.png").toURI().toString());
            case 7 -> new Image(new File("src/main/resources/Images/Cartas/7_of_hearts.png").toURI().toString());
            case 8 -> new Image(new File("src/main/resources/Images/Cartas/8_of_hearts.png").toURI().toString());
            case 9 -> new Image(new File("src/main/resources/Images/Cartas/9_of_hearts.png").toURI().toString());
            case 10 -> new Image(new File("src/main/resources/Images/Cartas/10_of_hearts.png").toURI().toString());
            case 11 -> new Image(new File("src/main/resources/Images/Cartas/jack_of_hearts.png").toURI().toString());
            case 12 -> new Image(new File("src/main/resources/Images/Cartas/queen_of_hearts.png").toURI().toString());
            case 13 -> new Image(new File("src/main/resources/Images/Cartas/king_of_hearts.png").toURI().toString());
            case 14 -> new Image(new File("src/main/resources/Images/Cartas/ace_of_diamonds.png").toURI().toString());
            case 15 -> new Image(new File("src/main/resources/Images/Cartas/2_of_diamonds.png").toURI().toString());
            case 16 -> new Image(new File("src/main/resources/Images/Cartas/3_of_diamonds.png").toURI().toString());
            case 17 -> new Image(new File("src/main/resources/Images/Cartas/4_of_diamonds.png").toURI().toString());
            case 18 -> new Image(new File("src/main/resources/Images/Cartas/5_of_diamonds.png").toURI().toString());
            case 19 -> new Image(new File("src/main/resources/Images/Cartas/6_of_diamonds.png").toURI().toString());
            case 20 -> new Image(new File("src/main/resources/Images/Cartas/7_of_diamonds.png").toURI().toString());
            case 21 -> new Image(new File("src/main/resources/Images/Cartas/8_of_diamonds.png").toURI().toString());
            case 22 -> new Image(new File("src/main/resources/Images/Cartas/9_of_diamonds.png").toURI().toString());
            case 23 -> new Image(new File("src/main/resources/Images/Cartas/10_of_diamonds.png").toURI().toString());
            case 24 -> new Image(new File("src/main/resources/Images/Cartas/jack_of_diamonds.png").toURI().toString());
            case 25 -> new Image(new File("src/main/resources/Images/Cartas/queen_of_diamonds.png").toURI().toString());
            case 26 -> new Image(new File("src/main/resources/Images/Cartas/king_of_diamonds.png").toURI().toString());
            case 27 -> new Image(new File("src/main/resources/Images/Cartas/ace_of_clubs.png").toURI().toString());
            case 28 -> new Image(new File("src/main/resources/Images/Cartas/2_of_clubs.png").toURI().toString());
            case 29 -> new Image(new File("src/main/resources/Images/Cartas/3_of_clubs.png").toURI().toString());
            case 30 -> new Image(new File("src/main/resources/Images/Cartas/4_of_clubs.png").toURI().toString());
            case 31 -> new Image(new File("src/main/resources/Images/Cartas/5_of_clubs.png").toURI().toString());
            case 32 -> new Image(new File("src/main/resources/Images/Cartas/6_of_clubs.png").toURI().toString());
            case 33 -> new Image(new File("src/main/resources/Images/Cartas/7_of_clubs.png").toURI().toString());
            case 34 -> new Image(new File("src/main/resources/Images/Cartas/8_of_clubs.png").toURI().toString());
            case 35 -> new Image(new File("src/main/resources/Images/Cartas/9_of_clubs.png").toURI().toString());
            case 36 -> new Image(new File("src/main/resources/Images/Cartas/10_of_clubs.png").toURI().toString());
            case 37 -> new Image(new File("src/main/resources/Images/Cartas/jack_of_clubs.png").toURI().toString());
            case 38 -> new Image(new File("src/main/resources/Images/Cartas/queen_of_clubs.png").toURI().toString());
            case 39 -> new Image(new File("src/main/resources/Images/Cartas/king_of_clubs.png").toURI().toString());
            case 40 -> new Image(new File("src/main/resources/Images/Cartas/ace_of_spades.png").toURI().toString());
            case 41 -> new Image(new File("src/main/resources/Images/Cartas/2_of_spades.png").toURI().toString());
            case 42 -> new Image(new File("src/main/resources/Images/Cartas/3_of_spades.png").toURI().toString());
            case 43 -> new Image(new File("src/main/resources/Images/Cartas/4_of_spades.png").toURI().toString());
            case 44 -> new Image(new File("src/main/resources/Images/Cartas/5_of_spades.png").toURI().toString());
            case 45 -> new Image(new File("src/main/resources/Images/Cartas/6_of_spades.png").toURI().toString());
            case 46 -> new Image(new File("src/main/resources/Images/Cartas/7_of_spades.png").toURI().toString());
            case 47 -> new Image(new File("src/main/resources/Images/Cartas/8_of_spades.png").toURI().toString());
            case 48 -> new Image(new File("src/main/resources/Images/Cartas/9_of_spades.png").toURI().toString());
            case 49 -> new Image(new File("src/main/resources/Images/Cartas/10_of_spades.png").toURI().toString());
            case 50 -> new Image(new File("src/main/resources/Images/Cartas/jack_of_spades.png").toURI().toString());
            case 51 -> new Image(new File("src/main/resources/Images/Cartas/queen_of_spades.png").toURI().toString());
            case 52 -> new Image(new File("src/main/resources/Images/Cartas/king_of_spades.png").toURI().toString());
            default -> null;
        };
    }

    private int setValor(int numero) {
        return switch (numero) {
            case 1, 14, 27, 40 -> 11;
            case 2, 15, 28, 41 -> 2;
            case 3, 16, 29, 42 -> 3;
            case 4, 17, 30, 43 -> 4;
            case 5, 18, 31, 44 -> 5;
            case 6, 19, 32, 45 -> 6;
            case 7, 20, 33, 46 -> 7;
            case 8, 21, 34, 47 -> 8;
            case 9, 22, 35, 48 -> 9;
            case 10, 23, 36, 49, 11, 24, 37, 50, 12, 25, 38, 51, 13, 26, 39, 52 -> 10;
            default -> 0;
        };
    }
    /**
     * Obtiene el valor numérico de la carta.
     *
     * @return El valor numérico de la carta.
     */
    public int getValor() {
        return valor;
    }

    /**
     * Obtiene la imagen de la carta.
     *
     * @return La imagen de la carta.
     */
    public Image getImagen() {
        return imagen;
    }
}

package blackjack.blackjack.Models;

import javafx.scene.image.Image;

import java.io.File;
import java.net.MalformedURLException;
import java.util.HashMap;

/**
 * Clase que representa una ficha utilizada en el juego de Blackjack.
 */
public class Ficha {

    private final int valor;
    private final Image imagen;

    Image[] fichas = {
            new Image(new File("src/main/resources/Images/Fichas/1_lateral.png").toURI().toURL().toExternalForm()),
            new Image(new File("src/main/resources/Images/Fichas/5_lateral.png").toURI().toURL().toExternalForm()),
            new Image(new File("src/main/resources/Images/Fichas/25_lateral.png").toURI().toURL().toExternalForm()),
            new Image(new File("src/main/resources/Images/Fichas/50_lateral.png").toURI().toURL().toExternalForm()),
            new Image(new File("src/main/resources/Images/Fichas/100_lateral.png").toURI().toURL().toExternalForm())
    };

    /**
     * Constructor de la clase Ficha.
     *
     * @param valor El valor de la ficha.
     * @throws MalformedURLException Si hay un error al crear la URL de la imagen de la ficha.
     */
    public Ficha(int valor) throws MalformedURLException {
        this.valor = valor;
        this.imagen = selectorDeImagen(valor);
    }

    /**
     * Obtiene el valor de la ficha.
     *
     * @return El valor de la ficha.
     */
    public int getValor() {
        return valor;
    }

    /**
     * Obtiene la imagen de la ficha.
     *
     * @return La imagen de la ficha.
     */
    public Image getImagen() {
        return imagen;
    }

    private Image selectorDeImagen(int valor){

        HashMap<Integer, Image> map = new HashMap<>();
        map.put(1, fichas[0]);
        map.put(5, fichas[1]);
        map.put(25, fichas[2]);
        map.put(50, fichas[3]);
        map.put(100, fichas[4]);
        return map.get(valor);
    }

}

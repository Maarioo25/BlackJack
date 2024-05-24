package blackjack.blackjack.Models;

import blackjack.blackjack.controllers.NombreController;
import blackjack.blackjack.controllers.TableroController;
import javafx.scene.image.Image;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Random;

/**
 * Clase que representa a un jugador en el juego de Blackjack.
 */
public class Jugador {

    String[] avatares = {
            "src/main/resources/Images/Avatares/hombre1.png",
            "src/main/resources/Images/Avatares/hombre2.png",
            "src/main/resources/Images/Avatares/hombre3.png",
            "src/main/resources/Images/Avatares/hombre4.png",
            "src/main/resources/Images/Avatares/hombre5.png",
            "src/main/resources/Images/Avatares/mujer1.png",
            "src/main/resources/Images/Avatares/mujer2.png",
            "src/main/resources/Images/Avatares/mujer3.png"
    };

    private final int id;
    private boolean disponible;
    private Image avatar;
    private int dinero;
    private Apuesta apuesta;
    private Carta[] cartas;
    private int manosJugadas = 0;

    /**
     * Constructor de la clase Jugador.
     *
     * @param id Identificador del jugador.
     */
    public Jugador(int id) {
        this.id = id;
        if (id == 3) {
            this.disponible = true;
            try {
                this.avatar = new Image(new File(avatares[TableroController.avatar - 1]).toURI().toURL().toExternalForm());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            this.dinero = 5000;
            cartas = new Carta[7];
            apuesta = new Apuesta();
            crearArchivo();
            return;
        }
        Random random = new Random();
        int randomNumber = random.nextInt(2);
        this.disponible = randomNumber == 1;
        if (disponible) {
            try {
                this.avatar = new Image(new File(avatares[random.nextInt(7)]).toURI().toURL().toExternalForm());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            this.dinero = random.nextInt(10000);
            cartas = new Carta[7];
            apuesta = new Apuesta();
            crearArchivo();
        } else {
            try {
                this.avatar = new Image(new File("src/main/resources/Images/Avatares/vacio.png").toURI().toURL().toExternalForm());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            this.dinero = 0;
        }

    }

    public boolean isDisponible() {
        return disponible;
    }

    public int getDinero() {
        return dinero;
    }

    public Image getAvatar() {
        return avatar;
    }

    public void setApuesta(Apuesta apuesta) {
        this.apuesta = apuesta;
    }

    public Apuesta getApuesta() {
        return apuesta;
    }

    public Carta getCarta(int x) {
        if (cartas == null) {
            return null;
        } else {
            return cartas[x];
        }
    }

    public void setCarta() {
        for (int i = 0; i < cartas.length; i++) {
            if (cartas[i] == null) {
                Random random = new Random();
                cartas[i] = new Carta(random.nextInt(51) + 1);
                break;
            }
        }
    }

    public int getId() {
        return id;
    }

    public void setDinero(int input) {
        dinero = dinero + input;
    }

    public int getSumaCartas() {
        int suma = 0;
        for (Carta carta : cartas) {
            if (carta != null) {
                suma += carta.getValor();
            }
        }
        return suma;
    }

    public boolean blackjack() {
        return (cartas[0].getValor() + cartas[1].getValor() == 21);
    }

    public void setDisponible(boolean valor) {
        this.disponible = valor;
    }

    public void setAvatar(Image avatar) {
        this.avatar = avatar;
    }

    public void setCartas(Carta[] cartas) {
        this.cartas = cartas;
    }

    public void crearArchivo() {
        File archivo;
        if (id == 3) {
            archivo = new File("src/main/resources/FicherosOutput/" + NombreController.nombre + ".txt");
        } else {
            archivo = new File("src/main/resources/FicherosOutput/" + "jugador_" + id + ".txt");
        }
        try {
            if (archivo.exists()) {
                if (archivo.delete()) {
                    System.out.println("Archivo existente eliminado.");
                } else {
                    System.out.println("No se pudo eliminar el archivo existente.");
                    return;
                }
            }
            if (archivo.createNewFile()) {
                System.out.println("Archivo creado: " + archivo.getName());
            } else {
                System.out.println("No se pudo crear el archivo.");
            }
        } catch (IOException e) {
            System.out.println("Error al crear el archivo: " + e.getMessage());
        }
    }

    public void borrarArchivo() {
        File archivo;
        if (id == 3) {
            archivo = new File("src/main/resources/FicherosOutput/" + NombreController.nombre + ".txt");
        } else {
            archivo = new File("src/main/resources/FicherosOutput/" + "jugador_" + id + ".txt");
        }
        if (archivo.delete()) {
            System.out.println("Archivo borrado: " + archivo.getName());
        } else {
            System.out.println("No se pudo borrar el archivo.");
        }
    }

    public void escribirLineaEnArchivo(String linea) {
        File archivo;
        if (id == 3) {
            archivo = new File("src/main/resources/FicherosOutput/" + NombreController.nombre + ".txt");
        } else {
            archivo = new File("src/main/resources/FicherosOutput/" + "jugador_" + id + ".txt");
        }
        try (FileWriter writer = new FileWriter(archivo, true)) {
            writer.write(linea + "\n");
            if (id == 3) {
                System.out.println("Tu archivo ha sido modificado correctamente.");
            } else {
                System.out.println("Archivo del jugador " + id + " modificado correctamente.");
            }

        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo del jugador " + id + ": " + e.getMessage());
        }
    }

    public int getManosJugadas() {
        manosJugadas++;
        return manosJugadas;
    }
}

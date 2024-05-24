package blackjack.blackjack.Models;

import java.util.Random;

/**
 * Clase que representa al dealer en el juego de Blackjack.
 */
public class Dealer {
    private Carta[] cartas = new Carta[9];

    /**
     * Obtiene una carta específica del dealer.
     *
     * @param x El índice de la carta que se desea obtener.
     * @return La carta en la posición especificada.
     */
    public Carta getCarta(int x) {
        return cartas[x];
    }

    /**
     * Añade una carta al conjunto de cartas del dealer.
     * Si es la primera carta, se agrega la carta por detrás.
     * Para el resto de las cartas, se genera aleatoriamente una carta normal.
     */
    public void setCarta() {
        Random random = new Random();
        for (int i = 0; i < cartas.length; i++) {
            if (cartas[i] == null || cartas[i].getValor() == 0) {
                if (i == 1 && cartas[i] == null) {
                    cartas[i] = new Carta(0);
                    break;
                } else if (i == 1 && cartas[i].getValor() == 0) {
                    cartas[i] = new Carta(random.nextInt(51) + 1);
                    break;
                } else {
                    cartas[i] = new Carta(random.nextInt(51) + 1);
                    break;
                }
            }
        }
    }

    /**
     * Calcula la suma total del valor de las cartas del dealer.
     *
     * @return La suma total del valor de las cartas del dealer.
     */
    public int getSumaCartas(){
        int suma = 0;
        for (Carta carta : cartas) {
            if (carta != null){
                suma += carta.getValor();
            }
        }
        return suma;
    }

    /**
     * Establece las cartas del dealer.
     *
     * @param cartas Arreglo de cartas que representan las cartas del dealer.
     */
    public void setCartas(Carta[] cartas){
        this.cartas = cartas;
    }
}

package blackjack.blackjack.Models;

/**
 * Clase que representa la apuesta realizada por un jugador en el juego de Blackjack.
 */
public class Apuesta {
    private Ficha[] fichas = new Ficha[8];

    /**
     * Establece las fichas de la apuesta.
     *
     * @param fichas Arreglo de fichas que representan la apuesta.
     */
    public void setFichas(Ficha[] fichas){
        this.fichas = fichas;
    }

    /**
     * Obtiene las fichas de la apuesta.
     *
     * @return Arreglo de fichas que representan la apuesta.
     */
    public Ficha[] getFichas(){
        return this.fichas;
    }

    /**
     * Calcula el valor total de la apuesta sumando el valor de todas las fichas.
     *
     * @return Valor total de la apuesta.
     */
    public int getValorTotal(){
        int total = 0;
        for (Ficha ficha : fichas) {
            if (ficha != null) {
                total += ficha.getValor();
            }
        }
        return total;
    }
}


package simulador.pokemon;


public class Lickitung extends Pokemon {
    public Lickitung(){
    super("Lickitung",90,55,TipoPokemon.NORMAL,TipoPokemon.NORMAL,Estado.Normal);
    
   }

    public Lickitung(String nombre, int salud, int PuntosDeAtaque, TipoPokemon tipo1, TipoPokemon tipo2, Estado estado) {
        super(nombre, salud, PuntosDeAtaque, tipo1, tipo2, estado);
    }
    
@Override
public void atacar(Pokemon oponente) {
    // Obtener los tipos del atacante y del oponente (pueden ser 1 o 2 tipos)
    TipoPokemon tipoAtacante = this.getTipo1();  // El atacante tiene 1 o 2 tipos
    TipoPokemon tipoAtacante2 = this.getTipo2(); // El atacante tiene 1 o 2 tipos
    TipoPokemon tipoDefensor1 = oponente.getTipo1(); // El defensor tiene 1 o 2 tipos
    TipoPokemon tipoDefensor2 = oponente.getTipo2(); // El defensor tiene 1 o 2 tipos

    // Llamada al método obtenerMultiplicadorDeDaño dependiendo de si el defensor tiene 1 o 2 tipos
    double multiplicador;

    if (tipoDefensor2 != null) {
        // Si el defensor tiene dos tipos
        multiplicador = TipoPokemon.obtenerMultiplicadorDeDaño(tipoAtacante, tipoAtacante2, tipoDefensor1, tipoDefensor2);
    } else {
        // Si el defensor tiene un solo tipo
        multiplicador = TipoPokemon.obtenerMultiplicadorDeDaño(tipoAtacante, tipoDefensor1);
    }

    // Calcular el daño final
    int daño = (int) (this.getPuntosDeAtaque() * multiplicador);

    // Aplicar el daño al oponente
    oponente.recibirDaño(daño);

    // Mostrar el mensaje de ataque
    System.out.println(this.getNombre() + " ataca a " + oponente.getNombre() + " causando " + daño + " de daño.");
}
}





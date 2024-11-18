
package simulador.pokemon;


public class Hitmonchan extends Pokemon {
    public Hitmonchan() {
        

        super("Hitmonchan", 50, 105, TipoPokemon.LUCHA, TipoPokemon.NORMAL,Estado.Normal);

    }

    
   
    public void atacar(Pokemon oponente) {
       
        TipoPokemon tipoAtacante1 = this.getTipo1();
        TipoPokemon tipoAtacante2 = this.getTipo2();
        TipoPokemon tipoDefensor1 = oponente.getTipo1();
        TipoPokemon tipoDefensor2 = oponente.getTipo2();

       
        double multiplicador = TipoPokemon.obtenerMultiplicadorDeDaño(tipoAtacante1, tipoAtacante2, tipoDefensor1, tipoDefensor2);

       
        int daño = (int) (this.getPuntosDeAtaque() * multiplicador);

     
        oponente.recibirDaño(daño);

        
        
    }
}
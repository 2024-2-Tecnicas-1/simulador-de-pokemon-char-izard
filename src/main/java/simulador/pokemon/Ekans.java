
package simulador.pokemon;


public class Ekans extends Pokemon {
    public Ekans(){
     super("Ekans", 35, 60, TipoPokemon.VENENO,TipoPokemon.NORMAL, Estado.Normal);
    }

    @Override
    public void atacar(Pokemon oponente) {
        
        TipoPokemon tipoAtacante = this.getTipo1();  
        TipoPokemon tipoAtacante2 = this.getTipo2(); 
        TipoPokemon tipoDefensor1 = oponente.getTipo1(); 
        TipoPokemon tipoDefensor2 = oponente.getTipo2(); 

       
        double multiplicador;

        if (tipoDefensor2 != null) {
         
            multiplicador = TipoPokemon.obtenerMultiplicadorDeDaño(tipoAtacante, tipoAtacante2, tipoDefensor1, tipoDefensor2);
        } else {
          
            multiplicador = TipoPokemon.obtenerMultiplicadorDeDaño(tipoAtacante, tipoDefensor1);
        }

        
        int daño = (int) (this.getPuntosDeAtaque() * multiplicador);

        oponente.recibirDaño(daño);

        
    }
}
    
    


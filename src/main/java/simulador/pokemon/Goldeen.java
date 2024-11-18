
package simulador.pokemon;


public class Goldeen extends Pokemon {
    public Goldeen(){
    super ("Golden",45,67,TipoPokemon.AGUA,TipoPokemon.NORMAL,Estado.Normal);
    }  
    @Override
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

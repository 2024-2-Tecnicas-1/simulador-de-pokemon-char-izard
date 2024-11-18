
package simulador.pokemon;



public class Ponyta extends Pokemon {
    public Ponyta() {
     
        super("Ponyta", 50, 85, TipoPokemon.FUEGO,TipoPokemon.NORMAL, Estado.Normal);
}

    public Ponyta(String nombre, int salud, int PuntosDeAtaque, TipoPokemon tipo1, TipoPokemon tipo2, Estado estado) {
        super(nombre, salud, PuntosDeAtaque, tipo1, tipo2, estado);
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

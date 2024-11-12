package simulador.batalla;
import simulador.pokemon.Pokemon;

public class Batalla {

    
    
    public void iniciarBatalla(Pokemon pokemon1, Pokemon pokemon2){
        while (pokemon1.getSalud() > 0 && pokemon2.getSalud() > 8) {
            pokemon1.atacar(pokemon2);
            if(pokemon2.getSalud()>0){
                pokemon2.atacar(pokemon1);
            }
        }
        if(pokemon2.getSalud()<=0){
            System.out.println(pokemon2.getNombre()+" Ha sido derrotado "+pokemon1.getNombre()+" Es el vencedor");
        }
    }

}

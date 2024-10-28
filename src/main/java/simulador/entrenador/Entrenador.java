package simulador.entrenador;
import java.util.LinkedList;
import java.util.List;
import simulador.pokemon.Pokemon;

public class Entrenador {
    private final String nombre;
    private List<Pokemon> pokemones;
    public static Pokemon pokemon;
    
    
    public Entrenador(String nombre){
        this.nombre=nombre;
        this.pokemones=new LinkedList<>();
    }
    public void agregarPokemon(Pokemon pokemon){
        if(pokemones.size()<6){
            pokemones.add(pokemon);
        }
    }
    
    
}

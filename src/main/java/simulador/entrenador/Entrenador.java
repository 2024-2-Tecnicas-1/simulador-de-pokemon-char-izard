package simulador.entrenador;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import simulador.pokemon.Pokemon;

public class Entrenador implements Serializable{
    private static final long serialVersionUID = 1L;
    private final String nombre;
    private List<Pokemon> pokemones;
    public static Pokemon pokemon;

    public Entrenador(String nombre) {
        this.nombre = nombre;
        this.pokemones = new LinkedList<>();
    }

    public void agregarPokemon(Pokemon pokemon) {
        if (pokemones.size() < 6) {
            pokemones.add(pokemon);
        }
    }

    public void entrenarPokemon(Pokemon pokemon) {
        if (pokemones.contains(pokemon)) {
            pokemon.entrenar();
        }
    }

    public Pokemon prepararBatalla() {
        if (!pokemones.isEmpty()) {
            Pokemon PokemonPelea = pokemones.get(0);
            System.out.println(PokemonPelea + " ha sido escogido para la batalla");
            return PokemonPelea;
        } else {
            System.out.println(
                    "No hay pokemones en tu equipo para participar en una batalla. \nAñade pokemones a la lista en el menu principal");
            return null;
        }
    }

    public void mostrarPokemones() {
        System.out.println("Tienes " + pokemones.size() + " pokemones");
        for (Pokemon pokemon : pokemones) {
            System.out.println(pokemon.getNombre());
        }
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public List<Pokemon> getPokemones() {
        return pokemones;
    }

    public void setPokemones(List<Pokemon> pokemones) {
        this.pokemones = pokemones;
    }

}

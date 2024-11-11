package simulador;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import simulador.batalla.Batalla;
import simulador.entrenador.Entrenador;
import simulador.pokemon.Cubone;
import simulador.pokemon.Doduo;
import simulador.pokemon.Ekans;
import simulador.pokemon.Electrode;
import simulador.pokemon.Estado;
import simulador.pokemon.Goldeen;
import simulador.pokemon.Hitmonchan;
import simulador.pokemon.Lickitung;
import simulador.pokemon.Paras;
import simulador.pokemon.Pokemon;
import simulador.pokemon.Ponyta;
import simulador.pokemon.Staryu;
import simulador.pokemon.TipoPokemon;

public class Principal {
    
    private static final Scanner sc = new Scanner(System.in); 
    private static final List<Entrenador> entrenadores = new ArrayList<>(); 
    private static final List<Pokemon> pokemones = new ArrayList<>(); 
    
    public static void main(String[] args) {
        pokemones.add(new Cubone());
        menuPrincipal();
    }
    public static void menuPrincipal(){
         while (true){
            System.out.println("=========Bienvenidos al simulador pokemon=========");
            System.out.println("=================By: Char-izard=================");
            System.out.println("Menu Principal, elige un opcion");
            System.out.println("1. Gestionar Entrenadores");
            System.out.println("2. Gestionar Pokemones");
            System.out.println("3. Iniciar Batalla");
            System.out.println("4. Salir");
            String op=sc.next();
            switch(op){
                case "1":
                    gestionarEntrenadores();
                    break;
                case "2":
                    gestionarPokemones();
                    break;
                case "3":
            }
        }
    }
    public static void gestionarEntrenadores() {
        System.out.println("""
                           
                           =================== Gestionar entrenadores===================""");
        System.out.println("1. Registrar un nuevo entrenador");
        System.out.println("2. Ver lista de entrenadores");
        System.out.println("3. Seleccionar un entrenador");
        System.out.println("4.Volver al menú principal");
        String op = sc.next();
        switch (op) {
            case "1":
                System.out.println("============Registrar Entrenador============");
                System.out.println("Digita el nombre del entrenador: ");
                String nombre = sc.next();
                entrenadores.add(new Entrenador(nombre));
                System.out.println(nombre + " Se registo correctamente como tu entrenador numero " + entrenadores.size());
                break;
            case "2":
                listaEntrenadores();
                break;
            case "3":
                seleccionarEntrenador();
                break;
            case "4":
                return;
            default:
                System.out.println("Opcion no valida, ingresa de nuevo otra opcion");
        }

    }

    public static void listaEntrenadores() {
        if (entrenadores.isEmpty()) {
            System.out.println("No hay entrenadores, dirigite al menu y registra uno nuevo");
        } else {
            for (int i = 0; i < entrenadores.size(); i++) {
                System.out.println((i+1)+". "+entrenadores.get(i).getNombre());
            }
        }
    }

    public static void seleccionarEntrenador() {
        if (entrenadores.isEmpty()) {
            System.out.println("No tienes entrenadores registrados, vuelve al menú");
        }else{
            listaEntrenadores();
            System.out.println("Elige el numero de entrenador segun el orden mostrado");
            int numEntre=sc.nextInt()-1;
            if (numEntre >=0 &numEntre< entrenadores.size()){
                Entrenador entrenadorSeleccionado=entrenadores.get(numEntre);
                gestionarEquipo(entrenadorSeleccionado);
                
               
            }else{
                System.out.println("El numero de entrenador no existe");
            }
        }
    }
    
    private static void gestionarEquipo(Entrenador entrenador) {
        while (true) {
            System.out.println("=============Gestionar Equipo=============");
            System.out.println("1.Ver equipo de Pokemones");
            System.out.println("2.Agregar pokemon al equipo");
            System.out.println("3.Entrenar pokemon");
            System.out.println("4.Volver a gestionar entrenadores");
            String op = sc.next();
            switch (op) {
                case "1":
                    verEquipo(entrenador);
                    break;
                case "2":
                    agregarPokemonAlEquipo(entrenador);
                    break;
                case "3":
                    entrenarPokemon(entrenador);
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Opcion no valida, ingrese de unevo otra opcion");
            }
        }
        
    }
    private static void verEquipo(Entrenador entrenador){
        List<Pokemon> equipo=entrenador.getPokemones();
        if (equipo.isEmpty()) {
            System.out.println("El equipo esta vacio");
        } else {
            for (Pokemon pokemon : equipo) {
                System.out.println(pokemon.getNombre());
            }
        }

    }

    private static void agregarPokemonAlEquipo(Entrenador entrenador) {
        System.out.println("Agregar un nuevo Pokemon al equipo de " + entrenador.getNombre());
        for (int i = 0; i < pokemones.size(); i++) {
            Pokemon pokemon = pokemones.get(i);
            System.out.println((i + 1) + ". " + pokemon.getNombre() + "\nTipo: " + pokemon.getTipo() + "\nSalud: " + pokemon.getSalud() + "\nAtaque: " + pokemon.getPuntosDeAtaque());
        }
        System.out.println("Selecciona un Pokemon por numero");
        int numPok = sc.nextInt() - 1;
        if (numPok >= 0 & numPok < pokemones.size()) {
            entrenador.getPokemones().add(pokemones.get(numPok));
            System.out.println("Pokemon añadido con exito a tu equipo");
        }else{
            System.out.println("Numero de pokemon invalido");
        }
    }
    private static void entrenarPokemon(Entrenador entrenador){
        List<Pokemon>equipo=entrenador.getPokemones();
        if(equipo.isEmpty()){
            System.out.println("El equipo esta vacio");
        }else{
            System.out.println("Selecciona el pokemon que quieres que sea Entrenado por el profesor Oak");
            for(int i=0; i<equipo.size();i++){
                Pokemon pokemon=equipo.get(i);
                System.out.println((i + 1) + ". " + pokemon.getNombre() + "\nSalud: " + pokemon.getSalud() + "\nAtaque: " + pokemon.getPuntosDeAtaque());
            }
            System.out.println("Elige el pokemon segun el numero que lo acompañe");
            int numPokEntren=sc.nextInt()-1;
            if(numPokEntren>=0&numPokEntren<equipo.size()){
                Pokemon pokemonSeleccionado=equipo.get(numPokEntren);
                pokemonSeleccionado.entrenar();
                System.out.println(pokemonSeleccionado.getNombre()+" Fue seleccionado para entrenar."+"\nNueva salud: "+pokemonSeleccionado.getSalud()+"\n Nuevo Puntos de ataque: "+pokemonSeleccionado.getPuntosDeAtaque());
            }else{
                System.out.println("Pokemon no existe");
            }
        }
    }
    private static void gestionarPokemones(){
        while(true){
            System.out.println("""
                           
                           ==========Estas en: Gestionar Pokemones==========""");
            System.out.println("1. Ver todos los pokemones registrados");
            System.out.println("2. Registrar nuevo Pokemon");
            System.out.println("3. Volver al menu principal");
            String op=sc.next();
            switch(op){
                case "1":
                    verPokemonesRegistrados();
                    break;
                case "2":
                    registrarNuevoPokemon();
                    break;
                case "3":
                    return;
                default:
                    System.out.println("Opcion no valida");
                
            }
        }
    }
    private static void verPokemonesRegistrados(){
        System.out.println("Estos son los pokemones registrados: ");
        for(int i =0; i<pokemones.size();i++){
            Pokemon pokemon =pokemones.get(i);
            System.out.println((i + 1) + "- " + pokemon.getNombre() + "\nTipo: " + pokemon.getTipo() + "\nSalud: " + pokemon.getSalud() + "\nAtaque: " + pokemon.getPuntosDeAtaque());
        }
    }
    private static void registrarNuevoPokemon(){
        System.out.println("Registrar un nuevo Pokemon");
        System.out.print("Ingrese el mote del pokmeon: ");
        String moteNuevoPokemon=sc.next();
        System.out.print("Puntos de salud: ");
        int saludNuevoPokmeon=sc.nextInt();
        System.out.print("Puntos de ataque: ");
        int ataqueNuevoPokemon=sc.nextInt();
        
        TipoPokemon[]tipos=TipoPokemon.values();
        System.out.println("Tipos de pokemon a elegir: ");
        for(int i=0;i<tipos.length;i++){
            System.out.println((i+1)+". "+tipos[i]);
        }
        System.out.print("Selecciona el numero de tipo de pokemon: ");
        int tipoSeleccionado=sc.nextInt()-1;
        TipoPokemon tipo;
        if(tipoSeleccionado>=0&tipoSeleccionado<tipos.length){
            tipo=tipos[tipoSeleccionado];
        }else{
            System.out.println("Numero de tipo no valido. Se le asignara tipo NORMAL por defecto");
            tipo=TipoPokemon.NORMAL;
        }
        Estado estado =Estado.Normal;
        Pokemon nuevoPokemon = new Pokemon(moteNuevoPokemon, saludNuevoPokmeon, ataqueNuevoPokemon, tipo, estado) {};
        pokemones.add(nuevoPokemon);
        System.out.println("Nuevo pokemon registrado a tu pokedex: "+moteNuevoPokemon+" \nSalud: "+saludNuevoPokmeon+"\nAtaque: "+ataqueNuevoPokemon + "\nTipo: "+tipo);
    }
}


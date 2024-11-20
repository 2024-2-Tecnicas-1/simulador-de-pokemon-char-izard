package simulador;
import java.io.File; 
import simulador.util.ArchivoUtil; 
import java.io.IOException;  
import java.util.List;  
import java.util.ArrayList;
import java.util.Arrays;
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
        File archivoEntrenadores = new File("entrenadores.dat");
        
         inicializarPokemones();

    
    if (archivoEntrenadores.exists() && archivoEntrenadores.length() > 0) {
       
        System.out.println("¿Quieres trabajar con los datos guardados o iniciar desde cero?");
        System.out.println("1. Trabajar con los datos guardados.");
        System.out.println("2. Iniciar desde cero.");
        String opcion = sc.next();

        if (opcion.equals("1")) {
           
            List<?> datosCargados = ArchivoUtil.cargarDatos("entrenadores.dat");

            
            if (datosCargados != null) {
                try {
                    
                    List<Entrenador> entrenadoresCargados = (List<Entrenador>) datosCargados;
                    entrenadores.addAll(entrenadoresCargados);
                    System.out.println("Datos cargados correctamente.");
                } catch (ClassCastException e) {
                    System.out.println("Error al cargar los datos. El formato del archivo no es válido.");
                }
            } else {
                System.out.println("No se encontraron datos guardados. Iniciando desde cero.");
                inicializarEntrenadores();
            }
        } else {
            System.out.println("Iniciando desde cero...");
            inicializarEntrenadores();
        }
    } else {
        
        System.out.println("No se encontraron datos guardados. Iniciando desde cero...");
        inicializarEntrenadores();
    }

    
    menuPrincipal();
}
    
private static void inicializarPokemones() {
    
    pokemones.clear();  // Limpia la lista de pokemones antes de agregar los nuevos
    pokemones.add(new Hitmonchan()); // Lucha
    pokemones.add(new Ponyta()); // Fuego
    pokemones.add(new Cubone()); // Tierra
    pokemones.add(new Doduo()); // Normal/Volador
    pokemones.add(new Ekans()); // Veneno
    pokemones.add(new Goldeen()); // Agua
    pokemones.add(new Paras()); // Bicho/Planta
    pokemones.add(new Electrode()); // Electrico
    pokemones.add(new Staryu()); // Agua
    pokemones.add(new Lickitung()); // Normal
}
private static void inicializarEntrenadores() {
    entrenadores.clear();  // Asegura que no haya datos anteriores
    // Aquí se pueden agregar entrenadores predeterminados si se desea
    System.out.println("Iniciando el registro de entrenadores...");
}

    public static void menuPrincipal() {
        while (true) {
            System.out.println("=========Bienvenidos al simulador pokemon=========");
            System.out.println("=================By: Char-izard=================");
            System.out.println("Menu Principal, elige un opcion");
            System.out.println("1. Gestionar Entrenadores");
            System.out.println("2. Gestionar Pokemones");
            System.out.println("3. Iniciar Batalla");
            System.out.println("4. Salir");
            System.out.println("======================================================");
            String op = sc.next();
            switch (op) {
                case "1":
                    gestionarEntrenadores();
                    break;
                case "2":
                    gestionarPokemones();
                    break;
                case "3":
                    iniciarBatalla();
                case "4":
                    // Aquí puedes llamar a la opción de guardar antes de salir
                    System.out.println("¿Quieres guardar los datos antes de salir?");
                    System.out.println("1. Sí");
                    System.out.println("2. No");
                    String guardarDatos = sc.next();
                    if (guardarDatos.equals("1")) {
                        ArchivoUtil.guardarDatos(entrenadores, "entrenadores.dat");
                    }
                    System.out.println("Saliendo del programa...");
                    return; // Salir del programa
                default:
                    System.out.println("Opción no válida, por favor selecciona otra opción.");
            }
        }
    }

    public static void gestionarEntrenadores() {
        System.out.println("""

                =================== Gestionar entrenadores ===================""");
        System.out.println("1. Registrar un nuevo entrenador");
        System.out.println("2. Ver lista de entrenadores");
        System.out.println("3. Seleccionar un entrenador");
        System.out.println("4.Volver al menu principal");
        System.out.println("======================================================");
        String op = sc.next();
        switch (op) {
            case "1":
                System.out.println("============Registrar Entrenador============");
                System.out.println("Digita el nombre del entrenador: ");
                String nombre = sc.next();
                entrenadores.add(new Entrenador(nombre));
                System.out
                        .println(nombre + " Se registo correctamente como tu entrenador numero " + entrenadores.size());
                break;
            case "2":
                listaEntrenadores();
                break;
            case "3":
                seleccionarEntrenador();
                break;
            case "4":
                menuPrincipal();
            default:
                System.out.println("Opcion no valida, ingresa de nuevo otra opcion");
        }

    }

    public static void listaEntrenadores() {
        System.out.println("====================== Entrenadores ==============================");
        if (entrenadores.isEmpty()) {
            System.out.println("No hay entrenadores, dirigite al menu y registra uno nuevo");
        } else {
            for (int i = 0; i < entrenadores.size(); i++) {

                System.out.println((i + 1) + ". " + entrenadores.get(i).getNombre());
            }
        }
    }

    public static void seleccionarEntrenador() {
        if (entrenadores.isEmpty()) {
            System.out.println("No tienes entrenadores registrados, vuelve al menú");
        } else {
            listaEntrenadores();
            System.out.println("Elige el numero de entrenador segun el orden mostrado");
            int numEntre = sc.nextInt() - 1;
            if (numEntre >= 0 & numEntre < entrenadores.size()) {
                Entrenador entrenadorSeleccionado = entrenadores.get(numEntre);
                gestionarEquipo(entrenadorSeleccionado);

            } else {
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
                    gestionarEntrenadores();
                default:
                    System.out.println("Opcion no valida, ingrese de unevo otra opcion");
            }
        }

    }

    private static void verEquipo(Entrenador entrenador) {
        List<Pokemon> equipo = entrenador.getPokemones();
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
            System.out.println((i + 1) + ". " + pokemon.getNombre() + "\nTipo: " + Arrays.toString(pokemon.getTipos())
                    + "\nSalud: " + pokemon.getSalud() + "\nAtaque: " + pokemon.getPuntosDeAtaque());
        }
        System.out.println("Selecciona un Pokemon por numero");
        int numPok = sc.nextInt() - 1;
        if (numPok >= 0 & numPok < pokemones.size()) {
            entrenador.getPokemones().add(pokemones.get(numPok));
            System.out.println("Pokemon añadido con exito a tu equipo");
        } else {
            System.out.println("Numero de pokemon invalido");
        }
    }

    private static void entrenarPokemon(Entrenador entrenador) {
        List<Pokemon> equipo = entrenador.getPokemones();
        if (equipo.isEmpty()) {
            System.out.println("El equipo esta vacio");
        } else {
            System.out.println("Selecciona el pokemon que quieres que sea Entrenado por el profesor Oak");
            for (int i = 0; i < equipo.size(); i++) {
                Pokemon pokemon = equipo.get(i);
                System.out.println((i + 1) + ". " + pokemon.getNombre() + "\nSalud: " + pokemon.getSalud()
                        + "\nAtaque: " + pokemon.getPuntosDeAtaque());
            }
            System.out.println("Elige el pokemon segun el numero que lo acompañe");
            int numPokEntren = sc.nextInt() - 1;
            if (numPokEntren >= 0 & numPokEntren < equipo.size()) {
                Pokemon pokemonSeleccionado = equipo.get(numPokEntren);
                pokemonSeleccionado.entrenar();
                System.out.println(pokemonSeleccionado.getNombre() + " Fue seleccionado para entrenar."
                        + "\nNueva salud: " + pokemonSeleccionado.getSalud() + "\n Nuevo Puntos de ataque: "
                        + pokemonSeleccionado.getPuntosDeAtaque());
            } else {
                System.out.println("Pokemon no existe");
            }
        }
    }

    private static void gestionarPokemones() {
        while (true) {
            System.out.println("""

                    ==========Estas en: Gestionar Pokemones==========""");
            System.out.println("1. Ver todos los pokemones registrados");
            System.out.println("2. Registrar nuevo Pokemon");
            System.out.println("3. Volver al menu principal");
            System.out.println("======================================================");
            String op = sc.next();
            switch (op) {
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

    private static void verPokemonesRegistrados() {
        System.out.println("======================================================");
        System.out.println("Estos son los pokemones registrados: ");
        for (int i = 0; i < pokemones.size(); i++) {
            Pokemon pokemon = pokemones.get(i);
            System.out.println((i + 1) + "- " + pokemon.getNombre() + "\nTipo: " + Arrays.toString(pokemon.getTipos())
                    + "\nSalud: " + pokemon.getSalud() + "\nAtaque: " + pokemon.getPuntosDeAtaque());
        }
    }

    private static void registrarNuevoPokemon() {
        System.out.println("======================================================");
        System.out.println("Registrar un nuevo Pokemon");
        System.out.print("Ingrese el mote del pokmeon: ");
        String moteNuevoPokemon = sc.next();
        System.out.print("Puntos de salud: ");
        int saludNuevoPokmeon = sc.nextInt();
        System.out.print("Puntos de ataque: ");
        int ataqueNuevoPokemon = sc.nextInt();

        TipoPokemon[] tipos = TipoPokemon.values();
        System.out.println("Tipos de pokemon a elegir: ");
        for (int i = 0; i < tipos.length; i++) {
            System.out.println((i + 1) + ". " + tipos[i]);
        }
        System.out.print("Selecciona el numero de tipo de pokemon: ");

        int tipoSeleccionado=sc.nextInt()-1;
        TipoPokemon tipo1;
        TipoPokemon tipo2;
        if(tipoSeleccionado>=0&tipoSeleccionado<tipos.length){
            tipo1=tipos[tipoSeleccionado];
            tipo2=tipos[tipoSeleccionado];
        }else{
            System.out.println("Numero de tipo no valido. Se le asignara tipo NORMAL por defecto");
            tipo1=TipoPokemon.NORMAL;
            tipo2=TipoPokemon.NORMAL;
        }
        Estado estado =Estado.Normal;
        Pokemon nuevoPokemon = new Pokemon(moteNuevoPokemon, saludNuevoPokmeon, ataqueNuevoPokemon, tipo1,tipo2, estado) {};
        pokemones.add(nuevoPokemon);
        System.out.println("Nuevo pokemon registrado a tu pokedex: "+moteNuevoPokemon+" \nSalud: "+saludNuevoPokmeon+"\nAtaque: "+ataqueNuevoPokemon + "\nTipo: "+tipo1+" "+tipo2);

      
       
        
        pokemones.add(nuevoPokemon);
        System.out.println("Nuevo pokemon registrado a tu pokedex: " + moteNuevoPokemon + " \nSalud: "
                + saludNuevoPokmeon + "\nAtaque: " + ataqueNuevoPokemon + "\nTipo: " + tipos);

    }

    public static void iniciarBatalla() {
        if (entrenadores.size() <= 1) {
            System.out.println("Deben haber minimo 2 entrenadores para hacer una batalla");
        } else {
            System.out.println("Seleccione el primer entrenador: ");
            Entrenador oponente1 = seleEntrenadorBatalla();
            if (oponente1 == null)
                return;
            System.out.println("Selecciona el segundo entrenador: ");
            Entrenador oponente2 = seleEntrenadorBatalla();
            if (oponente2 == null)
                return;
            System.out.println(oponente1.getNombre() + " Selecciona tu pokemon: ");
            Pokemon pokemon1 = seleccionarPokemonOp(oponente1);
            if (pokemon1 == null)
                return;
            System.out.println(oponente2.getNombre() + " Selecciona tu pokemon");
            Pokemon pokemon2 = seleccionarPokemonOp(oponente2);
            if (pokemon2 == null)
                return;

            System.out.println("Preparen sus asientos por que la batalla entre " + pokemon1.getNombre() + " y"
                    + pokemon2.getNombre() + " va a empezar!");
            Batalla batalla = new Batalla();
            batalla.iniciarBatalla(pokemon1, pokemon2);
        }
    }

    private static Entrenador seleEntrenadorBatalla() {
        listaEntrenadores();
        System.out.println("Selecciona el entrenador por su numero: ");
        int numOponente = sc.nextInt() - 1;
        if (numOponente >= 0 && numOponente < entrenadores.size()) {
            return entrenadores.get(numOponente);
        } else {
            System.out.println("Numero de entrenador no valido");
            return null;
        }
    }

    private static Pokemon seleccionarPokemonOp(Entrenador entrenador) {
        List<Pokemon> equipo = entrenador.getPokemones();
        for (int i = 0; i < equipo.size(); i++) {
            Pokemon pokemon = equipo.get(i);
            System.out.println((i + 1) + "- " + pokemon.getNombre() + "\nSalud: " + pokemon.getSalud() + "\nAtaque: "
                    + pokemon.getPuntosDeAtaque());
        }
        System.out.print("Selecciona un pokemon por numero: ");
        int numPoke = sc.nextInt() - 1;
        if (numPoke >= 0 & numPoke < equipo.size()) {
            return equipo.get(numPoke);
        } else {
            System.out.println("Nuemro de pokemon no valido.");
            return null;
        }

    }
}

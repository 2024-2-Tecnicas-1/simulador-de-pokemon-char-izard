package simulador.pokemon;
<<<<<<< HEAD

=======
>>>>>>> origin/master

public abstract class Pokemon {

    private String nombre;
    private int salud;
    private int puntosDeAtaque;
    private TipoPokemon tipo1;
    private TipoPokemon tipo2;
    private Estado estado;

<<<<<<< HEAD
=======
    public Pokemon(String nombre, int salud, int puntosDeAtaque, TipoPokemon tipo1, Estado estado) {
        this(nombre, salud, puntosDeAtaque, tipo1, null, estado);
    }

>>>>>>> origin/master
    public Pokemon(String nombre, int salud, int PuntosDeAtaque, TipoPokemon tipo1, TipoPokemon tipo2, Estado estado) {
        this.nombre = nombre;
        this.salud = salud;
        this.puntosDeAtaque = PuntosDeAtaque;
        this.tipo1 = tipo1;
        this.tipo2 = tipo2;
        this.estado = estado;
    }

    public void atacar(Pokemon oponente) {
        // Se obtiene el multiplicador de daño usando los tipos del atacante y el
        // defensor
        double multiplicador = TipoPokemon.obtenerMultiplicadorDeDaño(this.tipo1, this.tipo2, oponente.getTipo1(),
                oponente.getTipo2());

        // Se calcula el daño
        int daño = (int) (this.puntosDeAtaque * multiplicador);

        // El oponente recibe el daño
        oponente.recibirDaño(daño);

        // Se imprime la información del ataque
        System.out.println(this.nombre + " ataca a " + oponente.getNombre() + " causando " + daño + " de daño.");
    }

    public void recibirDaño(int daño) {
        this.salud -= daño;
    }

    public void entrenar() {
        this.salud = salud + 10;
        this.puntosDeAtaque = puntosDeAtaque + 3;
    }

    public String getNombre() {
        return nombre;
    }

    public int getSalud() {
        return salud;
    }

    public int getPuntosDeAtaque() {
        return puntosDeAtaque;
    }

    public TipoPokemon getTipo1() {
        return tipo1;
    }

    public TipoPokemon getTipo2() {
        return tipo2;
    }

    public TipoPokemon[] getTipos() {
        if (tipo2 != null) {
            return new TipoPokemon[] { tipo1, tipo2 }; // Si tiene dos tipos
        } else {
            return new TipoPokemon[] { tipo1 }; // Si solo tiene un tipo
        }
    }

    public Estado getEstado() {
        return estado;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }

    public void setPuntosDeAtaque(int puntosDeAtaque) {
        this.puntosDeAtaque = puntosDeAtaque;
    }

    public void setTipo1(TipoPokemon tipo1) {
        this.tipo1 = tipo1;
    }

    public void seTipo2(TipoPokemon tipo2) {
        this.tipo2 = tipo2;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

}
<<<<<<< HEAD

=======
>>>>>>> origin/master

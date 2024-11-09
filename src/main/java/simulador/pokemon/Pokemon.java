package simulador.pokemon;

public abstract class Pokemon {

    private String nombre;
    private int salud;
    private int puntosDeAtaque;
    private TipoPokemon tipo;
    private Estado estado;

    public Pokemon(String nombre, int salud, int puntosDeAtaque, TipoPokemon tipo, Estado estado) {
        this.nombre = nombre;
        this.salud = salud;
        this.puntosDeAtaque = puntosDeAtaque;
        this.tipo = tipo;
        this.estado = estado;
    }

    public void atacar(Pokemon oponente) {
        int daño = oponente.getPuntosDeAtaque() - oponente.getSalud();
        if (daño < 0) {
            daño = 0;
        }
        oponente.recibirDaño(daño);
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

    public TipoPokemon getTipo() {
        return tipo;
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

    public void setTipo(TipoPokemon tipo) {
        this.tipo = tipo;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

}

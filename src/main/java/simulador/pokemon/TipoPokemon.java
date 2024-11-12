package simulador.pokemon;

public enum TipoPokemon {
    FUEGO,AGUA,PLANTA,VENENO,ELECTRICO,PSIQUICO,ROCA,TIERRA,NORMAL,VOLADOR,HADA,LUCHA,ACERO,BICHO,HIELO,FANTASMA;
    

    
    
    
   
    

  public static double obtenerMultiplicadorDeDaño(TipoPokemon atacante, TipoPokemon defensor) {
    // Lógica para calcular el multiplicador entre un atacante y un defensor con un solo tipo
    return calcularMultiplicador(atacante, defensor);

}

public static double obtenerMultiplicadorDeDaño(TipoPokemon atacante1, TipoPokemon atacante2, TipoPokemon defensor1, TipoPokemon defensor2) {
    // Lógica para calcular el multiplicador entre un atacante con dos tipos y un defensor con dos tipos
    double multiplicadorTotal = 1.0;

    multiplicadorTotal *= calcularMultiplicador(atacante1, defensor1);
    if (atacante2 != null) {
        multiplicadorTotal *= calcularMultiplicador(atacante2, defensor1);
    }
    multiplicadorTotal *= calcularMultiplicador(atacante1, defensor2);
    if (atacante2 != null) {
        multiplicadorTotal *= calcularMultiplicador(atacante2, defensor2);
    }

    return multiplicadorTotal;
}
    
    
   public static double calcularMultiplicador(TipoPokemon atacante, TipoPokemon defensor){
       if (defensor == null)return 1.0;
       switch (atacante){
           case FUEGO:
               if (defensor == PLANTA|| defensor== BICHO) return 2.0;
               if (defensor == AGUA || defensor == TIERRA) return 0.5;
               break;
           case AGUA:
               if (defensor == FUEGO || defensor == TIERRA)return 2.0;
               if (defensor == PLANTA || defensor == ELECTRICO) return 0.5;
               break;
           case PLANTA:
               if(defensor == AGUA || defensor == TIERRA)return 2.0;
               if (defensor == FUEGO || defensor == BICHO)return 0.5;
           case ELECTRICO:
               if (defensor == AGUA || defensor == VOLADOR)return 2.0;
               if (defensor == TIERRA)return 0.0;
               break;
           case TIERRA:
               if(defensor == FUEGO || defensor == ELECTRICO)return 2.0;
               if(defensor == PLANTA ) return 0.5;
               break;
           case VOLADOR:
               if(defensor == PLANTA || defensor == BICHO || defensor == LUCHA)return 2.0;
               if(defensor== ELECTRICO)return 0.5;
               break;
           case LUCHA:
               if(defensor == NORMAL || defensor == HIELO || defensor == ROCA)return 2.0;
               if (defensor == VOLADOR || defensor == VENENO)return 0.5;
               break;
           case VENENO:
               if (defensor == PLANTA)return 2.0;
               if (defensor == VENENO || defensor == TIERRA || defensor == ROCA || defensor == FUEGO) return 0.5;
               break;
           case NORMAL:
           default:
               return 1.0;
       }
       return 1.0;
   
   }
        
}
 
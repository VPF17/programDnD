import java.util.Map;

public class Herida{
    // Puntos de golpe que quita actualmente la herida.
    int puntos_de_danyo;
    // Puntos de sanación acumulados que no son suficientes para curar un punto de golpe más.
    int puntos_de_sanacion_acumulados;
    // Tipo de daño de la herida.
    TipoDanyo tipo_danyo;

    static Map<TipoDanyo, String> texto_danyos;
    static{
        texto_danyos.put(TipoDanyo.ACIDO, "por ácido");
        texto_danyos.put(TipoDanyo.CONTUNDENTE, "contundente");
        texto_danyos.put(TipoDanyo.CORTANTE, "cortante");
        texto_danyos.put(TipoDanyo.ELECTRICO, "eléctrico");
        texto_danyos.put(TipoDanyo.FRIO, "por frío");
        texto_danyos.put(TipoDanyo.FUEGO, "por fuego");
        texto_danyos.put(TipoDanyo.FUERZA, "por fuerza");
        texto_danyos.put(TipoDanyo.NECROTICO, "necrótico");
        texto_danyos.put(TipoDanyo.PERFORANTE, "perforante");
        texto_danyos.put(TipoDanyo.PSIQUICO, "psíquico");
        texto_danyos.put(TipoDanyo.RADIANTE, "radiante");
        texto_danyos.put(TipoDanyo.SONICO, "sónico");
        texto_danyos.put(TipoDanyo.VENENO, "por veneno");
    }

    // Mapa en el que se guardan los puntos de sanación necesarios para curar
    // un punto de golpe en función del tipo de daño.
    // ACTUALÍCESE
    static Map<TipoDanyo, Integer> puntos_de_sanacion_por_punto_de_golpe;
    static{
        puntos_de_sanacion_por_punto_de_golpe.put(TipoDanyo.ACIDO, 72);
        puntos_de_sanacion_por_punto_de_golpe.put(TipoDanyo.CONTUNDENTE, 72);
        puntos_de_sanacion_por_punto_de_golpe.put(TipoDanyo.CORTANTE, 72);
        puntos_de_sanacion_por_punto_de_golpe.put(TipoDanyo.ELECTRICO, 72);
        puntos_de_sanacion_por_punto_de_golpe.put(TipoDanyo.FRIO, 72);
        puntos_de_sanacion_por_punto_de_golpe.put(TipoDanyo.FUEGO, 72);
        puntos_de_sanacion_por_punto_de_golpe.put(TipoDanyo.FUERZA, 72);
        puntos_de_sanacion_por_punto_de_golpe.put(TipoDanyo.NECROTICO, 72);
        puntos_de_sanacion_por_punto_de_golpe.put(TipoDanyo.PERFORANTE, 72);
        puntos_de_sanacion_por_punto_de_golpe.put(TipoDanyo.PSIQUICO, 72);
        puntos_de_sanacion_por_punto_de_golpe.put(TipoDanyo.RADIANTE, 72);
        puntos_de_sanacion_por_punto_de_golpe.put(TipoDanyo.SONICO, 72);
        puntos_de_sanacion_por_punto_de_golpe.put(TipoDanyo.VENENO, 72);
    }

    void curar(int puntos_de_sanacion){
        // Sumamos los puntos de sanación acumulados.
        puntos_de_sanacion += puntos_de_sanacion_acumulados;
        // Curamos los puntos de daño correspondientes.
        puntos_de_danyo -= puntos_de_sanacion / puntos_de_sanacion_por_punto_de_golpe.get(tipo_danyo);
        // Actualizamos los puntos de sanación acumulados.
        puntos_de_sanacion_acumulados = puntos_de_sanacion % puntos_de_sanacion_por_punto_de_golpe.get(tipo_danyo);
    }

    String a_texto(){
        String texto = "Herida de " + puntos_de_danyo + " puntos de daño " + texto_danyos.get(tipo_danyo) +
            ". Hay " + puntos_de_sanacion_acumulados + " puntos de sanacion acumulados."; 
        return texto;
    }
}

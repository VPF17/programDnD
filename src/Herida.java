public class Herida {
    // Puntos de golpe que quita actualmente la herida.
    int puntos_de_danyo;
    // Puntos de sanación acumulados que no son suficientes para curar un punto de golpe más.
    int puntos_de_sanacion_acumulados;
    // Tipo de daño de la herida.
    TipoDanyo tipo_danyo;

    void curar(int puntos_de_sanacion){
        switch(tipo_danyo){
            case ACIDO:
                
                break;
        }
    }

    String a_texto(){
        String texto = "Herida de " + puntos_de_danyo + " puntos de daño ";
        switch(tipo_danyo){
            case ACIDO:
                texto += "por acido";
                break;
            case CORTANTE:
                texto += "cortante";
                break;
            case PERFORANTE:
                texto += "perforante";
                break;
        }

        texto += ". Hay " + puntos_de_sanacion_acumulados + " puntos de sanacion acumulados."; 
        return texto;
    }
}

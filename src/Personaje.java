import java.util.ArrayList;

public class Personaje {
    // Nombre del personaje.
    String nombre;
    // Vida en el instante actual.
    int puntos_de_golpe_actuales;
    // Vida máxima (teniendo en cuenta daño necrótico).
    int puntos_de_golpe_maximos;
    // Vida máxima (sin tener en cuenta daño necrótico).
    int puntos_de_golpe_maximos_absolutos;
    // Array de dimensión variable en el que guardamos todas las heridas.
    ArrayList<Herida> heridas;

    void curar(int puntos_de_sanacion)
    {
        // Aplicamos los puntos de sanación a todas las heridas.
        for(Herida herida: heridas){
            herida.curar(puntos_de_sanacion);
        }

        // Eliminamos heridas ya curadas.
        // Para ello, primero encontramos los índices a eliminar.
        ArrayList<Integer> indices_a_eliminar = new ArrayList<Integer>();
        for (int i = heridas.size() - 1; i >= 0; i--){
            if (heridas.get(i).puntos_de_danyo <= 0){
                indices_a_eliminar.add(i);
            }
        }
        // Ahora, eliminamos los elementos concretos.
        for (int i = 0; i < indices_a_eliminar.size(); i++){
            heridas.remove(indices_a_eliminar.get(i).intValue());
        }

        // Actualizamos el valor de la vida actual.
        
    }

    String a_texto(){
        String texto = "COMIENZA PERSONAJE\nNombre: " + nombre +
            ".\n\tPuntos de golpe actuales: " + puntos_de_golpe_actuales +
            ".\n\tPuntos de golpe máximos: " + puntos_de_golpe_maximos +
            ".\n\tPuntos de golpe máximos absolutos: " + puntos_de_golpe_maximos_absolutos +
            ".\n\tHeridas:\n";
        for (Herida herida: heridas){
            texto += "\t\t" + herida.a_texto() + "\n";
        }
        texto += "FINALIZA PERSONAJE.";
        return texto;
    }
}

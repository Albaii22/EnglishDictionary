package net.englishdictionary;
import java.util.*;

public class Diccionario {
    private Map<Character, Set<String>> diccionario;

    public void WordDictionary() {
        diccionario = new HashMap<>();
    }

    public void agregarPalabra(String palabra) {
        String palabraSanitizada = sanitizarPalabra(palabra);
        char inicial = palabraSanitizada.charAt(0);

        if (!diccionario.containsKey(inicial)) {
            diccionario.put(inicial, new HashSet<>());
        }

        Set<String> palabras = diccionario.get(inicial);
        palabras.add(palabraSanitizada);
        System.out.println("La palabra se ha guardado correctamente.");
    }

    public void eliminarPalabra(String palabra) {
        String palabraSanitizada = sanitizarPalabra(palabra);
        char inicial = palabraSanitizada.charAt(0);

        if (diccionario.containsKey(inicial)) {
            Set<String> palabras = diccionario.get(inicial);
            if (palabras.remove(palabraSanitizada)) {
                System.out.println("La palabra se ha eliminado correctamente.");
            } else {
                System.out.println("La palabra no estaba almacenada.");
            }
        } else {
            System.out.println("La palabra no estaba almacenada.");
        }
    }

    public void buscarPalabra(String palabra) {
        String palabraSanitizada = sanitizarPalabra(palabra);
        char inicial = palabraSanitizada.charAt(0);

        if (diccionario.containsKey(inicial)) {
            Set<String> palabras = diccionario.get(inicial);
            if (palabras.contains(palabraSanitizada)) {
                System.out.println("La palabra se ha encontrado.");
            } else {
                System.out.println("La palabra no se ha encontrado.");
            }
        } else {
            System.out.println("La palabra no se ha encontrado.");
        }
    }

    public void mostrarInicialesDisponibles() {
        System.out.println("Iniciales disponibles:");

        List<Character> iniciales = new ArrayList<>(diccionario.keySet());
        Collections.sort(iniciales);

        for (char inicial : iniciales) {
            System.out.println(inicial);
        }
    }

    public void mostrarPalabrasPorInicial(char inicial) {
        inicial = Character.toLowerCase(inicial);

        if (diccionario.containsKey(inicial)) {
            System.out.println("Palabras que empiezan con '" + inicial + "':");

            Set<String> palabras = diccionario.get(inicial);
            for (String palabra : palabras) {
                System.out.println(palabra);
            }
        } else {
            System.out.println("No hay palabras almacenadas que empiecen con '" + inicial + "'.");
        }
    }

    private String sanitizarPalabra(String palabra) {
        return palabra.trim().toLowerCase();
    }

}

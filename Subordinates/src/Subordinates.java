import java.util.*;
import java.io.*;//clases que permiten leer la entrada mucho más rápido que Scanner

public class Subordinates {
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // Número de empleados
        
        int[] parent = new int[n + 1]; // Guarda padre de cada nodo
        int[] childCount = new int[n + 1]; // Cantidad de hijos pendientes
        int[] sub = new int[n + 1];// Resultado final de subordinados
        
          StringTokenizer st = new StringTokenizer(br.readLine()); // Lee línea de jefes

        for (int i = 2; i <= n; i++) {
            parent[i] = Integer.parseInt(st.nextToken()); // Padre del empleado i
            childCount[parent[i]]++; // Incrementa hijos del padre

        }    

        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {// Agrega hojas iniciales
            if (childCount[i] == 0) {// Nodo sin hijos
                queue.add(i);
            }
        }
   
        while (!queue.isEmpty()) {// Procesa desde las hojas hacia arriba
            int u = queue.poll(); // Nodo actual
   
        int p = parent[u];// Padre del nodo actual
            if (p != 0) { // la raíz no tiene padre
                sub[p] += 1 + sub[u];// Suma subordinados al padre
                childCount[p]--;// Reduce hijos pendientes
         
        if (childCount[p] == 0) { // Si ya procesó todos sus hijos
                    queue.add(p);
                }
            }
        }
        StringBuilder out = new StringBuilder();// Construye salida
        for (int i = 1; i <= n; i++) {// Agrega resultados
            out.append(sub[i]).append(" ");
        }
        
        System.out.println(out);// Imprime resultado
    }
}

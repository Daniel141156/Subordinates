package subordinates;
import java.util.*;


public class Subordinates {
     static List<Integer>[] tree;//Arbol que guarda los hijos
    static int[] subordinates;//cantidad de subordinados por empleado
 static void dfs(int node) {//cuenta subordinados
        subordinates[node] = 0;//contador
         for (int child : tree[node]) {//recorre hijos del nodo
            dfs(child);//recursividad mientras procesa el hijo
            subordinates[node] += 1 + subordinates[child];//suma: hijo+subordinados del hijo
        }
  
          }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();//numero de empleados
        tree = new ArrayList[n + 1];
        subordinates = new int[n + 1];
          for (int i = 1; i <= n; i++)//inicializa las listas
            tree[i] = new ArrayList<>();
           for (int i = 2; i <= n; i++) {//construyre el arbol
            int boss = sc.nextInt();//jefe directo
            tree[boss].add(i);//agrega el empleado al jefe
        }
           dfs(1);
            for (int i = 1; i <= n; i++)//imprime resultados
            System.out.print(subordinates[i] + " ");
    }
}

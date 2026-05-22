package subordinates;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

class Node {
    long data;
    List<Node> children;//lista de hijos 
    Node(long x) {//constructor del nodo
        data = x;
        children = new ArrayList<>();//se inicializa la lista de hijos vacia
    }
    
    Node get(long p) {//busca un nodo con el dato "p"
        if (p == data)
            return this;//si el nodo actual es el que se busca, retorna ese nodo
        for (Node node : children)
            return node.get(p);
        return null;//si no lo encuentra retorna null
    }
}
public class Subordinates {

     static void addChild(Node parent, Node child) {//agrega un hijo a un nodo padre
        if (parent == null) return;//si no existe no pasa nada
        parent.children.add(child);//agrega el hijo a la lista de hijos
    }
      static void printParents(Node node, Node parent) {
        if (parent == null)//si el padre es null, es la raíz
            System.out.println(node.data + " -> NULL");
        else
            System.out.println(node.data + " -> " + parent.data);

        for (Node child : node.children)//se recorren los hijos, recursivamente
            printParents(child, node);
    }
       static void printChildren(Node node) {
        System.out.print(node.data + " -> ");
        for (Node child : node.children)
            System.out.print(child.data + " ");
        System.out.println();

        for (Node child : node.children)
            printChildren(child);
    }
       static void printLeafNodes(Node node) {
        if (node.children.isEmpty()) {//si no tiene hijos es una hoja
            System.out.print(node.data + " ");//imprime el nodo
            return;
        }
        for (Node child : node.children)//se recorre en los hijos buscando hojas
            printLeafNodes(child);
    }
       static void printDegrees(Node node, Node parent) {//el grado inicial es la cantidad de hijos
        int degree = node.children.size();
        if (parent != null)
            degree++;//si tiene padre suma 1
        System.out.println(node.data + " -> " + degree);//imprime el grado

        for (Node child : node.children)//otra vez se recorren hijos recursivamente
            printDegrees(child, node);
    }
       
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();//lee la cantidad de nodos

        Node root = new Node(1);//Crea la raíz del árbol
        for (long i = 2; i <= n; i++) {//construye el arbol, crea el nodo, lee su padre y agrega el nodo como hijo
            Node node = new Node(i);
            long idParent = sc.nextLong();
            addChild(root.get(idParent), node); 
        }

        System.out.println("Parents of each node:");
        printParents(root, null);

        System.out.println("Children of each node:");
        printChildren(root);

        System.out.print("Leaf nodes: ");
        printLeafNodes(root);
        System.out.println();

        System.out.println("Degrees of nodes:");
        printDegrees(root, null);
    }       
}

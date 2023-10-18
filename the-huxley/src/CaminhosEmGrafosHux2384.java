import java.io.*;
import java.util.*;

public class CaminhosEmGrafosHux2384 {
  static int[][] grafico;
    static boolean[] visitado;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int P = sc.nextInt();
        grafico = new int[V][V];
        visitado = new boolean[V];
        
        for (int i = 0; i < P; i++) {
            int V1 = sc.nextInt();
            int V2 = sc.nextInt();
            grafico[V1][V2] = grafico[V2][V1] = 1;
        }
        
        int S = sc.nextInt();
        int D = sc.nextInt();
        boolean existsPath = dfs(S, D);
        
        if (existsPath) {
            System.out.println("EXISTE");
        } else {
            System.out.println("NAO EXISTE");
        }
    }
    
    public static boolean dfs(int curr, int dest) {
        if (curr == dest) {
            return true;
        }
        
        visitado[curr] = true;
        for (int i = 0; i < grafico[curr].length; i++) {
            if (grafico[curr][i] == 1 && !visitado[i]) {
                boolean foundPath = dfs(i, dest);
                if (foundPath) {
                    return true;
                }
            }
        }
        return false;
    }
}
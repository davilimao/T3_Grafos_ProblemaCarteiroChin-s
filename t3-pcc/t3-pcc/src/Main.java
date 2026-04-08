
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        In in = new In("C:/Users/jaime/Downloads/t3-pcc/t3-pcc/out/production/t3-pcc/dados/entrada_eulerizada.txt");

        int V = in.readInt();
        int E = in.readInt();

        Digraph G = new Digraph(V);

        int[] indegree = new int[V];
        int[] outdegree = new int[V];

        ST<String, Integer> map = new ST<>();
        String[] keys = new String[V];
        int index = 0;

        // 🔥 Agora usando Queue do algs4
        Map<String, Queue<DirectedEdge>> edgeMap = new HashMap<>();

        // -------------------------------
        // 📥 Leitura
        // -------------------------------
        for (int i = 0; i < E; i++) {

            String v = in.readString();
            String w = in.readString();
            int peso = in.readInt();

            if (!map.contains(v)) {
                map.put(v, index);
                keys[index] = v;
                index++;
            }

            if (!map.contains(w)) {
                map.put(w, index);
                keys[index] = w;
                index++;
            }

            int vi = map.get(v);
            int wi = map.get(w);

            G.addEdge(vi, wi);

            outdegree[vi]++;
            indegree[wi]++;

            DirectedEdge edge = new DirectedEdge(vi, wi, peso);

            String key = vi + "-" + wi;

            edgeMap.putIfAbsent(key, new Queue<>());
            edgeMap.get(key).enqueue(edge); // 🔥 enqueue no lugar de add
        }

        // -------------------------------
        // 📊 Graus
        // -------------------------------
        StdOut.println("Graus dos vértices:\n");

        boolean balanceado = true;

        for (int i = 0; i < V; i++) {

            StdOut.println(keys[i] +
                    " -> entrada: " + indegree[i] +
                    ", saída: " + outdegree[i]);

            if (indegree[i] != outdegree[i]) {
                balanceado = false;
            }
        }

        // -------------------------------
        // ✔️ Verificação
        // -------------------------------
        StdOut.println("\nGrafo balanceado? " + balanceado);

        if (!balanceado) {
            StdOut.println("Não possui circuito euleriano.");
            return;
        }

        // -------------------------------
        // 🔁 Euleriano
        // -------------------------------
        DirectedEulerianCycle euler = new DirectedEulerianCycle(G);

        if (!euler.hasEulerianCycle()) {
            StdOut.println("Não possui circuito euleriano.");
            return;
        }

        // -------------------------------
        // 📌 Caminho + custo
        // -------------------------------
        int custoTotal = 0;
        Integer prev = null;

        StdOut.println("\nCircuito Euleriano:");

        for (int v : euler.cycle()) {

            StdOut.print(keys[v] + " ");

            if (prev != null) {

                String key = prev + "-" + v;

                DirectedEdge edge = edgeMap.get(key).dequeue(); // 🔥 dequeue no lugar de poll

                custoTotal += edge.weight();
            }

            prev = v;
        }

        StdOut.println("\n\nCusto total: " + custoTotal);
    }
}
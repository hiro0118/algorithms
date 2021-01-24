import main.kotlin.dijkstra.Graph
import main.kotlin.dijkstra.dijkstra
import org.junit.jupiter.api.Test

internal class DijkstraKtTest {
    @Test
    fun testDijkstra() {
        val graph = Graph.Builder()
                .addVertex("A")
                .addVertex("S")
                .addVertex("B")
                .addVertex("C")
                .addVertex("D")
                .addVertex("E")
                .addVertex("F")
                .addVertex("G")
                .addEdge("S", "A", 5)
                .addEdge("S", "B", 4)
                .addEdge("S", "C", 1)
                .addEdge("A", "D", 2)
                .addEdge("B", "C", 2)
                .addEdge("B", "D", 5)
                .addEdge("B", "E", 6)
                .addEdge("D", "F", 1)
                .addEdge("D", "G", 3)
                .addEdge("E", "G", 2)
                .build()

        val result1 = dijkstra(graph, "S", "G")
        println("==== result (S->G) ====")
        for (vertex in result1) {
            println(vertex)
        }
        val result2 = dijkstra(graph, "S", "F")
        println("==== result (S->F) ====")
        for (vertex in result2) {
            println(vertex)
        }
    }

    @Test
    fun testDijkstra2() {
        val graph = Graph.Builder()
                .addVertex("S")
                .addVertex("A")
                .addVertex("B")
                .addVertex("C")
                .addVertex("D")
                .addVertex("E")
                .addVertex("F")
                .addVertex("G")
                .addVertex("H")
                .addEdge("S", "A", 1)
                .addEdge("S", "B", 2)
                .addEdge("S", "C", 3)
                .addEdge("S", "D", 5)
                .addEdge("A", "B", 3)
                .addEdge("B", "C", 2)
                .addEdge("B", "E", 3)
                .addEdge("C", "E", 1)
                .addEdge("D", "E", 4)
                .addEdge("D", "F", 4)
                .addEdge("E", "G", 7)
                .addEdge("E", "H", 5)
                .addEdge("F", "H", 7)
                .build()

        val result = dijkstra(graph, "S", "H")
        println("==== result ====")
        for (vertex in result) {
            println(vertex)
        }
    }
}
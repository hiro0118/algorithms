import main.kotlin.dijkstra.Graph
import main.kotlin.dijkstra.dijkstra
import org.junit.jupiter.api.Test

internal class DijkstraKtTest {
    @Test
    fun testDijkstra() {
        val graph = Graph()
        graph.addVertex("S")
        graph.addVertex("A")
        graph.addVertex("B")
        graph.addVertex("C")
        graph.addVertex("D")
        graph.addVertex("E")
        graph.addVertex("F")
        graph.addVertex("G")
        graph.addEdge("S", "A", 5)
        graph.addEdge("S", "B", 4)
        graph.addEdge("S", "C", 1)
        graph.addEdge("A", "D", 2)
        graph.addEdge("B", "C", 2)
        graph.addEdge("B", "D", 5)
        graph.addEdge("B", "E", 6)
        graph.addEdge("D", "F", 1)
        graph.addEdge("D", "G", 3)
        graph.addEdge("E", "G", 2)

        val result = dijkstra(graph, "S", "G")
        println("==== result ====")
        for (vertex in result) {
            println(vertex)
        }
    }

    @Test
    fun testDijkstra2() {
        val graph = Graph()
        graph.addVertex("S")
        graph.addVertex("A")
        graph.addVertex("B")
        graph.addVertex("C")
        graph.addVertex("D")
        graph.addVertex("E")
        graph.addVertex("F")
        graph.addVertex("G")
        graph.addVertex("H")
        graph.addEdge("S", "A", 1)
        graph.addEdge("S", "B", 2)
        graph.addEdge("S", "C", 3)
        graph.addEdge("S", "D", 5)
        graph.addEdge("A", "B", 3)
        graph.addEdge("B", "C", 2)
        graph.addEdge("B", "E", 3)
        graph.addEdge("C", "E", 1)
        graph.addEdge("D", "E", 4)
        graph.addEdge("D", "F", 4)
        graph.addEdge("E", "G", 7)
        graph.addEdge("E", "H", 5)
        graph.addEdge("F", "H", 7)

        val result = dijkstra(graph, "S", "H")
        println("==== result ====")
        for (vertex in result) {
            println(vertex)
        }
    }
}
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
}
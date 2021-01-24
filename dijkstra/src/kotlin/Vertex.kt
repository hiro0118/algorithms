package main.kotlin.dijkstra

class Vertex internal constructor(_id: String) {

    internal val id: String = _id
    private val edgeMap = HashMap<String, Int>()

    internal fun addEdge(vertexId: String, weight: Int) {
        edgeMap[vertexId] = weight
    }

    internal fun getEdgeMap(): Map<String, Int> {
        return edgeMap
    }
}
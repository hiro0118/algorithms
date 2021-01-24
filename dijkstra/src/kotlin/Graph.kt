package main.kotlin.dijkstra

import java.lang.Exception

class Graph {

    private val vertices: HashMap<String, Vertex> = HashMap()

    fun addVertex(vertexId: String) {
        vertices[vertexId] = Vertex(vertexId)
    }

    fun addEdge(vertexAId: String, vertexBId: String, weight: Int) {
        val vertexA = vertices[vertexAId]
        val vertexB = vertices[vertexBId]
        if (vertexA != null && vertexB != null) {
            val edge = Edge(vertexA, vertexB, weight)
            vertexA.addEdge(edge)
            vertexB.addEdge(edge)
        } else {
            throw Exception("Failed to create an Edge for vertexA=$vertexA, vertexB=$vertexB, weight=$weight")
        }
    }

    internal fun getVertex(id: String): Vertex? {
        return vertices[id]
    }

    internal fun getUnvisitedVertices(): Map<String, Vertex> {
        return vertices.filterValues { vertex -> !vertex.visited }
    }

    internal fun deepCopy(): Graph {
        val result = Graph()
        vertices.forEach { (key, vertex) -> result.vertices[key] = vertex.deepCopy() }
        return result
    }

    override fun toString(): String {
        var result = "graph:\n"
        vertices.forEach { (key, vertex) -> result += "$vertex\n" }
        result += '\n'
        return result
    }
}
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
            vertexA.addEdge(vertexBId, weight)
            vertexB.addEdge(vertexAId, weight)
        } else {
            throw Exception("Failed to create an Edge for vertexA=$vertexA, vertexB=$vertexB, weight=$weight")
        }
    }

    internal fun getVertices(): Map<String, Vertex> {
        return vertices
    }

    internal fun getVertex(id: String): Vertex? {
        return vertices[id]
    }
}
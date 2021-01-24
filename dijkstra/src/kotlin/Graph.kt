package main.kotlin.dijkstra

import java.lang.Exception

class Graph {

    private val vertices: HashMap<String, Vertex>

    private constructor(builder: Builder) {
        this.vertices = builder.vertices
    }

    internal fun getVertices(): Map<String, Vertex> {
        return vertices
    }

    class Builder {

        internal val vertices: HashMap<String, Vertex> = HashMap()

        fun addVertex(vertexId: String): Builder {
            vertices[vertexId] = Vertex(vertexId)
            return this
        }

        fun addEdge(vertexAId: String, vertexBId: String, weight: Int): Builder {
            val vertexA = vertices[vertexAId]
            val vertexB = vertices[vertexBId]
            if (vertexA != null && vertexB != null) {
                vertexA.addEdge(vertexBId, weight)
                vertexB.addEdge(vertexAId, weight)
            } else {
                throw Exception("Failed to create an Edge for vertexA=$vertexA, vertexB=$vertexB, weight=$weight")
            }
            return this
        }

        fun build(): Graph {
            return Graph(this)
        }
    }
}
package main.kotlin.dijkstra

import java.lang.Exception

class Edge internal constructor(private val vertexA: Vertex, private val vertexB: Vertex, internal val weight: Int) {

    fun getTheOtherVertex(myself: Vertex): Vertex {
        return when (myself) {
            vertexA -> vertexB
            vertexB -> vertexA
            else -> throw Exception("Illegal Input: $myself")
        }
    }
}
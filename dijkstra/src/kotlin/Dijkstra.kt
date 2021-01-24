package main.kotlin.dijkstra

fun dijkstra(graph: Graph, sourceId: String, targetId: String): List<Vertex> {

    // 1. Set the start point to 0.
    graph.getVertex(sourceId)!!.update(0, null)

    println(graph)

    while (graph.getUnvisitedVertices().isNotEmpty()) {
        // 2. Find the smallest unvisited vertex.
        val minVertex = findMinVertex(graph.getUnvisitedVertices())
        minVertex.visited = true
        if (minVertex.id == targetId) {
            break
        }

        // 3. Update distances of adjacent unvisited vertices.
        for (edge in minVertex.edges) {
            val nextVertex = edge.getTheOtherVertex(minVertex)
            val newDistAtNext = minVertex.dist + edge.weight
            if (nextVertex.dist > newDistAtNext) {
                nextVertex.update(newDistAtNext, minVertex)
            }
        }
        println(graph)
    }
    // 4. Get the result.
    return getResult(graph.getVertex(sourceId)!!, graph.getVertex(targetId)!!)
}

private fun findMinVertex(unvisitedVertices: Map<String, Vertex>): Vertex {
    var minVertex: Vertex? = null
    unvisitedVertices.forEach { (key, vertex) ->
        if ((minVertex?.dist ?: Int.MAX_VALUE) > vertex.dist) {
            minVertex = vertex
        }
    }
    return minVertex!!
}

private fun getResult(source: Vertex, target: Vertex): List<Vertex> {
    val result = ArrayList<Vertex>()
    result.add(target)
    var currentVertex = target
    while (currentVertex != source) {
        val prev = currentVertex.prevVertex
        result.add(0, prev!!)
        currentVertex = prev
    }
    return result
}
package main.kotlin.dijkstra

fun dijkstra(graph: Graph, sourceId: String, targetId: String): List<String> {
    val graphState = GraphState(graph, sourceId, targetId)

    // 1. Set the source vertex.
    graphState.getVertexInfo(sourceId).updateDist(0, null)
    println(graphState)

    while (graphState.getUnvisitedVertexInfoMap().isNotEmpty()) {
        val unvisitedVertexMap = graphState.getUnvisitedVertexInfoMap()

        // 2. Find the unvisited vertex with the smallest dist.
        val minVertexInfo = findMinVertex(unvisitedVertexMap)
        minVertexInfo.visited = true
        if (minVertexInfo.vertex.id == targetId) { break }

        // 3. Update distances of adjacent unvisited vertices.
        val edgeMap = minVertexInfo.vertex.getEdgeMap()
        edgeMap.forEach { (adjacentVertexId, weight) ->
            val adjacentVertexInfo = unvisitedVertexMap[adjacentVertexId]
            if (adjacentVertexInfo != null) {
                val newDist = minVertexInfo.dist + weight
                if (newDist < adjacentVertexInfo.dist) {
                    adjacentVertexInfo.updateDist(newDist, minVertexInfo)
                }
            }
        }
        println(graphState)
    }
    // 4. Get the result.
    return getResult(graphState, sourceId, targetId)
}

private fun findMinVertex(unvisitedVertexInfoMap: Map<String, GraphState.VertexInfo>): GraphState.VertexInfo {
    var minVertexInfo: GraphState.VertexInfo? = null
    for (vertexInfo in unvisitedVertexInfoMap.values) {
        if (minVertexInfo == null) {
            minVertexInfo = vertexInfo
        } else {
            if (vertexInfo.dist < minVertexInfo.dist) {
                minVertexInfo = vertexInfo
            }
        }
    }
    return minVertexInfo!!
}

private fun getResult(graphState: GraphState, sourceId: String, targetId: String): List<String> {
    val source = graphState.getVertexInfo(sourceId)
    val target = graphState.getVertexInfo(targetId)

    val result = ArrayList<String>()
    result.add(target.vertex.id)
    var currentVertexInfo = target
    while (currentVertexInfo != source) {
        val prev = currentVertexInfo.prev!!
        result.add(0, prev.vertex.id)
        currentVertexInfo = prev
    }
    return result
}
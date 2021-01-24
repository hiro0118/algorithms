package main.kotlin.dijkstra

class GraphState {

    private val graph: Graph
    private val sourceId: String
    private val targetId: String
    private val vertexInfoMap: HashMap<String, VertexInfo>

    internal constructor(graph: Graph, sourceId: String, targetId: String) {
        this.graph = graph
        this.sourceId = sourceId
        this.targetId = targetId
        vertexInfoMap = buildVertexInfo(graph.getVertices())
    }

    private fun buildVertexInfo(vertexMap: Map<String, Vertex>): HashMap<String, VertexInfo> {
        val result: HashMap<String, VertexInfo> = HashMap()
        for (vertex in vertexMap.values) {
            result[vertex.id] = VertexInfo(vertex)
        }
        return result
    }

    internal fun getUnvisitedVertexInfoMap(): Map<String, VertexInfo> {
        val unvisited: HashMap<String, VertexInfo> = HashMap()
        for (vertexInfo in vertexInfoMap.values) {
            if (!vertexInfo.visited) {
                unvisited[vertexInfo.vertex.id] = vertexInfo
            }
        }
        return unvisited
    }

    internal fun getVertexInfo(vertexId: String): VertexInfo {
        return vertexInfoMap[vertexId]!!
    }

    override fun toString(): String {
        var result = "graphSate:\n"
        vertexInfoMap.forEach { (key, vertexInfo) -> result += "$vertexInfo\n" }
        result += '\n'
        return result
    }

    internal inner class VertexInfo internal constructor(_vertex: Vertex) {
        internal val vertex: Vertex = _vertex
        internal var dist: Int = Int.MAX_VALUE
        internal var visited: Boolean = false
        internal var prev: VertexInfo? = null

        internal fun updateDist(dist: Int, prev: VertexInfo?) {
            this.dist = dist
            this.prev = prev
        }

        override fun toString(): String {
            val id = vertex.id
            val prevId = prev?.vertex?.id
            return "VertexInfo[id=$id, dist=$dist, visited=$visited, prev=$prevId]"
        }
    }
}

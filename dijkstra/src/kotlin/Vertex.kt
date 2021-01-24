package main.kotlin.dijkstra

class Vertex internal constructor(name: String) {

    internal val id: String = name
    internal val edges = HashSet<Edge>()
    internal var dist = Int.MAX_VALUE
        private set
    internal var prevVertex: Vertex? = null
    internal var visited: Boolean = false

    internal fun addEdge(edge: Edge) {
        edges.add(edge)
    }

    internal fun update(dist: Int, prev: Vertex?) {
        this.dist = dist
        this.prevVertex = prev
    }

    internal fun deepCopy(): Vertex {
        val copy = Vertex(this.id)
        edges.forEach { edge -> copy.addEdge(edge) }
        copy.dist = this.dist
        return copy
    }

    override fun toString(): String {
        val preId = prevVertex?.id
        return "Vertex$id[dist=$dist, pre=$preId, visited=$visited]"
    }
}
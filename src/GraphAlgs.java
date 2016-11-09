import java.util.*;

/**
 * Your implementation of 5 different graph algorithms.
 *
 * @author Hao Zhang
 * @version 1.0
 */
public class GraphAlgs {

    /**
     * Performs a breadth first search (bfs) on the input graph, starting at
     * int {@code start} which represents the starting vertex. You will be
     * modifying the empty list passed in to contain the vertices (ints) in
     * visited order. The start vertex should be at the beginning of the list
     * and the last vertex visited should be at the end.  (You may assume the
     * list is empty in the beginning).
     *
     * This method should utilize the adjacency list represented graph.
     *
     * When deciding which neighbors to visit next from a vertex, visit in the
     * order that the adjacency list has the vertices ordered starting from
     * index 0. Failure to do so may cause you to lose points.
     *
     * You may import/use {@code java.util.Queue}, {@code java.util.Set},
     * {@code java.util.Map}, {@code java.util.List}, and any classes
     * that implement the aforementioned interfaces.
     *
     * You may assume that the graph that we passed in will either be directed
     * or undirected, but not both. This should not have much of an effect, if
     * at all on your algorithm, however.
     *
     * @throws IllegalArgumentException if start is less than 0 or if any input
     *  is null, or if {@code start} doesn't exist in the graph
     * @param start the vertex to begin the bfs on
     * @param graph the graph in an adjacency list format to search
     * @param bfsList an empty list initially, this is the list that you should
     * be adding to as you conduct bfs with the vertices in order of traversal
     * @return true if the graph is connected (you were able to reach every
     * vertex and edge from {@code start}), false otherwise
     */
    public static boolean breadthFirstSearch(int start, GraphAdjList graph,
                                             List<Integer> bfsList) {
        if (graph == null || bfsList == null || start < 0) {
            throw new IllegalArgumentException("Input is null or start is less than zero");
        }
        Map<Integer, Integer> visited = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            int elem = queue.poll();
            visited.put(elem, 0);
            List<VertexDistancePair> path = graph.getAdjacencyList().get(elem);
            for (VertexDistancePair destination : path) {
                if (!visited.containsKey(destination.getVertex())) {
                    queue.add(destination.getVertex());
                    visited.put(destination.getVertex(), 0);
                }
            }
            bfsList.add(elem);
        }
        return graph.getAdjacencyList().size() == bfsList.size();
    }

    /**
     * Performs a depth first search (dfs) on the input graph, starting at
     * int {@code start} which represents the starting vertex.  You will be
     * modifying the empty list passed in to contain the vertices (ints) in
     * visited order. The start vertex should be at the beginning of the list
     * and the last vertex visited should be at the end.  (You may assume the
     * list is empty in the beginning).
     *
     * This method should utilize the adjacency matrix represented graph.
     *
     * When deciding which neighbors to visit next from a vertex, visit starting
     * with vertex at index 0 to vertex  at index v-1. Failure to do so may
     * cause you to lose points.
     *
     * *NOTE* You MUST implement this method recursively.
     *
     * You may import/use {@code java.util.Set}, {@code java.util.Map},
     * {@code java.util.List}, and any classes that implement the
     * aforementioned interfaces.
     *
     * You may assume that the graph that we passed in will either be directed
     * or undirected, but not both. This should not have much of an effect, if
     * at all on your algorithm, however.
     *
     * @throws IllegalArgumentException if start is less than 0 or if any input
     *  is null, or if {@code start} doesn't exist in the graph
     * @param start the vertex to begin the dfs on
     * @param graph the graph in an adjacency matrix format to search
     * @param dfsList the list of visited vertices in order. This list will be
     * empty initially. You will be adding to this list as you perform dfs.
     * @return true if the graph is connected (you were able to reach every
     * vertex and edge from {@code start}), false otherwise
     */
    public static boolean depthFirstSearch(int start, GraphAdjMatrix graph,
                                           List<Integer> dfsList) {
        if (graph == null || dfsList == null || start < 0) {
            throw new IllegalArgumentException("Input is null or start is less than zero");
        }
        int[][] matrix = graph.getAdjMatrix();
        Map<Integer, Integer> visited = new HashMap<>();
        dfs(start, matrix, dfsList, visited);
        return dfsList.size() == graph.getVertexList().size();
    }

    private static void dfs(int start, int[][] matrix, List<Integer> dfsList,
                            Map<Integer, Integer> visited) {
        dfsList.add(start);
        visited.put(start, 0);
        for (int i = 0; i < matrix[start].length; i++) {
            if (matrix[start][i] != 0 && !visited.containsKey(i)) {
                dfs(i, matrix, dfsList, visited);
            }
        }
    }

    /**
     * Find the single source shortest distance between the start vertex and
     * all vertices given a weighted graph using Dijkstra's shortest path
     * algorithm.
     *
     * Return a map of the shortest distances such that the key of each entry is
     * a node in the graph and the value for the key is the shortest distance
     * to that node from start, or Integer.MAX_VALUE (representing infinity)
     * if no path exists. You may assume that going from a vertex to itself
     * has a distance of 0.
     *
     * This method should utilize the adjacency list represented graph.
     *
     * You may import/use {@code java.util.PriorityQueue},
     * {@code java.util.Map}, and any class that implements the aforementioned
     * interface.
     *
     * You may assume that the graph that we passed in will either be directed
     * or undirected, but not both. This should not have much of an effect, if
     * at all on your algorithm, however.
     *
     * @throws IllegalArgumentException if start is less 0 or if any input
     *  is null, or if start doesn't exist in the graph.
     * @throws IllegalStateException if any of the edges are negative
     * @param start index representing which vertex (row) to start at (source)
     * @param graph the Graph we are searching using an adjacency List
     * @return a map of the shortest distances from start to every other node
     *         in the graph (first Integer is the vertex number in the adj
     *         list, second Integer is the shortest distance to that vertex)
     */
    public static Map<Integer, Integer> shortPathDijk(int start,
                                                      GraphAdjList graph) {
        if (start < 0 || graph == null) {
            throw new IllegalArgumentException("Input is null or start is less than zero");
        }
        Set<Integer> vertex = graph.getAdjacencyList().keySet();
        Map<Integer, List<VertexDistancePair>> adjList = graph.getAdjacencyList();
        Map<Integer, Integer> path = new HashMap<>();
        PriorityQueue<VertexDistancePair> pq = new PriorityQueue<>();
        path.put(start, 0);
        for (Integer x : vertex) {
            if (x != start) {
                path.put(x, Integer.MAX_VALUE);
            }
        }
        pq.addAll(adjList.get(start));
        while (!pq.isEmpty()) {
            VertexDistancePair current = pq.poll();
            int v = current.getVertex();
            int len = current.getDistance();
            if (len < 0) {
                throw new IllegalStateException("Edge cannot be negative");
            }
            if (len < path.get(v)) {
                path.put(v, len);
                for (VertexDistancePair next : adjList.get(v)) {
                    pq.add(new VertexDistancePair(next.getVertex(), next.getDistance() + len));
                }
            }
        }
        return path;
    }

    /**
     * Run Prim's algorithm on the given graph and return the MST/MSF
     * in the form of a set of Edges.  If the graph is disconnected, and
     * therefore there is no valid MST, return a minimal spanning forest (MSF).
     *
     * This method should utilize the adjacency list represented graph.
     *
     * A minimal spanning forest (MSF) is just a generalized version of the MST
     * for disconnected graphs. After running the algorithm once, just check to
     * see if there are still some vertices that are not connected to the
     * MST/MSF. If all vertices have been visited, you are done. If not, run
     * the algorithm again on an unvisited vertex.
     *
     * You may assume that all of the edge weights are unique (THIS MEANS THAT
     * THE MST/MSF IS UNIQUE FOR THE GRAPH, REGARDLESS OF STARTING VERTEX!!)
     * Although, if your algorithm works correctly, it should work even if the
     * MST/MSF is not unique, this is just for testing purposes.
     *
     * You should not allow for any self-loops in the MST/MSF. Additionally,
     * you may assume that the graph is undirected.
     *
     * You may NOT use/import anything for this method that is not in the
     * standard java.lang package.
     *
     * @throws IllegalArgumentException if any input is null
     * @param graph the Graph we are searching using an adjacency list
     * @return the MST/MSF of the graph
     */
    public static Set<Edge> mstPrim(GraphAdjList graph) {
        if (graph == null) {
            throw new IllegalArgumentException("Graph cannot be null.");
        }
        Map<Integer, List<VertexDistancePair>> adjList = graph.getAdjacencyList();
        Map<Integer, Integer> visited = new HashMap<>();
        Set<Integer> vertices = adjList.keySet();
        Set<Edge> MST = new LinkedHashSet<>();
        for (Integer x : vertices) {
            if (!visited.containsKey(x)) {
                prim(x, adjList, MST, visited);
            }
        }
        return MST;
    }

    private static void prim(int start, Map<Integer, List<VertexDistancePair>> adjList,
                      Set<Edge> MST, Map<Integer, Integer> visited) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        visited.put(start, 0);
        for (VertexDistancePair x : adjList.get(start)) {
            pq.add(new Edge(start, x.getVertex(), x.getDistance(), false));
        }
        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int next = current.getV();
            if (!visited.containsKey(next)) {
                visited.put(next, 0);
                MST.add(current);
                for (VertexDistancePair y : adjList.get(next)) {
                    pq.add(new Edge(next, y.getVertex(), y.getDistance(), false));
                }
            }
        }
    }

    /**
     * Run Kruskal's algorithm on the given graph and return the MST/MSF
     * in the form of a set of Edges.  If the graph is disconnected, and
     * therefore there is no valid MST, return a minimal spanning forest (MSF).
     *
     * This method should utilize the adjacency list represented graph.
     *
     * A minimal spanning forest (MSF) is just a generalized version of the MST
     * for disconnected graphs. Unlike Prim's algorithm, Kruskal's algorithm
     * will naturally return a MSF if the graph is disconnected.
     *
     * You may assume that all of the edge weights are unique (THIS MEANS THAT
     * THE MST/MSF IS UNIQUE FOR THE GRAPH.) Although, if your algorithm works
     * correctly, it should work even if the MST/MSF is not unique, this is
     * just for testing purposes.
     *
     * You should not allow for any self-loops in the MST/MSF. Additionally,
     * you may assume that the graph is undirected.
     *
     * Kruskal's will also require you to use a Disjoint Set which has been
     * provided for you.  A Disjoint Set will keep track of which verticies are
     * connected to each other by the edges you've chosen for your MST/MSF.
     * Without a Disjoint Set, it is possible for Kruskal's to omit edges that
     * should be in the final MST/MSF.
     *
     * You may import/use {@code java.util.PriorityQueue},
     * {@code java.util.Set}, and any class that implements the aforementioned
     * interface.
     *
     * @throws IllegalArgumentException if any input is null
     * @param graph the Graph we are searching using an adjacency list
     * @return the MST/MSF of the graph
     */
    @SuppressWarnings("unchecked")
    public static Set<Edge> mstKruskal(GraphAdjList graph) {
        if (graph == null) {
            throw new IllegalArgumentException("Graph cannot be null.");
        }
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        Set<Integer> vertices = graph.getAdjacencyList().keySet();
        for (Integer x : vertices) {
            List<VertexDistancePair> pairs = graph.getAdjacencyList().get(x);
            for (VertexDistancePair edge : pairs) {
                pq.add(new Edge(x, edge.getVertex(), edge.getDistance(), false));
            }
        }
        DisjointSet<Integer> disjointSet = new DisjointSet(vertices);
        Set<Edge> MST = new LinkedHashSet<>();
        while (!pq.isEmpty()) {
            Edge curr = pq.poll();
            if (!disjointSet.find(curr.getU()).equals(disjointSet.find(curr.getV()))) {
                MST.add(curr);
                disjointSet.union(curr.getU(), curr.getV());
            }
        }
        return MST;
    }
}
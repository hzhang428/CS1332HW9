import org.junit.Before;
import org.junit.Test;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Basic student tests to check GraphAlgs. These tests are in
 * no way comprehensive nor do they guarantee any kind of grade.
 * The number of comparisons in these tests are exact.
 *
 * @author Jyu and modifeid by Hasan
 * @version 1.0
 */
public class GraphAlgsStudentTests {

    private List<Integer> basicVertices;
    private Set<Edge> basicEdges;
    private int[][] basicMatrix;

    private GraphAdjList adjList;
    private GraphAdjMatrix adjMatrix;

//-----------starting point only has one edge
    private List<Integer> basicVertices2;
    private Set<Edge> basicEdges2;
    private int[][] basicMatrix2;

    private GraphAdjList adjList2;
    private GraphAdjMatrix adjMatrix2;
//-----------no edges
    private List<Integer> basicVertices3;
    private Set<Edge> basicEdges3;
    private int[][] basicMatrix3;

    private GraphAdjList adjList3;
    private GraphAdjMatrix adjMatrix3;
//-----------one vertex connects to others, the others does not connect
    private List<Integer> basicVertices4;
    private Set<Edge> basicEdges4;
    private int[][] basicMatrix4;

    private GraphAdjList adjList4;
    private GraphAdjMatrix adjMatrix4;

//-----------complete graph
    private List<Integer> basicVertices5;
    private Set<Edge> basicEdges5;
    private int[][] basicMatrix5;

    private GraphAdjList adjList5;
    private GraphAdjMatrix adjMatrix5;
//-----------bipartite graph
    private List<Integer> basicVertices6;
    private Set<Edge> basicEdges6;
    private int[][] basicMatrix6;

    private GraphAdjList adjList6;
    private GraphAdjMatrix adjMatrix6;
//----------No duplicate, positive, connected, parents
    private List<Integer> studentVerticesTwo;
    private Set<Edge> studentEdgesTwo;
    private int[][] studentMatrixTwo;
    
    private GraphAdjList adjListTwo;
    private GraphAdjMatrix adjMatrixTwo;
//----------Duplicate weights
    private List<Integer> studentVerticesThree;
    private Set<Edge> studentEdgesThree;
    private int[][] studentMatrixThree;
    
    private GraphAdjList adjListThree;
    private GraphAdjMatrix adjMatrixThree;
//----------negative weights
    private List<Integer> studentVerticesFour;
    private Set<Edge> studentEdgesFour;
    private int[][] studentMatrixFour;
    
    private GraphAdjList adjListFour;
    private GraphAdjMatrix adjMatrixFour;
//----------all zero weights
    private List<Integer> studentVerticesFive;
    private Set<Edge> studentEdgesFive;
    private int[][] studentMatrixFive;
    
    private GraphAdjList adjListFive;
    private GraphAdjMatrix adjMatrixFive;
//----------Self loops
    private List<Integer> studentVerticesSix;
    private Set<Edge> studentEdgesSix;
    private int[][] studentMatrixSix;
    
    private GraphAdjList adjListSix;
    private GraphAdjMatrix adjMatrixSix;

    @Before
    public void init() {
        basicVertices = vertices(7);
        basicEdges = basicEdges();
        basicMatrix = createMatrix(basicVertices, basicEdges);
        basicVertices2 = vertices(6);
        basicEdges2 = basicEdges2();
        basicMatrix2 = createMatrix(basicVertices2, basicEdges2);
        basicVertices3 = vertices(6);
        basicEdges3 = basicEdges3();
        basicMatrix3 = createMatrix(basicVertices3, basicEdges3);
        basicVertices4 = vertices(6);
        basicEdges4 = basicEdges4();
        basicMatrix4 = createMatrix(basicVertices4, basicEdges4);
        basicVertices5 = vertices(5);
        basicEdges5 = basicEdges5();
        basicMatrix5 = createMatrix(basicVertices5, basicEdges5);
        basicVertices6 = vertices(6);
        basicEdges6 = basicEdges6();
        basicMatrix6 = createMatrix(basicVertices6, basicEdges6);
        
        studentVerticesTwo = vertices(6);
        studentEdgesTwo = studentEdgesTwo();
        studentMatrixTwo = createMatrix(studentVerticesTwo, studentEdgesTwo);
        studentVerticesThree = vertices(6);
        studentEdgesThree = studentEdgesThree();
        studentMatrixThree = createMatrix(studentVerticesThree, studentEdgesThree);
        studentVerticesFour = vertices(7);
        studentEdgesFour = studentEdgesFour();
        studentMatrixFour = createMatrix(studentVerticesFour, studentEdgesFour);
        studentVerticesFive = vertices(7);
        studentEdgesFive = studentEdgesFive();
        studentMatrixFive = createMatrix(studentVerticesFive, studentEdgesFive);
        studentVerticesSix = vertices(6);
        studentEdgesSix = studentEdgesSix();
        studentMatrixSix = createMatrix(studentVerticesSix, studentEdgesSix);
    }

    /**
     * Creates a list of vertices
     *
     * @param num The number of verticies
     * @return List of verticies from 0 to num-1.
     */
    private List<Integer> vertices(int num) {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < num; i++) {
            list.add(i);
        }
        return list;
    }

    /**
     * Creates a list of basic edges.
     *
     * @return list of edges.
     */
    private Set<Edge> basicEdges() {
        Set<Edge> set = new LinkedHashSet<>();
        set.add(new Edge(0, 1, 8, false));
        set.add(new Edge(0, 2, 7, false));
        set.add(new Edge(0, 3, 1, false));
        set.add(new Edge(1, 3, 9, false));
        set.add(new Edge(1, 5, 6, false));
        set.add(new Edge(2, 4, 2, false));
        set.add(new Edge(3, 5, 3, false));
        set.add(new Edge(3, 6, 4, false));
        set.add(new Edge(4, 5, 10, false));
        set.add(new Edge(4, 6, 5, false));
        return set;
    }

    private Set<Edge> basicEdges2() {
        Set<Edge> set = new LinkedHashSet<>();
        set.add(new Edge(0, 1, 7, false));
        set.add(new Edge(1, 2, 4, false));
        set.add(new Edge(1, 3, 8, false));
        set.add(new Edge(3, 2, 5, false));
        set.add(new Edge(3, 4, 6, false));
        set.add(new Edge(2, 4, 3, false));
        set.add(new Edge(3, 5, 2, false));
        set.add(new Edge(4, 5, 9, false));
        return set;
    }

    private Set<Edge> basicEdges3() {
        Set<Edge> set = new LinkedHashSet<>();
        return set;
    }

    private Set<Edge> basicEdges4() {
        Set<Edge> set = new LinkedHashSet<>();
        set.add(new Edge(0, 1, 7, false));
        set.add(new Edge(0, 2, 4, false));
        set.add(new Edge(0, 3, 4, false));
        set.add(new Edge(0, 4, 4, false));
        set.add(new Edge(0, 5, 4, false));

        return set;
    }

    private Set<Edge> basicEdges5() {
        Set<Edge> set = new LinkedHashSet<>();
        set.add(new Edge(0, 1, 1, false));
        set.add(new Edge(0, 2, 2, false));
        set.add(new Edge(0, 3, 3, false));
        set.add(new Edge(0, 4, 4, false));

        set.add(new Edge(1, 2, 5, false));
        set.add(new Edge(1, 3, 6, false));
        set.add(new Edge(1, 4, 7, false));

        set.add(new Edge(2, 3, 8, false));
        set.add(new Edge(2, 4, 9, false));

        set.add(new Edge(3, 4, 10, false));

        return set;
    }

    private Set<Edge> basicEdges6() {
        Set<Edge> set = new LinkedHashSet<>();
        set.add(new Edge(0, 4, 8, false));
        set.add(new Edge(1, 3, 7, false));
        set.add(new Edge(1, 5, 1, false));
        set.add(new Edge(2, 4, 9, false));

        return set;
    }
    
    private Set<Edge> studentEdgesTwo() {
    	Set<Edge> set = new LinkedHashSet<>();
    	set.add(new Edge(0, 4, 2, false));
    	set.add(new Edge(4, 3, 1, false));
    	set.add(new Edge(4, 5, 5, false));
    	set.add(new Edge(5, 2, 4, false));
    	set.add(new Edge(2, 1, 3, false));
    	return set;
    }
    
    private Set<Edge> studentEdgesThree() {
    	Set<Edge> set = new LinkedHashSet<>();
    	set.add(new Edge(0, 1, 1, false));
    	set.add(new Edge(0, 2, 1, false));
    	set.add(new Edge(2, 3, 1, false));
    	set.add(new Edge(2, 4, 1, false));
    	set.add(new Edge(3, 5, 1, false));
    	return set;
    }
    
    private Set<Edge> studentEdgesFour() {
    	Set<Edge> set = new LinkedHashSet<>();
    	set.add(new Edge(0, 1, -1, false));
    	set.add(new Edge(0, 2, -5, false));
    	set.add(new Edge(2, 3, -3, false));
    	set.add(new Edge(2, 4, -9, false));
    	set.add(new Edge(3, 4, 5, false));
    	set.add(new Edge(3, 6, 2, false));
    	set.add(new Edge(6, 5, -6, false));

    	return set;
    }
    
    private Set<Edge> studentEdgesFive() {
    	Set<Edge> set = new LinkedHashSet<>();
    	set.add(new Edge(0, 0, 0, false));
    	set.add(new Edge(1, 1, 0, false));
    	set.add(new Edge(2, 2, 0, false));
    	set.add(new Edge(3, 3, 0, false));
    	set.add(new Edge(4, 4, 0, false));
    	set.add(new Edge(5, 5, 0, false));
    	set.add(new Edge(6, 6, 0, false));

    	return set;
    }
    private Set<Edge> studentEdgesSix() {
    	Set<Edge> set = new LinkedHashSet<>();
    	set.add(new Edge(0, 2, 2, false));
    	set.add(new Edge(0, 1, 1, false));
    	set.add(new Edge(2, 2, 0, false));
    	set.add(new Edge(2, 3, 3, false));
    	set.add(new Edge(2, 4, 9, false));
    	set.add(new Edge(3, 4, 4, false));
    	set.add(new Edge(5, 5, 0, false));
    	return set;
    }
    
    
    /**
     * Creates an adjacency matrix from a list of verticies and edges.
     *
     * @param vertices List of verticies in a graph
     * @param edges Set of edges in a graph
     * @return adjacency matrix.
     */
    private int[][] createMatrix(List<Integer> vertices, Set<Edge> edges) {
        int[][] matrix = new int[vertices.size()][vertices.size()];

        for (Edge e : edges) {
            int u = e.getU();
            int v = e.getV();
            matrix[u][v] = e.getWeight();
            if (!e.isDirected()) {
                matrix[v][u] = e.getWeight();
            }
        }
        return matrix;
    }

    @Test
    public void testBreadthFirstSearch() {
        adjList = new GraphAdjList(basicVertices, basicEdges);
        List<Integer> bfsActual = new LinkedList<>();
        assertTrue(GraphAlgs.breadthFirstSearch(0, adjList, bfsActual));

        List<Integer> bfsExpected = new LinkedList<>();
        bfsExpected.add(0);
        bfsExpected.add(1);
        bfsExpected.add(2);
        bfsExpected.add(3);
        bfsExpected.add(5);
        bfsExpected.add(4);
        bfsExpected.add(6);

        assertEquals(bfsExpected, bfsActual);
    }

    @Test
    public void testBreadthFirstSearch2() {
        adjList = new GraphAdjList(basicVertices2, basicEdges2);
        List<Integer> bfsActual = new LinkedList<>();
        assertTrue(GraphAlgs.breadthFirstSearch(0, adjList, bfsActual));

        List<Integer> bfsExpected = new LinkedList<>();
        bfsExpected.add(0);
        bfsExpected.add(1);
        bfsExpected.add(2);
        bfsExpected.add(3);
        bfsExpected.add(4);
        bfsExpected.add(5);

        assertEquals(bfsExpected, bfsActual);
    }

    @Test
    public void testBreadthFirstSearch3() {
        adjList = new GraphAdjList(basicVertices3, basicEdges3);
        List<Integer> bfsActual = new LinkedList<>();
        assertFalse(GraphAlgs.breadthFirstSearch(0, adjList, bfsActual));

        List<Integer> bfsExpected = new LinkedList<>();
        bfsExpected.add(0);
        assertEquals(bfsExpected, bfsActual);
    }

    @Test
    public void testBreadthFirstSearch4() {
        adjList = new GraphAdjList(basicVertices4, basicEdges4);
        List<Integer> bfsActual = new LinkedList<>();
        assertTrue(GraphAlgs.breadthFirstSearch(0, adjList, bfsActual));

        List<Integer> bfsExpected = new LinkedList<>();
        bfsExpected.add(0);
        bfsExpected.add(1);
        bfsExpected.add(2);
        bfsExpected.add(3);
        bfsExpected.add(4);
        bfsExpected.add(5);
        assertEquals(bfsExpected, bfsActual);
    }

    @Test
    public void testBreadthFirstSearch5() {
        adjList = new GraphAdjList(basicVertices5, basicEdges5);
        List<Integer> bfsActual = new LinkedList<>();
        assertTrue(GraphAlgs.breadthFirstSearch(0, adjList, bfsActual));

        List<Integer> bfsExpected = new LinkedList<>();
        bfsExpected.add(0);
        bfsExpected.add(1);
        bfsExpected.add(2);
        bfsExpected.add(3);
        bfsExpected.add(4);
        assertEquals(bfsExpected, bfsActual);
    }

    @Test
    public void testBreadthFirstSearch6() {
        adjList = new GraphAdjList(basicVertices6, basicEdges6);
        List<Integer> bfsActual = new LinkedList<>();
        assertFalse(GraphAlgs.breadthFirstSearch(0, adjList, bfsActual));

        List<Integer> bfsExpected = new LinkedList<>();
        bfsExpected.add(0);
        bfsExpected.add(4);
        bfsExpected.add(2);
        assertEquals(bfsExpected, bfsActual);
    }
    
    @Test
    public void testBreadthFirstSearch7() {
    	adjList = new GraphAdjList(studentVerticesTwo, studentEdgesTwo);
        List<Integer> bfsActual = new LinkedList<>();
        assertTrue(GraphAlgs.breadthFirstSearch(0, adjList, bfsActual));
        
        List<Integer> bfsExpected = new LinkedList<>();
        bfsExpected.add(0);
        bfsExpected.add(4);
        bfsExpected.add(3);
        bfsExpected.add(5);
        bfsExpected.add(2);
        bfsExpected.add(1);
        assertEquals(bfsExpected, bfsActual);
    }
    
    @Test
    public void testBreadthFirstSearch8() {
    	adjList = new GraphAdjList(studentVerticesSix, studentEdgesSix);
        List<Integer> bfsActual = new LinkedList<>();
        assertFalse(GraphAlgs.breadthFirstSearch(1, adjList, bfsActual));
        List<Integer> bfsExpected = new LinkedList<>();
        bfsExpected.add(1);
        bfsExpected.add(0);
        bfsExpected.add(2);
        bfsExpected.add(3);
        bfsExpected.add(4);
        assertEquals(bfsExpected, bfsActual);
    }
    
    @Test
    public void testBreadthFirstSearch9() {
    	adjList = new GraphAdjList(studentVerticesThree, studentEdgesThree);
        List<Integer> bfsActual = new LinkedList<>();
        assertTrue(GraphAlgs.breadthFirstSearch(0, adjList, bfsActual));
        List<Integer> bfsExpected = new LinkedList<>();
        bfsExpected.add(0);
        bfsExpected.add(1);
        bfsExpected.add(2);
        bfsExpected.add(3);
        bfsExpected.add(4);
        bfsExpected.add(5);
        assertEquals(bfsExpected, bfsActual);
    }
    
    @Test
    public void testBreadthFirstSearch10() {
    	adjList = new GraphAdjList(studentVerticesFour, studentEdgesFour);
        List<Integer> bfsActual = new LinkedList<>();
        assertTrue(GraphAlgs.breadthFirstSearch(0, adjList, bfsActual));
        List<Integer> bfsExpected = new LinkedList<>();
        bfsExpected.add(0);
        bfsExpected.add(1);
        bfsExpected.add(2);
        bfsExpected.add(3);
        bfsExpected.add(4);
        bfsExpected.add(6);
        bfsExpected.add(5);
        assertEquals(bfsExpected, bfsActual);
    }
    
    
    @Test
    public void testBreadthFirstSearch11() {
    	adjList = new GraphAdjList(studentVerticesFive, studentEdgesFive);
        List<Integer> bfsActual = new LinkedList<>();
        assertFalse(GraphAlgs.breadthFirstSearch(0, adjList, bfsActual));
        List<Integer> bfsExpected = new LinkedList<>();
        bfsExpected.add(0);

        assertEquals(bfsExpected, bfsActual);
    }
    
    @Test
    public void testDepthFirstSearch() {
        adjMatrix = new GraphAdjMatrix(basicVertices, basicMatrix);
        List<Integer> dfsActual = new LinkedList<>();
        assertTrue(GraphAlgs.depthFirstSearch(0, adjMatrix, dfsActual));

        List<Integer> dfsExpected = new LinkedList<>();
        dfsExpected.add(0);
        dfsExpected.add(1);
        dfsExpected.add(3);
        dfsExpected.add(5);
        dfsExpected.add(4);
        dfsExpected.add(2);
        dfsExpected.add(6);

        assertEquals(dfsExpected, dfsActual);
    }

    @Test
    public void testDepthFirstSearch2() {
        adjMatrix = new GraphAdjMatrix(basicVertices2, basicMatrix2);
        List<Integer> dfsActual = new LinkedList<>();
        assertTrue(GraphAlgs.depthFirstSearch(0, adjMatrix, dfsActual));

        List<Integer> dfsExpected = new LinkedList<>();
        dfsExpected.add(0);
        dfsExpected.add(1);
        dfsExpected.add(2);
        dfsExpected.add(3);
        dfsExpected.add(4);
        dfsExpected.add(5);

        assertEquals(dfsExpected, dfsActual);
    }

    @Test
    public void testDepthFirstSearch3() {
        adjMatrix = new GraphAdjMatrix(basicVertices3, basicMatrix3);
        List<Integer> dfsActual = new LinkedList<>();
        assertFalse(GraphAlgs.depthFirstSearch(0, adjMatrix, dfsActual));

        List<Integer> dfsExpected = new LinkedList<>();
        dfsExpected.add(0);

        assertEquals(dfsExpected, dfsActual);
    }
    @Test
    public void testDepthFirstSearch4() {
        adjMatrix = new GraphAdjMatrix(basicVertices4, basicMatrix4);
        List<Integer> dfsActual = new LinkedList<>();
        assertTrue(GraphAlgs.depthFirstSearch(0, adjMatrix, dfsActual));

        List<Integer> dfsExpected = new LinkedList<>();
        dfsExpected.add(0);
        dfsExpected.add(1);
        dfsExpected.add(2);
        dfsExpected.add(3);
        dfsExpected.add(4);
        dfsExpected.add(5);

        assertEquals(dfsExpected, dfsActual);
    }

    @Test
    public void testDepthFirstSearch5() {
        adjMatrix = new GraphAdjMatrix(basicVertices5, basicMatrix5);
        List<Integer> dfsActual = new LinkedList<>();
        assertTrue(GraphAlgs.depthFirstSearch(0, adjMatrix, dfsActual));

        List<Integer> dfsExpected = new LinkedList<>();
        dfsExpected.add(0);
        dfsExpected.add(1);
        dfsExpected.add(2);
        dfsExpected.add(3);
        dfsExpected.add(4);

        assertEquals(dfsExpected, dfsActual);
    }

    @Test
    public void testDepthFirstSearch6() {
        adjMatrix = new GraphAdjMatrix(basicVertices6, basicMatrix6);
        List<Integer> dfsActual = new LinkedList<>();
        assertFalse(GraphAlgs.depthFirstSearch(0, adjMatrix, dfsActual));

        List<Integer> dfsExpected = new LinkedList<>();
        dfsExpected.add(0);
        dfsExpected.add(4);
        dfsExpected.add(2);

        assertEquals(dfsExpected, dfsActual);
    }
    
    @Test
    public void testDepthFirstSearch7() {
        adjMatrix = new GraphAdjMatrix(studentVerticesTwo, studentMatrixTwo);
        List<Integer> dfsActual = new LinkedList<>();
        assertTrue(GraphAlgs.depthFirstSearch(0, adjMatrix, dfsActual));

        List<Integer> dfsExpected = new LinkedList<>();
        dfsExpected.add(0);
        dfsExpected.add(4);
        dfsExpected.add(3);
        dfsExpected.add(5);
        dfsExpected.add(2);
        dfsExpected.add(1);


        assertEquals(dfsExpected, dfsActual);
    }

    @Test
    public void testDepthFirstSearch8() {
        adjMatrix = new GraphAdjMatrix(studentVerticesSix, studentMatrixSix);
        List<Integer> dfsActual = new LinkedList<>();
        assertFalse(GraphAlgs.depthFirstSearch(0, adjMatrix, dfsActual));

        List<Integer> dfsExpected = new LinkedList<>();
        dfsExpected.add(0);
        dfsExpected.add(1);
        dfsExpected.add(2);
        dfsExpected.add(3);
        dfsExpected.add(4);

        assertEquals(dfsExpected, dfsActual);
    }
    
    @Test
    public void testDepthFirstSearch9() {
        adjMatrix = new GraphAdjMatrix(studentVerticesThree, studentMatrixThree);
        List<Integer> dfsActual = new LinkedList<>();
        assertTrue(GraphAlgs.depthFirstSearch(0, adjMatrix, dfsActual));

        List<Integer> dfsExpected = new LinkedList<>();
        dfsExpected.add(0);
        dfsExpected.add(1);
        dfsExpected.add(2);
        dfsExpected.add(3);
        dfsExpected.add(5);
        dfsExpected.add(4);

        assertEquals(dfsExpected, dfsActual);
    }
    
    @Test
    public void testDepthFirstSearch10() {
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("Start");

        adjMatrix = new GraphAdjMatrix(studentVerticesFour, studentMatrixFour);
        List<Integer> dfsActual = new LinkedList<>();
        assertTrue(GraphAlgs.depthFirstSearch(0, adjMatrix, dfsActual));

        List<Integer> dfsExpected = new LinkedList<>();
        dfsExpected.add(0);
        dfsExpected.add(1);
        dfsExpected.add(2);
        dfsExpected.add(3);
        dfsExpected.add(4);
        dfsExpected.add(6);
        dfsExpected.add(5);

    	System.out.println("Done");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
        assertEquals(dfsExpected, dfsActual);
    }
    
    
    @Test
    public void testDepthFirstSearch11() {

        adjMatrix = new GraphAdjMatrix(studentVerticesFive, studentMatrixFive);
        List<Integer> dfsActual = new LinkedList<>();
        assertFalse(GraphAlgs.depthFirstSearch(0, adjMatrix, dfsActual));

        List<Integer> dfsExpected = new LinkedList<>();
        dfsExpected.add(0);

        assertEquals(dfsExpected, dfsActual);
    }
    
    
    @Test
    public void testShortPathDijk() {
        adjList = new GraphAdjList(basicVertices, basicEdges);
        Map<Integer, Integer> dijkActual = GraphAlgs.shortPathDijk(0, adjList);
        Map<Integer, Integer> dijkExpected = new HashMap<>();
        dijkExpected.put(0, 0);
        dijkExpected.put(1, 8);
        dijkExpected.put(2, 7);
        dijkExpected.put(3, 1);
        dijkExpected.put(4, 9);
        dijkExpected.put(5, 4);
        dijkExpected.put(6, 5);

        assertEquals(dijkExpected, dijkActual);
    }

    @Test
    public void testShortPathDijk2() {
        adjList = new GraphAdjList(basicVertices2, basicEdges2);
        Map<Integer, Integer> dijkActual = GraphAlgs.shortPathDijk(0, adjList);
        Map<Integer, Integer> dijkExpected = new HashMap<>();
        dijkExpected.put(0, 0);
        dijkExpected.put(1, 7);
        dijkExpected.put(2, 11);
        dijkExpected.put(3, 15);
        dijkExpected.put(4, 14);
        dijkExpected.put(5, 17);

        assertEquals(dijkExpected, dijkActual);
    }

    @Test
    public void testShortPathDijk3() {
        adjList = new GraphAdjList(basicVertices3, basicEdges3);
        Map<Integer, Integer> dijkActual = GraphAlgs.shortPathDijk(0, adjList);
        Map<Integer, Integer> dijkExpected = new HashMap<>();
        dijkExpected.put(0, 0);
        dijkExpected.put(1, Integer.MAX_VALUE);
        dijkExpected.put(2, Integer.MAX_VALUE);
        dijkExpected.put(3, Integer.MAX_VALUE);
        dijkExpected.put(4, Integer.MAX_VALUE);
        dijkExpected.put(5, Integer.MAX_VALUE);

        assertEquals(dijkExpected, dijkActual);
    }

    @Test
    public void testShortPathDijk4() {
        adjList = new GraphAdjList(basicVertices4, basicEdges4);
        Map<Integer, Integer> dijkActual = GraphAlgs.shortPathDijk(0, adjList);
        Map<Integer, Integer> dijkExpected = new HashMap<>();
        dijkExpected.put(0, 0);
        dijkExpected.put(1, 7);
        dijkExpected.put(2, 4);
        dijkExpected.put(3, 4);
        dijkExpected.put(4, 4);
        dijkExpected.put(5, 4);

        assertEquals(dijkExpected, dijkActual);
    }


    @Test
    public void testShortPathDijk5() {
        adjList = new GraphAdjList(basicVertices5, basicEdges5);
        Map<Integer, Integer> dijkActual = GraphAlgs.shortPathDijk(0, adjList);
        Map<Integer, Integer> dijkExpected = new HashMap<>();
        dijkExpected.put(0, 0);
        dijkExpected.put(1, 1);
        dijkExpected.put(2, 2);
        dijkExpected.put(3, 3);
        dijkExpected.put(4, 4);
        assertEquals(dijkExpected, dijkActual);
    }

    @Test
    public void testShortPathDijk6() {
        adjList = new GraphAdjList(basicVertices6, basicEdges6);
        Map<Integer, Integer> dijkActual = GraphAlgs.shortPathDijk(0, adjList);
        Map<Integer, Integer> dijkExpected = new HashMap<>();
        dijkExpected.put(0, 0);
        dijkExpected.put(1, Integer.MAX_VALUE);
        dijkExpected.put(2, 17);
        dijkExpected.put(3, Integer.MAX_VALUE);
        dijkExpected.put(4, 8);
        dijkExpected.put(5, Integer.MAX_VALUE);
        assertEquals(dijkExpected, dijkActual);
    }

    
    @Test
    public void testShortPathDijk7() {
        adjList = new GraphAdjList(studentVerticesTwo, studentEdgesTwo);
        Map<Integer, Integer> dijkActual = GraphAlgs.shortPathDijk(0, adjList);
        Map<Integer, Integer> dijkExpected = new HashMap<>();
        dijkExpected.put(0, 0);
        dijkExpected.put(1, 14);
        dijkExpected.put(2, 11);
        dijkExpected.put(3, 3);
        dijkExpected.put(4, 2);
        dijkExpected.put(5, 7);
        dijkExpected.put(5, 7);

        assertEquals(dijkExpected, dijkActual);
    }
    
    @Test
    public void testShortPathDijk8() {
        adjList = new GraphAdjList(studentVerticesSix, studentEdgesSix);
        Map<Integer, Integer> dijkActual = GraphAlgs.shortPathDijk(0, adjList);
        Map<Integer, Integer> dijkExpected = new HashMap<>();
        dijkExpected.put(0, 0);
        dijkExpected.put(1, 1);
        dijkExpected.put(2, 2);
        dijkExpected.put(3, 5);
        dijkExpected.put(4, 9);
        dijkExpected.put(5, Integer.MAX_VALUE);

        assertEquals(dijkExpected, dijkActual);
    }
    
    @Test
    public void testShortPathDijk9() {
        adjList = new GraphAdjList(studentVerticesThree, studentEdgesThree);
        Map<Integer, Integer> dijkActual = GraphAlgs.shortPathDijk(0, adjList);
        Map<Integer, Integer> dijkExpected = new HashMap<>();
        dijkExpected.put(0, 0);
        dijkExpected.put(1, 1);
        dijkExpected.put(2, 1);
        dijkExpected.put(3, 2);
        dijkExpected.put(4, 2);
        dijkExpected.put(5, 3);

        assertEquals(dijkExpected, dijkActual);
    }
    @Test
    public void testMSTPrims() {
        adjList = new GraphAdjList(basicVertices, basicEdges);
        Set<Edge> mstActual = GraphAlgs.mstPrim(adjList);

        Set<Edge> mstExpected = new LinkedHashSet<>();
        mstExpected.add(new Edge(0, 3, 1, false));
        mstExpected.add(new Edge(2, 4, 2, false));
        mstExpected.add(new Edge(3, 5, 3, false));
        mstExpected.add(new Edge(3, 6, 4, false));
        mstExpected.add(new Edge(4, 6, 5, false));
        mstExpected.add(new Edge(1, 5, 6, false));
        System.out.println(mstExpected);
        assertEqualsSet(mstExpected, mstActual);
    }

    @Test
    public void testMSTPrims2() {
        adjList = new GraphAdjList(basicVertices2, basicEdges2);
        Set<Edge> mstActual = GraphAlgs.mstPrim(adjList);

        Set<Edge> mstExpected = new LinkedHashSet<>();
        mstExpected.add(new Edge(0, 1, 7, false));
        mstExpected.add(new Edge(1, 2, 4, false));
        mstExpected.add(new Edge(2, 4, 3, false));
        mstExpected.add(new Edge(2, 3, 5, false));
        mstExpected.add(new Edge(3, 5, 2, false));
        System.out.println(mstExpected);
        assertEqualsSet(mstExpected, mstActual);
    }

    @Test
    public void testMSTPrims3() {
        adjList = new GraphAdjList(basicVertices3, basicEdges3);
        Set<Edge> mstActual = GraphAlgs.mstPrim(adjList);

        Set<Edge> mstExpected = new LinkedHashSet<>();

        assertEqualsSet(mstExpected, mstActual);
    }

    @Test
    public void testMSTPrims4() {
        adjList = new GraphAdjList(basicVertices4, basicEdges4);
        Set<Edge> mstActual = GraphAlgs.mstPrim(adjList);

        Set<Edge> mstExpected = new LinkedHashSet<>();
        mstExpected.add(new Edge(0, 1, 7, false));
        mstExpected.add(new Edge(0, 2, 4, false));
        mstExpected.add(new Edge(0, 3, 4, false));
        mstExpected.add(new Edge(0, 4, 4, false));
        mstExpected.add(new Edge(0, 5, 4, false));
        System.out.println(mstExpected);
        assertEqualsSet(mstExpected, mstActual);
    }

    @Test
    public void testMSTPrims5() {
        adjList = new GraphAdjList(basicVertices5, basicEdges5);
        Set<Edge> mstActual = GraphAlgs.mstPrim(adjList);

        Set<Edge> mstExpected = new LinkedHashSet<>();
        mstExpected.add(new Edge(0, 1, 1, false));
        mstExpected.add(new Edge(0, 2, 2, false));
        mstExpected.add(new Edge(0, 3, 3, false));
        mstExpected.add(new Edge(0, 4, 4, false));
        System.out.println(mstExpected);
        assertEqualsSet(mstExpected, mstActual);
    }

    @Test
    public void testMSTPrims6() {
        adjList = new GraphAdjList(basicVertices6, basicEdges6);
        Set<Edge> mstActual = GraphAlgs.mstPrim(adjList);

        Set<Edge> mstExpected = new LinkedHashSet<>();
        mstExpected.add(new Edge(0, 4, 8, false));
        mstExpected.add(new Edge(2, 4, 9, false));
        mstExpected.add(new Edge(1, 3, 7, false));
        mstExpected.add(new Edge(1, 5, 1, false));
        System.out.println(mstExpected);
        assertEqualsSet(mstExpected, mstActual);
    }

    @Test
    public void testMSTPrims7() {
        adjList = new GraphAdjList(studentVerticesTwo, studentEdgesTwo);
        Set<Edge> mstActual = GraphAlgs.mstPrim(adjList);

        Set<Edge> mstExpected = new LinkedHashSet<>();
        mstExpected.add(new Edge(0, 4, 2, false));
        mstExpected.add(new Edge(4, 3, 1, false));
        mstExpected.add(new Edge(4, 5, 5, false));
        mstExpected.add(new Edge(5, 2, 4, false));
        mstExpected.add(new Edge(2, 1, 3, false));
        System.out.println(mstExpected);
        assertEqualsSet(mstExpected, mstActual);
    }
    

    @Test
    public void testMSTPrims8() {
        adjList = new GraphAdjList(studentVerticesFour, studentEdgesFour);
        Set<Edge> mstActual = GraphAlgs.mstPrim(adjList);

        Set<Edge> mstExpected = new LinkedHashSet<>();
        mstExpected.add(new Edge(0, 1, -1, false));
        mstExpected.add(new Edge(0, 2, -5, false));
        mstExpected.add(new Edge(2, 3, -3, false));
        mstExpected.add(new Edge(2, 4, -9, false));
        mstExpected.add(new Edge(3, 6, 2, false));
        mstExpected.add(new Edge(6, 5, -6, false));
        System.out.println("E:" + mstExpected);
        assertEqualsSet(mstExpected, mstActual);
    }
    
    
    @Test
    public void testMSTKruskals() {
        adjList = new GraphAdjList(basicVertices, basicEdges);
        Set<Edge> mstActual = GraphAlgs.mstKruskal(adjList);

        Set<Edge> mstExpected = new LinkedHashSet<>();
        mstExpected.add(new Edge(0, 3, 1, false));
        mstExpected.add(new Edge(2, 4, 2, false));
        mstExpected.add(new Edge(3, 5, 3, false));
        mstExpected.add(new Edge(3, 6, 4, false));
        mstExpected.add(new Edge(4, 6, 5, false));
        mstExpected.add(new Edge(1, 5, 6, false));

        assertEqualsSet(mstExpected, mstActual);
    }

    @Test
    public void testMSTKruskals2() {
        adjList = new GraphAdjList(basicVertices2, basicEdges2);
        Set<Edge> mstActual = GraphAlgs.mstKruskal(adjList);

        Set<Edge> mstExpected = new LinkedHashSet<>();
        mstExpected.add(new Edge(3, 5, 2, false));
        mstExpected.add(new Edge(2, 4, 3, false));
        mstExpected.add(new Edge(1, 2, 4, false));
        mstExpected.add(new Edge(2, 3, 5, false));
        mstExpected.add(new Edge(1, 0, 7, false));

        assertEqualsSet(mstExpected, mstActual);
    }


    @Test
    public void testMSTKruskals3() {
        adjList = new GraphAdjList(basicVertices3, basicEdges3);
        Set<Edge> mstActual = GraphAlgs.mstKruskal(adjList);

        Set<Edge> mstExpected = new LinkedHashSet<>();

        assertEqualsSet(mstExpected, mstActual);
    }

    @Test
    public void testMSTKruskals4() {
        adjList = new GraphAdjList(basicVertices4, basicEdges4);
        Set<Edge> mstActual = GraphAlgs.mstKruskal(adjList);

        Set<Edge> mstExpected = new LinkedHashSet<>();
        mstExpected.add(new Edge(0, 1, 7, false));
        mstExpected.add(new Edge(0, 2, 4, false));
        mstExpected.add(new Edge(0, 3, 4, false));
        mstExpected.add(new Edge(0, 4, 4, false));
        mstExpected.add(new Edge(0, 5, 4, false));
        assertEqualsSet(mstExpected, mstActual);
    }

    @Test
    public void testMSTKruskals5() {
        adjList = new GraphAdjList(basicVertices5, basicEdges5);
        Set<Edge> mstActual = GraphAlgs.mstKruskal(adjList);

        Set<Edge> mstExpected = new LinkedHashSet<>();
        mstExpected.add(new Edge(0, 1, 1, false));
        mstExpected.add(new Edge(0, 2, 2, false));
        mstExpected.add(new Edge(0, 3, 3, false));
        mstExpected.add(new Edge(0, 4, 4, false));
        assertEqualsSet(mstExpected, mstActual);
    }

    @Test
    public void testMSTKruskals6() {
        adjList = new GraphAdjList(basicVertices6, basicEdges6);
        Set<Edge> mstActual = GraphAlgs.mstKruskal(adjList);

        Set<Edge> mstExpected = new LinkedHashSet<>();
        mstExpected.add(new Edge(0, 4, 8, false));
        mstExpected.add(new Edge(2, 4, 9, false));
        mstExpected.add(new Edge(1, 3, 7, false));
        mstExpected.add(new Edge(1, 5, 1, false));
        assertEqualsSet(mstExpected, mstActual);
    }
    
    @Test
    public void testMSTKruskal7() {
        adjList = new GraphAdjList(studentVerticesTwo, studentEdgesTwo);
        Set<Edge> mstActual = GraphAlgs.mstKruskal(adjList);

        Set<Edge> mstExpected = new LinkedHashSet<>();
        mstExpected.add(new Edge(0, 4, 2, false));
        mstExpected.add(new Edge(4, 3, 1, false));
        mstExpected.add(new Edge(4, 5, 5, false));
        mstExpected.add(new Edge(5, 2, 4, false));
        mstExpected.add(new Edge(2, 1, 3, false));

        assertEqualsSet(mstExpected, mstActual);
    }
    
    @Test
    public void testMSTKruskal8() {
        adjList = new GraphAdjList(studentVerticesFour, studentEdgesFour);
        Set<Edge> mstActual = GraphAlgs.mstKruskal(adjList);

        Set<Edge> mstExpected = new LinkedHashSet<>();
        mstExpected.add(new Edge(0, 1, -1, false));
        mstExpected.add(new Edge(0, 2, -5, false));
        mstExpected.add(new Edge(2, 3, -3, false));
        mstExpected.add(new Edge(2, 4, -9, false));
        mstExpected.add(new Edge(3, 6, 2, false));
        mstExpected.add(new Edge(6, 5, -6, false));

        assertEqualsSet(mstExpected, mstActual);
    }

    /**
     * Checks to see if two sets are the same.
     *
     * @param expected Expected set result.
     * @param actual Actual set result.
     */
    public void assertEqualsSet(Set<Edge> expected, Set<Edge> actual) {
        assertEquals(expected.size(), actual.size());
        for (Edge e : expected) {
            assertTrue(actual.contains(e));
        }
    }
}

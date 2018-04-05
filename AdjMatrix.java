import java.io.*;
import java.util.*;


/**
 * Adjacency matrix implementation for the FriendshipGraph interface.
 * 
 * Your task is to complete the implementation of this class.  You may add methods, but ensure your modified class compiles and runs.
 *
 * @author Jeffrey Chan, 2016.
 */
public class AdjMatrix <T extends Object> implements FriendshipGraph<T>
{
    ArrayList<T> vertices;
    ArrayList<ArrayList<Integer>> matrixCol;
    ArrayList<Integer> matrixRow;

    Integer notConn = 0;
    Integer conn = 1;

	/**
	 * Contructs empty graph.
	 */
    public AdjMatrix() {
    	// Implement me!

        matrixCol = new ArrayList<ArrayList<Integer>>();

        vertices = new ArrayList<T>();       

    } // end of AdjMatrix()
    

    
    public void addVertex(T vertLabel) {
        // Implement me!

    	matrixRow = new ArrayList<Integer>();
		vertices.add(vertLabel);

    	for (int i = 0; i<vertices.size();i++) {
    		matrixRow.add(notConn);
    	}
    	matrixCol.add(matrixRow);

        int newVert = vertices.indexOf(vertLabel);

        for (int i = 0; i<vertices.size()-1;i++) {
        	matrixCol.get(i).add(newVert, notConn);
        }

    } // end of addVertex()
	
   
    public void addEdge(T srcLabel, T tarLabel) {
//         // Implement me!

        int vert1 = vertices.indexOf(srcLabel);
        int vert2 = vertices.indexOf(tarLabel);

        matrixCol.get(vert2).set(vert1, conn);
        matrixCol.get(vert1).set(vert2, conn);

        // for (int i=0;i<matrixCol.get(0).size();i++) {
        //     for(int j=0;j<matrixCol.get(0).size();j++) {
        //         if (matrixCol.get(i).get(j) != conn) {
        //             matrixCol.get(i).set(j, notConn);
        //         }
        //     }
        // }

    } // end of addEdge()
	

    public ArrayList<T> neighbours(T vertLabel) {
        ArrayList<T> neighbours = new ArrayList<T>();
//         // Implement me!
        
        int vert = vertices.indexOf(vertLabel); 
        for (int i=0;i<vertices.size();i++) {
            if (matrixCol.get(vert).get(i) == conn) {
                neighbours.add(vertices.get(i));
            }
        }

        return neighbours;
    } // end of neighbours()
    
    
    public void removeVertex(T vertLabel) {
//         // Implement me!

        int vert = vertices.indexOf(vertLabel);

        for (int i =0;i<vertices.size();i++) {
        	matrixCol.get(i).remove(vert);
        }

        vertices.remove(vert);
        matrixCol.remove(vert);

    } // end of removeVertex()
	
    
    public void removeEdge(T srcLabel, T tarLabel) {
//         // Implement me!

        int vert1 = vertices.indexOf(srcLabel);
        int vert2 = vertices.indexOf(tarLabel);

        matrixCol.get(vert1).set(vert2, notConn);
        matrixCol.get(vert2).set(vert1, notConn);

    } // end of removeEdges()
	
    
    public void printVertices(PrintWriter os) {
//         // Implement me!

        for (int i=0;i<vertices.size();i++) {
            os.print(vertices.get(i)+" ");
        }   
    	os.println();
        os.flush();

    } // end of printVertices()
	
    
    public void printEdges(PrintWriter os) {
//         // Implement me!

    	for (int i=0;i<vertices.size();i++) {
    		for (int j=0;j<vertices.size();j++) {
    			if (matrixCol.get(i).get(j) == conn) {
    				os.print(vertices.get(i));
                    os.println(vertices.get(j));
    			}
    		}
    	}
    	os.flush();

    } // end of printEdges()
    
    
    public int shortestPathDistance(T vertLabel1, T vertLabel2) {
     	// Implement me!
    	
        int src = vertices.indexOf(vertLabel1);
        int dest = vertices.indexOf(vertLabel2);
        int vSize = vertices.size();
        T curVertex;

        // 1 is visited, 0 is not visited
        int[] visited = new int[vSize];
        for (int i=0;i<vSize;i++) {
            visited[i] = 0;
        }
        visited[src] = 1;

        Queue<T> q = new LinkedList<T>();
        HashMap<T, T> fam = new HashMap<T, T>();

        q.add(vertLabel1);
        fam.put(vertLabel1, null);

        while(!q.isEmpty()) {
            curVertex = q.remove();
            int v = vertices.indexOf(curVertex);
            for (int i=0;i<vSize;i++) {
                if (visited[i]!=1 && matrixCol.get(v).get(i)==1) {
                    visited[i]=1;
                    q.add(vertices.get(i));
                    fam.put(vertices.get(i), curVertex);
                }
            }
        }

        if (fam.get(vertLabel2) == null) {
            return disconnectedDist;
        } else {
            ArrayList<T> path = new ArrayList<T>();
            T des = vertLabel2;
            while (des != null) {
                path.add(des);
                des = fam.get(des);
            }

            return path.size()-1;
        }   	
    } // end of shortestPathDistance()


} // end of class AdjMatrix
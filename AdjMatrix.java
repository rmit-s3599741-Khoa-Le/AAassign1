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
    ArrayList<ArrayList<T>> matrixCol;
    ArrayList<T> matrixRow;


    T notConn = (T)(Integer)0;
    T conn = (T)(Integer)1;

	/**
	 * Contructs empty graph.
	 */
    public AdjMatrix() {
    	// Implement me!

        matrixCol = new ArrayList<ArrayList<T>>();
		matrixRow = new ArrayList<T>();       
        matrixRow.add(notConn);
        matrixCol.add(matrixRow);

    } // end of AdjMatrix()
    

    
    public void addVertex(T vertLabel) {
        // Implement me!

        // adjMatrix.get(0).set(adjMatrix.size(), vertLabel);
        // adjMatrix.get(0).add(vertLabel);
        // adjMatrix.get(adjMatrix.size()).set(vertLabel); 
        // ArrayList<T> eg = adjMatrix.get(adjMatrix.size());
        // eg.set(eg.size(),vertLabel); 

    	matrixCol.get(0).add(vertLabel);
    	matrixRow = new ArrayList<T>();
    	matrixRow.add(vertLabel);
    	for (int i=1;i<matrixCol.get(0).size();i++) {
    		matrixRow.add(notConn);
    	}
    	matrixCol.add(matrixRow);

    } // end of addVertex()
	
    
    public void addEdge(T srcLabel, T tarLabel) {
        // Implement me!

        int vert1 = matrixCol.get(0).indexOf(srcLabel);
        int vert2 = matrixCol.get(0).indexOf(tarLabel);

        // ArrayList<T> addeg = adjMatrix.get(vert1);
        // addeg.set(vert2, conn);
        // adjMatrix.get(vert1).set(vert2, conn);
        // adjMatrix.get(vert2).set(vert1, conn);

        matrixCol.get(vert2).set(vert1, conn);
        matrixCol.get(vert1).set(vert2, conn);

    } // end of addEdge()
	

    public ArrayList<T> neighbours(T vertLabel) {
        ArrayList<T> neighbours = new ArrayList<T>();
        // Implement me!
        
        int vert = matrixCol.get(0).indexOf(vertLabel); 
        for (int i=1;i<matrixCol.get(0).size();i++) {
            if ((Integer)matrixCol.get(vert).get(i) == 1) {
                neighbours.add(matrixCol.get(0).get(i));
            }
        }

        return neighbours;
    } // end of neighbours()
    
    
    public void removeVertex(T vertLabel) {
        // Implement me!

        int vert = matrixCol.get(0).indexOf(vertLabel);
        for (int i=0;i<matrixCol.size();i++) {
            matrixCol.get(i).remove(vert);
        }
        matrixCol.remove(vert);

    } // end of removeVertex()
	
    
    public void removeEdge(T srcLabel, T tarLabel) {
        // Implement me!

        int vert1 = matrixCol.get(0).indexOf(srcLabel);
        int vert2 = matrixCol.get(0).indexOf(tarLabel);

        matrixCol.get(vert1).set(vert2, notConn);
        matrixCol.get(vert2).set(vert1, notConn);

    } // end of removeEdges()
	
    
    public void printVertices(PrintWriter os) {
        // Implement me!

        for (int i=1;i<matrixCol.size();i++) {
            String vertices = (String)matrixCol.get(0).get(i);
            os.print(vertices+" ");
        }   

    } // end of printVertices()
	
    
    public void printEdges(PrintWriter os) {
        // Implement me!

    	for (int i=1;i<matrixCol.size();i++) {
    		for (int j=1;j<matrixCol.size();j++) {
    			if (matrixCol.get(i).get(j) == conn) {
    				os.print(matrixCol.get(0).get(i).toString());
    			}
    		}
    	}

    } // end of printEdges()
    
    
    public int shortestPathDistance(T vertLabel1, T vertLabel2) {
    	// Implement me!
    	
    	int src = matrixCol.get(0).indexOf(vertLabel1);
    	int dest = matrixCol.get(0).indexOf(vertLabel2);

    	ArrayList<String> path = new ArrayList<>();
		path.add(matrixCol.get(src).toString());

    	for (int i=1;i<matrixCol.size();i++) {
    		if (matrixCol.get(src).get(i) == conn) {
    			String connection = matrixCol.get(src)+ "" + matrixCol.get(i);
    			path.add(connection);
    		}
    	}

    	for (int j=0;j<path.size();j++) {
    		String s = path.get(j)+"";
    		T str = (T)(String) s;
    		int nextChar = matrixCol.get(0).indexOf(str);
    		for (int k=0;k<matrixCol.size();k++) {
    			if (matrixCol.get(nextChar).get(k) == conn

    				) {
    				
    			}
    		}
    	}
    	

        // if we reach this point, source and target are disconnected
        return disconnectedDist;    	
    } // end of shortestPathDistance()


} // end of class AdjMatrix
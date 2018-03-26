import java.io.*;
import java.util.*;


/**
 * Incidence matrix implementation for the FriendshipGraph interface.
 * 
 * Your task is to complete the implementation of this class.  You may add methods, but ensure your modified class compiles and runs.
 *
 * @author Jeffrey Chan, 2016.
 */
public class IndMatrix <T extends Object> implements FriendshipGraph<T>
{
    /* private ArrayList<ArrayList<T>> matrixCol;
    private ArrayList<T> matrixRow;
    private int i = 0;
    T notConn = (T)(Integer)0;
    T conn = (T)(Integer)1; */
    ArrayList<ArrayList<Integer>> matrixCol;
    ArrayList<Integer> matrixRow;
    ArrayList<T> vert;
	/**
	 * Contructs empty graph.
	 */
    public IndMatrix() {
    	// Implement me!
        matrixCol = new ArrayList<ArrayList<Integer>>();
        vert = new ArrayList<T>();
        // matrixRow = new ArrayList<T>();
        // matrixCol.add(matrixRow);
    } // end of IndMatrix()
    
    
    public void addVertex(T vertLabel) {
        // Implement me!
        vert.add(vertLabel);
    } // end of addVertex()
	
    
    public void addEdge(T srcLabel, T tarLabel) {
        // Implement me!
        
        matrixRow = new ArrayList<Integer>(); // creating a new row
        for(int i = 0; i < vert.size(); i++) {
            
            if(vert.get(i).equals(srcLabel) || vert.get(i).equals(tarLabel)) { 
                matrixRow.add(1);
            }
            else {
                matrixRow.add(0);
            }
        }
        
        matrixCol.add(matrixRow);
        /**
        matrixRow = new ArrayList<T>();     
        for(int i = 0; i < matrixCol.get(0).size(); i++) {
            if(matrixCol.get(0).contains(srcLabel) || matrixCol.get(0).contains(tarLabel)) {
                matrixRow.add(conn);
            }
            else {
                matrixRow.add(notConn);
            }
        }
        matrixCol.add(matrixRow);
        **/
    } // end of addEdge()
	

    public ArrayList<T> neighbours(T vertLabel) {
        ArrayList<T> neighbours = new ArrayList<T>();
        
        // Implement me!
        
        return neighbours;
    } // end of neighbours()
    
    
    public void removeVertex(T vertLabel) {
        // Implement me!
        int temp = 0;
        for(int i = 0; i < vert.size(); i++) {
            if(vert.get(i) == vertLabel) {
                vert.remove(i);
                temp = i;
            }
        }
        
        for(int j = 0; j < matrixCol.size(); j++) {
            if(matrixCol.get(j).get(temp) == 1) {
                matrixCol.remove(j);
            }
            else {
                matrixCol.get(j).remove(temp);
            }
        }
        
    } // end of removeVertex()
	
    
    public void removeEdge(T srcLabel, T tarLabel) {
        // Implement me!
        
    } // end of removeEdges()
	
    
    public void printVertices(PrintWriter os) {
        // Implement me!
        for(T object : vert) {
            String vertex = (String)object;
            System.out.printf("%s ", vertex);
            os.print(vertex + " ");
        }
    } // end of printVertices()
	
    
    public void printEdges(PrintWriter os) {
        // Implement me!
        for(ArrayList<Integer> array : matrixCol) {
            for(int i = 0; i < array.size(); i++) {
                if(array.get(i) == 1) {
                    String value = (String)vert.get(i);
                    System.out.printf("%s ", value);
                }
            }
            System.out.println();
        }
    } // end of printEdges()
    
    
    public int shortestPathDistance(T vertLabel1, T vertLabel2) {
    	// Implement me!
    	
        // if we reach this point, source and target are disconnected
        return disconnectedDist;    	
    } // end of shortestPathDistance()
    
} // end of class IndMatrix

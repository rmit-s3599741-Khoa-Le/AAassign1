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
    } // end of addEdge()
	

    public ArrayList<T> neighbours(T vertLabel) {
        ArrayList<T> neighbours = new ArrayList<T>();      
        // Implement me!
        int temp = 0; int count = 0;
        
        for(int i = 0; i < vert.size(); i++) { // find where vertLabel is located in vert
            if(vert.get(i).equals(vertLabel)) {
                temp = i;
                break;
            }
        }
        
        for(int j = 0; j < matrixCol.size(); j++) {
            if(temp < matrixCol.get(j).size()) {
                if(matrixCol.get(j).get(temp) == 1) { // find if row with vertLabel
                    for(int jj = 0; jj < matrixCol.get(j).size(); jj++) {
                        if(matrixCol.get(j).get(jj) == 1 && jj != temp) { // find which vertex it's connected
                            neighbours.add(vert.get(jj)); // add to array
                        }
                    }
                }
            }
            else {
                continue;
            }
        }
        
        return neighbours;
    } // end of neighbours()
    
    
    public void removeVertex(T vertLabel) {
        // Implement me!
        int temp = 0;
        for(int i = 0; i < vert.size(); i++) { // to find the position of deleted value
            if(vert.get(i).equals(vertLabel)) {    
                temp = i;
                vert.remove(vertLabel);
            }
        }
        
        for(int j = 0; j < matrixCol.size(); j++) { // loop through to each row
            if(matrixCol.get(j).get(temp) == 1) { // find if current row has deleted value
                matrixCol.remove(j); // remove row
            }
            else {
                matrixCol.get(j).remove(temp); // delete column from row
            }
        }
        
    } // end of removeVertex()
	
    
    public void removeEdge(T srcLabel, T tarLabel) {
        // Implement me!
        int srcCount = 0;
        int tarCount = 0;
        int count = 0;
        for(T object : vert) {
            if(object.equals(srcLabel)) {
                srcCount = count;
            }
            else if(object.equals(tarLabel)) {
                tarCount = count;
            }
            if(srcCount != 0 && tarCount != 0) { break; } // don't need to go through every value
            count++;
        }
        
        for(int i = 0; i < matrixCol.size(); i++) { // loop through rows to delete certain column
            if(matrixCol.get(i).get(srcCount) == 1 && matrixCol.get(i).get(tarCount) == 1) {
                matrixCol.remove(i);
                break;
            }
        }
        
        
        
    } // end of removeEdges()
	
    
    public void printVertices(PrintWriter os) {
        // Implement me!
        for(T object : vert) {
            String vertex = (String)object;
            System.out.printf("%s ", vertex);
            os.print(vertex + " ");
        }
        System.out.println();
    } // end of printVertices()
	
    
    public void printEdges(PrintWriter os) {

        int count = 0;
        for(int i = 0; i < matrixCol.size(); i++) {
            for(int j = 0; j < matrixCol.get(i).size(); j++) {
                if(matrixCol.get(i).get(j) == 1) {
                    count++;
                    String value = (String)vert.get(j);
                    System.out.printf("%s ", value);
                    if(count == 2) { break; }
                }
            }
            count = 0;
            System.out.println();
        }
    } // end of printEdges()
    
    
    public int shortestPathDistance(T vertLabel1, T vertLabel2) {
    	// Implement me!
    	
        // if we reach this point, source and target are disconnected
        return disconnectedDist;    	
    } // end of shortestPathDistance()
    
} // end of class IndMatrix

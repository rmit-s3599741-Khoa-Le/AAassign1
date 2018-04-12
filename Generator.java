import java.io.*;
import java.util.*;

public class Generator {
    
    private static int small_input = 100;
    private static int medium_input = 1000;
    private static int large_input = 10000;
    
    private static ArrayList<String> vertices = new ArrayList<>();
    private static ArrayList<String> edges = new ArrayList<>();
    private static Random random = new Random();
    
    static PrintWriter outputStream = null;

    public static void main(String[] args) {
        readFile();
        double density = (2 * edges.size()) / (vertices.size() * (vertices.size() - 1));
        double desiredDensity;
        
        for(int i = 2; i < 11; i++) { // Change to fitted density.
            desiredDensity = density + (i * 0.01);
            String fileName = "facebook_combined_" + desiredDensity;
            increaseDensity(fileName, desiredDensity);
        } 
        generateVerticeData("small_AV", small_input);
        generateVerticeData("medium_AV", medium_input);
        generateVerticeData("large_AV", large_input);
        generateEdgesData("small_AE", small_input);
        generateEdgesData("medium_AE", medium_input);
        generateEdgesData("large_AE", large_input);
        generateNearestNeighbour("small_NN", small_input);
        generateNearestNeighbour("medium_NN", medium_input);
        generateNearestNeighbour("large_NN", large_input);
        generateShortDistance("small_S", small_input);
        generateShortDistance("medium_S", medium_input);
        generateShortDistance("large_S", large_input);
        generateDeletedVertices("small_RV", small_input);
        generateDeletedVertices("medium_RV", medium_input);
        generateDeletedVertices("large_RV", large_input);
        generateDeletedEdges("small_RE", small_input);
        generateDeletedEdges("medium_RE", medium_input);
        generateDeletedEdges("large_RE", large_input);
        
        
    }
    
    private static void readFile() {
        try {
            
            FileInputStream fstream = new FileInputStream("facebook_combined.txt");
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            
            while ((strLine = br.readLine()) != null) {
                edges.add(strLine);
            }

            for (int k = 0; k < edges.size();k++) { // add not repeated values
                
                String[] tokens = edges.get(k).split(" ");
                if(!vertices.contains(tokens[0])) {
                    vertices.add(tokens[0]);
                }
                if(!vertices.contains(tokens[1])) {
                    vertices.add(tokens[1]);
                }
            }
        }
        catch (Exception e) {
            System.err.println("Cannot read file");
        }
    }
    
    private static void increaseDensity(String fileName, double desiredDensity) {
        // increasing density by adding more edges to the file
        double numOfInput = (desiredDensity * (vertices.size() * (vertices.size()-1)))/2;
        int sizeOfInput = (int)numOfInput - edges.size();
        
        try {
            outputStream = new PrintWriter(new File(fileName + ".txt"));
            for(int i = 0; i < edges.size(); i++) {
                outputStream.printf(edges.get(i) + "\n");
            }
            for(int j = 0; j < sizeOfInput; j++) {
                outputStream.printf((random.nextInt(1000000 - vertices.size()) + vertices.size()) + " " + (random.nextInt(1000000 - vertices.size()) + vertices.size()) + "\n");
            } 
            outputStream.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Error creating file");
        }
        //add random edges.
        
    }
    
    
    private static void generateVerticeData(String fileName, int sizeOfInput) {
        
        try {
            outputStream = new PrintWriter(new File(fileName + ".in"));
            for(int j = 0; j < sizeOfInput; j++) {
                outputStream.printf("AV " + (random.nextInt(1000000 - 4039) + 4039) + "\n");
            } 
            outputStream.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Error creating file");
        }   
    }
    
    private static void generateEdgesData(String fileName, int sizeOfInput) { // need to complete.
        try {
            outputStream = new PrintWriter(new File(fileName + ".in"));
            for(int i = 0; i < sizeOfInput; i++) {
                outputStream.printf("AE " + vertices.get(random.nextInt(vertices.size())) + " " + vertices.get(random.nextInt(vertices.size())) + "\n");
            }
            outputStream.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Error creating file");
        }
    }
    
    private static void generateShortDistance(String fileName, int sizeOfInput) {
        try {
            outputStream = new PrintWriter(new File(fileName + ".in"));
            for(int i = 0; i < sizeOfInput; i++) {
                outputStream.printf("S " + vertices.get(random.nextInt(vertices.size())) + " " + vertices.get(random.nextInt(vertices.size())) + "\n");
            }
            outputStream.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Error creating file.");
        }
        
    }
    
    private static void generateNearestNeighbour(String fileName, int sizeOfInput) {
        try {
            outputStream = new PrintWriter(new File(fileName + ".in"));
            for(int i = 0; i < sizeOfInput; i++) {
                outputStream.printf("N " + vertices.get(random.nextInt(vertices.size())) + " " + vertices.get(random.nextInt(vertices.size())) + "\n");
            }
            outputStream.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Error creating file.");
        }
    }
    
    private static void generateDeletedEdges(String fileName, int sizeOfInput) {
        try {
            outputStream = new PrintWriter(new File(fileName + ".in"));
            for(int i = 0; i < sizeOfInput; i++) {
                outputStream.printf("RE " + vertices.get(random.nextInt(vertices.size())) + " " + vertices.get(random.nextInt(vertices.size())) + "\n");
            }
            outputStream.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Error creating file.");
        }
    }

    private static void generateDeletedVertices(String fileName, int sizeOfInput) {
        try {
            outputStream = new PrintWriter(new File(fileName + ".in"));
            for(int i = 0; i < sizeOfInput; i++) {
                outputStream.printf("RV " + vertices.get(random.nextInt(vertices.size())) + " " + vertices.get(random.nextInt(vertices.size())) + "\n");
            }
            outputStream.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Error creating file.");
        }
    }
    
}
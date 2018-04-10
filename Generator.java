import java.io.*;
import java.util.*;
public class Generator {

	public static void main(String args[]) throws FileNotFoundException {
		try {
			ArrayList<String> arrayList = new ArrayList<>();
			ArrayList<String> vertices = new ArrayList<>();
			ArrayList<String> outRangeNum = new ArrayList<>();
			ArrayList<String> newVertices = new ArrayList<>();
			ArrayList<String> newEdges = new ArrayList<>();
			Set<String> hashSet = new HashSet<>();
			Random random = new Random();
			
			FileInputStream fstream = new FileInputStream("facebook_combined.txt");
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;

			while ((strLine = br.readLine()) != null) {
				arrayList.add(strLine);
			}

			for (int k=0;k<arrayList.size();k++) {
				String[] tokens = arrayList.get(k).split(" ");
				
				if (vertices.indexOf(tokens[0])==-1) {
					vertices.add(tokens[0]);
				}
				if (vertices.indexOf(tokens[1])==-1) {
					vertices.add(tokens[1]);
				}
			}
			hashSet.addAll(vertices);
			vertices.clear();
			vertices.addAll(hashSet);

			// for (int i=0;i<10000;i++) {
			// 	if (vertices.indexOf(i)==-1) {
			// 		outRangeNum.add(String.valueOf(i));
			// 	}
			// }

			// for (int j=0;j<100;j++) {
			// 	newVertices.add(outRangeNum.get(random.nextInt(outRangeNum.size())));
			// }

			// vertices.addAll(newVertices);


			///// find neighbor ///////////////////////////////////////////////////////////////////////////
			// for (int n=0;n<160000;n++) {
			// 	newEdges.add(vertices.get(random.nextInt(vertices.size())) + 
			// 		" " + vertices.get(random.nextInt(vertices.size())));
			// }

			// BufferedWriter out = new BufferedWriter(new FileWriter("neighbor.in"));
			// for (int m=0;m<newEdges.size();m++) {
			// 	out.write("AE "+ newEdges.get(m)+"\n");
			// }
			// out.write("N " + vertices.get(random.nextInt(vertices.size())));
			// out.close();
			// in.close();
			//////////////////////////////////////////////////////////////////////////////////////////////


			///// find shortpath ///////////////////////////////////////////////////////////////////////////
			for (int n=0;n<160000;n++) {
				newEdges.add(vertices.get(random.nextInt(vertices.size())) + 
					" " + vertices.get(random.nextInt(vertices.size())));
			}

			BufferedWriter out = new BufferedWriter(new FileWriter("shortpath.in"));
			for (int m=0;m<newEdges.size();m++) {
				out.write("AE "+ newEdges.get(m)+"\n");
			}
			out.write("S " + vertices.get(random.nextInt(vertices.size())) + " " + vertices.get(random.nextInt(vertices.size())));
			out.close();
			in.close();
			//////////////////////////////////////////////////////////////////////////////////////////////
			
			// BufferedWriter out = new BufferedWriter(new FileWriter("data.in"));
			// for (int l=0;l<newVertices.size();l++) {
			// 	out.write("AV "+ newVertices.get(l)+"\n");
			// }
			// for (int m=0;m<newEdges.size();m++) {
			// 	out.write("AE "+ newEdges.get(m)+"\n");
			// }
			// out.close();
			// in.close();

			// BufferedWriter small = new BufferedWriter(new FileWriter("small.in"));
			// for (int j=0;j<100;j++) {
			// 	newVertices.add(outRangeNum.get(random.nextInt(outRangeNum.size())));
			// }
			// for (int l=0;l<newVertices.size();l++) {
			// 	small.write("AV "+ newVertices.get(l)+"\n");
			// }
			// small.close();
			// in.close();

			// newVertices.clear();
			// BufferedWriter medium = new BufferedWriter(new FileWriter("medium.in"));
			// for (int j=0;j<1000;j++) {
			// 	newVertices.add(outRangeNum.get(random.nextInt(outRangeNum.size())));
			// }
			// for (int l=0;l<newVertices.size();l++) {
			// 	medium.write("AV "+ newVertices.get(l)+"\n");
			// }
			// medium.close();
			// in.close();

			// newVertices.clear();
			// BufferedWriter big = new BufferedWriter(new FileWriter("big.in"));
			// for (int j=0;j<4000;j++) {
			// 	newVertices.add(outRangeNum.get(random.nextInt(outRangeNum.size())));
			// }
			// for (int l=0;l<newVertices.size();l++) {
			// 	big.write("AV "+ newVertices.get(l)+"\n");
			// }
			// big.close();
			// in.close();			




		} catch (Exception e) {
			System.err.println("Error: "+e.getMessage());
		}
	}
}

import java.io.*;
import java.util.*;
public class Generator {

	public static void main(String args[]) throws FileNotFoundException {
		try {
			ArrayList<String> arrayList = new ArrayList<>();
			ArrayList<String> randomList = new ArrayList<>();
			ArrayList<String> vertices = new ArrayList<>();
			Random random = new Random();
			
			FileInputStream fstream = new FileInputStream("input.txt");
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			while ((strLine = br.readLine()) != null) {
				arrayList.add(strLine);
				
				//String[] tokens = strLine.split(" ");
				//System.out.println(tokens[0] + " " + tokens[1]);
			}
			for (int i=0;i<5;i++) {
				// i = number of lines wanted to add
				randomList.add(arrayList.get(random.nextInt(21)));
			}
			for (int k=0;k<randomList.size();k++) {
				String[] tokens = randomList.get(k).split(" ");
				
				if (vertices.indexOf(tokens[0])==-1) {
					vertices.add(tokens[0]);
				}
				if (vertices.indexOf(tokens[1])==-1) {
					vertices.add(tokens[1]);
				}
			}

			
			//FileOutputStream fo = new FileOutputStream("data.txt");
			
			//for (int l=0;l<vertices.size();l++) {
			//	int vert = Integer.parseInt(vertices.get(l));
			//	fo.write(vert);
			//}
			
			//fo.close();
			
			BufferedWriter out = new BufferedWriter(new FileWriter("data.in"));
			for (int l=0;l<vertices.size();l++) {
				out.write("AV "+ vertices.get(l)+"\n");
			}
			for (int m=0;m<randomList.size();m++) {
				out.write("AE "+ randomList.get(m)+"\n");
			}
			out.close();
			in.close();
		} catch (Exception e) {
			System.err.println("Error: "+e.getMessage());
		}
	}
}

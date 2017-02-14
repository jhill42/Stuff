import java.io.*;
import java.util.*;

public class crossroad {
	
	
	public static void main(String[] args) throws IOException {
	int counter = 0;
	BufferedReader br = new BufferedReader(new FileReader("crossroad.in"));
	PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("crossroad.out")));
	
	int n = Integer.parseInt(br.readLine());
	
	int[][] entries = new int[n][2];
	
	for(int i=0; i<n; i++){
		entries[i][0] = Integer.parseInt(br.readLine()); 
		
		if(entries[i][0] % 10 == 1){
			entries[i][1] = 1;
			entries[i][0] = (entries[i][0] - 1)/10;
		}else{
			entries[i][1] = 0;
			entries[i][0] = entries[i][0]/10;
		}
	}
	
	for(int i = 0; i < (n-1); i++){
		if(entries[i][1] == entries[i+1][1]){
			counter++;
		}
	}
	
			br.close();
	// print the answer
			pw.println(counter);
			
			// close the file
			pw.close();
	}
}

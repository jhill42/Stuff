import java.io.*;
import java.util.*;

public class circlecross {

	public static void main(String[] args) throws IOException {
		int crossings = 0;
		BufferedReader br = new BufferedReader(new FileReader("circlecross.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("circlecross.out")));
		
		int[][] cross = new int[26][2];
		
		for(int i=0; i<26; i++){
			cross[i][0] = 200;
		}
		
		for(int i=0; i<52; i++){
			if(cross[(int)br.read() - 65][0] == 200){
				cross[(int)br.read() - 65][0] = i;
			}else{
				cross[(int)br.read() - 65][1] = i;
			}
			
		}
		
		br.close();
		
		for(int i=0; i<26; i++){
			for(int j=0; j<26; j++){
				if(cross[j][0] > cross[i][0] && cross[j][1] < cross[i][1]){
					crossings++;
				}
			}
			cross[i][0] = -1;
			cross[i][1] = -1;
		}	
		pw.println(crossings);
		pw.close();
	}
}

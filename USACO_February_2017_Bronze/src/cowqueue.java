import java.io.*;
import java.util.*;

public class cowqueue{
	
	boolean busy = false;
	
	public static void main(String[] args) throws IOException{
		final String probName = new Throwable().getStackTrace()[0].getClassName();
		BufferedReader br = new BufferedReader(new FileReader(probName + ".in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(probName + ".out")));
		
		int timer = 0;
		int nextAvailable = -1;
		//int maxStart = 0;
		boolean finished = false;
		
		int n = Integer.parseInt(br.readLine());
		int[][] times = new int[n][2];
		
		for(int i = 0; i < n; i++){
			String string = br.readLine();
			String[] parts = string.split(" ");
			times[i][0] = Integer.parseInt(parts[0]);
			times[i][1] = Integer.parseInt(parts[1]);
			//if(times[i][0] > maxStart){maxStart = times[i][0];}
		}
		
		br.close();
		
		while(!finished){
			ArrayList<int[]> startNow = new ArrayList<int[]>();
			for(int i=0; i < n; i++){
				if(times[i][0] == timer){
					startNow.add(times[i]);
					times[i] = null;
				}
			}
			
			if(timer >= nextAvailable){
				while(!(startNow == null)){
					nextAvailable = startNow.get(0)[1] + timer;
					startNow.remove(0);
				}
 			}
			
			if(times == null && timer >= nextAvailable){
				finished = true;
			}
			
			timer++;
		}
		
		pw.println(nextAvailable);
		pw.close();
		System.exit(0);
	}
}

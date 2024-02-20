import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static int count;
    static String command;
    static Deque<Integer> array;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < t; tc++) {
            command = br.readLine();
            count = Integer.parseInt(br.readLine());

            array = new ArrayDeque<>();

            st = new StringTokenizer(br.readLine(), "[],");

            for (int i = 0; i < count; i++) {
                array.offer(Integer.parseInt(st.nextToken()));
            }
            AC(command);
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
    
    static void AC(String command) {
    	boolean isRight = true;
    	
    	for(char cmd : command.toCharArray()) {
    		if(cmd == 'R') {
    			isRight = !isRight;
    			continue;
    		}
    		
    		if(isRight) {
    			if(array.pollFirst() == null) {
    				sb.append("error").append("\n");
    				return;
    			}
    		} else {
    			if(array.pollLast() == null) {
    				sb.append("error").append("\n");
    				return;
    			}
    		}
    	}
    	print(isRight);
    }
    
    static void print(boolean isRight) {
    	sb.append('[');
    	if(array.size() > 0) {
    		if(isRight) {
    			sb.append(array.pollFirst());
    			
    			while(!array.isEmpty()) {
    				sb.append(",").append(array.pollFirst());
    			}
    		} else {
    			sb.append(array.pollLast());
    			
    			while(!array.isEmpty()) {
    				sb.append(",").append(array.pollLast());
    			}
    		}
    	}
    	sb.append(']').append('\n');
    }
}

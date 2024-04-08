import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
	
	static int L, C;
	static char[] arr, pw;
	static Set<Character> set = new HashSet<>();
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		L = Integer.parseInt(input[0]);
		C = Integer.parseInt(input[1]);
		arr = new char[C];
		pw = new char[L];
		set.add('a');
		set.add('e');
		set.add('i');
		set.add('o');
		set.add('u');
		
		String[] data = br.readLine().split(" ");
		for(int i = 0; i < C; i++) {
			arr[i] = data[i].charAt(0);
		}
		
		Arrays.sort(arr);
		dfs(0,0,0);
		System.out.println(sb);
	}
	
	static void dfs(int idx, int depth, int a) {
		if(depth == L) {
			if(a >= 1 && L - a >= 2) {
				for(int i = 0; i < L; i++) {
					sb.append(pw[i]);
				}
				sb.append("\n");
				return;
			}
			return;
		}
		
		if(idx == C) return;
		
		for(int i = idx; i < C; i++) {
			if(depth > 0 && arr[i] <= pw[depth - 1]) continue;
			if(set.contains(arr[i])) {
				pw[depth] = arr[i];
				dfs(idx + 1, depth + 1, a + 1);				
			} else {
				pw[depth] = arr[i];
				dfs(idx + 1, depth + 1, a);
			}
		}
	}
}
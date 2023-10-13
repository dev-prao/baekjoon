import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String c = br.readLine();
		br.close();
		String result = "";
		switch (c) {
			case "M":
				result = "MatKor";
				break;
			case "W":
				result = "WiCys";
				break;
			case "C":
				result = "CyKor";
				break;
			case "A":
				result = "AlKor";
				break;
			case "$":
				result = "$clear";
				break;
		}
		System.out.println(result);
	}
}

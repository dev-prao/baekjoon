import java.time.LocalDate;

public class Main {
	public static void main(String[] args) {
		LocalDate now = LocalDate.now();
		String strNow = now.toString();
		System.out.println(strNow.substring(0, 4));
		System.out.println(strNow.substring(5, 7));
		System.out.println(strNow.substring(8, 10));
	}
}

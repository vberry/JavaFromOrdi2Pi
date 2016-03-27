import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello Raspberry PI. Entrez un mot : ");
		Scanner clavier = new Scanner(System.in);
		String message = clavier.next();
		clavier.close();
		System.out.print("Prochain mot obtenu du clavier : ");
		System.out.println(message);
	}

}

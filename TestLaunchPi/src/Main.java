import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello Raspberry PI");
		Scanner clavier = new Scanner(System.in);
		String message = clavier.next();
		System.out.println("Message donne par le clavier du RaspBerry : ");
		System.out.println(message);
	}

}

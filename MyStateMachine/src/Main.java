import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("SCEGLIERE IN CHE STATO SI TROVA LA MACCHINA");
		System.out.printf("1 - ALPHA\n2 - BETA\n3 - DELTA\n4 - GAMMA\n5 - OMEGA\n");
		Scanner in = new Scanner(System.in);
		int value = 0;
		
		while(String.valueOf(value).matches("[^12345]")) {
			if(in.hasNextInt())
				value = in.nextInt();
			else {
				in.next();
				System.out.println("INSERIRE UN VALORE ACCETTABILE");
			}
		}

		StateMachine m = new StateMachine(value);
		
		while(true) {
			System.out.printf("INSERIRE UN VALORE DI K: ");
			int k=0;
			boolean legit = false;
			while(!legit) {
				if(in.hasNextInt()) {
					k = in.nextInt();
					legit = true;
				}
				else {
					in.next();
					System.out.println("INSERIRE UN VALORE ACCETTABILE");
				}
			}
			m.run(k);
		}
	}

}

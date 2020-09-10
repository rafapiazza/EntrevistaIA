package func;

public class Principal {

	public static void main(String[] args) {
		Validador v1 = new Validador();
		String a[] = { "()", "()[]{}", "(]", "([)]", "{[]}", "[(){}([({}[]())]){}]", ""};
		for (int k = 0; k < a.length; k++) {

			System.out.print("Entrada: " + a[k] + "\nSaída: " + v1.validador(a[k]) + "\n\n");

		}
	}

}

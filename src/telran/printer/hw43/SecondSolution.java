package telran.printer.hw43;

public class SecondSolution {

	private static final int N_PRINTERS = 4;
	private static final int AMOUNT_IN_LINE = 10;
	private static final int GENERAL_AMOUNT = 100;

	public static void main(String[] args) {
		int[] buffer = new int[N_PRINTERS];
		for(int i=0; i<N_PRINTERS; i++) {
			buffer[i] = i+1;
		}
		int total = 0;
		while(total < GENERAL_AMOUNT) {
			for(int i=0; i<N_PRINTERS; i++) {
				for(int j=0; j<AMOUNT_IN_LINE; j++) {
					System.out.print(buffer[i]);
				}
				System.out.println();
				total = total + AMOUNT_IN_LINE;
			}
		}
	}

}

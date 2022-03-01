package telran.printer.hw43;

public class PrinterControllerAppl {

	private static final int N_PRINTERS = 4;
	private static final int AMOUNT_IN_LINE = 10;
	private static final int GENERAL_AMOUNT = 100;

	public static void main(String[] args) {
		Printer[] printers=new Printer[N_PRINTERS];
		creatingPrinters(printers);
		printers[0].interrupt();
	}

	private static void creatingPrinters(Printer[] printers) {
		printers[0]=new Printer(1, GENERAL_AMOUNT, AMOUNT_IN_LINE, N_PRINTERS);
		for(int i=1; i<printers.length; i++) {
			printers[i]=new Printer(i+1, GENERAL_AMOUNT, AMOUNT_IN_LINE, N_PRINTERS);
			printers[i-1].setNextPrinter(printers[i]);
			printers[i-1].start();
		}
		printers[printers.length-1].setNextPrinter(printers[0]);
		printers[printers.length-1].start();
	}

}

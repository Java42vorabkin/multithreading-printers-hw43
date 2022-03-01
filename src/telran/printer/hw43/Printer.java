package telran.printer.hw43;

public class Printer extends Thread {
	
	private static final long SLEEPING_TIME = 500;
	private int printerNumber;
	private Printer nextPrinter;
	private int generalAmount;
	private int amountInLine;
	private int nPrinters;
	private String symbol;
	
	// dtor
	public  Printer(int printerNumber, int generalAmount, int amountInLine, int nPrinters) {
		this.printerNumber = printerNumber;
		symbol = "" + printerNumber;
		this.generalAmount = generalAmount;
		this.amountInLine = amountInLine;
		this.nPrinters = nPrinters;
	}
	
	public void setNextPrinter(Printer nextPrinter) {
		this.nextPrinter = nextPrinter;
	}
	
	@Override
	public void run() {
		int nPortions=generalAmount/amountInLine;
		int nLine=0;
		while(nLine < nPortions) {
			try {
				sleep(SLEEPING_TIME);
			} catch (InterruptedException e) {
				printPortion(nLine++ + 1);
				nextPrinter.interrupt();
			}
		}
	}
	
	private void printPortion(int count) {
		/*
		for(int i=0; i<amountInLine; i++)
			System.out.print(printerNumber);
		*/
		
		System.out.println(symbol.repeat(amountInLine));
		if(printerNumber == nPrinters) {
			System.out.println(count + "========================" + count);
			try {
				sleep(SLEEPING_TIME);
			} catch(Exception ex) {
				 
			}
		}
	}

}

class PrintEvenTask implements Runnable{
    Printer printer;
    int max;
    PrintEvenTask(Printer printer, int max){
        this.printer = printer;
        this.max = max;
    }
    @Override
    public void run() {
        for(int i = 2; i <= max; i+=2){ 
		       
            printer.printEven(i);
        }   
    }
}
 
class PrintOddTask implements Runnable{
    Printer printer;
    int max;
    PrintOddTask(Printer printer, int max){
        this.printer = printer;
        this.max = max;
    }
    @Override
    public void run() {
        for(int i = 1; i <= max; i+=2){
            printer.printOdd(i);
        }   
    }
}
 
public class Printer {
    boolean evenFlag = false;
	public int sleep1,sleep2;
    public void printEven(int num){
        synchronized (this) {
            while(!evenFlag){
                try {
                    wait();
                } catch (InterruptedException e) {
                    System.out.println("Thread Interrupted" + e.getMessage());
                }
            }
            System.out.println(Thread.currentThread().getName()+"-->"+ num);
            evenFlag = false;
		try{
		Thread.sleep(sleep2);
		}
		catch(Exception e){}
		notify();
        }
    }
    public void printOdd(int num){
        synchronized (this) {
            while(evenFlag){
                try {
			wait();
                } catch (InterruptedException e) {
                    System.out.println("Thread Interrupted" + e.getMessage());
                }
            }
            System.out.println(num+"--"+Thread.currentThread().getName());
            evenFlag = true;
		try{
		Thread.sleep(sleep1);
		}
		catch(Exception e){}
		notify();
        }
    }
    public static void main(String[] args) {
        Printer printer = new Printer();
	PrintOddTask po=new PrintOddTask(printer,Integer.parseInt(args[4]));
	PrintEvenTask pe=new PrintEvenTask(printer,Integer.parseInt(args[4]));
	printer.sleep1=Integer.parseInt(args[0]);
	printer.sleep2=Integer.parseInt(args[1]);
        Thread t1 = new Thread(po, args[2]);
        Thread t2 = new Thread(pe, args[3]);
        t1.start();
        t2.start();
    }
}

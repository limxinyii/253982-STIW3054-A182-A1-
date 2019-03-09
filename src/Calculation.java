
public class Calculation {
	public static int calcTotalUC (int qtyUC, int qtyUC1, int qtyUC2) {
		return ((qtyUC*5)+(qtyUC1*10)+(qtyUC2*15));
    }
	
	public static int calcTotalAc (int qtyAct1, int qtyAct2, int qtyAct3) {
		return ((qtyAct1*1)+(qtyAct2*2)+(qtyAct3*3));
	}
	
	public static double calcTotalTCF (int ttlTF) {
		return ((0.01*ttlTF)+0.6);
	}
	
	public static double calcEF (double tt1EF) {
		return ((-0.03*tt1EF)+1.4);
	}
	
	public static double calcWReport(double adjustedMH, double reportMH) {
		return (adjustedMH + reportMH);
	}
	
}

import java.util.*;

public class EffortEstimation extends Thread {
	 public static void main(String[]args){
		 
		 EffortEstimation run = new EffortEstimation();	
		 run.cal();	 
	 }
	 
	 public void cal() {
		 try {
			 Scanner scan = new Scanner(System.in);
			//---------- calculating use case weight ----------
			 System.out.println("1. Weighting Use Case for Complexity");
			 System.out.println("-----------------------------------------------------");
			 System.out.println("Use Case Type \t Description \t Weight\t Qty ");
			 System.out.println("-----------------------------------------------------");
			 System.out.print("Simple \t\t 3 or fewer \t  5 \t ");
			 int qty1 = scan.nextInt();
			 System.out.print("Average \t 4 to 7 \t  10 \t ");
			 int qty2 = scan.nextInt();
			 System.out.print("Complex \t More than 7 \t  15 \t ");
			 int qty3 = scan.nextInt();
			 System.out.println("-----------------------------------------------------");
			 
			 Calculation useCase = new Calculation();
			 int totalUC = useCase.calcTotalUC(qty1,qty2,qty3);  
			 System.out.println("Total Use Case = "+ totalUC);
			 
			//---------- calculating actor weight -------------
			 System.out.println("\n2. Weighting Actors for Complexity");
			 System.out.println("-----------------------------------------------------------------------------------");
			 System.out.println("Actor Type \t Description \t\t\t\t\tWeight\tQty ");
			 System.out.println("-----------------------------------------------------------------------------------");
			 System.out.print("Simple \t\t Defined API  \t\t\t\t\t 1 \t ");
			 int qtyAc1 = scan.nextInt();
			 System.out.print("Average \t Interactive or Protocol driven interface \t 2 \t ");
			 int qtyAc2 = scan.nextInt();
			 System.out.print("Complex \t Graphical User Interface \t\t\t 3 \t ");
			 int qtyAc3 = scan.nextInt();
			 System.out.println("-----------------------------------------------------------------------------------");
			 
			 Calculation actor = new Calculation();
			 int totalAc = actor.calcTotalAc(qtyAc1,qtyAc2,qtyAc3);
			 System.out.println("Total Actor Points = "+ totalAc);
			 int UUCP = (totalUC + totalAc);
			 System.out.println("\nUnadjusted Use Case Point (UUCP) = "+UUCP);
			 
			 //------------- calculating TCF -------------
			 System.out.println("\n3. Weighting Technical Factors");
			 System.out.println("Rate each factor from 0 to 5.");
			 System.out.println("-----------------------------------------------------------------------------------");
			 System.out.println("Factor \t\tDescription \t\t\tWeight \t Project Rating (0 to 5)");
			 System.out.println("-----------------------------------------------------------------------------------");		 
			 System.out.print("T1 \t Distributed system required \t\t 2 \t\t ");
		     int r1 = scan.nextInt();
		     System.out.print("T2 \t Response time is important \t\t 1 \t\t ");
		     int r2 = scan.nextInt();
		     System.out.print("T3 \t End-user efficiency \t\t\t 1 \t\t ");
		     int r3 = scan.nextInt();
		     System.out.print("T4 \t Complex internal processing \t\t 1 \t\t ");
		     int r4 = scan.nextInt();
		     System.out.print("T5 \t Code must be reuseable \t\t 1 \t\t ");
		     int r5 = scan.nextInt();
		     System.out.print("T6 \t Easy to install \t\t\t 0.5 \t\t ");
		     int r6 = scan.nextInt();
		     System.out.print("T7 \t Easy to use \t\t\t\t 0.5 \t\t ");
		     int r7 = scan.nextInt();
		     System.out.print("T8 \t Cross-platform support \t\t 2 \t\t ");
		     int r8 = scan.nextInt();
		     System.out.print("T9 \t Easy to change. \t\t\t 1 \t\t ");
		     int r9 = scan.nextInt();
		     System.out.print("T10 \t Highly concurrent \t\t\t 1 \t\t ");
		     int r10 = scan.nextInt();
		     System.out.print("T11 \t Custom Security \t\t\t 1 \t\t ");
		     int r11 = scan.nextInt();
		     System.out.print("T12 \t Dependence on third-party code \t 1 \t\t ");
		     int r12 = scan.nextInt();
		     System.out.print("T13 \t User Training \t\t\t\t 1 \t\t ");
		     int r13 = scan.nextInt();
		     System.out.println("---------------------------------------------------------------------------------");
		     
		     int totalTF = (int) ((r1*2)+(r2*1)+(r3*1)+(r4*1)+(r5*1)+(r6*0.5)+(r7*0.5)+(r8*2)+(r9*1)+(r10*1)+(r11*1)+(r12*1)+(r13*1));
		     System.out.println("Total TFactor = "+totalTF);
		     Calculation tcf = new Calculation();
		     double TCF = tcf.calcTotalTCF(totalTF);
		     System.out.printf("\nTechnical Complexity Factor (TCF) = %.2f" ,TCF); 
		     double SzUC = UUCP*TCF;
		     System.out.printf("\nSize of Software (SzUC) = %.2f",SzUC);
		     
		   //-------------- calculating EF --------------
			 System.out.println("\n\n4. Weighting Experience Factors");
			 System.out.println("Rate for each factor from 0 to 5.");
			 System.out.println("------------------------------------------------------------------------------------");
			 System.out.println("Factor \t Description \t\t\t\t Weight\t Project Rating (0 to 5)");
			 System.out.println("------------------------------------------------------------------------------------");
			 System.out.print("E1 \t Familiar with FPT software process \t  1 \t\t ");
			 int e1 = scan.nextInt();
		     System.out.print("E2 \t Application experience \t\t  0.5 \t\t ");
		     int e2 = scan.nextInt();
		     System.out.print("E3 \t Paradigm experience(OO) \t\t  1 \t\t ");
		     int e3 = scan.nextInt();
		     System.out.print("E4 \t Lead analyst capability \t\t  0.5 \t\t ");
		     int e4 = scan.nextInt();
		     System.out.print("E5 \t Motivation \t\t\t\t  0 \t\t ");
		     int e5 = scan.nextInt();
		     System.out.print("E6 \t Stable requirements \t\t\t  2 \t\t ");
		     int e6 = scan.nextInt();
		     System.out.print("E7 \t Part-time staff \t\t\t -1 \t\t ");
		     int e7 = scan.nextInt();
		     System.out.print("E8 \t Difficult programming language \t -1 \t\t ");
		     int e8 = scan.nextInt();
		     System.out.println("------------------------------------------------------------------------------------");
			  
		     double totalEF=(e1*1)+(e2*0.5)+(e3*1)+(e4*0.5)+(e5*0)+(e6*2)+(e7*-1)+(e8*-1);
		     System.out.printf("Total EFactor = %.2f",totalEF);
		     Calculation ef = new Calculation();
		     double EF = ef.calcEF(totalEF);
		     System.out.printf("\n\nExperience Factor (EF) = %.2f",EF);
		     double UCP = UUCP * TCF * EF;
		     System.out.printf("\nUse Case Points (UCP) = %.3f",UCP);	 
			 
		   //---------- calculating Man-hours from UCP ----------
			 System.out.println("\n\n5. Calculating Man-hours from UCP");
			 int ER=0;
			 System.out.print("\nNumber of Factor Rating of E1-E6 that are below 3 : ");
		     int a = scan.nextInt();
		     System.out.print("Number of Factor Rating of E7-E8 that are above 3 : ");
		     int b = scan.nextInt();
		     int total = a + b;
		        
		        if(total>0 && total<=2){
		            ER=20;
		        }
		        else if(total>2 && total<=4){
		            ER=28;
		        }
		        else if (total>5){
		            System.out.println("Restructuring the project team so that the members fall at least below 5");
		        }
		        else 
		            ER=0;
		        
		       double totalMHours = ER * UCP;
		       System.out.printf("\nTotal man-hours = %.3f",totalMHours);
			 
		     //---------- calculating Adjusted Man-hours for risk ----------
				 System.out.println("\n\n6. Adjusted Man-hours for Risk");
				 System.out.print("Enter a risk coefficient: ");
				 double num = scan.nextDouble();
				 double adjustMH=((1.0+num)*totalMHours);
				 System.out.printf("\nAdjusted man-hours = %.2f",adjustMH);	
				 
			//------------- Estimating for Reports ----------
				 System.out.println("\n\n7. Weighting Reports for Complexity");
				 System.out.println("-----------------------------------------------------");
				 System.out.println("Report \t  Average Man-hours \t Qty ");
				 System.out.println("-----------------------------------------------------");
				 System.out.print("Simple \t\t 12 \t\t ");
				 int simple = scan.nextInt();
				 System.out.print("Average \t 20 \t\t ");
				 int average = scan.nextInt();
				 System.out.print("Complex \t 40 \t\t ");
				 int complex = scan.nextInt();
				 int ttlReportMH = (simple*12) + (average*20) + (complex*40);
				 System.out.println("-----------------------------------------------------");
				 System.out.println("Total Report Man-hour Estimate = "+ ttlReportMH);
				 
				 Calculation report = new Calculation();
				 double totalMH = report.calcWReport(adjustMH,ttlReportMH);
				 System.out.println("\n==============================");
				 System.out.printf("Total man-hours = %.2f ",totalMH); 
				 System.out.println("\n==============================");
			 
			 
		 }catch(Exception e) {
			 System.out.println("\n**** You only can enter number! Please Try Again ****\n");
			 cal();
		 }
	 }

}

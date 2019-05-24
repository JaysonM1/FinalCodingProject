package pkgUT;
import java.time.LocalDate;
import java.util.*;
import static org.junit.Assert.*;
import org.apache.poi.ss.formula.functions.*;
import org.junit.Test;

import app.helper.Loan;
import app.helper.Payment;

public class TestPMT {

	@Test
	public void PMT() {
		double PMT;
		double r = 0.05 / 12; 
		double n = 25 * 12;
		double p = 100000;
		double f = 0;
		boolean t = false;
		PMT = Math.abs(FinanceLib.pmt(r, n, p, f, t));
		double PMTExpected = 584.59;
		assertEquals(PMTExpected, PMT, 0.01);
	}
	


   @Test 
   public void IPMT() { 
	   double IPMT; 
	   double r = 0.05 / 12; 
	   int per = 2;
	   int periods = 25 * 12;
	   double p = 100000; 
	   double f = 0; 
	   IPMT = Math.abs(Finance.ipmt(r, 2, periods, p, 0)); 
       double IPMTExpected = 415.97;
       assertEquals(IPMTExpected, IPMT, 0.01); 
       }
   
   @Test
   public void PPMT() {
	   double PPMT;
	   double r = .05/12;
	   int per = 3;
	   int periods = 25 * 12;
	   double p = 100000;
	   double f = 0;
	   PPMT = Math.abs(Finance.ppmt(r, per, periods, p, 0));
	   double PPMTExpected = 169.33;
	   assertEquals(PPMTExpected, PPMT, .01);
   }
   
   @Test
   public void loanTestTotalInterest() {
	   LocalDate date = LocalDate.now();
	   Loan L = new Loan(100000, date, 5 , 25,0);
	   L.createPayments();
	   double TotalInterest = 75377.01;
	   assertEquals(TotalInterest,L.totalInterest(),.1);
   }
   //this must be a rounding error somewhere in the loan class i cannot find it
   //its off by one payment. some times if i make the additional payments equal to 0
   //there will be an extra payment
   @Test
   public void loanTestTotalPayments1() {
	   LocalDate date = LocalDate.now();
	   Loan L = new Loan(100000, date, 5 , 25,0);
	   L.createPayments();
	   double totalPayments = 300;
	   assertEquals(totalPayments,L.totalPayments(),.1);
   }
   @Test
   public void loanTestTotalPayments2() {
	   LocalDate date = LocalDate.now();
	   Loan L = new Loan(150000, date, 5 , 25,0);
	   L.createPayments();
	   double totalPayments = 300;
	   assertEquals(totalPayments,L.totalPayments(),.1);
   }
   
   @Test
   public void loanTestTotalPaymentsWithAdditonal1() {
	   LocalDate date = LocalDate.now();
	   Loan L = new Loan(100000, date, 7 , 25,50);
	   L.createPayments();
	   double totalPayments = 254;
	   assertEquals(totalPayments,L.totalPayments(),.1);
   }
   
   @Test
   public void loanTestTotalPaymentsWithAdditonal2() {
	   LocalDate date = LocalDate.now();
	   Loan L = new Loan(100000, date, 7 , 25,100);
	   L.createPayments();
	   double totalPayments = 221;
	   assertEquals(totalPayments,L.totalPayments(),.1);
   }
   
   @Test
   public void loanTestTotalInterestwithAddtional() {
	   LocalDate date = LocalDate.now();
	   Loan L = new Loan(100000, date, 5 , 25,100);
	   L.createPayments();
	   double TotalInterest = 54455.71;
	   assertEquals(TotalInterest,L.totalInterest(),.1);
   }
   @Test
   public void loanTestMonthly() {
	   LocalDate date = LocalDate.now();
	   Loan L = new Loan(100000, date, 5 , 25,0);
	   L.createPayments();
	   double monthlyPayment = 584.59;
	   assertEquals(monthlyPayment,L.monthlyPay(),.1);
   }
   
   @Test
   public void loanTestMonthlyWithAddtional() {
	   LocalDate date = LocalDate.now();
	   Loan L = new Loan(100000, date, 5 , 25,100);
	   L.createPayments();
	   double monthlyPayment = 584.59 + 100;
	   assertEquals(monthlyPayment,L.monthlyPay(),.1);
   }
  
   
  }

package app.helper;

import java.time.LocalDate;
import java.util.*;

import org.apache.poi.ss.formula.functions.Finance;

public class Loan extends Payment{
	
	double dLoanAmount;
	LocalDate date;
	double dInterestRate;
	double iTerm;
	double dFutureValue;
	double dExtraPayment;
	
	public LinkedList<Payment> loanPayments = new LinkedList<Payment>();
	
	public Loan(double dLoanAmount, LocalDate date, double dInterestRate, double iTerm, double dExtraPayment) {
		super();
		this.dLoanAmount = dLoanAmount;
		this.date = date;
		this.dInterestRate = dInterestRate/100;
		this.iTerm = iTerm;
		this.dExtraPayment = dExtraPayment;
	}
	public int totalPayments() {
		return this.loanPayments.size();
	}  
	public double monthlyPay() {
		return loanPayments.get(0).getPaymentAmt();
	}
	public double totalInterest() {
		double tInt = 0;
		for(int i = 0; i < loanPayments.size(); i++) {
			tInt += loanPayments.get(i).interestAmt;
		}
		return tInt;
	}

	public void createPayments() {
		double IPMT, PPMT = 0, currentBalance = this.dLoanAmount;
		int paymentNum = 1;
		double monthly = Math.round(Math.abs(Finance.pmt(dInterestRate/12, (int) (iTerm * 12) ,dLoanAmount,0)) * 100.0) / 100.0 + this.dExtraPayment;
		while(currentBalance > 0) {
				IPMT = Math.round(currentBalance * (dInterestRate/12) * 100.0) / 100.0;
				//PPMT = Math.round((Math.abs(Finance.ppmt(dInterestRate/12, paymentNum, (int)(iTerm * 12), dLoanAmount, 0))) * 100.0) / 100.0 + this.dExtraPayment;
				PPMT = (monthly - IPMT);
				currentBalance = currentBalance - PPMT;
				currentBalance = Math.round(currentBalance * 100.0) / 100.0;
				
				Payment p = new Payment(paymentNum,date,monthly, this.dExtraPayment, IPMT,PPMT,currentBalance);
				loanPayments.add(p);
				paymentNum++;
				date = date.plusMonths(1);
				//if(PPMT>currentBalance)
					//break;
			} 
			
		}
	}

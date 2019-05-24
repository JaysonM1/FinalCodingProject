package app.helper;

import java.time.LocalDate;

public class Payment {
	int paymentNbr;
	LocalDate dueDate;
	double paymentAmt;
	public double addPayment;
	public double interestAmt;
	public double principleAmt;
	public double balance;
	public Payment() {
	}
	public Payment(int paymentNbr, LocalDate date, double paymentAmt, double addPayment, double interestAmt, double principleAmt, double balance) {
		this.paymentNbr = paymentNbr;
		this.dueDate = date;
		this.paymentAmt = paymentAmt; 
		this.addPayment = addPayment;
		this.interestAmt = interestAmt;
		this.principleAmt = principleAmt;
		this.balance = balance;
	}
	
	public int getPaymentNbr() {
		return paymentNbr;
	}
	public double getPaymentAmt() {
		return paymentAmt;
	}
	public double getAddPayment() {
		return addPayment;
	}
	public double getInterestAmt() {
		return interestAmt;
	}
	public double getPrincipleAmt() {
		return principleAmt;
	}
	public double getBalance() {
		return balance;
	}
	public LocalDate getDueDate() {
		return dueDate;
	}

}

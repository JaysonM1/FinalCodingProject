package app.controller;
import app.helper.*;
import app.StudentCalc;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import java.util.*;
public class LoanCalcViewController implements Initializable  {

	private StudentCalc SC = null;
	
	@FXML
	private TextField LoanAmount;
	
	@FXML 
	private TextField NbrOfYears;
		
	@FXML
	private TextField intRate;
		
	@FXML
	private TextField addPayment;
	@FXML
	private Label lblTotalPayments;
	@FXML
	private Label totalInterest;
	
	@FXML
	private DatePicker PaymentStartDate;
	@FXML
	private TableView myTable;
	
	@FXML 
	private TableColumn PaymentNum,DueDate,PaymentAmt,AdditionalPay,Interest,Principle,Balance;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	public void setMainApp(StudentCalc sc) {
		this.SC = sc;
	}
	
	/**
	 * btnCalcLoan - Fire this event when the button clicks
	 * 
	 * @version 1.0
	 * @param event
	 */
	@FXML
	private void btnCalcLoan(ActionEvent event) {
		DecimalFormat df = new DecimalFormat("0.00");
		LocalDate localDate = PaymentStartDate.getValue();
		Loan L = new Loan(Double.parseDouble(LoanAmount.getText()), localDate, Double.parseDouble(intRate.getText()), Double.parseDouble(NbrOfYears.getText()), Double.parseDouble(addPayment.getText()));
		L.createPayments();
		System.out.println("Amount: " + LoanAmount.getText());
		System.out.println(Integer.toString(L.totalPayments()));
		lblTotalPayments.setText(String.valueOf(L.totalPayments()));
		totalInterest.setText(String.valueOf(df.format(L.totalInterest())));
		System.out.println(localDate);
		/*
		 * for(int i = 0; i < L.totalPayments(); i++) { Payment p =
		 * L.loanPayments.get(i); System.out.println(p.getPaymentNbr() + "  |  " +
		 * p.getDueDate() + "  |  "+ p.getPaymentAmt() + "  |  " + p.getAddPayment() +
		 * "  |  " + p.getInterestAmt() + "  |  " + p.getPrincipleAmt() + "  |  " +
		 * p.getBalance()); }
		 */
	} 
}

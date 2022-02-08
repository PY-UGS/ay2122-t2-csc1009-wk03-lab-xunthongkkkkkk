import java.util.Date;
import java.util.Scanner;
public class Loan {

	private double annualInterestRate;
	private int numberOfYears;
	private double loanAmount;
	private Date loanDate = new Date();
	
	public Loan(double annualInterestRate, int numberOfYears, double loanAmount) {
		this.annualInterestRate = annualInterestRate;
		this.numberOfYears = numberOfYears;
		this.loanAmount = loanAmount;
	}
	
	public double getAnnualInterestRate() {
		return annualInterestRate;
	}
	
	public int getNumberOfYears() {
		return numberOfYears;
	}
	
	public double getLoanAmount() {
		return loanAmount;
	}
	
	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}
	
	public void setNumberOfYears(int numberOfYears) {
		this.numberOfYears = numberOfYears;
	}

	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public double getMonthlyPayment() {
		double monthlyPayment = (this.getLoanAmount() * (this.getAnnualInterestRate() / 12 / 100)) / (1 - (1/ Math.pow( (1 + (this.getAnnualInterestRate() / 12 / 100)) , (this.getNumberOfYears() * 12) ) ));
		return monthlyPayment;
	}
	
	public double getTotalPayment() {
		double totalPayment = this.getMonthlyPayment() * this.getNumberOfYears() * 12;
		return totalPayment;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter annual interest rate, for example, 8.25: ");
		double annualIntRate = input.nextDouble();
		
		System.out.println("Enter number of years as an integer: ");
		int years = input.nextInt();
		
		System.out.println("Enter loan amount, for example, 120000.95: ");
		double loanAmt = input.nextDouble();
		
		Loan loan = new Loan(annualIntRate, years, loanAmt);
		
		Date createdLoan = loan.loanDate;
		double monthlyPay = loan.getMonthlyPayment();
		double totalPay = loan.getTotalPayment();
		
		System.out.println("The loan was created on " + createdLoan.toString());
		System.out.println(String.format("The monthly payment is %.2f", monthlyPay));
		System.out.println(String.format("The total payment is %.2f", totalPay));
	}

}

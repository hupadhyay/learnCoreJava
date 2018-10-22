package in.himtech.java.designpattern.behaviral;

/**
 * In the Chain Of Responsibility, The responsibility of process the requested
 * is divided into several objects. Each object takes the request and perform an
 * operation on it and pass to another object. The last object of the chain
 * completed the process. The good example of this design pattern is
 * ServletFilter in the Java API.
 * 
 * @author Himanshu
 *
 */
public class ChainOfResponsibility {

	public static void main(String[] args) {
		String financialChanges = "Financial Changes";
		FinancialUpdate financialUpdate = new SavingAccountUpdate();
		
		while(financialUpdate != null) {
			financialChanges = financialUpdate.updateAccount(financialChanges);
			financialUpdate = financialUpdate.next();
		}
		
		System.out.println("Update financial report is : " + financialChanges);
	}
}

interface FinancialUpdate {

	String updateAccount(String updates);

	FinancialUpdate next();
}

class SavingAccountUpdate implements FinancialUpdate {

	private FinancialUpdate financialUpdate;

	public SavingAccountUpdate() {
		financialUpdate = new CurrentAccountUpdate();
	}

	@Override
	public String updateAccount(String updates) {
		return updates + ", Saving Account update";
	}

	@Override
	public FinancialUpdate next() {
		return financialUpdate;
	}
}

class CurrentAccountUpdate implements FinancialUpdate {

	private FinancialUpdate financialUpdate;

	public CurrentAccountUpdate() {
		financialUpdate = new FixedDepositeUpdate();
	}

	@Override
	public String updateAccount(String updates) {
		return updates + ", Current Account update";
	}

	@Override
	public FinancialUpdate next() {
		return financialUpdate;
	}
}

class FixedDepositeUpdate implements FinancialUpdate {

	private FinancialUpdate financialUpdate;

	public FixedDepositeUpdate() {
		financialUpdate = new InvestmentAccountUpdate();
	}

	@Override
	public String updateAccount(String updates) {
		return updates + ", Fixed Deposite update";
	}

	@Override
	public FinancialUpdate next() {
		return financialUpdate;
	}
}

class InvestmentAccountUpdate implements FinancialUpdate {

	public InvestmentAccountUpdate() {

	}

	@Override
	public String updateAccount(String updates) {
		return updates + ", Investment Account update";
	}

	@Override
	public FinancialUpdate next() {
		return null;
	}
}

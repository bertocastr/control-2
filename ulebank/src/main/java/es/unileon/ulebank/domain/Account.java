package es.unileon.ulebank.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import es.unileon.ulebank.handler.AccountHandler;
import es.unileon.ulebank.handler.Handler;

@Entity
@Table(name="ACCOUNTS")
public class Account {

	@Id
    @Column(name = "account_number")
    private String accountNumber;	
	
	@Column(name = "balance")
	private double balance;
	
	@Column(name = "last_liquidation")
    private Date lastLiquidation;
	
	@Column(name = "liquidation_frequency")
	private int liquidationFrequency;
	
	@Column(name = "max_overdraft")
	private double maxOverdraft;
	
	@ManyToOne
	@JoinColumn(name = "office_id", insertable = false, updatable = false)
	private Office office;

	public Account(String accountNumber, double balance, Date lastLiquidation,
		int liquidationFrequency, double maxOverdraft, Office office) {
		Handler numberAccount = new AccountHandler(accountNumber);
		this.accountNumber = numberAccount.toString();
		this.balance = balance;
		this.lastLiquidation = lastLiquidation;
		this.liquidationFrequency = liquidationFrequency;
		this.maxOverdraft = maxOverdraft;
		this.office = office;
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Date getLastLiquidation() {
		return lastLiquidation;
	}

	public void setLastLiquidation(Date lastLiquidation) {
		this.lastLiquidation = lastLiquidation;
	}

	public int getLiquidationFrequency() {
		return liquidationFrequency;
	}

	public void setLiquidationFrequency(int liquidationFrequency) {
		this.liquidationFrequency = liquidationFrequency;
	}

	public double getMaxOverdraft() {
		return maxOverdraft;
	}

	public void setMaxOverdraft(double maxOverdraft) {
		this.maxOverdraft = maxOverdraft;
	}

	public Office getOffice() {
		return office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", balance="
				+ balance + ", lastLiquidation=" + lastLiquidation
				+ ", liquidationFrequency=" + liquidationFrequency
				+ ", maxOverdraft=" + maxOverdraft + ", office=" + office.getOfficeId() + "]";
	}
	
	
	
}
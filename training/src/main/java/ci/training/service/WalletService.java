package ci.training.service;

import java.math.BigDecimal;

import ci.training.beans.Customer;

public interface WalletService {

	public Customer createWallet(String name, String phone, BigDecimal amount);
	
	public Customer showBalance(String phone);
	
	public Customer withdraw(String phone, BigDecimal amount);
	
	public Customer deposit(String phone, BigDecimal amount);
	
	public Customer fundTransfer(String fromPhone, String toPhone, BigDecimal amount);
}

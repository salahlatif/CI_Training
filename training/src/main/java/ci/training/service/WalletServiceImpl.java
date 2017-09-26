package ci.training.service;

import java.math.BigDecimal;

import ci.training.beans.Customer;
import ci.training.beans.Wallet;
import ci.training.exceptions.InsufficientBalanceException;
import ci.training.repo.WalletRepo;

public class WalletServiceImpl implements WalletService{

	private WalletRepo repo;

	public WalletServiceImpl(WalletRepo repo) {
		super();
		this.repo = repo;
	}

	public Customer createWallet(String name, String phone, BigDecimal amount) {
		
		if(name == null || phone == null || amount == null){
			throw new IllegalArgumentException();
		}
		Customer customer = new Customer(name,phone, new Wallet(amount));
		if(repo.save(customer)){
			return customer;
		}
		return null;
	}

	public Customer showBalance(String phone) {

		if(phone == null){
			throw new IllegalArgumentException();
		}
		return repo.find(phone);
		
	}

	public Customer withdraw(String phone, BigDecimal amount) {
		// TODO Auto-generated method stub
		Customer c = repo.find(phone);
		if(c == null){
			return null;
		}
		if(c.getWallet().getBalance().compareTo(amount)<0){
			throw new InsufficientBalanceException();
		}
		c.getWallet().setBalance(c.getWallet().getBalance().subtract(amount));
		return c;
	}

	public Customer deposit(String phone, BigDecimal amount) {
		// TODO Auto-generated method stub
		
		if(amount.doubleValue()<=0){
			
			throw new IllegalArgumentException();
		}
		Customer c = repo.find(phone);
		if(c == null){
			return null;
		}
		c.getWallet().setBalance(c.getWallet().getBalance().add(amount));
		return c;
	}

	public Customer fundTransfer(String fromPhone, String toPhone, BigDecimal amount) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}

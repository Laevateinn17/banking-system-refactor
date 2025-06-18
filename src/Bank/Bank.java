package Bank;

import Exceptions.*;
import javax.swing.DefaultListModel;

public class Bank {
    private final AccountRepository repository = new AccountRepository();
    private final TransactionService transactionService = new TransactionService(repository);

    public int addAccount(BankAccount acc) {
        return repository.addAccount(acc);
    }

    public int addAccount(String name, double balance, double maxWithLimit) {
        return addAccount(new SavingsAccount(name, balance, maxWithLimit));
    }

    public int addAccount(String name, double balance, String tradeLicense) throws Exception {
        return addAccount(new CurrentAccount(name, balance, tradeLicense));
    }

    public int addAccount(String name, String institutionName, double balance) {
        return addAccount(new StudentAccount(name, balance, institutionName));
    }

    public void deposit(String accountNum, double amt) throws InvalidAmount, AccNotFound {
        transactionService.deposit(accountNum, amt);
    }

    public void withdraw(String accountNum, double amt)
            throws MaxBalance, AccNotFound, MaxWithdraw, InvalidAmount {
        transactionService.withdraw(accountNum, amt);
    }

    public DefaultListModel<String> display() {
        DefaultListModel<String> list = new DefaultListModel<>();
        for (BankAccount acc : repository.getAccounts()) {
            if (acc == null) break;
            list.addElement(acc.toString());
        }
        return list;
    }
}

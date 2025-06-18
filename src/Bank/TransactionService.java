package Bank;

import Exceptions.*;

public class TransactionService {
    private final AccountRepository repository;

    public TransactionService(AccountRepository repository) {
        this.repository = repository;
    }

    public void deposit(String accountNum, double amt) throws InvalidAmount, AccNotFound {
        if (amt < 0) throw new InvalidAmount("Invalid Deposit amount");

        BankAccount acc = repository.findAccount(accountNum)
                .orElseThrow(() -> new AccNotFound("Account Not Found"));

        acc.deposit(amt);
    }

    public void withdraw(String accountNum, double amt)
            throws MaxBalance, AccNotFound, MaxWithdraw, InvalidAmount {

        if (amt <= 0) throw new InvalidAmount("Invalid Amount");

        BankAccount acc = repository.findAccount(accountNum)
                .orElseThrow(() -> new AccNotFound("Account Not Found"));

        if (amt > acc.getbalance()) throw new MaxBalance("Insufficient Balance");

        acc.withdraw(amt);
    }
}

package Bank;

import Exceptions.AccNotFound;
import java.util.Optional;

public class AccountRepository {
    private static final int MAX_ACCOUNTS = 100;
    private BankAccount[] accounts = new BankAccount[MAX_ACCOUNTS];

    public int addAccount(BankAccount acc) {
        for (int i = 0; i < MAX_ACCOUNTS; i++) {
            if (accounts[i] == null) {
                accounts[i] = acc;
                return i;
            }
        }
        return -1; // repository full
    }

    public Optional<BankAccount> findAccount(String accountNum) {
        for (BankAccount acc : accounts) {
            if (acc == null) break;
            if (acc.acc_num.equals(accountNum)) {
                return Optional.of(acc);
            }
        }
        return Optional.empty();
    }

    public BankAccount[] getAccounts() {
        return accounts;
    }
}

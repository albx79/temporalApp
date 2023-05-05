package it.albx79.money;

public class AccountActivityImpl implements AccountActivity {
    @Override
    public void withdraw(String fromAccountId, String referenceId, double amount) {
        System.out.printf(
                "\nWithdrawing $%f from account %s. ReferenceId: %s\n",
                amount, fromAccountId, referenceId
        );

    }

    @Override
    public void deposit(String toAccountId, String referenceId, double amount) {
        System.out.printf(
                "\nDepositing $%f into account %s. ReferenceId: %s\n",
                amount, toAccountId, referenceId
        );

    }
}

package it.albx79.money;

import io.temporal.activity.ActivityInterface;
import io.temporal.activity.ActivityMethod;

@ActivityInterface
public interface AccountActivity {

    @ActivityMethod
    void withdraw(String fromAccountId, String referenceId, double amount);

    @ActivityMethod
    void deposit(String toAccountId, String referenceId, double amount);
}

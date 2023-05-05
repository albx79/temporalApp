package it.albx79.money;

import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

@WorkflowInterface
public interface MoneyTransferWorkflow {
    @WorkflowMethod
    void transfer(String fromAccountId, String toAccountId, String referenceId, double amount);
}

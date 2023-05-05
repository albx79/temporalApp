package it.albx79.shopping;


import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

@WorkflowInterface
public interface CartWorkflow {
    @WorkflowMethod
    void todoDoIt();
}

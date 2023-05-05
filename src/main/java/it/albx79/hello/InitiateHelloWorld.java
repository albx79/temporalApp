package it.albx79.hello;

import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowOptions;
import io.temporal.client.WorkflowStub;
import io.temporal.serviceclient.WorkflowServiceStubs;
import it.albx79.Shared;

public class InitiateHelloWorld {
    public static void main(String[] args) {
        WorkflowServiceStubs service = WorkflowServiceStubs.newLocalServiceStubs();
        WorkflowClient client = WorkflowClient.newInstance(service);
        String workflowId = "HelloWorldWorkflowID";
        WorkflowOptions options = WorkflowOptions.newBuilder()
                .setWorkflowId(workflowId)
                .setTaskQueue(Shared.helloWorldTaskQueue)
                .build();
        HelloWorldWorkflow workflow = client.newWorkflowStub(HelloWorldWorkflow.class, options);

        String greeting = workflow.getGreeting("World");

        String actualWorkflowId = WorkflowStub.fromTyped(workflow).getExecution().getWorkflowId();
        System.out.println(actualWorkflowId + " " + greeting);
    }
}

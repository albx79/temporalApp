package it.albx79.shopping;

import io.temporal.api.common.v1.WorkflowExecution;
import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowOptions;
import io.temporal.serviceclient.WorkflowServiceStubs;
import io.temporal.workflow.Workflow;
import it.albx79.Shared;
import it.albx79.money.MoneyTransferWorkflow;

import java.util.UUID;

public class InitiateShoppingCart {
    public static String TASK_QUEUE = "shoppingCartTaskQueue";

    public static void main(String[] args) throws Exception {
        // WorkflowServiceStubs is a gRPC stubs wrapper that talks to the local Docker instance of the Temporal server.
        WorkflowServiceStubs service = WorkflowServiceStubs.newLocalServiceStubs();
        WorkflowOptions options = WorkflowOptions.newBuilder()
                .setTaskQueue(TASK_QUEUE)
                // A WorkflowId prevents this it from having duplicate instances, remove it to duplicate.
                .setWorkflowId("CART-" + Workflow.randomUUID())
                .build();
        // WorkflowClient can be used to start, signal, query, cancel, and terminate Workflows.
        WorkflowClient client = WorkflowClient.newInstance(service);
        // WorkflowStubs enable calls to methods as if the Workflow object is local, but actually perform an RPC.
        CartWorkflow workflow = client.newWorkflowStub(CartWorkflow.class, options);
        // Asynchronous execution. This process will exit after making this call.
        WorkflowExecution we = WorkflowClient.start(workflow::todoDoIt);
        System.out.println(we.getRunId());
    }
}

package it.albx79.shopping;

import io.temporal.client.WorkflowClient;
import io.temporal.serviceclient.WorkflowServiceStubs;
import io.temporal.worker.Worker;
import io.temporal.worker.WorkerFactory;
import it.albx79.Shared;
import it.albx79.hello.HelloWorldActivitiesImpl;
import it.albx79.hello.HelloWorldWorkflowImpl;

public class ShoppingCartWorker {
    public static void main(String[] args) {
        WorkflowServiceStubs service = WorkflowServiceStubs.newLocalServiceStubs();
        WorkflowClient client = WorkflowClient.newInstance(service);
        WorkerFactory factory = WorkerFactory.newInstance(client);
        Worker worker = factory.newWorker(Shared.helloWorldTaskQueue);
        worker.registerWorkflowImplementationTypes(CartWorkflowImpl.class);
        worker.registerActivitiesImplementations(new CartActivityImpl());
        factory.start();
    }
}

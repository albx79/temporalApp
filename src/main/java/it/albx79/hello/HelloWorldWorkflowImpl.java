package it.albx79.hello;

import io.temporal.activity.ActivityOptions;
import io.temporal.workflow.Workflow;

import java.time.Duration;

public class HelloWorldWorkflowImpl implements HelloWorldWorkflow {

    final ActivityOptions options = ActivityOptions.newBuilder()
            .setStartToCloseTimeout(Duration.ofSeconds(60))
            .build();

    private final HelloWorldActivities activity = Workflow.newActivityStub(HelloWorldActivities.class, options);

    @Override
    public String getGreeting(String name) {
        return activity.composeGreeting(name);
    }
}

package it.albx79.hello;

import io.temporal.activity.ActivityInterface;

@ActivityInterface
public interface HelloWorldActivities {

    String composeGreeting(String name);
}

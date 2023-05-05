package it.albx79.hello;

public class HelloWorldActivitiesImpl implements HelloWorldActivities {
    @Override
    public String composeGreeting(String name) {
        return "Hello " + name + "!";
    }
}

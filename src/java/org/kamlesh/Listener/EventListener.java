package org.kamlesh.Listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class EventListener implements ApplicationListener 
{
    @Override
    public void onApplicationEvent(ApplicationEvent event) 
    {
        //Calls by Spring when any event is published
        System.out.println("Event called = "+event.toString());
    }
    
}

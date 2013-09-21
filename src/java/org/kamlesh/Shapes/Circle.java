package org.kamlesh.Shapes;

import java.util.Locale;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import org.kamlesh.Base.Point;
import org.kamlesh.Base.Shape;
import org.kamlesh.Listener.DrawEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Controller
public class Circle implements Shape,ApplicationEventPublisherAware 
{
    private Point Center;
    private MessageSource messageSource;
    //To publish Events
    private ApplicationEventPublisher publisher;
   
    @Autowired
    public void setMessageSource(MessageSource messageSource) 
    {
        this.messageSource = messageSource;
    }

    public Point getCenter() {return Center;}

    // @Autowired @Qualifier("qual")
    @Resource(name="point3")
    public void setCenter(Point Center) {this.Center = Center;}
    
    @Override
    public void draw() 
    {
     System.out.println("-- Circle ---");    
     System.out.println("Circle Center is = (" + getCenter().getX()+","+ getCenter().getY()+")");
     //System.out.println(this.messageSource.getMessage("Starter", null,"defaultCircle", null));
     DrawEvent event=new DrawEvent(this); 
     publisher.publishEvent(event);
    }
    
    @PostConstruct
    public void InitializeCircle(){System.out.println("Circle Initialization"); }
    
    @PreDestroy
    public void DestroyCircle(){System.out.println("Circle Destroyed"); }

    //Publisher Handler
    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {this.publisher=applicationEventPublisher;}
}

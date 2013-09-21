package org.kamlesh;

import java.util.Locale;
import org.kamlesh.Base.Shape;
import org.kamlesh.Base.Shape;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class DrawingApp 
{
	public static void main(String[] args) 
	{
	  //BeanFactory factory=new XmlBeanFactory(new FileSystemResource("web/WEB-INF/applicationContext.xml"));
          //Application context is more powerful than Bean Factory
          //Abstract application context helps lifecycle callbacks
          AbstractApplicationContext context = new FileSystemXmlApplicationContext("web/WEB-INF/applicationContext.xml");
          context.registerShutdownHook();
          Shape s=(Shape)context.getBean("circle");
          s.draw();
          //System.out.println(context.getMessage("Starter",null,"Default Message",null));
	}

}
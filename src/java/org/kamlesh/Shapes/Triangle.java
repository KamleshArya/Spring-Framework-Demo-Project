package org.kamlesh.Shapes;

import org.kamlesh.Base.Point;
import java.util.List;
import org.kamlesh.Base.Shape;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

//implements them for system generated init and destroy InitializingBean,DisposableBean
//Interface implementation of Shape
public class Triangle implements ApplicationContextAware,BeanNameAware,InitializingBean,DisposableBean,Shape
{
    private Point A;
    private Point B;
    private Point C;
    private ApplicationContext context=null;

    public Point getA() {
        return A;
    }

    public void setA(Point A) {
        this.A = A;
    }

    public Point getB() {
        return B;
    }

    public void setB(Point B) {
        this.B = B;
    }

    public Point getC() {
        return C;
    }

    public void setC(Point C) {
        this.C = C;
    }
    
    public void draw()
    {
      System.out.println("-- Triangle --");  
      System.out.println("Point A = (" + getA().getX() +"," + getA().getY()+")");
      System.out.println("Point B = (" + getB().getX() +"," + getB().getY()+")");
      System.out.println("Point C = (" + getC().getX() +"," + getC().getY()+")");
     }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {this.context=applicationContext;}

    //Print Bean Name using context
    @Override
    public void setBeanName(String name) {System.out.println("Bean Name = " + name + "\n");}

    public void myInit(){System.out.println("My init method is initializing beans");}
    
    public void myDestroy(){System.out.println("My destroy method is destroying beans");}

    @Override
    public void afterPropertiesSet() throws Exception {System.out.println("System init method is initializing beans");}

    @Override
    public void destroy() throws Exception {System.out.println("System destroy method is destroying beans");}
}

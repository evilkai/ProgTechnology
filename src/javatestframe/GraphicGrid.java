
package javatestframe;

import java.awt.*;
import java.awt.geom.Line2D;
import javax.swing.*;

public class GraphicGrid extends JPanel{

    private double centerX;
    private double centerY;
    
    private double moveX;
    private double moveY;
    
    private double step;
    
    private Line2D line;

    private Graphics2D pointer;
    
    public GraphicGrid(){
        setBackground(Color.WHITE);
        line=new Line2D.Double();
        
        step=50;
    }
    
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        
        pointer=(Graphics2D)g;
        
        centerX=getWidth()/2+moveX;
        centerY=getHeight()/2+moveY;
        
        // Отрисовка центральных осей
        line.setLine(centerX,0,centerX,getHeight());
        pointer.draw(line);
        line.setLine(0,centerY,getWidth(),centerY);
        pointer.draw(line);
        
        pointer.drawString("0",(int)centerX-8,(int)centerY+12);
        
        double startX=centerX-(centerX%step);
        
        // Отрисовка ОТРИЦАТЕЛЬНОЙ части по осиX
        for (double x=centerX; x>=0;x-=step) {
            if(x-centerX<0){
                System.out.println((x-centerX)/step);
                line.setLine(x,centerY+5,x,centerY-5);
                pointer.draw(line);
                pointer.drawString(Integer.toString((int)((x-centerX)/step)), (int)x-8, (int)centerY+20);
            }
        }
        
        // Отрисовка ПОЛОЖИТЕЛЬНОЙ части по осиX
        for (double x=centerX; x<=getWidth();x+=step) {
            System.out.println(x);
            if(x-centerX>0){
                line.setLine(x,centerY+5,x,centerY-5);
                pointer.draw(line);
                pointer.drawString(Integer.toString((int)((x-centerX)/step)), (int)x-3, (int)centerY+20);
            }
        }
        
    }
    
    public void onUpdate(Point p){
        moveX+=p.x;
        moveY+=p.y;
        repaint();
    }
}

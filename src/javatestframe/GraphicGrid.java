
package javatestframe;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GraphicGrid extends JPanel{

    private Graphics2D pointer;
    
    public GraphicGrid(){
        setBackground(Color.WHITE);
    }
    
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        System.out.println("getPointer");
        pointer = (Graphics2D)g;
    }
    
    public void _drow(){
        System.out.println(pointer);
        int width = getWidth();
        int height = getHeight();
        
        pointer.setColor(Color.red);
        pointer.fillOval(width/2-5, height/2-5, 10, 10);
    }
}

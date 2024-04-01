package javatestframe;
import java.awt.Color;
import java.awt.Dimension;
import javatestframe.windows.Graphic;
import java.awt.event.*;
import javax.swing.*;

public class MouseAction implements MouseListener{
    private Graphic window;
    private JPanel panel;
    public MouseAction(BaseWin wind){
        window=(Graphic) wind;
    }
    
    public MouseAction(JPanel panel){
        this.panel=panel;
    }
    
    
    @Override
    // Клик мышм
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getButton()==MouseEvent.BUTTON1){
            System.out.println("CLICK");
        }
        if(e.getButton()==MouseEvent.BUTTON3){
            System.out.println("CLICK2");
            
        }
    }

    @Override
    // Отпускание мышки
    public void mouseReleased(MouseEvent e) {
        System.out.println("RELEASED");
    }

    @Override
    // Мышка в какомто меесте
    public void mouseEntered(MouseEvent e) {
        if(window.hiddenPanel.contains(e.getPoint())){
            System.out.println("ENTERED");
            window.hiddenSize(new Dimension(window.getWidth(),100));
        }
//        System.out.println(panel.getSize());
//        if(window.hiddenPanel.contains(e.getPoint())){
//        System.out.println("ENTERED");
//            window.hiddenPanel.setBackground(Color.red);
//            //panel.setSize(new Dimension(panel.getWidth(),50));
//        }
    }

    @Override
    // Мышка вышла из места 
    public void mouseExited(MouseEvent e) {
        System.out.println("NOT ENTERED");
        if(!window.hiddenPanel.contains(e.getPoint())){
            window.hiddenSize(new Dimension(window.getWidth(),3));
            //window.hiddenSize(new Dimension(window.getWidth(),(int)(window.getHeight()*0.01)));
        }
    }
    
}

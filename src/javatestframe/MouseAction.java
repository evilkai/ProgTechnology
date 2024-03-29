package javatestframe;
import java.awt.event.*;

public class MouseAction implements MouseListener{
    private Graphic window;
    
    public MouseAction(Graphic wind){
        window=wind;
    }
    
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getButton()==MouseEvent.BUTTON1){
            System.out.println("CLICK");
            window.test();
        }
        if(e.getButton()==MouseEvent.BUTTON3){
            System.out.println("CLICK2");
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // Нажатие мышки
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // Отпускание мышки
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // Мышка в какомто меесте
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // Мышка вышла из места 
    }
    
}

package javatestframe;
import javatestframe.windows.Graphic;
import java.awt.Point;
import java.awt.event.*;
import javax.swing.SwingUtilities;
public class MouseMove implements MouseMotionListener{

    private Graphic window;
    private int lastX;
    private int lastY;
    
    public MouseMove(Graphic w){
        window=(Graphic)w;
    }
    
    @Override
    public void mouseDragged(MouseEvent e) {
        Point point=SwingUtilities.convertPoint(window, e.getPoint(), window.getGrid());
        int dx=point.x-lastX;
        int dy=point.y-lastY;
        Point newP=new Point(dx, dy);
        window.getGrid().onUpdate(newP);
        lastX=point.x;
        lastY=point.y;
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        Point point=SwingUtilities.convertPoint(window, e.getPoint(), window.getGrid());
        lastX=point.x;
        lastY=point.y;
    }
    
}

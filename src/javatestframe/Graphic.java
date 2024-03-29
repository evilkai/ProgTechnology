
package javatestframe;


import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

public class Graphic extends BaseWin{
    private GraphicGrid gridDrawing;
    private MouseAction mouseListener;
    
    
    public Graphic(String name) {
        super(name);
        init();
        gridDrawing = new GraphicGrid();
        
        Container frame=getContentPane();
        frame.setLayout(new GridLayout());
        
        frame.add(gridDrawing);
        System.out.println("Hello");

        mouseListener=new MouseAction(this);
        this.addMouseListener(mouseListener);
        
    }
    
    public void test(){
        gridDrawing._drow();
    }

    
    @Override
    public void setButton() {
        
    }

    @Override
    public JPanel setTop(JPanel layout) {
        return layout;
    }

    @Override
    public JPanel setCenter(JPanel layout) {
        return layout;
    }

    @Override
    public JPanel setBottom(JPanel layout) {
        return layout;
    }

    @Override
    public void onClose() {
        
    }
    
}

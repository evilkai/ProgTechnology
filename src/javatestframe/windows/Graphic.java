
package javatestframe.windows;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javatestframe.BaseWin;
import javatestframe.GraphicGrid;
import javatestframe.MouseAction;
import javatestframe.MouseMove;

import javax.swing.JPanel;
import javax.swing.SwingContainer;
import javax.swing.Timer;

public class Graphic extends BaseWin{
    private GraphicGrid gridDrawing;
    private MouseAction mouseListener;
    private MouseMove mouseMove;
    public JPanel hiddenPanel;
    private Container frame;
    
    public JPanel p2;
//     public Graphic(String name) {
//         super(name);
//         init();
//         
//         frame=getContentPane();
//         frame.setLayout(new BorderLayout());
//         
//         
//         JPanel p1=new JPanel();
//         p1.setBackground(Color.BLACK);
//         p2=new JPanel();
//         p2.setBackground(Color.red);
//         p2.setPreferredSize(new Dimension(p2.getWidth(),3));
//         
//         frame.add(p2,BorderLayout.NORTH);       
//         frame.add(p1,BorderLayout.CENTER);
//         
//         mouseListener=new MouseAction(this);
//         p2.addMouseListener(mouseListener);
//         
//         
//         
//     }
    
    public Graphic(String name) {
        super(name);
        setName("GP");
        init();
        gridDrawing = new GraphicGrid();
        
        frame=getContentPane();
        frame.setLayout(new BorderLayout());
        
        hiddenPanel=new JPanel();
        hiddenPanel.setSize(new Dimension(frame.getWidth(),3));
        hiddenPanel.setBackground(Color.BLACK);
        hiddenPanel.setVisible(true);
        

        mouseListener=new MouseAction(this);
        hiddenPanel.addMouseListener(mouseListener);
        
        mouseMove=new MouseMove(this);
        this.addMouseMotionListener(mouseMove);
        
        frame.add(hiddenPanel,BorderLayout.NORTH);
        frame.add(gridDrawing,BorderLayout.CENTER);
        
        
    }
    
    public GraphicGrid getGrid(){
        return gridDrawing;
    }
    
    public void hiddenSize(Dimension d){
        System.out.println("NEW DIM");
        hiddenPanel.setPreferredSize(d);
        hiddenPanel.revalidate();
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

    @Override
    public Graphic getWindow() {
        return (Graphic)this;
    }

    @Override
    public void onUpdate() {
    }

    
    
}

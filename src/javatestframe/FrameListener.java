package javatestframe;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class FrameListener extends ComponentAdapter{
    
    private BaseWin window;
    
    public FrameListener(BaseWin get){
        window=get;
    }
    
    
    public void componentResized(ComponentEvent e) {
        System.out.println("Its changed");
        window.onUpdate();
    }
}

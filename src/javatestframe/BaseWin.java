
package javatestframe;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public abstract class BaseWin extends JFrame {
    
    protected String[] OPTION;
    protected JComboBox<String> checkBoxOption;
    
    protected Map<String,BaseWin> map=new HashMap<>();
    
    protected String nameWin;

    public BaseWin(String name){
        super(name);
        nameWin=name;
        map.put(name, this);
        OPTION=new String[3];
        
        OPTION[0]="Base";
        OPTION[1]="Binary";
        OPTION[2]="Grapich";
        
        checkBoxOption= new JComboBox<String>(OPTION);
        checkBoxOption.setName("Oprions");
        checkBoxOption.addActionListener(new ButtonEvent(this));
        checkBoxOption.setBackground(Color.WHITE);
        checkBoxOption.setBorder(null);
        
    }
    
    public void init(){
        System.out.println("this");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(300,400);
        getContentPane().setBackground(Color.WHITE);
        setResizable(false);
        setVisible(true);        
    }
    
    public void openWindow(String name){
        if(this.nameWin.equals(name)) return;
        switch (name) {
            case "Base":
                new Simple(name);
                this.dispose();
                System.out.println("It is Base");
                break;
            case "Binary":
                new Binary(name);
                this.dispose();
                System.out.println("It is Binary");
                break;
            default:
                System.out.println("No Window");
        }
    }
    
    
    
    public abstract  void setButton();
    public abstract  JPanel setTop(JPanel layout);
    public abstract  JPanel setCenter(JPanel layout);
    public abstract  JPanel setBottom(JPanel layout);
    public abstract void onClose();
}

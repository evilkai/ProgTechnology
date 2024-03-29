
package javatestframe;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public abstract class BaseWin extends JFrame {
    
    protected String[] OPTION;
    protected JComboBox<String> checkBoxOption;
    
    //protected Map<String,BaseWin> map=new HashMap<>();
    
    protected String nameWin;

    public BaseWin(String name){
        super(name);
        
        nameWin=name;
        //map.put(name, this);
        OPTION=new String[3];
        
        OPTION[0]="Base";
        OPTION[1]="Binary";
        OPTION[2]="Graphic";
        
        checkBoxOption= new JComboBox<String>(OPTION);
        checkBoxOption.setName("Oprions");
        checkBoxOption.addActionListener(new ButtonEvent(this));
        checkBoxOption.setBackground(Color.WHITE);
        checkBoxOption.setBorder(null);
        
    }
    
    // Иницилизация окна 
    public void init(){
        System.out.println("this");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(300,400);
        getContentPane().setBackground(Color.WHITE);
        setResizable(false);
        setVisible(true);        
    }
    
    // Открытие/смена окна 
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
            case "Graphic":
                new Graphic(name);
                this.dispose();
                System.out.println("It is Graphic");
                break;
            default:
                System.out.println("No Window");
        }
    }
    
    
    
    public abstract  void setButton();  // установить кнопки кнопок
    public abstract  JPanel setTop(JPanel layout);  // верхняя часть
    public abstract  JPanel setCenter(JPanel layout);   // цент часть
    public abstract  JPanel setBottom(JPanel layout);   // внижняя часть
    public abstract void onClose(); // Закритие окна ?*
}

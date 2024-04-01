package javatestframe;
import javatestframe.windows.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;

public abstract class BaseWin extends JFrame {
    
    protected String[] OPTION;  // Список калькуляторо (типы)
    protected JComboBox<String> checkBoxOption;
    protected String nameWin;   // Название окна
    
    protected Map<String,Integer> map=new HashMap<>(); 
    

    public BaseWin(String name){
        super(name);
        
        nameWin=name;
        OPTION=new String[4];
        
        OPTION[0]="Base";
        OPTION[1]="Binary";
        OPTION[2]="Graphic";
        OPTION[3]="Engineering";
        
        
        
        checkBoxOption= new JComboBox<>(OPTION);
        checkBoxOption.setName("Options");
        checkBoxOption.addActionListener(new ButtonEvent(this));
        
        checkBoxOption.setBackground(Color.WHITE);
        checkBoxOption.setBorder(null);
        
        checkBoxOption.setSelectedItem(name);
        
        
    }
    
    // Иницилизация окна 
    public void init(){
        System.out.println("this");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Положение null-центр
        setSize(300,400);   // Размер ? 
        getContentPane().setBackground(Color.WHITE);
        //setResizable(false);
        setVisible(true);        
    }
    
    // Открытие/смена окна 
    public void openWindow(String name){
        if(this.nameWin.equals(name)) return;
        System.out.println("CHECK "+name);
        switch (name) {
            case "Base":
                new Simple(name);
                this.dispose();
                System.out.println("It is Base");
                break;
            case "Binary":{
                new Binary(name);
                this.dispose();
                System.out.println("It is Binary");
                break;}
            case "Graphic" :
                new Graphic(name);
                this.dispose();
                System.out.println("It is Graphic");
                break;
            case "Engineering" :
                new Engineering(name);
                this.dispose();
                System.out.println("It is Engineering");
                break;
            default:
                System.out.println("ERROR: NO WINDOW");
        }
    }
    
    
    
    public abstract  void setButton();  // установить кнопки кнопок
    public abstract  JPanel setTop(JPanel layout);  // верхняя часть
    public abstract  JPanel setCenter(JPanel layout);   // цент часть
    public abstract  JPanel setBottom(JPanel layout);   // внижняя часть
    
    public abstract void onClose(); // Закритие окна ?*
    //public abstract void onUpdate();
    public abstract BaseWin getWindow();
}

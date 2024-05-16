package javatestframe;
import javatestframe.windows.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;

public abstract class BaseWin extends JFrame {
    
    protected String[] OPTION;  // Список калькуляторо (типы)
    protected JComboBox<String> checkBoxOption;
    protected String nameWin;   // Название окна
    private int rows=10, columns=1;
    //protected JTextArea inputArea=new JTextArea(rows,columns);
    protected JTextField inputArea;
    protected JTextField outArea;
    
    protected Map<String,Integer> map=new HashMap<>(); 
    

    public BaseWin(String name){
        super(name);
        
        outArea=new JTextField();
        inputArea=new JTextField();
        
        
        nameWin=name;
        OPTION=new String[3];
        
        OPTION[0]="Обычный";
        OPTION[1]="Графический";
        OPTION[2]="Инженерный";
        
        
        
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
            case "Обычный":
                new Simple(name);
                this.dispose();
                System.out.println("It is Base");
                break;
            case "Графический" :
                new Graphic(name);
                this.dispose();
                System.out.println("It is Graphic");
                break;
            case "Инженерный" :
                new Engineering(name);
                this.dispose();
                System.out.println("It is Engineering");
                break;
            default:
                System.out.println("ERROR: NO WINDOW");
        }
    }
    
    
    
    protected abstract  void setButton();  // установить кнопки кнопок
    protected abstract  JPanel setTop(JPanel layout);  // верхняя часть
    protected abstract  JPanel setCenter(JPanel layout);   // цент часть
    protected abstract  JPanel setBottom(JPanel layout);   // внижняя часть
    
    public abstract void onClose(); // Закритие окна ?*
    public abstract void onUpdate();
    public abstract BaseWin getWindow();
}

package javatestframe;
import javatestframe.windows.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;

public abstract class BaseWin extends JFrame {
    
    protected String[] OPTION;  // Список калькуляторов (типы)
    protected JComboBox<String> checkBoxOption;
    protected String nameWin;   // Название окна
    private int rows=10, columns=1;
    //protected JTextArea inputArea=new JTextArea(rows,columns);
    protected JTextField inputArea;
    protected JTextField outArea;
    
    protected Map<String,Integer> map = new HashMap<>(); 

    public BaseWin(String name){
        super(name);
        
        nameWin = name;
        OPTION = new String[5];

        outArea=new JTextField();
        inputArea=new JTextField();
        
        
        nameWin=name;
        OPTION=new String[3];
        
        OPTION[0]="Обычный";
        OPTION[1]="Инженерный";
        OPTION[2]="Графический";
        
        checkBoxOption = new JComboBox<>(OPTION);
        checkBoxOption.setName("Options");
        checkBoxOption.addActionListener(new ButtonEvent(this));
        checkBoxOption.setBackground(Color.WHITE);
        checkBoxOption.setBorder(null);
        checkBoxOption.setSelectedItem(name);
    }
    
    // Инициализация окна 
    public void init(){
        System.out.println("Инициализация окна: " + nameWin);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Положение null - центр
        setSize(300, 400);   // Размер
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);        
    }
    
    // Открытие/смена окна 
    public void openWindow(String name){
        if (this.nameWin.equals(name)) return;
        System.out.println("Переключение на: " + name);
        switch (name) {
            case "Обычный":
                new Simple(name);
                this.dispose();
                break;
            case "Инженерный":
                new Engineering(name).init();
                this.dispose();
                break;
            case "Графический":
                new GraphWindow(name).init();
                this.dispose();
                break;
            default:
                System.out.println("ОШИБКА: НЕТ ТАКОГО ОКНА");
        }
    }

    // Абстрактные методы для реализации в подклассах
    public abstract void setButton();  // Установить кнопки
    public abstract JPanel setTop(JPanel layout);  // Верхняя часть компоновки
    public abstract JPanel setCenter(JPanel layout);   // Центральная часть компоновки
    public abstract JPanel setBottom(JPanel layout);   // Нижняя часть компоновки
    public abstract void onClose(); // Обработка закрытия окна
    
    public abstract void onUpdate();
    public abstract BaseWin getWindow();
}

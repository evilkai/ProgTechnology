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
        
<<<<<<< HEAD
        nameWin = name;
        OPTION = new String[5];
        
        OPTION[0] = "Base";
        OPTION[1] = "Binary";
        OPTION[2] = "Graphic";
        OPTION[3] = "Engineering";
        OPTION[4] = "GraphWindow";  // Новое окно
=======
        outArea=new JTextField();
        inputArea=new JTextField();
        
        
        nameWin=name;
        OPTION=new String[3];
        
        OPTION[0]="Обычный";
        OPTION[1]="Графический";
        OPTION[2]="Инженерный";
>>>>>>> BaseEngin
        
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
<<<<<<< HEAD
            case "Base":
                new Simple(name).init();
=======
            case "Обычный":
                new Simple(name);
>>>>>>> BaseEngin
                this.dispose();
                break;
<<<<<<< HEAD
            case "Binary":
                new Binary(name).init();
                this.dispose();
                break;
            case "Graphic":
                new Graphic(name).init();
                this.dispose();
                break;
            case "Engineering":
                new Engineering(name).init();
                this.dispose();
                break;
            case "GraphWindow":
                new GraphWindow(name).init();
=======
            case "Графический" :
                new Graphic(name);
                this.dispose();
                System.out.println("It is Graphic");
                break;
            case "Инженерный" :
                new Engineering(name);
>>>>>>> BaseEngin
                this.dispose();
                break;
            default:
                System.out.println("ОШИБКА: НЕТ ТАКОГО ОКНА");
        }
    }
<<<<<<< HEAD

    // Абстрактные методы для реализации в подклассах
    public abstract void setButton();  // Установить кнопки
    public abstract JPanel setTop(JPanel layout);  // Верхняя часть компоновки
    public abstract JPanel setCenter(JPanel layout);   // Центральная часть компоновки
    public abstract JPanel setBottom(JPanel layout);   // Нижняя часть компоновки
    public abstract void onClose(); // Обработка закрытия окна
=======
    
    
    
    protected abstract  void setButton();  // установить кнопки кнопок
    protected abstract  JPanel setTop(JPanel layout);  // верхняя часть
    protected abstract  JPanel setCenter(JPanel layout);   // цент часть
    protected abstract  JPanel setBottom(JPanel layout);   // внижняя часть
    
    public abstract void onClose(); // Закритие окна ?*
    public abstract void onUpdate();
>>>>>>> BaseEngin
    public abstract BaseWin getWindow();
}

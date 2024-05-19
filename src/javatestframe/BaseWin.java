package javatestframe;
import javatestframe.windows.GraphWindow;
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
    
    private Point position;
    private final int minX=600;
    private final int minY=400;

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
        OPTION[2]="Графы";
        
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
        //setLocationRelativeTo(null); // Положение null - центр
        setSize(400, 600);   // Размер
        this.setMinimumSize(new Dimension(minY, minX));
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
        
    }
    
    // Открытие/смена окна 
    public void openWindow(String name){
        if (this.nameWin.equals(name)) return;
        System.out.println("Переключение на: " + name);
        switch (name) {
            case "Обычный":
                position=getLocation();
                System.out.println("GET LOCATION "+position);
                new Simple(name,position);
                this.dispose();
                break;
            case "Инженерный":
                position=getLocation();
                new Engineering(name,position).init();
                this.dispose();
                break;
            case "Графы":
                position=getLocation();
                new GraphWindow(name,position).init();
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
    
    public abstract Point getLocationWindow();
    
    public abstract void onUpdate();
    public abstract BaseWin getWindow();
    
    protected void centerWindow(JFrame window) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        
        int x = (screenSize.width-minX)/2;
        int y = (screenSize.height-minY)/2;
        window.setLocation(x, y);
    }
}

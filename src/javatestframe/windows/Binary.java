
package javatestframe.windows;
import java.awt.*;
import javatestframe.BaseWin;
import javatestframe.ButtonEvent;
import javax.swing.*;
import javax.swing.border.*;


public class Binary extends BaseWin{

    String[] BASE={"2","4","8","10","16"}; // Основания систем счисления
    
    // Числовые кнопки
    private JButton button1=new JButton("1");
    private JButton button2=new JButton("2");
    private JButton button3=new JButton("3");
    private JButton button4=new JButton("4");
    private JButton button5=new JButton("5");
    private JButton button6=new JButton("6");
    private JButton button7=new JButton("7");
    private JButton button8=new JButton("8");
    private JButton button9=new JButton("9");
    private JButton button0=new JButton("0");
    
    // Буквенные
    private JButton buttonA=new JButton("A");
    private JButton buttonB=new JButton("B");
    private JButton buttonC=new JButton("C");
    private JButton buttonD=new JButton("D");
    private JButton buttonE=new JButton("E");
    private JButton buttonF=new JButton("F");
    
    // TODO: Изменить кнопки
    private JButton buttonUnar=new JButton("test");
    private JButton buttonSplit=new JButton(".");
    
    // Функциональные кнопки
    private JButton buttonStepRight=new JButton(">>");
    private JButton buttonStepLeft=new JButton("<<");
    private JButton buttonMod=new JButton("%");
    private JButton buttonDiv=new JButton("/");
    private JButton buttonMul=new JButton("*");
    private JButton buttonSub=new JButton("-");
    private JButton buttonAdd=new JButton("+");
    private JButton buttonEqu=new JButton("=");
    
    // Скобки
    private JButton buttonRight=new JButton("(");
    private JButton buttonLeft=new JButton(")");
    
    // Поля ввода/вывода
    private JTextField textName=new JTextField("");
    private JTextField textFrom=new JTextField("");
    private JTextField textIn=new JTextField("");
    
    // Отображение систем счисления
    private JLabel LableFrom=new JLabel("From");
    private JLabel LableIn=new JLabel("In");
    
    // Кнопки очистки
    private JButton buttonClearAll=new JButton("CA");
    private JButton buttonClearChar=new JButton("CC");
    
    // Чекбоксы для систем счисления
    private JComboBox<String> checkBoxFrom= new JComboBox<String>(BASE);
    private JComboBox<String> checkBoxIn= new JComboBox<String>(BASE);
    
    // Обработчики
    private ButtonEvent listener;
    
    public Binary(String name){
        super(name);
        System.out.println("Wind Binary");
        
        listener=new ButtonEvent(this);
        init();
        setButton();
        
        //checkBoxOption.setSelectedItem("Binary"); // TODO: как то исправить!!
    }

    @Override
    public void setButton() {
        System.out.println("TEST Binary");
        
        Container frame=getContentPane();
        frame.setLayout(new GridBagLayout());
        GridBagConstraints param=new GridBagConstraints();
        
        JPanel top=new JPanel(new GridBagLayout());
        JPanel center=new JPanel(new GridBagLayout());
        JPanel bottom=new JPanel(new GridBagLayout());
        
        top=setTop(top);
        center=setCenter(center);
        bottom=setBottom(bottom);
        
        // Добавление кнопки вверх
        param.gridx = 0;
        param.gridy = 0;
        top.setBorder(new LineBorder(Color.BLACK));
        param.fill = GridBagConstraints.HORIZONTAL;
        param.weightx = 1.0;
        param.weighty = 0.0;
        param.anchor = GridBagConstraints.NORTHWEST;
        frame.add(top, param);

        // Добавление кнопки в центр
        param.gridx = 0;
        param.gridy = 1;
        param.fill = GridBagConstraints.BOTH;
        param.weighty = 1.0;
        center.setBorder(new LineBorder(Color.BLACK));
        frame.add(center, param);
        
        // Добавление кнопки вниз
        param.gridx = 0;
        param.gridy = 2;
        param.fill = GridBagConstraints.HORIZONTAL;
        param.weighty = 0.0;
        param.anchor = GridBagConstraints.SOUTH;
        frame.add(bottom, param);
    }

    @Override
    public JPanel setTop(JPanel layout) {
        GridBagConstraints param = new GridBagConstraints();
        param.anchor=GridBagConstraints.WEST;
        param.fill=GridBagConstraints.BOTH;
        param.weightx=1;
        param.weighty=1;
        
        // CheckBox
        param.gridx = 0;
        param.gridy = 0;
        layout.add(checkBoxOption, param);

        // TextField
        param.gridx = 1;
        param.gridy = 0;
        textName.setBorder(null);
        layout.add(textName, param);

        // Пустая метка
        param.gridx = 2;
        param.gridy = 0;
        param.gridwidth = 3;
        layout.add(new JLabel(), param);

        layout.setBorder(new LineBorder(Color.BLACK));
        return layout;
    }

    @Override
    public JPanel setCenter(JPanel layout) {
        GridBagConstraints param=new GridBagConstraints();
        layout.setBackground(Color.WHITE);
        
        // Ввод
        param.gridwidth=5;
        param.gridx=0;
        param.gridy=0;
        param.weightx=1;
        param.weighty=0;
        param.fill=GridBagConstraints.BOTH;
        LableFrom.setBackground(Color.WHITE);
        LableFrom.setHorizontalAlignment(SwingConstants.CENTER);
        layout.add(LableFrom,param);
        param.gridy=1;
        param.weighty=2;
        param.gridheight=2;
        textFrom.setFont(new Font("Ariel",Font.PLAIN,50));
        textFrom.setHorizontalAlignment(SwingConstants.RIGHT);
        textFrom.setBorder(null);
        layout.add(textFrom,param);
        
        // Вывод
        param.gridx=0;
        param.gridy=3;
        param.weightx=1;
        param.weighty=0;
        param.gridheight=1;
        param.fill=GridBagConstraints.BOTH;
        layout.add(LableIn,param);
        param.gridy=4;
        param.weightx=2;
        param.gridheight=2;
        LableIn.setHorizontalAlignment(SwingConstants.CENTER);
        textIn.setFont(new Font("Ariel",Font.PLAIN,50));
        textIn.setHorizontalAlignment(SwingConstants.RIGHT);
        textIn.setBorder(null);
        layout.add(textIn,param);
         
        return layout;
    }

    @Override
    public JPanel setBottom(JPanel layout) {
        GridBagConstraints param=new GridBagConstraints();
        param.fill=GridBagConstraints.BOTH;
        param.weightx=1;
        param.gridy=0;
        
        param.gridx=0;
        layout.add(buttonA,param);
        param.gridx=1;
        layout.add(buttonStepLeft,param);
        param.gridx=2;
        layout.add(buttonStepRight,param);
        param.gridx=3;
        layout.add(buttonClearAll,param);
        param.gridx=4;
        layout.add(buttonClearChar,param);
        
        param.gridy=1;
        
        param.gridx=0;
        layout.add(buttonB,param);
        param.gridx=1;
        layout.add(buttonRight,param);
        param.gridx=2;
        layout.add(buttonLeft,param);
        param.gridx=3;
        layout.add(buttonMod,param);
        param.gridx=4;
        layout.add(buttonDiv,param);
        
        param.gridy=2;
        
        param.gridx=0;
        layout.add(buttonC,param);
        param.gridx=1;
        layout.add(button7,param);
        param.gridx=2;
        layout.add(button8,param);
        param.gridx=3;
        layout.add(button9,param);
        param.gridx=4;
        layout.add(buttonMul,param);
        
        param.gridy=3;
        
        param.gridx=0;
        layout.add(buttonD,param);
        param.gridx=1;
        layout.add(button4,param);
        param.gridx=2;
        layout.add(button5,param);
        param.gridx=3;
        layout.add(button6,param);
        param.gridx=4;
        layout.add(buttonSub,param);
        
        param.gridy=4;
        
        param.gridx=0;
        layout.add(buttonE,param);
        param.gridx=1;
        layout.add(button1,param);
        param.gridx=2;
        layout.add(button2,param);
        param.gridx=3;
        layout.add(button3,param);
        param.gridx=4;
        layout.add(buttonAdd,param);
        
        param.gridy=5;
        
        param.gridx=0;
        layout.add(buttonF,param);
        param.gridx=1;
        layout.add(buttonUnar,param);
        param.gridx=2;
        button0.addActionListener(new ButtonEvent());
        layout.add(button0,param);
        param.gridx=3;
        layout.add(buttonSplit,param);
        param.gridx=4;
        layout.add(buttonEqu,param);
        
        layout.setBorder(new LineBorder(Color.BLACK));
        return layout;
    }

    @Override
    public void onClose() {
        System.out.println("OnClose Binary");
    }

    @Override
    public Binary getWindow() {
        return this;
    }


}


package javatestframe.windows;

import java.awt.*;
import javatestframe.BaseWin;
import javatestframe.ButtonEvent;
import javatestframe.FrameListener;
import javatestframe.SimpleImplement.Buttons;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class Simple extends BaseWin{
    
    // Числовые кнопки
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JButton button0;
    
    // TODO: Изменить кнопки
    private JButton buttonUnar;
    private JButton buttonSplit;
    
    // TODO: изменить; Поля ввода/вывода
    private JTextField textFieldNameOption;
    
    // Функциональные кнопки
    private JButton buttonDel;
    private JButton buttonMul;
    private JButton buttonSub;
    private JButton buttonAdd;
    private JButton buttonEqu;
    
    private JButton buttonPow;
    private JButton buttonSqr;
    private JButton buttonDrob;
    
    private JButton buttonPer;
    
    // Кнопки очистки
    private JButton buttonClearAll;
    private JButton buttonClearLine;
    private JButton buttonClearChar;
    
    // Переменные - обработчик
    private ButtonEvent listener;
    
    // Панели
    JPanel top;
    JPanel center;
    JPanel bottom;
    
    
    // Флаги
    boolean isCreated=false;
    
    
    
    public Simple(String name, Point location){
        super(name);
        if(location==null){centerWindow(this);}
        else {setLocation(location);}
        
        button1=new JButton("1");
        button2=new JButton("2");
        button3=new JButton("3");
        button4=new JButton("4");
        button5=new JButton("5");
        button6=new JButton("6");
        button7=new JButton("7");
        button8=new JButton("8");
        button9=new JButton("9");
        button0=new JButton("0");
        
        buttonUnar=new JButton("+/-");
        buttonSplit=new JButton(".");
        
        textFieldNameOption=new JTextField(10);

        buttonDel=new JButton("/");
        buttonMul=new JButton("*");
        buttonSub=new JButton("-");
        buttonAdd=new JButton("+");
        buttonEqu=new JButton("=");

        buttonPow=new JButton("^");
        buttonSqr=new JButton("\u221A");
        buttonDrob=new JButton("1/x");

        buttonPer=new JButton("%");
        
        buttonClearAll=new JButton("C");
        buttonClearLine=new JButton("CL");
        buttonClearChar=new JButton("CC");
        
        System.out.println("Wind Simple");
        
        listener=new ButtonEvent(this);
        this.addComponentListener(new FrameListener(this));
        
        init();
        setButton();
        isCreated=true;
        onUpdate();
        
    }
    

    @Override
    public void setButton() {
        System.out.println("Обычный калькулятор");
        Container frame=getContentPane();
        frame.setLayout(new GridBagLayout());
        GridBagConstraints param=new GridBagConstraints();
        
        top=new JPanel(new GridBagLayout());
        center=new JPanel(new GridBagLayout());
        bottom=new JPanel(new GridBagLayout());
        
        top=setTop(top);
        center=setCenter(center);
        bottom=setBottom(bottom);
        
        // Добавление кнопки вверх
        param.gridx = 0;
        param.gridy = 0;
        param.fill = GridBagConstraints.HORIZONTAL;
        param.weightx = 1.0;
        param.weighty = 0.0;
        param.anchor = GridBagConstraints.NORTH;
        frame.add(top, param);

        // Добавление кнопки в центр
        param.gridx=0;
        param.gridy=1;
        param.fill=GridBagConstraints.BOTH;
        param.anchor=GridBagConstraints.CENTER;
        param.weightx=1;
        param.weighty=0.5;
        frame.add(center, param);
        
        // Добавление кнопки вниз
        param.gridx=0;
        param.gridy=2;
        param.fill=GridBagConstraints.BOTH;
        param.anchor=GridBagConstraints.SOUTH;
        param.weightx=1;
        param.weighty=0.8;
        frame.add(bottom, param);
    }

    @Override
    public JPanel setTop(JPanel layout) {
        GridBagConstraints param = new GridBagConstraints();
        param.gridx=0;
        param.gridy=0;
        param.anchor=GridBagConstraints.WEST;
        param.weightx=0;
        
        // CheckBox
        param.gridx = 0;
        param.gridy = 0;
        layout.add(checkBoxOption, param);

        // TextField
        param.gridx=1;
        param.weightx=0.4;
        param.weighty=1;
        param.fill=GridBagConstraints.BOTH;
        param.insets=(new Insets(0, (int)(getWidth()*0.01), 0, 0));
        textFieldNameOption.setBorder(new LineBorder(Color.WHITE));
        layout.add(textFieldNameOption, param);

        // Пустая метка
        param.gridx=2;
        param.gridwidth=3;
        param.weighty=1;
        param.weightx=1;
        param.fill=GridBagConstraints.HORIZONTAL;
        param.insets=(new Insets(0, 0, 0, 0));
        layout.add(new JLabel(), param);

        layout.setBackground(Color.WHITE);
        //layout.setBorder(new LineBorder(Color.BLACK));
        return layout;
    }

    @Override
    public JPanel setCenter(JPanel layout) {
        GridBagConstraints param=new GridBagConstraints();
        
        // История операций
        param.gridx=0;
        param.gridy=0;
        param.weightx=1;
        param.weighty=0.2;
        param.fill=GridBagConstraints.BOTH;
        
        outArea.setHorizontalAlignment(SwingConstants.RIGHT);
        outArea.setBorder(null);
        
        //outArea.setEnabled(false);
        outArea.setBackground(new Color(210, 210, 210));
        outArea.setForeground(Color.BLACK);
        layout.add(outArea,param);
        
        // Текущая операция 
        param.gridx=0;
        param.gridy=1;
        param.weightx=1;
        param.weighty=1;
        param.fill=GridBagConstraints.BOTH;
        
        inputArea.setHorizontalAlignment(SwingConstants.RIGHT);
        inputArea.setBorder(null);
        inputArea.setBackground(new Color(210, 210, 210));
        layout.add(inputArea,param);
        
        //layout.setBorder(new LineBorder(Color.RED));
        return layout;
    }

    @Override
    public JPanel setBottom(JPanel layout) {
        GridBagConstraints param=new GridBagConstraints();
        param.fill=GridBagConstraints.BOTH;
        param.weightx=1.0;
        param.weighty=0.1;
        param.gridy=0;
        param.insets=(new Insets(1, 1, 1, 1));
        
        param.gridx=0;
        buttonClearAll.addActionListener(listener);
        buttonClearAll.setBackground(new Color(234, 235, 235));
        buttonClearAll.setBorder(BorderFactory.createEtchedBorder());
        buttonClearAll.setActionCommand(String.valueOf(Buttons.buttonClearAll));
        layout.add(buttonClearAll,param);
        
        param.gridx=1;
        buttonClearLine.addActionListener(listener);
        buttonClearLine.setActionCommand(String.valueOf(Buttons.buttonClearLine));
        buttonClearLine.setBackground(new Color(234, 235, 235));
        buttonClearLine.setBorder(BorderFactory.createEtchedBorder());
        layout.add(buttonClearLine,param);
        
        param.gridx=2;
        buttonClearChar.addActionListener(listener);
        buttonClearChar.setActionCommand(String.valueOf(Buttons.buttonClearChar));
        buttonClearChar.setBackground(new Color(234, 235, 235));
        buttonClearChar.setBorder(BorderFactory.createEtchedBorder());
        layout.add(buttonClearChar,param);
        
        param.gridx=3;
        buttonPer.addActionListener(listener);
        buttonPer.setActionCommand(String.valueOf(Buttons.buttonPercent));
        buttonPer.setBackground(new Color(234, 235, 235));
        buttonPer.setBorder(BorderFactory.createEtchedBorder());
        layout.add(buttonPer,param);
        
        param.gridy=1;
        
        param.gridx=0;
        buttonDrob.addActionListener(listener);
        buttonDrob.setActionCommand(String.valueOf(Buttons.buttonFraction));
        buttonDrob.setBackground(new Color(234, 235, 235));
        
        buttonDrob.setBorder(BorderFactory.createEtchedBorder());
        layout.add(buttonDrob,param);
        
        param.gridx=1;
        buttonPow.addActionListener(listener);
        buttonPow.setActionCommand(String.valueOf(Buttons.buttonPow));
        buttonPow.setBackground(new Color(234, 235, 235));
        buttonPow.setBorder(BorderFactory.createEtchedBorder());
        layout.add(buttonPow,param);
        
        param.gridx=2;
        buttonSqr.addActionListener(listener);
        buttonSqr.setActionCommand(String.valueOf(Buttons.buttonSqr));
        buttonSqr.setBackground(new Color(234, 235, 235));
        buttonSqr.setBorder(BorderFactory.createEtchedBorder());
        layout.add(buttonSqr,param);
        
        param.gridx=3;
        buttonMul.addActionListener(listener);
        buttonMul.setActionCommand(String.valueOf(Buttons.buttonMul));
        buttonMul.setBackground(new Color(234, 235, 235));
        buttonMul.setBorder(BorderFactory.createEtchedBorder());
        layout.add(buttonMul,param);
        
        param.gridy=2;
        
        param.gridx=0;
        button7.addActionListener(listener);
        button7.setActionCommand(String.valueOf(Buttons.button7));
        button7.setBackground(new Color(234, 235, 235));
        button7.setBorder(BorderFactory.createEtchedBorder());
        layout.add(button7,param);
        
        param.gridx=1;
        button8.addActionListener(listener);
        button8.setActionCommand(String.valueOf(Buttons.button8));
        button8.setBackground(new Color(234, 235, 235));
        button8.setBorder(BorderFactory.createEtchedBorder());
        layout.add(button8,param);
        
        param.gridx=2;
        button9.addActionListener(listener);
        button9.setActionCommand(String.valueOf(Buttons.button9));
        button9.setBackground(new Color(234, 235, 235));
        button9.setBorder(BorderFactory.createEtchedBorder());
        layout.add(button9,param);
        
        param.gridx=3;
        buttonDel.addActionListener(listener);
        buttonDel.setActionCommand(String.valueOf(Buttons.buttonDel));
        buttonDel.setBackground(new Color(234, 235, 235));
        buttonDel.setBorder(BorderFactory.createEtchedBorder());
        layout.add(buttonDel,param);
        
        param.gridy=3;
        
        param.gridx=0;
        button4.addActionListener(listener);
        button4.setActionCommand(String.valueOf(Buttons.button4));
        button4.setBackground(new Color(234, 235, 235));
        button4.setBorder(BorderFactory.createEtchedBorder());
        layout.add(button4,param);
        
        param.gridx=1;
        button5.addActionListener(listener);
        button5.setActionCommand(String.valueOf(Buttons.button5));
        button5.setBackground(new Color(234, 235, 235));
        button5.setBorder(BorderFactory.createEtchedBorder());
        layout.add(button5,param);
        
        param.gridx=2;
        button6.addActionListener(listener);
        button6.setActionCommand(String.valueOf(Buttons.button6));
        button6.setBackground(new Color(234, 235, 235));
        button6.setBorder(BorderFactory.createEtchedBorder());
        layout.add(button6,param);
        
        param.gridx=3;
        buttonSub.addActionListener(listener);
        buttonSub.setActionCommand(String.valueOf(Buttons.buttonSub));
        buttonSub.setBackground(new Color(234, 235, 235));
        buttonSub.setBorder(BorderFactory.createEtchedBorder());
        layout.add(buttonSub,param);
        
        param.gridy=4;
        
        param.gridx=0;
        button1.addActionListener(listener);
        button1.setActionCommand(String.valueOf(Buttons.button1));
        button1.setBackground(new Color(234, 235, 235));
        button1.setBorder(BorderFactory.createEtchedBorder());
        layout.add(button1,param);
        
        param.gridx=1;
        button2.addActionListener(listener);
        button2.setActionCommand(String.valueOf(Buttons.button2));
        button2.setBackground(new Color(234, 235, 235));
        button2.setBorder(BorderFactory.createEtchedBorder());
        layout.add(button2,param);
        
        param.gridx=2;
        button3.addActionListener(listener);
        button3.setActionCommand(String.valueOf(Buttons.button3));
        button3.setBackground(new Color(234, 235, 235));
        button3.setBorder(BorderFactory.createEtchedBorder());
        layout.add(button3,param);
        
        param.gridx=3;
        buttonAdd.addActionListener(listener);
        buttonAdd.setActionCommand(String.valueOf(Buttons.buttonAdd));
        buttonAdd.setBackground(new Color(234, 235, 235));
        buttonAdd.setBorder(BorderFactory.createEtchedBorder());
        layout.add(buttonAdd,param);
        
        param.gridy=5;
        
        param.gridx=0;
        buttonUnar.addActionListener(listener);
        buttonUnar.setActionCommand(String.valueOf(Buttons.buttonUnar));
        buttonUnar.setBackground(new Color(234, 235, 235));
        buttonUnar.setBorder(BorderFactory.createEtchedBorder());
        layout.add(buttonUnar,param);
        
        param.gridx=1;
        button0.addActionListener(listener);
        button0.setActionCommand(String.valueOf(Buttons.button0));
        button0.setBackground(new Color(234, 235, 235));
        button0.setBorder(BorderFactory.createEtchedBorder());
        layout.add(button0,param);
        
        param.gridx=2;
        buttonSplit.addActionListener(listener);
        buttonSplit.setActionCommand(String.valueOf(Buttons.buttonSplit));
        buttonSplit.setBackground(new Color(234, 235, 235));
        buttonSplit.setBorder(BorderFactory.createEtchedBorder());
        layout.add(buttonSplit,param);
        
        param.gridx=3;
        buttonEqu.addActionListener(listener);
        buttonEqu.setActionCommand(String.valueOf(Buttons.buttonEqual));
        buttonEqu.setBackground(new Color(123, 181, 254));
        buttonEqu.setBorder(BorderFactory.createEtchedBorder());
        layout.add(buttonEqu,param);

        //layout.setBorder(new LineBorder(Color.BLACK));
        return layout;
    }

    @Override
    public void onClose() {
        System.out.println("OnClose Simple");
    }

    @Override
    public Simple getWindow() {
        return this;
    }

    @Override
    public void onUpdate() {
        if(isCreated){
            System.out.println("UPDATE IS SIMPLE");
            inputArea.setFont(new Font("Ariel",Font.BOLD,(int)((double)(center.getHeight()/100.*25))));
            outArea.setFont(new Font("Ariel",Font.PLAIN,(int)((double)(center.getHeight()/100.*15))));
        }
    }

    @Override
    public Point getLocationWindow() {
        return this.getLocation();
    }



}

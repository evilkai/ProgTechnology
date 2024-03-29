
package javatestframe;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class Simple extends BaseWin{
    
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
    
    private JButton buttonUnar=new JButton(new ImageIcon("D:\\Program\\Java\\JavaTestFrame\\src\\Icon\\clearAll.png"));
    private JButton buttonSplit=new JButton(".");
    
    private JTextField textField1=new JTextField();
    private JTextField textField2=new JTextField();
    private JTextField textFieldNameOption=new JTextField(10);
    
    private JButton buttonDel=new JButton("/");
    private JButton buttonMul=new JButton("*");
    private JButton buttonSub=new JButton("-");
    private JButton buttonAdd=new JButton("+");
    private JButton buttonEqu=new JButton("=");
    
    private JButton buttonClearAll=new JButton("C");
    private JButton buttonClearLine=new JButton("CL");
    private JButton buttonClearChar=new JButton("CC");
    
    private JButton buttonPow=new JButton("pow(x,a)");
    private JButton buttonSqr=new JButton("sqr)");
    private JButton buttonDrob=new JButton("1/x");  // Название придумать
    
    private JButton buttonPer=new JButton("%");
    
    // Переменные - обработчик
    
    private ButtonEvent listener;
    
    
    
    public Simple(String name){
        super(name);
        System.out.println("Wind Simple");
        
        listener=new ButtonEvent(this);
        
        init();
        setButton();
        
    }
    

    @Override
    public void setButton() {
        System.out.println("TEST Simple");
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
        //center.add(new JButton("CENTER"), param);
        param.fill = GridBagConstraints.BOTH;
        param.weighty = 1.0;
        center.setBorder(new LineBorder(Color.BLACK));
        frame.add(center, param);
        
        // Добавление кнопки вниз
        param.gridx = 0;
        param.gridy = 2;
        //bottom.add(new JButton("BOTTOM"), param);
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
        //param.weightx=0;
        textFieldNameOption.setBorder(null);
        layout.add(textFieldNameOption, param);

        // Пустая метка
        param.gridx = 2;
        param.gridy = 0;
        //param.weightx=2;
        param.gridwidth = 2;
        layout.add(new JLabel(), param);

        layout.setBorder(new LineBorder(Color.BLACK));
        return layout;
    }

    @Override
    public JPanel setCenter(JPanel layout) {
        GridBagConstraints param=new GridBagConstraints();
        
        param.gridx=0;
        param.gridy=0;
        param.weightx=1;
        param.weighty=0;
        param.fill=GridBagConstraints.BOTH;
        textField2.setFont(new Font("Ariel",Font.PLAIN,20));
        textField2.setForeground(Color.GRAY);
        textField2.setHorizontalAlignment(SwingConstants.RIGHT);
        textField2.setBorder(null);
        layout.add(textField2,param);
        
        param.gridx=0;
        param.gridy=1;
        param.weightx=1;
        param.weighty=1;
        param.fill=GridBagConstraints.BOTH;
        textField1.setFont(new Font("Ariel",Font.BOLD,40));
        textField1.setHorizontalAlignment(SwingConstants.RIGHT);
        textField1.setBorder(null);
        layout.add(textField1,param);
        layout.setBorder(new LineBorder(Color.RED));
        
        return layout;
    }

    @Override
    public JPanel setBottom(JPanel layout) {
        GridBagConstraints param=new GridBagConstraints();
        param.fill=GridBagConstraints.BOTH;
        param.gridy=0;
        
        param.gridx=0;
        layout.add(buttonClearAll,param);
        param.gridx=1;
        layout.add(buttonClearLine,param);
        param.gridx=2;
        layout.add(buttonClearChar,param);
        param.gridx=3;
        layout.add(buttonPer,param);
        
        param.gridy=1;
        
        param.gridx=0;
        layout.add(buttonDrob,param);
        param.gridx=1;
        layout.add(buttonPow,param);
        param.gridx=2;
        layout.add(buttonSqr,param);
        param.gridx=3;
        layout.add(buttonMul,param);
        
        param.gridy=2;
        
        param.gridx=0;
        button7.addActionListener(listener);
        layout.add(button7,param);
        param.gridx=1;
        button8.addActionListener(listener);
        layout.add(button8,param);
        param.gridx=2;
        button9.addActionListener(listener);
        layout.add(button9,param);
        param.gridx=3;
        layout.add(buttonDel,param);
        
        param.gridy=3;
        
        param.gridx=0;
        button4.addActionListener(listener);
        layout.add(button4,param);
        param.gridx=1;
        button5.addActionListener(listener);
        layout.add(button5,param);
        param.gridx=2;
        button6.addActionListener(listener);
        layout.add(button6,param);
        param.gridx=3;
        layout.add(buttonSub,param);
        
        param.gridy=4;
        
        param.gridx=0;
        button1.addActionListener(listener);
        layout.add(button1,param);
        param.gridx=1;
        button2.addActionListener(listener);
        layout.add(button2,param);
        param.gridx=2;
        button3.addActionListener(listener);
        layout.add(button3,param);
        param.gridx=3;
        layout.add(buttonAdd,param);
        
        param.gridy=5;
        
        param.gridx=0;
        layout.add(buttonUnar,param);
        param.gridx=1;
        button0.addActionListener((listener));
        layout.add(button0,param);
        param.gridx=2;
        layout.add(buttonSplit,param);
        param.gridx=3;
        layout.add(buttonEqu,param);
        
        
        layout.setBorder(new LineBorder(Color.BLACK));
        return layout;
    }

    @Override
    public void onClose() {
        System.out.println("OnClose Simple");
    }

}

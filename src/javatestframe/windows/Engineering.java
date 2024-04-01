
package javatestframe.windows;

import java.awt.*;
import javatestframe.BaseWin;
import javax.swing.*;
import javax.swing.border.*;

public class Engineering extends BaseWin{

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
    private JTextField textFieldiInput;
    private JTextField textFieldNameOption;
    
     // Функциональные кнопки
    private JButton buttonDel;
    private JButton buttonMul;
    private JButton buttonSub;
    private JButton buttonAdd;
    private JButton buttonEqu;
    
    private JButton buttonPow;
    private JButton buttonSqrt;
    private JButton buttonDrob;
    private JButton buttonFact;
    private JButton buttonModule;
    private JButton buttonSqrtAny;
    private JButton buttonPowAny;
    
    private JButton buttonLogX_Y;
    private JButton buttonLnX;
    private JButton buttonExpX;
    private JButton buttonExp;
    
    private JButton buttonPow2;
    private JButton buttonPow10;
    
    private JButton buttonPhi;
    
    private JButton cos;
    private JButton sin;
    private JButton tan;
    private JButton ctan;
    
    // Кнопки очистки
    private JButton buttonClearAll;
    private JButton buttonClearChar;
    
    // Скобки
    private JButton buttonLeft;
    private JButton buttonRight;
    
    // Дополнительно
    private JPanel trigonometry;
    
    
    
    
    
    public Engineering(String name) {
        super(name);
        init();
        
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
        
        buttonUnar=new JButton("TEST");
        buttonSplit=new JButton(".");
        
        textFieldiInput=new JTextField("HERE");
        textFieldNameOption=new JTextField("HERE");
        
        buttonDel=new JButton("/");
        buttonMul=new JButton("*");
        buttonSub=new JButton("-");
        buttonAdd=new JButton("+");
        buttonEqu=new JButton("=");
        
        buttonPow=new JButton("pow");
        buttonSqrt=new JButton("sqr");
        buttonDrob=new JButton("1/x");
        buttonFact=new JButton("n!");
        buttonModule=new JButton("|x|");
        buttonPowAny=new JButton("pow(x,y)");
        buttonSqrtAny=new JButton("sqr(x,y)");
        
        buttonLogX_Y=new JButton("Log(x,y)");
        buttonLnX=new JButton("ln(x)");
        buttonExpX=new JButton("exp(x)");
        buttonExp=new JButton("exp");
        
        buttonPow2=new JButton("pow(2,x)");
        buttonPow10=new JButton("pow(10,x)");
        
        buttonPhi=new JButton("PI");
        
        buttonClearAll=new JButton("CA");
        buttonClearChar=new JButton("CC");
        
        buttonRight=new JButton("(");
        buttonLeft=new JButton(")");
        
        setButton();
    }
    

    @Override
    public void setButton() {
        System.out.println("TEST Engin");
        Container frame=getContentPane();
        frame.setLayout(new GridBagLayout());
        GridBagConstraints param=new GridBagConstraints();
        
        JPanel top=new JPanel(new GridBagLayout());
        JPanel center=new JPanel(new GridBagLayout());
        JPanel bottom=new JPanel(new GridBagLayout());
        
        top=setTop(top);
        center=setCenter(center);
        bottom=setBottom(bottom);
        
        param.gridx=0;
        param.gridy=0;
        param.fill=GridBagConstraints.HORIZONTAL;
        param.anchor=GridBagConstraints.NORTH;
        param.weightx=1;
        param.weighty=0;
        
        frame.add(top,param);
        
        param.gridx=0;
        param.gridy=1;
        param.fill=GridBagConstraints.BOTH;
        param.anchor=GridBagConstraints.CENTER;
        param.weightx=1;
        param.weighty=0.5;
        
        frame.add(center,param);
        
        param.gridx=0;
        param.gridy=2;
        param.fill=GridBagConstraints.BOTH;
        param.anchor=GridBagConstraints.SOUTH;
        param.weightx=1;
        param.weighty=0.5;
        
        frame.add(bottom,param);
    }

    @Override
    public JPanel setTop(JPanel layout) {
        GridBagConstraints param = new GridBagConstraints();
        param.gridx=0;
        param.gridy=0;
        param.anchor=GridBagConstraints.WEST;
        param.weightx=0;
        
        // CheckBox
        checkBoxOption.setBorder(null);
        layout.add(checkBoxOption,param);
        
        //TextField
        param.gridx=1;
        param.weightx=0.1;
        param.weighty=1;
        param.fill=GridBagConstraints.BOTH;
        param.insets=(new Insets(0, (int)(getWidth()*0.01), 0, 0));
        textFieldNameOption.setBorder(null);
        layout.add(textFieldNameOption,param);
        
        // Пустое поле
        param.gridx=2;
        param.gridwidth=3;
        param.weighty=1;
        param.weightx=1;
        param.fill=GridBagConstraints.HORIZONTAL;
        param.insets=(new Insets(0, 0, 0, 0));
        JLabel tmp=new JLabel();
        tmp.setBackground(Color.WHITE);
        layout.add(tmp,param);
        
        layout.setBackground(Color.WHITE);
        layout.setBorder(new LineBorder(Color.BLACK));
        
        return layout;
    }

    @Override
    public JPanel setCenter(JPanel layout) {
        GridBagConstraints param = new GridBagConstraints();
        param.gridx=0;
        param.gridy=0;
        param.fill=GridBagConstraints.BOTH;
        param.weightx=1;
        param.weighty=1;
        
        // Поле ввода
        layout.add(textFieldiInput,param);
        
        layout.setBorder(new LineBorder(Color.RED));
        return layout;
    }

    @Override
    public JPanel setBottom(JPanel layout) {
        GridBagConstraints param=new GridBagConstraints();
        param.fill=GridBagConstraints.BOTH;
        param.weightx=1.0;
        param.weighty=0.1;
        param.gridy=0;
        
        param.gridx=0;
        layout.add(buttonSqrtAny,param);
        param.gridx=1;
        layout.add(buttonPhi,param);
        param.gridx=2;
        layout.add(buttonExp,param);
        param.gridx=3;
        layout.add(buttonClearChar,param);
        param.gridx=4;
        layout.add(buttonClearAll,param);
        
        param.gridy=1;
        
        param.gridx=0;
        layout.add(buttonPowAny,param);
        param.gridx=1;
        layout.add(buttonSqrt,param);
        param.gridx=2;
        layout.add(buttonDrob,param);
        param.gridx=3;
        layout.add(buttonFact,param);
        param.gridx=4;
        layout.add(buttonModule,param);
        
        param.gridy=2;
        
        param.gridx=0;
        layout.add(buttonPow10,param);
        param.gridx=1;
        layout.add(buttonPow,param);
        param.gridx=2;
        layout.add(buttonRight,param);  
        param.gridx=3;
        layout.add(buttonLeft,param);
        param.gridx=4;
        layout.add(buttonDel,param);
        
        param.gridy=3;
        
        param.gridx=0;
        layout.add(buttonPow2,param);
        param.gridx=1;
        layout.add(button7,param);
        param.gridx=2;
        layout.add(button8,param);
        param.gridx=3;
        layout.add(button9,param);
        param.gridx=4;
        layout.add(buttonMul,param);
        
        param.gridy=4;
        
        param.gridx=0;
        layout.add(buttonLogX_Y,param);
        param.gridx=1;
        layout.add(button4,param);
        param.gridx=2;
        layout.add(button5,param);
        param.gridx=3;
        layout.add(button6,param);
        param.gridx=4;
        layout.add(buttonSub,param);
        
        param.gridy=5;
        
        param.gridx=0;
        layout.add(buttonLnX,param);
        param.gridx=1;
        layout.add(button1,param);
        param.gridx=2;
        layout.add(button2,param);
        param.gridx=3;
        layout.add(button3,param);
        param.gridx=4;
        layout.add(buttonAdd,param);
        
        param.gridy=6;
        
        param.gridx=0;
        layout.add(buttonExpX,param);
        param.gridx=1;
        layout.add(buttonUnar,param);
        param.gridx=2;
        layout.add(button0,param);
        param.gridx=3;
        layout.add(buttonSplit,param);
        param.gridx=4;
        layout.add(buttonEqu,param);
        
        layout.setBorder(new LineBorder(Color.GREEN));
        return layout;
    }

    @Override
    public void onClose() {

    }

    @Override
    public BaseWin getWindow() {
        return this;
    }
    
}

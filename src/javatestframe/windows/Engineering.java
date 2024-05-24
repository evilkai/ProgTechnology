package javatestframe.windows;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Math.log;
import javax.swing.*;
import javatestframe.BaseWin;
import javax.swing.border.*;
import java.util.Stack;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import javatestframe.FrameListener;


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
    private JButton buttonExit;
    private JButton buttonSplit;
    
    // TODO: изменить; Поля ввода/вывода
    //private JTextField inputArea;
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
    private JButton buttonInfo;
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
    private JButton buttonSymbol;
    
    // Скобки
    private JButton buttonLeft;
    private JButton buttonRight;
    
    // Дополнительно
    private JPanel trigonometry;
    
    
    // Панели
    JPanel top;
    JPanel center;
    JPanel bottom;
    
    
    // Флаги
    boolean isCreated=false;
    
    public Engineering(String name, Point location) {
        super(name);
        
        setLocation(location);
        
        
        this.addComponentListener(new FrameListener(this));
        
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
        
        buttonSymbol=new JButton(",");
        
        buttonExit=new JButton("exit");
        buttonSplit=new JButton(".");
        
        inputArea=new JTextField("");
        textFieldNameOption=new JTextField("");
        
        buttonDel=new JButton("/");
        buttonMul=new JButton("*");
        buttonSub=new JButton("-");
        buttonAdd=new JButton("+");
        buttonEqu=new JButton("=");
        
        buttonPow=new JButton("^");
        buttonSqrt=new JButton("sqrt");
        buttonDrob=new JButton("1/");
        buttonFact=new JButton("!");
        buttonModule=new JButton("|");
        buttonPowAny=new JButton("^");
        buttonInfo=new JButton("Info");
        
        buttonLogX_Y=new JButton("lg");
        buttonLnX=new JButton("ln");
        buttonExpX=new JButton("Exp");
        buttonExp=new JButton("exp");
        
        cos = new JButton("cos");
        sin = new JButton("cin");
        tan = new JButton("tan");
        ctan = new JButton("ctan");
        
        buttonPow2=new JButton("2^");
        buttonPow10=new JButton("10^");
        
        buttonPhi=new JButton("P");
        
        buttonClearAll=new JButton("CA");
        buttonClearChar=new JButton("CC");
        
        buttonRight=new JButton("(");
        buttonLeft=new JButton(")");
        
        setButton();
        isCreated=true;
        addButtonListeners();
        onUpdate();
    }
    
    private void addButtonListeners() {
        button1.addActionListener(e -> appendButtonText(button1));
        button2.addActionListener(e -> appendButtonText(button2));
        button3.addActionListener(e -> appendButtonText(button3));
        button4.addActionListener(e -> appendButtonText(button4));
        button5.addActionListener(e -> appendButtonText(button5));
        button6.addActionListener(e -> appendButtonText(button6));
        button7.addActionListener(e -> appendButtonText(button7));
        button8.addActionListener(e -> appendButtonText(button8));
        button9.addActionListener(e -> appendButtonText(button9));
        button0.addActionListener(e -> appendButtonText(button0));
        
        buttonSymbol.addActionListener(e -> appendButtonText(buttonSymbol));
        
        buttonExit.addActionListener(e -> System.exit(0));
        buttonSplit.addActionListener(e -> appendButtonText(buttonSplit));
        
        buttonDel.addActionListener(e -> appendButtonText(buttonDel));
        buttonMul.addActionListener(e -> appendButtonText(buttonMul));
        buttonSub.addActionListener(e -> appendButtonText(buttonSub));
        buttonAdd.addActionListener(e -> appendButtonText(buttonAdd));
        buttonEqu.addActionListener(e -> {
    String result = calculateExpression(inputArea.getText());
    inputArea.setText(result);
});
         
        buttonPow.addActionListener(e -> appendButtonText(buttonPow));
        buttonSqrt.addActionListener(e -> appendButtonText(buttonSqrt));
        buttonDrob.addActionListener(e -> appendButtonText(buttonDrob));
        buttonFact.addActionListener(e -> appendButtonText(buttonFact));
        buttonModule.addActionListener(e -> appendButtonText(buttonModule));
        buttonInfo.addActionListener(e -> {
    String infoText = 
                      "Функция ^ возведение в степень: 2^3\n" +
                      "Функция ln натуральный логарифм от числа: ln(2)\n" +
                      "Функция lg десятичный логарифм от числа: lg(2)\n" +
                      "Функция sqrt квадратный корень из числа: sqrt(2)\n" +
            "Функция ! факториал числа:2\n" +
            "Функция 1/ дробная часть числа:1/2\n" +
            "Функция | модуль числа:|(-2)\n" +
            "Функции cin,cos,tan,ctan тригонометрические функции :cin(2)\n" +
            "Функция exp степень экспоненты, Exp экспонента модуль числа:exp(2), Exp\n";
    inputArea.setText(infoText);
});
        buttonPowAny.addActionListener(e -> appendButtonText(buttonPowAny));
        
        buttonLogX_Y.addActionListener(e -> appendButtonText(buttonLogX_Y));
        buttonLnX.addActionListener(e -> appendButtonText(buttonLnX));
        buttonExpX.addActionListener(e -> appendButtonText(buttonExpX));
        buttonExp.addActionListener(e -> appendButtonText(buttonExp));
        
        buttonPow2.addActionListener(e -> appendButtonText(buttonPow2));
        buttonPow10.addActionListener(e -> appendButtonText(buttonPow10));
        
        buttonPhi.addActionListener(e -> appendButtonText(buttonPhi));
        
        cos.addActionListener(e -> appendButtonText(cos));
        sin.addActionListener(e -> appendButtonText(sin));
        tan.addActionListener(e -> appendButtonText(tan));
        ctan.addActionListener(e -> appendButtonText(ctan));
        
        buttonClearAll.addActionListener(e -> clearAll());
        buttonClearChar.addActionListener(e -> clearLastChar());
        
        buttonLeft.addActionListener(e -> appendButtonText(buttonLeft));
        buttonRight.addActionListener(e -> appendButtonText(buttonRight));
    }
    
    private void appendButtonText(JButton button) {
        String buttonText = button.getText();
        inputArea.setText(inputArea.getText() + buttonText);
    }
    
    private void clearLastChar() {
        String currentText = inputArea.getText();
        if (!currentText.isEmpty()) {
            // Удаляем последний символ
            inputArea.setText(currentText.substring(0, currentText.length() - 1));
        }
    }

    
    private void clearAll() {
        inputArea.setText("");
    }
  
private static String calculateExpression(String expression) {
    // Инициализация структур данных и переменных
    String[] tokens = expression.split("(?<=[-+*/^()!|])|(?=[-+*/^()!|])");
    Stack<Double> operands = new Stack<>();
    Stack<Character> operations = new Stack<>();

    for (int i = 0; i < tokens.length; i++) {
        String token = tokens[i].trim();
        if (token.isEmpty()) {
            continue;
        }
        char firstChar = token.charAt(0);

        if (Character.isDigit(firstChar) || (firstChar == '-' && (i == 0 || !Character.isDigit(expression.charAt(i - 1))))) {
            // Это число, добавляем его в стек чисел
            StringBuilder operand = new StringBuilder();
            while (i < tokens.length && (Character.isDigit(tokens[i].charAt(0)) || tokens[i].charAt(0) == '.' || (firstChar == '-' && operand.length() == 0))) {
                operand.append(tokens[i++]);
            }
            i--;
            operands.push(Double.parseDouble(operand.toString()));
        } else if (isOperator(firstChar)) {
            // Это оператор, обрабатываем его
            while (!operations.isEmpty() && precedence(operations.peek()) >= precedence(firstChar)) {
                applyOperation(operands, operations);
            }
            operations.push(firstChar);
        } else if (firstChar == '(') {
            // Открывающая скобка, добавляем ее в стек операций
            operations.push(firstChar);
        } else if (firstChar == ')') {
            // Закрывающая скобка, вычисляем все операции внутри скобок
            while (!operations.isEmpty() && operations.peek() != '(') {
                applyOperation(operands, operations);
            }
            operations.pop(); // Удаляем открывающую скобку
        } else if (Character.isAlphabetic(firstChar)) {
            // Обработка функций
           String functionName;
int indexOfOpenBracket = token.indexOf('(');
if (indexOfOpenBracket != -1) {
    functionName = token.substring(0, indexOfOpenBracket);
} else {
    functionName = token;
}
            if ("sqrt".equals(functionName)) {
                operations.push('s');
            } else if ("ln".equals(functionName)) {
                operations.push('l');
            } else if ("exp".equals(functionName)) {
                operations.push('e');
            } else if ("lg".equals(functionName)) {
                operations.push('g');
            } else if ("Exp".equals(functionName)) {
                operations.push('E');
            } else if ("1/".equals(functionName)) {
                operations.push('o');
            } else if ("cin".equals(functionName)) {
                operations.push('X');
            } else if ("cos".equals(functionName)) {
                operations.push('C');
            } else if ("tan".equals(functionName)) {
                operations.push('T');
            } else if ("ctan".equals(functionName)) {
                operations.push('N');
            }
        }
    }

    // Выполняем оставшиеся операции
    while (!operations.isEmpty()) {
        applyOperation(operands, operations);
    }

    // Возвращаем результат
    return String.valueOf(operands.peek());
}

private static double factorial(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }
    // Метод для определения приоритета операций
    private static int precedence(char operator) {
        if (operator == '+' || operator == '-') {
            return 1;
        } else if (operator == '*' || operator == '/') {
            return 2;
        } else if (operator == '^' || operator == 's' || operator == 'l' || operator == 'e' || operator == 'g' || operator == 'E' || operator == 'o'|| operator == '!'|| operator == '|'|| operator == 'X' || operator == 'C' || operator == 'T' || operator == 'N'||operator == 'P'||operator == 'S') {
            return 3; // Приоритет функций выше, чем у операторов
        } else {
            return 0;
        }
    }

    // Метод для проверки, является ли символ оператором
    private static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^' || ch == 's' || ch == 'l' || ch == 'e' || ch == 'g' || ch == 'E' || ch == 'o'|| ch == '!'|| ch == '|'|| ch == 'X'|| ch == 'C'|| ch == 'T'|| ch == 'N'||ch == 'P'|| ch == 'S';
    }
public static double getFactorial(double f) {
  double result = 1;
  for (double i = 1; i <= f; i++) {
     result = result * i;
  }
  return result;
}
    // Метод для применения операции к числам из стека чисел
    private static void applyOperation(Stack<Double> numbers, Stack<Character> operations) {
        char operator = operations.pop();
        double result = 0;
        double operand;
        switch (operator) {
            case '+':
                result = numbers.pop() + numbers.pop();
                break;
            case '-':
                operand = numbers.pop();
                result = numbers.pop() - operand;
                break;
            case '*':
                result = numbers.pop() * numbers.pop();
                break;
            case '/':
                operand = numbers.pop();
                result = numbers.pop() / operand;
                break;
            case '^':
                operand = numbers.pop();
                result = Math.pow(numbers.pop(), operand);
                break;
            case 's':
                result = Math.sqrt(numbers.pop());
                break;
            case 'l':
                result = Math.log(numbers.pop());
                break;
            case 'e':
                result = Math.exp(numbers.pop());
                break;
            case 'g':
                result = Math.log10(numbers.pop());
                break;
            case 'E':
                result = Math.E;
                break;
            case 'o':
                result = 1 / numbers.pop();
                break;
                case '!':
                result = getFactorial( numbers.pop());
                break;
                case '|':
                result = Math.abs(numbers.pop());
                break;
                case 'X':
                result = Math.sin(Math.toRadians(numbers.pop()));
                break;
                case 'C':
                result = Math.cos(Math.toRadians(numbers.pop()));
                break;
                case 'T':
                result = Math.tan(Math.toRadians(numbers.pop()));
                break;
                case 'N':
                result = 1.0/Math.tan(Math.toRadians(numbers.pop()));
                break;
                case 'P':
                result = Math.PI;
                break;
    }
        numbers.push(result);
    }


       


    @Override
    public void setButton() {
       System.out.println("TEST Engin");
        Container frame=getContentPane();
        frame.setLayout(new GridBagLayout());
        GridBagConstraints param=new GridBagConstraints();
        
        top=new JPanel(new GridBagLayout());
        center=new JPanel(new GridBagLayout());
        bottom=new JPanel(new GridBagLayout());
        
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
        //layout.setBorder(new LineBorder(Color.BLACK));
        
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
        layout.add(inputArea,param);
        
        //layout.setBorder(new LineBorder(Color.RED));
        return layout;
    }

    @Override
    public JPanel setBottom(JPanel layout) {
      GridBagConstraints param=new GridBagConstraints();
        param.fill=GridBagConstraints.BOTH;
        //param.insets=(new Insets(1, 1, 1, 1));
        param.weightx=1.0;
        param.weighty=0.1;
        param.gridy=0;
        
        param.gridx=0;
        buttonInfo.setBackground(new Color(222, 237, 253));
        buttonInfo.setBorder(BorderFactory.createEtchedBorder());
        layout.add(buttonInfo,param);
        
        param.gridx=1;
        buttonExit.setBackground(new Color(222, 237, 253));
        buttonExit.setBorder(BorderFactory.createEtchedBorder());
        layout.add(buttonExit,param);
        
        param.gridx=2;
        buttonExp.setBackground(new Color(222, 237, 253));
        buttonExp.setBorder(BorderFactory.createEtchedBorder());
        layout.add(buttonExp,param);
        
        param.gridx=3;
        buttonClearChar.setBackground(new Color(222, 237, 253));
        buttonClearChar.setBorder(BorderFactory.createEtchedBorder());
        layout.add(buttonClearChar,param);
        
        param.gridx=4;
        buttonClearAll.setBackground(new Color(222, 237, 253));
        buttonClearAll.setBorder(BorderFactory.createEtchedBorder());
        layout.add(buttonClearAll,param);
        
        param.gridy=1;
        
        param.gridx=0;
        buttonPowAny.setBackground(new Color(222, 237, 253));
        buttonPowAny.setBorder(BorderFactory.createEtchedBorder());
        layout.add(buttonPowAny,param);
        param.gridx=1;
        buttonSqrt.setBackground(new Color(222, 237, 253));
        buttonSqrt.setBorder(BorderFactory.createEtchedBorder());
        layout.add(buttonSqrt,param);
        param.gridx=2;
        buttonDrob.setBackground(new Color(222, 237, 253));
        buttonDrob.setBorder(BorderFactory.createEtchedBorder());
        layout.add(buttonDrob,param);
        param.gridx=3;
        buttonFact.setBackground(new Color(222, 237, 253));
        buttonFact.setBorder(BorderFactory.createEtchedBorder());
        layout.add(buttonFact,param);
        param.gridx=4;
        buttonModule.setBackground(new Color(222, 237, 253));
        buttonModule.setBorder(BorderFactory.createEtchedBorder());
        layout.add(buttonModule,param);
        
        param.gridy=2;
        
        param.gridx=0;
        buttonPow10.setBackground(new Color(222, 237, 253));
        buttonPow10.setBorder(BorderFactory.createEtchedBorder());
        layout.add(buttonPow10,param);
        param.gridx=1;
        buttonRight.setBackground(new Color(222, 237, 253));
        buttonRight.setBorder(BorderFactory.createEtchedBorder());
        layout.add(buttonRight,param);  
        param.gridx=2;
        buttonLeft.setBackground(new Color(222, 237, 253));
        buttonLeft.setBorder(BorderFactory.createEtchedBorder());
        layout.add(buttonLeft,param);
        param.gridx=3;
        buttonDel.setBackground(new Color(222, 237, 253));
        buttonDel.setBorder(BorderFactory.createEtchedBorder());
        layout.add(buttonDel,param);
        param.gridx=4;
        buttonSymbol.setBackground(new Color(222, 237, 253));
        buttonSymbol.setBorder(BorderFactory.createEtchedBorder());
        layout.add(buttonSymbol, param);
        
        param.gridy=3;
        
        param.gridx=0;
        buttonPow2.setBackground(new Color(222, 237, 253));
        buttonPow2.setBorder(BorderFactory.createEtchedBorder());
        layout.add(buttonPow2,param);
        param.gridx=1;
        button7.setBackground(new Color(222, 237, 253));
        button7.setBorder(BorderFactory.createEtchedBorder());
        layout.add(button7,param);
        param.gridx=2;
        button8.setBackground(new Color(222, 237, 253));
        button8.setBorder(BorderFactory.createEtchedBorder());
        layout.add(button8,param);
        param.gridx=3;
        button9.setBackground(new Color(222, 237, 253));
        button9.setBorder(BorderFactory.createEtchedBorder());
        layout.add(button9,param);
        param.gridx=4;
        buttonMul.setBackground(new Color(222, 237, 253));
        buttonMul.setBorder(BorderFactory.createEtchedBorder());
        layout.add(buttonMul,param);
        
        param.gridy=4;
        
        param.gridx=0;
        buttonLogX_Y.setBackground(new Color(222, 237, 253));
        buttonLogX_Y.setBorder(BorderFactory.createEtchedBorder());
        layout.add(buttonLogX_Y,param);
        param.gridx=1;
        button4.setBackground(new Color(222, 237, 253));
        button4.setBorder(BorderFactory.createEtchedBorder());
        layout.add(button4,param);
        param.gridx=2;
        button5.setBackground(new Color(222, 237, 253));
        button5.setBorder(BorderFactory.createEtchedBorder());
        layout.add(button5,param);
        param.gridx=3;
        button6.setBackground(new Color(222, 237, 253));
        button6.setBorder(BorderFactory.createEtchedBorder());
        layout.add(button6,param);
        param.gridx=4;
        buttonSub.setBackground(new Color(222, 237, 253));
        buttonSub.setBorder(BorderFactory.createEtchedBorder());
        layout.add(buttonSub,param);
        
        param.gridy=5;
        
        param.gridx=0;
        buttonLnX.setBackground(new Color(222, 237, 253));
        buttonLnX.setBorder(BorderFactory.createEtchedBorder());
        layout.add(buttonLnX,param);
        param.gridx=1;
        button1.setBackground(new Color(222, 237, 253));
        button1.setBorder(BorderFactory.createEtchedBorder());
        layout.add(button1,param);
        param.gridx=2;
        button2.setBackground(new Color(222, 237, 253));
        button2.setBorder(BorderFactory.createEtchedBorder());
        layout.add(button2,param);
        param.gridx=3;
        button3.setBackground(new Color(222, 237, 253));
        button3.setBorder(BorderFactory.createEtchedBorder());
        layout.add(button3,param);
        param.gridx=4;
        buttonAdd.setBackground(new Color(222, 237, 253));
        buttonAdd.setBorder(BorderFactory.createEtchedBorder());
        layout.add(buttonAdd,param);
        
        param.gridy=6;
        
        param.gridx=0;
        buttonExpX.setBackground(new Color(222, 237, 253));
        buttonExpX.setBorder(BorderFactory.createEtchedBorder());
        layout.add(buttonExpX,param);
        param.gridx=1;
        buttonPhi.setBackground(new Color(222, 237, 253));
        buttonPhi.setBorder(BorderFactory.createEtchedBorder());
        layout.add(buttonPhi,param);
        param.gridx=2;
        button0.setBackground(new Color(222, 237, 253));
        button0.setBorder(BorderFactory.createEtchedBorder());
        layout.add(button0,param);
        param.gridx=3;
        buttonSplit.setBackground(new Color(222, 237, 253));
        buttonSplit.setBorder(BorderFactory.createEtchedBorder());
        layout.add(buttonSplit,param);
        param.gridx=4;
        param.gridheight=2;
        buttonEqu.setBackground(new Color(114, 180, 255));
        buttonEqu.setBorder(BorderFactory.createEtchedBorder());
        layout.add(buttonEqu,param);
        param.gridheight=1;
        param.gridy=7;

        param.gridx=0;
        cos.setBackground(new Color(222, 237, 253));
        cos.setBorder(BorderFactory.createEtchedBorder());
        layout.add(cos,param);
        param.gridx=1;
        sin.setBackground(new Color(222, 237, 253));
        sin.setBorder(BorderFactory.createEtchedBorder());
        layout.add(sin,param);
        param.gridx=2;
        tan.setBackground(new Color(222, 237, 253));
        tan.setBorder(BorderFactory.createEtchedBorder());
        layout.add(tan,param);
        param.gridx=3;
        ctan.setBackground(new Color(222, 237, 253));
        ctan.setBorder(BorderFactory.createEtchedBorder());
        layout.add(ctan,param);
        
        //layout.setBorder(new LineBorder(Color.GREEN));
        return layout;  
 
    }

    @Override
    public void onClose() {
        
    }

    @Override
    public BaseWin getWindow() {
        return this;
    }

    @Override
    public void onUpdate() {
        if(isCreated){
            System.out.println("UPDATE IS SIMPLE");
            inputArea.setFont(new Font("Ariel",Font.BOLD,(int)((double)(center.getHeight()/100.*35))));
        }
    }

    @Override
    public Point getLocationWindow() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
   
    
    
    
} 
package javatestframe.SimpleImplement;

import java.text.DecimalFormat;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static javatestframe.windows.Engineering.getFactorial;
import javax.swing.*;

public class SImpleMath {
    private static boolean toChange;
    private static boolean isDot;
    private static boolean isError;
    
    private static DecimalFormat decimalFormat;

    static {
        decimalFormat = new DecimalFormat("#.####");
        toChange=false;
        isError=false;
        isDot=false;
    }
    
    public static String getMath(JTextField outArea, Integer operatorID, JTextField inputArea){
        String out = "";
        
        switch (operatorID) {
            case Buttons.button1:
                System.out.println("Button1");
                out="1";
                break;
            case Buttons.button2:
                System.out.println("Button2");
                out="2";
                break;
            case Buttons.button3:
                System.out.println("Button3");
                out="3";
                break;
            case Buttons.button4:
                System.out.println("Button4");
                out="4";
                break;
            case Buttons.button5:
                System.out.println("Button5");
                out="5";
                break;
            case Buttons.button6:
                System.out.println("Button6");
                out="6";
                break;
            case Buttons.button7:
                System.out.println("Button7");
                out="7";
                break;
            case Buttons.button8:
                System.out.println("Button8");
                out="8";
                break;
            case Buttons.button9:
                System.out.println("Button9");
                out="9";
                break;
            case Buttons.button0:
                System.out.println("Button0");
                out="0";
                break;
            case Buttons.buttonUnar:
                System.out.println("ButtonUnar");
                //out="Unar";
                out=Unar(inputArea);
                break;
            case Buttons.buttonSplit:
                System.out.println("ButtonSplit");
                    out=".";
                break;
            case Buttons.buttonDel:
                System.out.println("ButtonDel");
                out="/";
                break;
            case Buttons.buttonMul:
                System.out.println("ButtonMul");
                out="*";
                break;
            case Buttons.buttonSub:
                System.out.println("ButtonSub");
                out="-";
                break;
            case Buttons.buttonAdd:
                System.out.println("ButtonAdd");
                out="+";
                break;
            case Buttons.buttonEqual:
                toChange=true;
                System.out.println("ButtonEqual");
                //out="=";
                ClearLine(outArea);
                addInArea(outArea, inputArea.getText()+"=");
                String buf=Equal(inputArea);
                out=buf;
                ClearLine(inputArea);
                
                
                break;
            case Buttons.buttonPow:
                System.out.println("ButtonPow");
                out="^";
                break;
            case Buttons.buttonSqr:
                System.out.println("ButtonSqr");
                try {
                    out=Sqr(inputArea);
                } catch (NullPointerException e) {
                    out=e.getMessage();
                }
                //out="\u221A";
                
                break;
            case Buttons.buttonFraction:
                System.out.println("ButtonFraction");
                //out="1/";
                try {
                    out=Fraction(inputArea);
                } catch (NullPointerException e) {
                    out=e.getMessage();
                }
                
                break;
            case Buttons.buttonPercent:
                System.out.println("ButtonPercent");
                out="%";
                break;
            case Buttons.buttonClearAll:
                System.out.println("ButtonClearAll");
                //out="CA";
                ClearAll(inputArea,outArea);
                break;
            case Buttons.buttonClearLine:
                System.out.println("ButtonClearLine");
                //out="CL";
                ClearLine(inputArea);
                
                break;
            case Buttons.buttonClearChar:
                System.out.println("ButtonClearChar");
                //out="CC";
                out=ClearChar(inputArea);
                ClearLine(inputArea);
                break;
            default:
                System.out.println("ERROR BUTTON");
                out=null;
                break;
        }
        
        
        
        if (!inputArea.getText().isEmpty()) {
            if (inputArea.getText().charAt(0) == '0' || !isDigit(inputArea.getText())) {
                //&& (inputArea.getText().toString().charAt(0)=='0' || !isDigit(inputArea.getText().toString()))
                System.out.println("IS ZERO");
                inputArea.setText("");
            }
            else if (!outArea.getText().isEmpty() && outArea.getText().charAt(outArea.getText().length()-1) == '=' && isDigit(out) && toChange) {
                System.out.println("EARASE "+out);
                inputArea.setText("");
            }else if(isError){
                inputArea.setText("");
                isError=false;
            }
            toChange=false;
        }
        
        if(hasDot(inputArea.getText(), out)){
            System.out.println("ISDOD");
            if(out.charAt(0)=='.'){
                out="";
            }
            isDot=true;
        }else {isDot=false;}
        
        if (!hasSimilar(inputArea.getText(), out)) out="";
        return out;
    }
    
    public static boolean getMantissa(double number){
        double fraction=number-(int)number;
        boolean out=fraction!=0.0;
        return out;
    }
    
    public static String Unar(JTextField out){
        String getStr=out.getText();
        if(!isDigit(getStr)) {System.out.println("HERE UNAR"); return "0";}
        double number = Double.parseDouble(getStr);
        
        out.setText(null);
        if(getMantissa(number)){
            System.out.println("mantissa");
            return String.valueOf(-number);
            
        }
        System.out.println("no mantissa");
        return String.valueOf((int)-number);
    }
    
    private static String Equal(JTextField out){
        String answer;
        answer=calculateExpression(out.getText());
        //String formattedNumber = decimalFormat.format(answer).replace(',', '.');
        return answer;
    }
    
    // Реализация sqrt(x)
    private static String Sqr(JTextField out){
        double number;
        if(out.getText().isEmpty()) return "0";
            try {
                number = Double.parseDouble(out.getText());
            } catch (NumberFormatException e) {
                isError = true;
                toChange=false;
                throw new NullPointerException("Неверный ввод");
            }
            System.out.println("THE "+number);
        if(number<0.){
            isError=true;
            toChange=false;
            throw new NullPointerException("Отрицательное число");
        }
        if(number<0) return "";
        number=Math.sqrt(number);
        out.setText(null);
        if(getMantissa(number)){
            System.out.println("mantissa");
            return String.format("%.4f", number).replace(",", ".");

        }
        System.out.println("no mantissa");
        return String.valueOf((int)number);
    }
    
    
    // Реализация 1/x
    private static String Fraction(JTextField out){
        double number;
        if(out.getText().isEmpty()) return "0";
            try {
                number = Double.parseDouble(out.getText());
            } catch (NumberFormatException e) {
                isError = true;
                toChange=false;
                throw new NullPointerException("Неверный ввод");
            }
        if(number==0    ){
            isError=true;
            toChange=false;
            throw new NullPointerException("Деление на 0");
        }
        number=1./number;
        out.setText(null);
        if(getMantissa(number)){
            System.out.println("mantissaFr");
            String formattedNumber = decimalFormat.format(number).replace(',', '.');
            return formattedNumber;

        }
        System.out.println("no mantissa");
        return String.valueOf((int)number);
    }
    
    
    // Реализация C
    private static void ClearAll(JTextField in, JTextField out){
        in.setText("");
        out.setText("");
    }
    
    // Реализация CL
    private static void ClearLine(JTextField in){
        in.setText("");
    }
    
    // Реализация CC
    private static String ClearChar(JTextField in){
        System.out.println(in.getText());
        return in.getText().substring(0, in.getText().length() - 1);
    }
    
    private static void addInArea(JTextField in,String str){
        in.setText(str);
    }
    
    
    
    
    
    private static String calculateExpression(String expression) {
        // Инициализация структур данных и переменных
        String[] tokens = expression.split("(?<=[-+*/^|%])|(?=[-+*/^|%])");
        Stack<Double> operands = new Stack<>();
        Stack<Character> operations = new Stack<>();
        char check=tokens[0].charAt(0);
        System.out.println("TOKEN "+tokens[0]);

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
                    String buf=tokens[i++];
                    operand.append(buf);
                System.out.println("FIRST "+operand.toString());
                }
                i--;
                if (!isDigit(operand.toString())) return "0";
                operands.push(Double.parseDouble(operand.toString()));
                
            } else if (isOperator(firstChar)) {
                // Это оператор, обрабатываем его
                
                while (!operations.isEmpty() && precedence(operations.peek()) >= precedence(firstChar)) {
                    applyOperation(operands, operations);
                System.out.println("COMPLITED");
                }
                operations.push(firstChar);
            } 
        }
        if (!isDigit(operands.toString())) return "0";
        System.out.println("START DOING"+ operations.toString());
        // Выполняем оставшиеся операции
        while (!operations.isEmpty()) {
            
            try {
                System.out.println("DOING CHECK "+operands+" "+operations);
                applyOperation(operands, operations);
            } catch (NullPointerException e) {
                return e.getMessage();
            }
        }

        // Возвращаем результат
        String formattedNumber = decimalFormat.format(operands.peek()).replace(',', '.');
        return formattedNumber;
    }
    
    
    
    
// Метод для применения операции к числам из стека чисел
    private static void applyOperation(Stack<Double> numbers, Stack<Character> operations) {
        System.out.println("CHAR BEFOR"+operations.toString());
        char operator = operations.pop();
        System.out.println("CHAR AFTER"+operator);
        double result = 0;
        double operand;
        double operand2=0;
        
        switch (operator) {
            case '+':
                operand=numbers.pop();
                if(numbers.isEmpty()) operand2=operand;
                else operand2=numbers.pop();
                System.out.println("DO + "+ numbers);
                result = operand+operand2;
                System.out.println("ANWS "+operand+" "+operand2+" "+result);
                break;
            case '-':
                System.out.println("DO - "+ numbers);
                operand=numbers.pop();
                if(numbers.isEmpty()) operand2=operand;
                else operand2=numbers.pop();
                result = operand2 - operand;
                System.out.println("ANWS "+operand+" "+operand2+" "+result);
                break;
            case '*':
                System.out.println("DO * "+ numbers);
                operand=numbers.pop();
                if(numbers.isEmpty()){
                    result=operand*operand;
                }else{
                    result=numbers.pop() *operand;
                }
                break;
            case '/':
                System.out.println("DO / "+ numbers);
                operand = numbers.pop();
                if(operand==0 || numbers.isEmpty()){
                    isError=true;
                    toChange=false;
                    throw new NullPointerException("Деление на 0");
                }
                result = numbers.pop() / operand;
                break;
            case '^':
                System.out.println("DO ^ "+ numbers);
                operand = numbers.pop();
                operand2=2;
                if (numbers.isEmpty()){
                    result=Math.pow(operand, operand2);
                    break;
                }else {operand2=numbers.pop();}
                result = Math.pow(operand2, operand);
                break;
            case '%':
                System.out.println("DO % "+ numbers);
                operand=numbers.pop();
                operand2=numbers.pop();
                if(numbers.isEmpty()){
                    numbers.push(operand2);
                }
                if(operations.get(operations.size()-1)=='*'){
                    operations.pop();
                    result=Math.abs(operand/100*operand2);
                }else if(operations.get(operations.size()-1)=='/'){
                    operations.pop();
                    result=Math.abs(operand2*100/operand);
                }else{
                    result=Math.abs(operand/100*operand2);
                }
                System.out.println("ANWS"+operand+" "+operand2+" "+result);
                break;
        }
        numbers.push(result);
    }
    
    
    // Метод для проверки, является ли символ оператором
    private static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^' || ch=='%';
    }
    
    
    // Метод для определения приоритета операций
    private static int precedence(char operator) {
        if (operator == '+' || operator == '-') {
            return 1;
        } else if (operator == '*' || operator == '/') {
            return 2;
        } else if (operator == '^'  || operator=='%') {
            return 3; // Приоритет функций выше, чем у операторов
        } else {
            return 0;
        }
    }
    
    private static boolean isDigit(String digit_str){
        boolean hasDigits = false;
        for(int i = 0;i<digit_str.length() && !hasDigits; i++) {
            if(Character.isDigit(digit_str.charAt(i))) {
                hasDigits = true;
            }
        }
        return hasDigits;
    }
    
    private static boolean hasDot(String str, String s){
        boolean dot=false;
        if(str.length()<1) return false;
        String[] token={"+","-","/","*","^","%"};
        for(int i=str.length()-1;i>=0;i--){
            if(!isDigit(s)){
                if(str.charAt(i)==s.charAt(0)){  
                    return true;
                }else for(int j=0;j<token.length;j++){
                    if(str.contains(token[j]))
                    return false;
                }
            }
        }
        return false;
    }
    
    private static boolean hasSimilar(String input, String last_chr) {
        if(input.isEmpty()) return true;
        String buf=""+input.charAt(input.length()-1);
        System.out.println("LAST "+last_chr+" "+buf);
        if(!isDigit(last_chr) && !isDigit(buf)){return false;}
        return true;
    }
 
}

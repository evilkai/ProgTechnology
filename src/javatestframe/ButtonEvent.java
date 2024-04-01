
package javatestframe;

import java.awt.event.*;
import javax.swing.*;


public class ButtonEvent implements ActionListener{
    public BaseWin wind;
    public ButtonEvent(BaseWin get){
        
        wind=get;
        //System.out.println("HERE "+wind.nameWin);
    }

    
    public ButtonEvent(){}
    @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("OVVERIDE");
            Object type=e.getSource();
            switch (type.getClass().getSimpleName()) {
        case "JButton": // TODO: cделать; обработка кнопок
            JButton clikedButton=(JButton) type;
            System.out.println("ButtonEvent actionPerformed");
            String text=clikedButton.getText();
            System.out.println(text);
            break;
        case "JComboBox":   // Обработка чекбоксов
            System.out.println("ERROR HERE");
            JComboBox<String> cb=(JComboBox<String>)type;
            Object get=cb.getSelectedItem();
            System.out.println("ITS IN CHECKBOX "+get.toString());
            wind.openWindow(get.toString());
            break;
        default:
            throw new AssertionError();
            }
        }
    public void Button(){}  // TODO: cделать;
    public void onNewWindow(){} // TODO: cделать;
    public void setBase(){} // TODO: cделать;
}

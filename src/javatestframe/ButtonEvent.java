
package javatestframe;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class ButtonEvent implements ActionListener{
    public BaseWin wind;
    public ButtonEvent(BaseWin get){
        
        wind=get;
        System.out.println("HERE "+wind.nameWin);
    }

    
    public ButtonEvent(){}
    @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("OVVERIDE");
            Object type=e.getSource();
            switch (type.getClass().getSimpleName()) {
        case "JButton":
            JButton clikedButton=(JButton) type;
            System.out.println("ButtonEvent actionPerformed");
            String text=clikedButton.getText();
            System.out.println(text);
            break;
        case "JComboBox":
            JComboBox<String> cb=(JComboBox<String>)type;
            Object get=cb.getSelectedItem();
            System.out.println(cb.getName());
            System.out.println(wind.nameWin);
            wind.openWindow(get.toString());
            break;
        default:
            throw new AssertionError();
            }
        }
    public void Button(){}
    public void onNewWindow(){}
    public void setBase(){}
}

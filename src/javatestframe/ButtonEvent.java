
package javatestframe;

import java.awt.event.*;
import javatestframe.SimpleImplement.Buttons;
import javatestframe.SimpleImplement.SImpleMath;
import javatestframe.windows.Simple;
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
            JButton clickedButton = (JButton) type;
            int buttonId = Integer.parseInt(clickedButton.getActionCommand());
            String out=SImpleMath.getMath(wind.outArea, buttonId,wind.inputArea);
            System.out.println(out);
            wind.inputArea.setText(wind.inputArea.getText()+out);
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

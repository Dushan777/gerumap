package dsw.gerumap.app.gui.swing.controller.mindMapActions;

import dsw.gerumap.app.core.ApplicationFramework;
import dsw.gerumap.app.gui.swing.errorLogger.EventType;
import dsw.gerumap.app.gui.swing.view.MainFrame;
import dsw.gerumap.app.messageGenerator.MessageGeneratorImplementation;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfirmAction implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        String text = MainFrame.getInstance().getActionManager().getColorChooserAction().getTextField().getText();
        String text2 = MainFrame.getInstance().getActionManager().getColorChooserAction().getTextFieldText().getText();
        if(!text.matches("[0-9]+") || !text2.matches("[0-9a-zA-Z]+"))
        {
            ((MessageGeneratorImplementation) ApplicationFramework.getInstance().getMessageGenerator()).setType(EventType.CANNOT_SET_NAME);
            ApplicationFramework.getInstance().getMessageGenerator().generateMessage();
            MainFrame.getInstance().getActionManager().getColorChooserAction().getTextField().setText("");
            MainFrame.getInstance().getActionManager().getColorChooserAction().getTextFieldText().setText("");

            return;
        }
        int lineStroke = Integer.parseInt(text);
        Color color = MainFrame.getInstance().getActionManager().getColorChooserAction().getColorChooser().getColor();
        String hex = Integer.toHexString(color.getRGB());
        hex= hex.substring(2,hex.length());
        hex="#"+hex;
        System.out.println(hex);

    }
}

package dsw.gerumap.app.gui.swing.controller.mindMapActions;

import dsw.gerumap.app.core.ApplicationFramework;
import dsw.gerumap.app.gui.swing.errorLogger.EventType;
import dsw.gerumap.app.gui.swing.view.MainFrame;
import dsw.gerumap.app.gui.swing.view.MindMapView;
import dsw.gerumap.app.mapRepository.implementation.Concept;
import dsw.gerumap.app.mapRepository.implementation.Element;
import dsw.gerumap.app.messageGenerator.MessageGeneratorImplementation;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Getter
@Setter
public class ConfirmAction implements ActionListener {

    private Color color;
    private int lineStroke;
    private String text2;
    private int dimensionX, dimensionY;
    @Override
    public void actionPerformed(ActionEvent e) {
        String text = MainFrame.getInstance().getActionManager().getColorChooserAction().getTextField().getText();
        text2 = MainFrame.getInstance().getActionManager().getColorChooserAction().getTextFieldText().getText();
        dimensionX = text2.length()*9 + 45;
        dimensionY = text2.length()*3/2 + 30;
        MindMapView mindMapView = (MindMapView)MainFrame.getInstance().getProjectView().getTabbedPane().getSelectedComponent();
        if(mindMapView.getMapSelectionModel().getSelectedElements() != null)
        {
            for(Element element : mindMapView.getMapSelectionModel().getSelectedElements())
            {
                if(text.matches("[0-9]+") && text2.matches("[0-9a-zA-Z\\s]+"))
                {
                    element.setColor(MainFrame.getInstance().getActionManager().getColorChooserAction().getColorChooser().getColor());
                    element.setLineStroke(Integer.parseInt(text));
                    Concept c = (Concept) element;
                    c.setHeight(dimensionX);
                    c.setWidth(dimensionY);
                    element.setName(text2);
                }

            }
        }
        if(!text.matches("[0-9]+") || !text2.matches("[0-9a-zA-Z\\s]+"))
        {
            ((MessageGeneratorImplementation) ApplicationFramework.getInstance().getMessageGenerator()).setType(EventType.CANNOT_SET_NAME);
            ApplicationFramework.getInstance().getMessageGenerator().generateMessage();
            MainFrame.getInstance().getActionManager().getColorChooserAction().getTextField().setText("");
            MainFrame.getInstance().getActionManager().getColorChooserAction().getTextFieldText().setText("");
            return;
        }

        lineStroke = Integer.parseInt(text);
        color = MainFrame.getInstance().getActionManager().getColorChooserAction().getColorChooser().getColor();
        System.out.println(color);
        MainFrame.getInstance().getActionManager().getColorChooserAction().getFrame().dispose();
        MainFrame.getInstance().getActionManager().getColorChooserAction().setFlag(false);
        MainFrame.getInstance().setVisible(true);
    }

}

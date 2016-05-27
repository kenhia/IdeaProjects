package com.kenhia.ps;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame{
    private TextPanel textPanel;
    private FormPanel formPanel;

    public MainFrame() {
        super("Hello, World");

        setLayout(new BorderLayout());

        Toolbar toolbar = new Toolbar();
        textPanel = new TextPanel();
        formPanel = new FormPanel();

        toolbar.setStringListener(text -> textPanel.appendText(text));
        formPanel.setFormListener(new FormListener() {
            public void formEventOccured(FormEvent e) {
                String name = e.getName();
                String occupation = e.getOccupation();
                int ageCat = e.getAgeCategory();
                String empCat = e.getEmploymentCategory();

                textPanel.appendText(name + ": " + occupation + ": " + ageCat + ":" + empCat + "\n");
            }
        });

        add(toolbar, BorderLayout.NORTH);
        add(textPanel, BorderLayout.CENTER);
        add(formPanel, BorderLayout.WEST);

        setSize(600, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}

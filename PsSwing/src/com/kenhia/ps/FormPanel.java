package com.kenhia.ps;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormPanel extends JPanel {

    private JLabel nameLabel;
    private JLabel occupationLabel;
    private JLabel ageLabel;
    private JLabel empLabel;
    private JTextField nameField;
    private JTextField occupationField;
    private JButton okBtn;
    private static final Insets BLANK_INSETS = new Insets(0, 0, 0, 0);
    private static final Insets LABEL_PAD_INSETS = new Insets(0, 0, 0, 5);
    private FormListener formListener;
    private JList ageList;
    private JComboBox empCombo;



    public FormPanel() {
        Dimension dim = getPreferredSize();
        dim.width = 250;
        setPreferredSize(dim);

        nameLabel = new JLabel("Name:");
        occupationLabel = new JLabel("Occupation:");
        ageLabel = new JLabel("Age:");
        empLabel = new JLabel("Emp Status:");
        nameField = new JTextField(10);
        occupationField = new JTextField(10);
        ageList = new JList();
        empCombo = new JComboBox();

        // Setup ListBox
        DefaultListModel ageModel = new DefaultListModel();
        ageModel.addElement(new AgeCategory(0, "under 18"));
        ageModel.addElement(new AgeCategory(1, "18 - 65"));
        ageModel.addElement(new AgeCategory(2, "65 or over"));
        ageList.setModel(ageModel);

        ageList.setPreferredSize(new Dimension(110, 70));
        ageList.setBorder(BorderFactory.createEtchedBorder());
        ageList.setSelectedIndex(1);

        // Setup combo box
        DefaultComboBoxModel empModel = new DefaultComboBoxModel();
        empModel.addElement("employeed");
        empModel.addElement("self-employeed");
        empModel.addElement("unemployeed");
        empCombo.setModel(empModel);
        empCombo.setEditable(true);
        empCombo.setSelectedIndex(-1);

        okBtn = new JButton("OK");
        okBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String occupation = occupationField.getText();
                AgeCategory ageCat = (AgeCategory) ageList.getSelectedValue();
                String empCat = (String)empCombo.getSelectedItem();

                System.out.println(empCat);

                FormEvent ev = new FormEvent(this, name, occupation, ageCat.getId(), empCat);

                if (formListener != null) {
                    formListener.formEventOccured(ev);
                }
            }
        });

        Border innerBoarder = BorderFactory.createTitledBorder("Add Person");
        Border outerBoarder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        setBorder(BorderFactory.createCompoundBorder(outerBoarder, innerBoarder));

        layoutComponents();
    }

    public void layoutComponents() {
        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();
        gc.weightx = 1;
        gc.weighty = 1;
        gc.gridx = 0;
        gc.gridy = 0;

        /* First Row *****************************************************************************/
        gc.gridy = 0;


        gc.weightx = 1;
        gc.weighty = 0.1;

        gc.gridx = 0;
        gc.fill = GridBagConstraints.NONE;

        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = LABEL_PAD_INSETS;
        add(nameLabel, gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = BLANK_INSETS;
        add(nameField, gc);

        /* Second Row ****************************************************************************/
        gc.gridy++;


        gc.weightx = 1;
        gc.weighty = 0.1;


        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = LABEL_PAD_INSETS;
        add(occupationLabel, gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = BLANK_INSETS;
        add(occupationField, gc);

        /* Third Row *****************************************************************************/
        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 0.2;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        gc.insets = LABEL_PAD_INSETS;
        add(ageLabel, gc);


        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = BLANK_INSETS;
        add(ageList, gc);

        /* Fourth Row ****************************************************************************/
        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 0.2;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        gc.insets = LABEL_PAD_INSETS;
        add(empLabel, gc);


        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = BLANK_INSETS;
        add(empCombo, gc);

        /* Last Row ******************************************************************************/
        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 2.0;
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = BLANK_INSETS;
        add(okBtn, gc);
    }

    public void setFormListener(FormListener listener) {
        this.formListener = listener;
    }
}

class AgeCategory {
    private int id;
    private String text;

    public int getId() { return id; }

    public AgeCategory(int id, String text) {
        this.id = id;
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}

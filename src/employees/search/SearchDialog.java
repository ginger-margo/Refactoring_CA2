package employees.search;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EtchedBorder;

import employees.ui.EmployeeDetails;
import employees.ui.JTextFieldLimit;
import employees.ui.JTextFieldLimitAdapter;
import employees.ui.TextFieldAdapter;

public abstract class SearchDialog extends JDialog implements ActionListener {
    protected EmployeeDetails parent;
    protected JButton search, cancel;
    protected TextFieldAdapter searchField; 
    protected JLabel searchLabel;

    public SearchDialog(EmployeeDetails parent, String title, String labelText) {
        setTitle(title);
        setModal(true);
        this.parent = parent;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        searchField = new JTextFieldLimitAdapter(new JTextField(20), new JTextFieldLimit(20)); 

        JScrollPane scrollPane = new JScrollPane(createSearchPane(labelText));
        setContentPane(scrollPane);
        getRootPane().setDefaultButton(search);

        setSize(500, 190);
        setLocation(350, 250);
        setVisible(true);
    }

    private Container createSearchPane(String labelText) {
        JPanel searchPanel = new JPanel(new GridLayout(3, 1));
        JPanel textPanel = new JPanel();
        JPanel buttonPanel = new JPanel();

        searchPanel.add(new JLabel("Search"));

        textPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        textPanel.add(searchLabel = new JLabel(labelText));
        searchLabel.setFont(parent.font1);

        textPanel.add(searchField.getTextField()); 
        searchField.setFont(parent.font1);

        buttonPanel.add(search = new JButton("Search"));
        search.addActionListener(this);
        search.requestFocus();

        buttonPanel.add(cancel = new JButton("Cancel"));
        cancel.addActionListener(this);

        searchPanel.add(textPanel);
        searchPanel.add(buttonPanel);

        return searchPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == search) {
            handleSearch();
        } else if (e.getSource() == cancel) {
            dispose();
        }
    }

    protected abstract void handleSearch();
}

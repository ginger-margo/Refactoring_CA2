import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EtchedBorder;

public abstract class SearchDialog extends JDialog implements ActionListener {
    protected EmployeeDetails parent;
    protected JButton search, cancel;
    protected JTextField searchField;
    protected JLabel searchLabel;

    public SearchDialog(EmployeeDetails parent, String title, String labelText) {
        setTitle(title);
        setModal(true);
        this.parent = parent;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

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
        textPanel.add(searchField = new JTextField(20));
        searchField.setFont(parent.font1);
        searchField.setDocument(new JTextFieldLimit(20));

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

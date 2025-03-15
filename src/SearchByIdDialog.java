import java.awt.Color;
import javax.swing.JOptionPane;

public class SearchByIdDialog extends SearchDialog {
    public SearchByIdDialog(EmployeeDetails parent) {
        super(parent, "Search by ID", "Enter ID:");
    }

    @Override
    protected void handleSearch() {
        try {
            int id = Integer.parseInt(searchField.getText().trim());
            parent.searchByIdField.setText(searchField.getText().trim());
            parent.searchEmployeeById();
            dispose();
        } catch (NumberFormatException e) {
            searchField.getTextField().setBackground(new Color(255, 150, 150));
            JOptionPane.showMessageDialog(this, "Invalid ID format! Please enter a numeric ID.");
        }
    }
}

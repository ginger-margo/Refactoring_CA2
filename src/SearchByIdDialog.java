import java.awt.Color;
import javax.swing.JOptionPane;

public class SearchByIdDialog extends SearchDialog {
    public SearchByIdDialog(EmployeeDetails parent) {
        super(parent, "Search by ID", "Enter ID:");
    }

    @Override
    protected void handleSearch() {
        try {
            int id = Integer.parseInt(searchField.getText().trim()); // Validate numeric input
            parent.searchByIdField.setText(searchField.getText().trim());
            parent.searchEmployeeById(); // Call the search method in EmployeeDetails
            dispose(); // Close the dialog after search
        } catch (NumberFormatException e) {
            searchField.setBackground(new Color(255, 150, 150)); // Highlight input field in red
            JOptionPane.showMessageDialog(this, "Invalid ID format! Please enter a numeric ID.");
        }
    }
}

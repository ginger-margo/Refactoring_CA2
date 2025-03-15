package employees.search;
/*
 * 
 * This is a dialog for searching Employees by their surname.
 * 
 * */

import employees.ui.EmployeeDetails;

public class SearchBySurnameDialog extends SearchDialog {
    public SearchBySurnameDialog(EmployeeDetails parent) {
        super(parent, "Search by Surname", "Enter Surname:");
    }

    @Override
    protected void handleSearch() {
        parent.searchBySurnameField.setText(searchField.getText().trim());
        parent.searchEmployeeBySurname();
        dispose();
    }
}

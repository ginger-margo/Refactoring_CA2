package employees.ui;
import employees.search.SearchDialog;

public interface SearchDialogFactory {
    SearchDialog createSearchDialog(EmployeeDetails parent);
}

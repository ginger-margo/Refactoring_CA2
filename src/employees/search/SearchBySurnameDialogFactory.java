package employees.search;
import employees.ui.EmployeeDetails;
import employees.ui.SearchDialogFactory;

public class SearchBySurnameDialogFactory implements SearchDialogFactory {
    @Override
    public SearchDialog createSearchDialog(EmployeeDetails parent) {
        return new SearchBySurnameDialog(parent);
    }
}

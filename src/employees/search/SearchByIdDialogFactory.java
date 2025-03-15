package employees.search;
import employees.ui.EmployeeDetails;
import employees.ui.SearchDialogFactory;

public class SearchByIdDialogFactory implements SearchDialogFactory {
    @Override
    public SearchDialog createSearchDialog(EmployeeDetails parent) {
        return new SearchByIdDialog(parent);
    }
}

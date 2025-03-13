public class SearchBySurnameDialogFactory implements SearchDialogFactory {
    @Override
    public SearchDialog createSearchDialog(EmployeeDetails parent) {
        return new SearchBySurnameDialog(parent);
    }
}

public class SearchByIdDialogFactory implements SearchDialogFactory {
    @Override
    public SearchDialog createSearchDialog(EmployeeDetails parent) {
        return new SearchByIdDialog(parent);
    }
}

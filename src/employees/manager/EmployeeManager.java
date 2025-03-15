package employees.manager;
import java.io.File;

import employees.data.RandomFile;
import employees.model.Employee;

public class EmployeeManager {
    private RandomFile fileHandler;
    private File file;

    public EmployeeManager(File file) {
        this.file = file;
        this.fileHandler = new RandomFile();
    }

    // Adds an employee record to the file
    public void addEmployee(Employee employee) {
        fileHandler.openWriteFile(file.getAbsolutePath());
        fileHandler.addRecords(employee);
        fileHandler.closeWriteFile();
    }

    // Updates an existing employee record at the specified byte position
    public void updateEmployee(Employee employee, long bytePosition) {
        fileHandler.openWriteFile(file.getAbsolutePath());
        fileHandler.changeRecords(employee, bytePosition);
        fileHandler.closeWriteFile();
    }

    // Deletes (marks as inactive) an employee record at the specified byte position
    public void deleteEmployee(long bytePosition) {
        fileHandler.openWriteFile(file.getAbsolutePath());
        fileHandler.deleteRecords(bytePosition);
        fileHandler.closeWriteFile();
    }

    // Reads an employee record from the specified byte position
    public Employee readEmployee(long bytePosition) {
        fileHandler.openReadFile(file.getAbsolutePath());
        Employee employee = fileHandler.readRecords(bytePosition);
        fileHandler.closeReadFile();
        return employee;
    }

    // Navigation methods
    public long getFirstRecordPosition() {
        fileHandler.openReadFile(file.getAbsolutePath());
        long pos = fileHandler.getFirst();
        fileHandler.closeReadFile();
        return pos;
    }

    public long getLastRecordPosition() {
        fileHandler.openReadFile(file.getAbsolutePath());
        long pos = fileHandler.getLast();
        fileHandler.closeReadFile();
        return pos;
    }

    public long getNextRecordPosition(long currentPosition) {
        fileHandler.openReadFile(file.getAbsolutePath());
        long pos = fileHandler.getNext(currentPosition);
        fileHandler.closeReadFile();
        return pos;
    }

    public long getPreviousRecordPosition(long currentPosition) {
        fileHandler.openReadFile(file.getAbsolutePath());
        long pos = fileHandler.getPrevious(currentPosition);
        fileHandler.closeReadFile();
        return pos;
    }
}

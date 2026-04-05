package session14.Exercise06;

import session14.Exercise06.business.service.EmployeeProjectManager;

public class Main {
    public static void main(String[] args) {
        EmployeeProjectManager employeeProjectManager = new EmployeeProjectManager();
        employeeProjectManager.assignEmployeeToProject(1,2);
    }
}

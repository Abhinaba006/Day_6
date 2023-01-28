package Day_6;
import java.util.*;

public class CRUD {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ArrayList<Employee> al = new ArrayList<>();
        System.out.println("1 insert\n2 display\n3 search\n4 delete\n5 update\n6 exit");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        while (true) {
            // print the choices

            switch (choice) {
                case 1:
                    System.out.println("Enter info: ");
                    int empno = sc.nextInt();
                    String name = sc.next();
                    int salary = sc.nextInt();
                    al.add(new Employee(empno, name, salary));
                    break;
                case 2:
                    for (var emp : al) {
                        System.out.print(emp + " ");
                    }
                    System.out.println("");
                    break;
                case 3:
                    System.out.println("Enter empno: ");
                    int enteredEmpNo = sc.nextInt(), found = 0;
                    for (var emp : al) {
                        if (emp.getEmpno() == enteredEmpNo) {
                            found = 1;
                            break;
                        }
                    }
                    if (found == 1)
                        System.out.println("Found");
                    else
                        System.out.println("Not Found");
                    break;
                case 4:
                    System.out.println("Enter empno: ");
                    enteredEmpNo = sc.nextInt();
                    Employee toBeDeleted = null;
                    for (var emp : al) {
                        if (emp.getEmpno() == enteredEmpNo) {
                            toBeDeleted = emp;
                            break;
                        }
                    }
                    if (toBeDeleted != null)
                        al.remove(toBeDeleted);
                    break;
                case 5:
                    System.out.println("Enter empno: ");
                    enteredEmpNo = sc.nextInt();
                    System.out.println("Enter new name: ");
                    String newName = sc.next();
                    System.out.println("Enter new salary: ");
                    int newSalary = sc.nextInt();
                    int toBeUpdated = -1;
                    for (var emp : al) {
                        if (emp.getEmpno() == enteredEmpNo) {
                            toBeUpdated = emp.getEmpno();
                            break;
                        }
                    }
                    if (toBeUpdated != -1)
                        al.set(toBeUpdated, new Employee(enteredEmpNo, newName, newSalary));
                    else
                        System.out.println("Employee Not Found");
                    break;
                default:
                    System.out.println("exiting program");
                    return;
            }
            System.out.println("1 insert\n2 display\n3 search\n4 delete\n5 update\n6 exit");
            choice = sc.nextInt();
        }

    }

}

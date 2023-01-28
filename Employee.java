package Day_6;
public class Employee implements Comparable<Employee> {
	int empno;
	String name;
	int salary;

	public int getEmpno() {
		return empno;
	}
	public Employee(int empno, String name, int salary) {
		super();
		this.empno = empno;
		this.name = name;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [empno=" + empno + ", name=" + name + ", salary=" + salary + "]";
	}

	@Override
	public int compareTo(Employee o) {
		if (this.empno == o.getEmpno())
			return 0;
		else if (this.empno > o.empno)
			return 1;
		else
			return -1;
	}

}

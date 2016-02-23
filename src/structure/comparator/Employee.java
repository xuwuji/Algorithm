package structure.comparator;

/**
 * Comparable is implemented by a class in order to be able to comparing object
 * of itself with some other objects. The class itself must implement the
 * interface in order to be able to compare its instance(s). The method required
 * for implementation is compareTo()
 * 
 * @author wuxu
 *
 */
public class Employee implements Comparable<Employee> {

	private int age;
	private String name;

	public Employee(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(Employee o) {
		if (this.getAge() > o.getAge()) {
			return 1;
		} else if (this.getAge() == o.getAge()) {
			return this.getName().compareTo(o.getName());
		} else {
			return -1;
		}
	}

	public static void main(String[] args) {
		Employee e1 = new Employee(20, "c");
		Employee e2 = new Employee(20, "b");
		if (e1.compareTo(e2) > 0) {
			System.out.println("e2 bigger");
		}
	}

}

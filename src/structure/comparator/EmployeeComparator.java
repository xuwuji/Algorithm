package structure.comparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * In some situations, you may not want to change a class and make it
 * comparable. In such cases, Comparator can be used if you want to compare
 * objects based on certain attributes/fields. For example, 2 persons can be
 * compared based on `height` or `age` etc. (this can not be done using
 * comparable.)
 * 
 * The method required to implement is compare(). Now let's use another way to
 * compare those TV by size. One common use of Comparator is sorting. Both
 * Collections and Arrays classes provide a sort method which use a Comparator.
 * 
 * @author wuxu
 *
 */
public class EmployeeComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		if (o1.getAge() > o2.getAge()) {
			return 1;
		} else if (o1.getAge() == o2.getAge()) {
			return o1.getName().compareTo(o2.getName());
		} else {
			return -1;
		}
	}

	public static void main(String[] args) {
		Employee e1 = new Employee(20, "c");
		Employee e2 = new Employee(20, "b");
		ArrayList<Employee> list = new ArrayList<Employee>();
		list.add(e1);
		list.add(e2);
		Collections.sort(list, new EmployeeComparator());
		for (Employee e : list) {
			System.out.println(e.getName());
		}
	}

}

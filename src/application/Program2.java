package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== Test 1: fyndById ===");
		Department dep = departmentDao.findById(1);
		System.out.println(dep);
		
		System.out.println("=== Test 2: fyndAll ===");
		List<Department> list = departmentDao.findAll();
		for (Department d : list) {
			System.out.println(d);
		}
		
		System.out.println("=== Test 3: insert ===");
		Department NewDepartment = new Department(null, "Music");
		departmentDao.insert(NewDepartment);
		System.out.println("Inserted! new id " + NewDepartment.getId());
		
		System.out.println("=== Test 4: update ===");
		Department dep2 = departmentDao.findById(1);
		dep2.setName("Food");
		departmentDao.update(dep2);
		System.out.println("Update completed");
		
		
		System.out.println("=== Test 5: delete ===");
		System.out.println("Enter a department for delet test");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delet completed");
		
		sc.close();
		
	}

}

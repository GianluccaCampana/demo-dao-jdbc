package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		SellerDao sellerDao = DaoFactory.createSellerDao();
		System.out.println("=== Test 1: seller findById ===");
		Seller seller = sellerDao.findById(16);
		System.out.println(seller);
		
		System.out.println("\n=== Test 2: seller findByIdDepartment ===");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		
		for(Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== Test 3: seller findAll ===");
		
		 list = sellerDao.findAll();
		
		for(Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== Test 4: seller insert ===");
		
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.00, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id = " + newSeller.getId());
		
		System.out.println("\n=== Test 5: seller update ===");
		
		seller = sellerDao.findById(20);
		seller.setName("Ronaldo");		
		sellerDao.update(seller);
		System.out.println("Update completed");
		
		System.out.println("\n=== Test 6: seller update ===");
		System.out.println("Enter id for delete test");
		int id = scan.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete completed");
	}

}

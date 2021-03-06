package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== TESTE 1 findById ===");
		
		Seller seller = sellerDao.findById(3);
		
		System.out.println(seller);
		
		System.out.println("\n === TESTE 2 findByDepartment ===");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		
		for (Seller obj : list ) {
			System.out.println(obj);
		}
		
		System.out.println("\n === TESTE 3 findAll ===");
		list = sellerDao.findAll();
		
		for (Seller obj : list ) {
			System.out.println(obj);
		}
		
		System.out.println("\n === TESTE 4 insert ===");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id = " + newSeller.getId());
		
		System.out.println("\n=== TESTE 5 seller Update ====");
		seller = sellerDao.findById(1);
		seller.setName("Marta Wayne");
		sellerDao.update(seller);
		System.out.println("Update completed!");
		
		System.out.println("\n === TESTE 6 seller Delete ===");
		sellerDao.deleteById(18);
		System.out.println("Deleted!");
	}

}

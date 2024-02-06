package com.practice1.repository;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.practice1.entities.SanPham;
@Repository
public interface SanPhamRepository extends CrudRepository<SanPham, Integer>, JpaRepository<SanPham, Integer>{
	//value = "select * from products p inner join categories c on c.category_id = p.category_id where p.category_id = ?1", nativeQuery = true
	@Query("SELECT sp FROM SanPham sp WHERE sp.type LIKE CONCAT('%', ?1, '%') OR sp.nameProduct LIKE CONCAT('%', ?1, '%')")
	List<SanPham> searchSP(String keyword);
	@Query("select sp from SanPham sp where sp.id = ?1")
	SanPham FindSPById(int id);
	
	
}

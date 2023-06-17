package hello.servlet.web.product.mangement;

import hello.servlet.web.domain.Product;
import hello.servlet.web.domain.ProductOption;

import java.util.List;

public interface ProductManagementRepository {

	Product getProductById(Long productId);

	List<Product> getAllProducts();

	List<Product> getProductsByCategory(Long categoryId);

	List<Product> getProductsByKeyword(String keyword);

	Product createProduct(Product product);

	Product updateProduct(Product product);

	void deleteProduct(Long productId);

	void addScrapProduct(Long memberId, Long productId);

	void deleteScrapProduct(Long memberId, Long productId);

	void isScrapProduct(Long memberId, Long productId);


	// 수정해야댐
	ProductOption getOptionsById(Long productId);
}

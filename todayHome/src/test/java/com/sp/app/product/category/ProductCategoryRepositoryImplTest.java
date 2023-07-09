package com.sp.app.product.category;

import com.sp.app.domain.product.ProductCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:/spring/appServlet/servlet-context.xml",
		"classpath:/spring/root-context.xml",
		"classpath:/mybatis/mybatis-context.xml"
})
public class ProductCategoryRepositoryImplTest {

	@Autowired
	ProductCategoryRepository productCategoryRepository;

	@Test
	public void getAllCategories() throws Exception {

		List<ProductCategory> allCategories = productCategoryRepository.getAllCategories();

		for (ProductCategory allCategory : allCategories) {
			System.out.println("allCategory = " + allCategory);
		}
	}

	@Test
	public void testGetAllCategories() {
	}

	@Test
	public void getCategoryById() {
	}

	@Test
	public void getCategoriesByParentId() {
	}

	@Test
	public void createCategory() {
	}

	@Test
	public void updateCategory() {
	}

	@Test
	public void deleteCategory() {
	}

	@Test
	public void getAllCategoryHierarchy() throws Exception {
		List<ProductCategory> childCategories = productCategoryRepository.getChildCategories(1L);
		for (ProductCategory childCategory : childCategories) {
			System.out.println(childCategory);
		}
	}


}

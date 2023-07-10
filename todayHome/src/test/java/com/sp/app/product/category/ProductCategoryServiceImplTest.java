package com.sp.app.product.category;

import com.sp.app.domain.product.ProductCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:/spring/appServlet/servlet-context.xml",
		"classpath:/spring/root-context.xml",
		"classpath:/mybatis/mybatis-context.xml"
})
public class ProductCategoryServiceImplTest {

	@Autowired
	ProductCategoryService productCategoryService;

	@Test
	public void fetchCategory() throws Exception {
		List<ProductCategory> productCategories = productCategoryService.fetchCategory(null);

		List<ProductCategory> subCategoryList = productCategories.get(0).getSubCategoryList();

		System.out.println("1");
		for (ProductCategory productCategory : subCategoryList) {
			System.out.println(productCategory);

			System.out.println("2");
			if (productCategory.getSubCategoryList().size() > 0) {
				List<ProductCategory> sub1 = productCategory.getSubCategoryList();
				for (ProductCategory category : sub1) {
					System.out.println(category);
				}
			}
		}
	}

	@Test
	public void printCategory() throws Exception {
		List<ProductCategory> productCategories = productCategoryService.fetchCategory(null);

		for (ProductCategory productCategory : productCategories) {
			productCategoryService.printCategoryWithSubcategories(productCategory, 0);
		}
	}

	@Test
	public void getChild() throws Exception {

	}
}
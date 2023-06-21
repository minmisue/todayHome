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
	public void getAllCategories() {
		productCategoryRepository.getAllCategories();
	}

}

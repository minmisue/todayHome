package com.sp.app.product.management;

import com.sp.app.common.CommonDAO;
import com.sp.app.domain.product.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductManagementRepositoryImpl implements ProductManagementRepository {

	@Autowired
	private CommonDAO commonDAO;

	@Override
	public void insertProduct(Product product) throws Exception {
		commonDAO.insertData("productManagement.insertProduct", product);
	}

	@Override
	public void insertProductImg(Long productId, ProductImg productImg) throws Exception {
		Map<String, Object> imgMap = new HashMap<>();
		imgMap.put("productId", productId);
		imgMap.put("imgName", productImg.getSaveName());
		imgMap.put("sequence", productImg.getSequence());
		imgMap.put("type", productImg.getType());
		commonDAO.insertData("productManagement.insertProductImg", imgMap);
	}

	@Override
	public Product getProductById(Long productId) throws Exception {
		return commonDAO.selectOne("productManagement.getProductById", productId);
	}

	@Override
	public List<ProductImg> getProductImgList(Long productId) throws Exception {
		return commonDAO.selectList("productManagement.getProductImgList", productId);
	}

	@Override
	public void increaseImgSequences(Long productId, int sequence) throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("productId", productId);
		map.put("sequence", sequence);

		commonDAO.updateData("productManagement.increaseImgSequences", map);
	}

	@Override
	public List<ProductForList> getAllProducts() throws Exception {
		return commonDAO.selectList("productManagement.getAllProducts");
	}

	@Override
	public List<ProductForList> getProductsByKeyword(String keyword, String sort) throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("keyword", keyword);
		map.put("sort", sort);

		return commonDAO.selectList("productManagement.getProductsByKeyword", map);
	}

	@Override
	public List<ProductForList> searchProductBySellerId(Long sellerId, String keyword, String sort) throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("keyword", keyword);
		map.put("sort", sort);
		map.put("sellerId", sellerId);

		return commonDAO.selectList("productManagement.searchProductBySellerId", map);
	}

	@Override
	public List<Product> getProductsByCategory(Long categoryId) {
		return null;
	}


	@Override
	public void updateProduct(Product product) {

	}

	@Override
	public void deleteProduct(Long productId) {

	}

	@Override
	public void insertScrapProduct(Long memberId, Long productId) throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("memberId", memberId);
		map.put("productId", productId);
		commonDAO.insertData("productManagement.insertScrapProduct", map);
	}

	@Override
	public void deleteScrapProduct(Long memberId, Long productId) throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("memberId", memberId);
		map.put("productId", productId);
		commonDAO.deleteData("productManagement.deleteScrapProduct", map);
	}

	@Override
	public int isScrapProduct(Long memberId, Long productId) throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("memberId", memberId);
		map.put("productId", productId);
		return commonDAO.selectOne("productManagement.isScrapProduct", map);
	}

	@Override
	public int scrapCnt(Long productId) throws Exception {
		return commonDAO.selectOne("productManagement.scrapCnt", productId);
	}

	@Override
	public ProductMainOption getOptionsById(Long productId) {
		return null;
	}


	@Override
	public ProductMainOption getMainOptionByParentId(Long productId, Long parentOptionId) throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("productId", productId);
		map.put("parentOptionId", parentOptionId);
		return commonDAO.selectOne("productManagement.getMainOptionByParentId", map);
	}

	@Override
	public List<ProductSubOption> getSubOptionsByMainOptionId(Long mainOptionId) throws Exception {
		return commonDAO.selectList("productManagement.getSubOptionsByMainOptionId", mainOptionId);
	}

	@Override
	public List<ProductStock> getStockBySubOptionId(Long subOptionId) throws Exception {
		return commonDAO.selectList("productManagement.getStockBySubOptionId", subOptionId);
	}

	@Override
	public List<Product> findProductByCategory(Long categoryId) throws Exception {
		return null;
	}

	@Override
	public Long getMainOptionSeq() throws Exception {
		return commonDAO.selectOne("productManagement.getMainOptionSeq");
	}

	@Override
	public Long getProductSeq() throws Exception {
		return commonDAO.selectOne("productManagement.getProductSeq");
	}

	@Override
	public int getMainOptionCnt(Long productId) throws Exception {
		return commonDAO.selectOne("productManagement.getMainOptionCnt", productId);
	}

	@Override
	public List<OptionMap> getOptionMapByStockId(Long stockId) throws Exception {
		return commonDAO.selectList("productManagement.getOptionMapByStockId", stockId);
	}

	@Override
	public void insertMainOption(ProductMainOption productMainOption) throws Exception {
		commonDAO.insertData("productManagement.insertMainOption", productMainOption);
	}

	@Override
	public void insertSubOption(ProductSubOption productSubOption) throws Exception {
		commonDAO.insertData("productManagement.insertSubOption", productSubOption);
	}

	@Override
	public void insertStock(ProductStock productStock) throws Exception {
		commonDAO.insertData("productManagement.insertStock", productStock);
	}

	@Override
	public List<ProductStock> getStockListByProductId(Long productId) throws Exception {
		return commonDAO.selectList("productManagement.getStockListByProductId", productId);
	}

	@Override
	public ProductStock getStockByStockId(Long stockId) throws Exception {
		return commonDAO.selectOne("productManagement.getStockByStockId", stockId);
	}

	@Override
	public void updateStockQuantity(Long stockId, int quantity) throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("stockId", stockId);
		map.put("quantity", quantity);

		commonDAO.updateData("productManagement.updateStockQuantity", map);
	}

	@Override
	public int getQuantityByStockId(Long stockId) throws Exception {
		return commonDAO.selectOne("productManagement.getQuantityByStockId", stockId);
	}

	@Override
	public void deleteProductImg(Long productId, int type) throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("productId", productId);
		map.put("type", type);

		commonDAO.deleteData("productManagement.deleteProductImg", map);
	}
}

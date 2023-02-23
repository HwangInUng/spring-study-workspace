package com.edu.springshop.model.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.edu.springshop.domain.Pimg;
import com.edu.springshop.domain.Product;
import com.edu.springshop.exception.PimgException;
import com.edu.springshop.exception.ProductException;
import com.edu.springshop.exception.UploadException;
import com.edu.springshop.util.FileManager;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	@Qualifier("mybatisProductDAO")
	private ProductDAO productDAO;
	@Autowired
	@Qualifier("mybatisPimgDAO")
	private PimgDAO pimgDAO;
	@Autowired
	private FileManager fileManager;
	
	@Override
	public List selectAll() {
		return productDAO.selectAll();
	}

	@Override
	public Product select(int product_idx) {
		return productDAO.select(product_idx);
	}

	@Override
	public void regist(Product product, String savePath) throws ProductException, PimgException, UploadException{
		/* save() :
		 * -파일들을 지정된 절대경로에 저장
		 * -pimgList의 각 객체에 파일이름 저장
		 */
		fileManager.save(product, savePath);
		
		/* insert() :
		 * -객체를 등록하고 product_idx를 반환
		 */
		productDAO.insert(product);
		
		/* product에 저장된 객체 수만큼 반복문을 수행하여 저장 */
		List<Pimg> pimgList = product.getPimgList();
		for(Pimg pimg : pimgList) {
			pimg.setProduct(product);
			pimgDAO.insert(pimg);
		}
	}

	@Override
	public void update(Product product) {
		
	}

	@Override
	public void delete(int product_idx) {
		
	}

}

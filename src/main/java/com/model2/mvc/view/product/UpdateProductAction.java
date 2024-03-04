package com.model2.mvc.view.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.impl.ProductServiceimpl;
import com.model2.mvc.service.domain.Product;

public class UpdateProductAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String prodNo1 = request.getParameter("prodNo");
		System.out.println("UpdateProductAction ���� ");
		System.out.println("Request���� prodNo : "+prodNo1);
		
		
		Product product = new Product();
		product.setProdNo(Integer.parseInt(request.getParameter("prodNo")));
		product.setProdName(request.getParameter("prodName"));
		product.setProdDetail(request.getParameter("prodDetail"));
		product.setPrice(Integer.parseInt(request.getParameter("price")));
		product.setFileName(request.getParameter("fileName"));
		
		System.out.println("VO���� �Ϸ�");
		
		ProductService service = new ProductServiceimpl();
		service.updateProduct(product);

		System.out.println("����� VO�� : "+product);
		
		request.setAttribute("update", product);
		
		return "forward:/product/updateReadProduct.jsp";
	}


}

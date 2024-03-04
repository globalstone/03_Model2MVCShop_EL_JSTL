package com.model2.mvc.view.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.impl.ProductServiceimpl;
import com.model2.mvc.service.domain.Product;

public class UpdateProductViewAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("Action ����");
		
		String ProdNo = request.getParameter("prodNo");

		System.out.println("Request ���� �� : "+ProdNo);
		
		ProductService service = new ProductServiceimpl();
		Product vo = service.getProduct(Integer.parseInt(ProdNo));

		System.out.println("�޾ƿ� NO ��ȣ : "+vo.getProdNo());
		
		request.setAttribute("UpdateProdVO", vo);
		
		return "forward:/product/updateProduct.jsp";
	}


}

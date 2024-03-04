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
		
		System.out.println("Action 시작");
		
		String ProdNo = request.getParameter("prodNo");

		System.out.println("Request 받은 값 : "+ProdNo);
		
		ProductService service = new ProductServiceimpl();
		Product vo = service.getProduct(Integer.parseInt(ProdNo));

		System.out.println("받아온 NO 번호 : "+vo.getProdNo());
		
		request.setAttribute("UpdateProdVO", vo);
		
		return "forward:/product/updateProduct.jsp";
	}


}

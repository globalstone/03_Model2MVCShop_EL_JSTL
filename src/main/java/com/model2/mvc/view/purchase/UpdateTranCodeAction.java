package com.model2.mvc.view.purchase;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.purchase.PurchaseService;
import com.model2.mvc.service.purchase.impl.PurchaseServiceimpl;
import com.model2.mvc.service.domain.Purchase;

public class UpdateTranCodeAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("Action ����");
		
		Purchase vo = new Purchase();
		Product prod = new Product();
		String code = request.getParameter("tranCode");
		String no = request.getParameter("prodNo");
		
		
		prod.setProdNo(Integer.parseInt(no));
		vo.setPurchaseProd(prod);
		vo.setTranCode(code);
		
		System.out.println("VO set �Ϸ�");
		
		PurchaseService service = new PurchaseServiceimpl();
		service.updateTranCode(vo);
		
		System.out.println("Service �̵� �Ϸ�");
		
		String jsp = null;
		
		if( vo.getTranCode().equals("2")){
			
			System.out.println("TranCode 2 �Է�");
			jsp =  "forward:/listProduct.do?menu=manage";
		}else if( vo.getTranCode().equals("3")) {
			
			jsp =  "forward:/listProduct.do?menu=search";
		}
		
		return jsp;
	}


}

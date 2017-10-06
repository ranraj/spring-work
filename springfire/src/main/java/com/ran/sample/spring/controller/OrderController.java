package com.ran.sample.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ran.sample.spring.model.SaleOrder;
import com.ran.sample.spring.service.OrderService;

@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listPage(Model model) {
		model.addAttribute("order", new SaleOrder());
		model.addAttribute("orders", orderService.getAllOrders());
		return "orders";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveEmployee(@ModelAttribute("employee") SaleOrder order,
			final RedirectAttributes redirectAttributes) {

		if (orderService.createOrder(order) != null) {
			redirectAttributes.addFlashAttribute("saveOrder", "success");
		} else {
			redirectAttributes.addFlashAttribute("saveOrder", "failed");
		}

		return "redirect:/order/";
	}

	@RequestMapping(value = "/{operation}/{orderId}", method = RequestMethod.GET)
	public String editRemoveEmployee(@PathVariable("operation") String operation, @PathVariable("orderId") Long orderId,
			final RedirectAttributes redirectAttributes, Model model) {
		if (operation.equals("delete")) {
			if (orderService.deleteOrder(orderId)) {
				redirectAttributes.addFlashAttribute("deletion", "success");
			} else {
				redirectAttributes.addFlashAttribute("deletion", "unsuccess");
			}
		} else if (operation.equals("edit")) {
			SaleOrder editOrder = orderService.getOrder(orderId);
			if (editOrder != null) {
				model.addAttribute("editOrder", editOrder);
				return "editPage";
			} else {
				redirectAttributes.addFlashAttribute("status", "notfound");
			}
		}
		return "redirect:/order/";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateOrder(@ModelAttribute("editOrder") SaleOrder order,
			final RedirectAttributes redirectAttributes) {
		if (orderService.updateOrder(order) != null) {
			redirectAttributes.addFlashAttribute("edit", "success");
		} else {
			redirectAttributes.addFlashAttribute("edit", "unsuccess");
		}
		// return "redirect:/savepage";
		return "redirect:/order/";
	}
}
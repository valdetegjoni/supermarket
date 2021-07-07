package com.supermarket.mapstruct.mapper;

import com.supermarket.entity.Cashier;
import com.supermarket.entity.Customer;
import com.supermarket.entity.InvoiceReceipt;
import com.supermarket.entity.OrderProduct;
import com.supermarket.entity.Product;
import com.supermarket.entity.VerifyOrder;
import com.supermarket.mapstruct.DTO.CashierDTO;
import com.supermarket.mapstruct.DTO.CustomerDTO;
import com.supermarket.mapstruct.DTO.InvoiceReceiptDTO;
import com.supermarket.mapstruct.DTO.OrderProductDTO;
import com.supermarket.mapstruct.DTO.ProductDTO;
import com.supermarket.mapstruct.DTO.VerifyOrderDTO;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Generated;

import org.springframework.stereotype.Component;

@Generated(value = "org.mapstruct.ap.MappingProcessor", date = "2021-07-07T09:50:46+0200", comments = "version: 1.3.1.Final, compiler: javac, environment: Java 15.0.1 (Oracle Corporation)")
@Component
public class InvoiceReceiptEntityDTOMapperImpl implements InvoiceReceiptEntityDTOMapper {

	@Override
	public InvoiceReceiptDTO invoiceReceiptTODTO(InvoiceReceipt invoiceReceipt) {
		if (invoiceReceipt == null) {
			return null;
		}

		InvoiceReceiptDTO invoiceReceiptDTO = new InvoiceReceiptDTO();

		invoiceReceiptDTO.setId(invoiceReceipt.getId());
		invoiceReceiptDTO.setCashier(cashierToCashierDTO(invoiceReceipt.getCashier()));
		invoiceReceiptDTO.setCustomer(customerToCustomerDTO(invoiceReceipt.getCustomer()));
		invoiceReceiptDTO.setTotalAmount(invoiceReceipt.getTotalAmount());
		invoiceReceiptDTO.setDate(invoiceReceipt.getDate());
		invoiceReceiptDTO.setPrice(invoiceReceipt.getPrice());

		return invoiceReceiptDTO;
	}

	@Override
	public InvoiceReceipt invoiceReceiptDTOToEntity(InvoiceReceiptDTO invoiceReceiptDTO) {
		if (invoiceReceiptDTO == null) {
			return null;
		}

		InvoiceReceipt invoiceReceipt = new InvoiceReceipt();

		invoiceReceipt.setId(invoiceReceiptDTO.getId());
		invoiceReceipt.setCashier(cashierDTOToCashier(invoiceReceiptDTO.getCashier()));
		invoiceReceipt.setCustomer(customerDTOToCustomer(invoiceReceiptDTO.getCustomer()));
		invoiceReceipt.setTotalAmount(invoiceReceiptDTO.getTotalAmount());
		invoiceReceipt.setDate(invoiceReceiptDTO.getDate());
		invoiceReceipt.setPrice(invoiceReceiptDTO.getPrice());

		return invoiceReceipt;
	}

	protected Set<InvoiceReceiptDTO> invoiceReceiptSetToInvoiceReceiptDTOSet(Set<InvoiceReceipt> set) {
		if (set == null) {
			return null;
		}

		Set<InvoiceReceiptDTO> set1 = new HashSet<InvoiceReceiptDTO>(Math.max((int) (set.size() / .75f) + 1, 16));
		for (InvoiceReceipt invoiceReceipt : set) {
			set1.add(invoiceReceiptTODTO(invoiceReceipt));
		}

		return set1;
	}

	protected CashierDTO cashierToCashierDTO(Cashier cashier) {
		if (cashier == null) {
			return null;
		}

		CashierDTO cashierDTO = new CashierDTO();

		cashierDTO.setId(cashier.getId());
		cashierDTO.setFirstName(cashier.getFirstName());
		cashierDTO.setLastName(cashier.getLastName());
		cashierDTO.setBirthdate(cashier.getBirthdate());
		cashierDTO.setAddress(cashier.getAddress());
		cashierDTO.setTelephone(cashier.getTelephone());
		cashierDTO.setEmail(cashier.getEmail());
		if (cashierDTO.getInvoiceReceipts() != null) {
			Set<InvoiceReceiptDTO> set = invoiceReceiptSetToInvoiceReceiptDTOSet(cashier.getInvoiceReceipts());
			if (set != null) {
				cashierDTO.getInvoiceReceipts().addAll(set);
			}
		}

		return cashierDTO;
	}

	protected Set<OrderProductDTO> orderProductSetToOrderProductDTOSet(Set<OrderProduct> set) {
		if (set == null) {
			return null;
		}

		Set<OrderProductDTO> set1 = new HashSet<OrderProductDTO>(Math.max((int) (set.size() / .75f) + 1, 16));
		for (OrderProduct orderProduct : set) {
			set1.add(orderProductToOrderProductDTO(orderProduct));
		}

		return set1;
	}

	protected ProductDTO productToProductDTO(Product product) {
		if (product == null) {
			return null;
		}

		ProductDTO productDTO = new ProductDTO();

		productDTO.setId(product.getId());
		productDTO.setProductName(product.getProductName());
		productDTO.setProductDescription(product.getProductDescription());
		productDTO.setProductPrice(product.getProductPrice());
		productDTO.setProductQuantity(product.getProductQuantity());
		productDTO.setProductIn(product.getProductIn());
		productDTO.setProductOut(product.getProductOut());
		productDTO.setCategory(product.getCategory());
		productDTO.setOrderProducts(orderProductSetToOrderProductDTOSet(product.getOrderProducts()));

		return productDTO;
	}

	protected OrderProductDTO orderProductToOrderProductDTO(OrderProduct orderProduct) {
		if (orderProduct == null) {
			return null;
		}

		OrderProductDTO orderProductDTO = new OrderProductDTO();

		orderProductDTO.setId(orderProduct.getId());
		orderProductDTO.setCustomer(customerToCustomerDTO(orderProduct.getCustomer()));
		orderProductDTO.setProduct(productToProductDTO(orderProduct.getProduct()));
		orderProductDTO.setDate(orderProduct.getDate());
		orderProductDTO.setDetails(orderProduct.getDetails());
		orderProductDTO.setQuantity(orderProduct.getQuantity());

		return orderProductDTO;
	}

	protected VerifyOrderDTO verifyOrderToVerifyOrderDTO(VerifyOrder verifyOrder) {
		if (verifyOrder == null) {
			return null;
		}

		VerifyOrderDTO verifyOrderDTO = new VerifyOrderDTO();

		verifyOrderDTO.setId(verifyOrder.getId());
		verifyOrderDTO.setOrderProduct(orderProductToOrderProductDTO(verifyOrder.getOrderProduct()));

		return verifyOrderDTO;
	}

	protected Set<VerifyOrderDTO> verifyOrderSetToVerifyOrderDTOSet(Set<VerifyOrder> set) {
		if (set == null) {
			return null;
		}

		Set<VerifyOrderDTO> set1 = new HashSet<VerifyOrderDTO>(Math.max((int) (set.size() / .75f) + 1, 16));
		for (VerifyOrder verifyOrder : set) {
			set1.add(verifyOrderToVerifyOrderDTO(verifyOrder));
		}

		return set1;
	}

	protected Set<CashierDTO> cashierSetToCashierDTOSet(Set<Cashier> set) {
		if (set == null) {
			return null;
		}

		Set<CashierDTO> set1 = new HashSet<CashierDTO>(Math.max((int) (set.size() / .75f) + 1, 16));
		for (Cashier cashier : set) {
			set1.add(cashierToCashierDTO(cashier));
		}

		return set1;
	}

	protected CustomerDTO customerToCustomerDTO(Customer customer) {
		if (customer == null) {
			return null;
		}

		CustomerDTO customerDTO = new CustomerDTO();

		customerDTO.setId(customer.getId());
		customerDTO.setFirstName(customer.getFirstName());
		customerDTO.setLastName(customer.getLastName());
		customerDTO.setAddress(customer.getAddress());
		customerDTO.setTelephone(customer.getTelephone());
		customerDTO.setEmail(customer.getEmail());
		customerDTO.setOrderProducts(orderProductSetToOrderProductDTOSet(customer.getOrderProducts()));
		customerDTO.setVerifyOrders(verifyOrderSetToVerifyOrderDTOSet(customer.getVerifyOrders()));
		customerDTO.setCashiers(cashierSetToCashierDTOSet(customer.getCashiers()));
		// customerDTO.setInvoiceReceipts( invoiceReceiptSetToInvoiceReceiptDTOSet(
		// customer.getInvoiceReceipts() ) );

		return customerDTO;
	}

	protected Set<InvoiceReceipt> invoiceReceiptDTOSetToInvoiceReceiptSet(Set<InvoiceReceiptDTO> set) {
		if (set == null) {
			return null;
		}

		Set<InvoiceReceipt> set1 = new HashSet<InvoiceReceipt>(Math.max((int) (set.size() / .75f) + 1, 16));
		for (InvoiceReceiptDTO invoiceReceiptDTO : set) {
			set1.add(invoiceReceiptDTOToEntity(invoiceReceiptDTO));
		}

		return set1;
	}

	protected Cashier cashierDTOToCashier(CashierDTO cashierDTO) {
		if (cashierDTO == null) {
			return null;
		}

		Cashier cashier = new Cashier();

		cashier.setId(cashierDTO.getId());
		cashier.setFirstName(cashierDTO.getFirstName());
		cashier.setLastName(cashierDTO.getLastName());
		cashier.setBirthdate(cashierDTO.getBirthdate());
		cashier.setAddress(cashierDTO.getAddress());
		cashier.setTelephone(cashierDTO.getTelephone());
		cashier.setEmail(cashierDTO.getEmail());
		cashier.setInvoiceReceipts(invoiceReceiptDTOSetToInvoiceReceiptSet(cashierDTO.getInvoiceReceipts()));

		return cashier;
	}

	protected Set<OrderProduct> orderProductDTOSetToOrderProductSet(Set<OrderProductDTO> set) {
		if (set == null) {
			return null;
		}

		Set<OrderProduct> set1 = new HashSet<OrderProduct>(Math.max((int) (set.size() / .75f) + 1, 16));
		for (OrderProductDTO orderProductDTO : set) {
			set1.add(orderProductDTOToOrderProduct(orderProductDTO));
		}

		return set1;
	}

	protected Product productDTOToProduct(ProductDTO productDTO) {
		if (productDTO == null) {
			return null;
		}

		Product product = new Product();

		product.setOrderProducts(orderProductDTOSetToOrderProductSet(productDTO.getOrderProducts()));
		product.setId(productDTO.getId());
		product.setProductName(productDTO.getProductName());
		product.setProductDescription(productDTO.getProductDescription());
		product.setProductPrice(productDTO.getProductPrice());
		product.setProductQuantity(productDTO.getProductQuantity());
		product.setProductIn(productDTO.getProductIn());
		product.setProductOut(productDTO.getProductOut());
		product.setCategory(productDTO.getCategory());

		return product;
	}

	protected OrderProduct orderProductDTOToOrderProduct(OrderProductDTO orderProductDTO) {
		if (orderProductDTO == null) {
			return null;
		}

		OrderProduct orderProduct = new OrderProduct();

		orderProduct.setId(orderProductDTO.getId());
		orderProduct.setCustomer(customerDTOToCustomer(orderProductDTO.getCustomer()));
		orderProduct.setProduct(productDTOToProduct(orderProductDTO.getProduct()));
		orderProduct.setDate(orderProductDTO.getDate());
		orderProduct.setDetails(orderProductDTO.getDetails());
		orderProduct.setQuantity(orderProductDTO.getQuantity());

		return orderProduct;
	}

	protected VerifyOrder verifyOrderDTOToVerifyOrder(VerifyOrderDTO verifyOrderDTO) {
		if (verifyOrderDTO == null) {
			return null;
		}

		VerifyOrder verifyOrder = new VerifyOrder();

		verifyOrder.setId(verifyOrderDTO.getId());
		verifyOrder.setOrderProduct(orderProductDTOToOrderProduct(verifyOrderDTO.getOrderProduct()));

		return verifyOrder;
	}

	protected Set<VerifyOrder> verifyOrderDTOSetToVerifyOrderSet(Set<VerifyOrderDTO> set) {
		if (set == null) {
			return null;
		}

		Set<VerifyOrder> set1 = new HashSet<VerifyOrder>(Math.max((int) (set.size() / .75f) + 1, 16));
		for (VerifyOrderDTO verifyOrderDTO : set) {
			set1.add(verifyOrderDTOToVerifyOrder(verifyOrderDTO));
		}

		return set1;
	}

	protected Set<Cashier> cashierDTOSetToCashierSet(Set<CashierDTO> set) {
		if (set == null) {
			return null;
		}

		Set<Cashier> set1 = new HashSet<Cashier>(Math.max((int) (set.size() / .75f) + 1, 16));
		for (CashierDTO cashierDTO : set) {
			set1.add(cashierDTOToCashier(cashierDTO));
		}

		return set1;
	}

	protected Customer customerDTOToCustomer(CustomerDTO customerDTO) {
		if (customerDTO == null) {
			return null;
		}

		Customer customer = new Customer();

		customer.setId(customerDTO.getId());
		customer.setFirstName(customerDTO.getFirstName());
		customer.setLastName(customerDTO.getLastName());
		customer.setAddress(customerDTO.getAddress());
		customer.setTelephone(customerDTO.getTelephone());
		customer.setEmail(customerDTO.getEmail());
		customer.setVerifyOrders(verifyOrderDTOSetToVerifyOrderSet(customerDTO.getVerifyOrders()));
		customer.setCashiers(cashierDTOSetToCashierSet(customerDTO.getCashiers()));
		customer.setInvoiceReceipts(invoiceReceiptDTOSetToInvoiceReceiptSet(customerDTO.getInvoiceReceipts()));
		customer.setOrderProducts(orderProductDTOSetToOrderProductSet(customerDTO.getOrderProducts()));

		return customer;
	}
}

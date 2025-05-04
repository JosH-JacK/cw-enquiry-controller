package com.conway.reference.cw_enquiry_controller.dao;

import com.conway.reference.cw_enquiry_controller.dto.CustomerEnquiryRequestDto;
import com.conway.reference.cw_enquiry_controller.dto.AllCustomerEnquiryResponseDto;
import com.conway.reference.cw_enquiry_controller.model.Product;

import java.util.List;

public interface CustomerEnquiryDao {

    public Long addCustomerEnquiry(CustomerEnquiryRequestDto customerEnquiryRequestDto);

    public void addEnquiredProducts(Long enquiryId, List<Long> productIds);

    public Long getProductId(Product product);

    public List<AllCustomerEnquiryResponseDto> getAllCustomerEnquiryDetails();
}

package com.conway.reference.cw_enquiry_controller.service;

import com.conway.reference.cw_enquiry_controller.dto.AllCustomerEnquiryResponseDto;
import com.conway.reference.cw_enquiry_controller.dto.CustomerEnquiryRequestDto;

import java.util.List;

public interface CustomerEnquiryService {

    public String addNewCustomerEnquiry(CustomerEnquiryRequestDto customerEnquiryRequestDto);

    public List<AllCustomerEnquiryResponseDto> getAllEnquiries();

}

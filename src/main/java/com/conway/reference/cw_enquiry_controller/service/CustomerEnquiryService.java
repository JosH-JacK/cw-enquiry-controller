package com.conway.reference.cw_enquiry_controller.service;

import com.conway.reference.cw_enquiry_controller.dto.AllCustomerEnquiryResponseDto;
import com.conway.reference.cw_enquiry_controller.dto.CustomerEnquiryRequestDto;
import com.conway.reference.cw_enquiry_controller.dto.SearchByCustomerNameRequestDto;
import com.conway.reference.cw_enquiry_controller.dto.SearchByDateRequestDto;

import java.util.List;

public interface CustomerEnquiryService {

    public String addNewCustomerEnquiry(CustomerEnquiryRequestDto customerEnquiryRequestDto);

    public List<AllCustomerEnquiryResponseDto> getAllEnquiries();

    public List<AllCustomerEnquiryResponseDto> getEnquiryByCustomerName(SearchByCustomerNameRequestDto customerName);

    public List<AllCustomerEnquiryResponseDto> getEnquiryByDateRange(SearchByDateRequestDto dateRange);

}

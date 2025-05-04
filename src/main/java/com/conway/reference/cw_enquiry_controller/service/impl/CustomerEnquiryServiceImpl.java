package com.conway.reference.cw_enquiry_controller.service.impl;

import com.conway.reference.cw_enquiry_controller.dao.CustomerEnquiryDao;
import com.conway.reference.cw_enquiry_controller.dto.AllCustomerEnquiryResponseDto;
import com.conway.reference.cw_enquiry_controller.dto.CustomerEnquiryRequestDto;
import com.conway.reference.cw_enquiry_controller.dto.SearchByCustomerNameRequestDto;
import com.conway.reference.cw_enquiry_controller.dto.SearchByDateRequestDto;
import com.conway.reference.cw_enquiry_controller.model.Product;
import com.conway.reference.cw_enquiry_controller.service.CustomerEnquiryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerEnquiryServiceImpl implements CustomerEnquiryService {

    private final CustomerEnquiryDao customerEnquiryDao;

    @Override
    public String addNewCustomerEnquiry(CustomerEnquiryRequestDto customerEnquiryRequestDto) {
        try {
            Long enquiryId = customerEnquiryDao.addCustomerEnquiry(customerEnquiryRequestDto);
            List<Long> productIds = new ArrayList<>();
            for (Product product : customerEnquiryRequestDto.getProduct()) {
                Long productId = customerEnquiryDao.getProductId(product);
                productIds.add(productId);
            }
            customerEnquiryDao.addEnquiredProducts(enquiryId, productIds);
            return String.format("Added new Enquiry with Enquiry ID : %d", enquiryId) ;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Exception while adding new enquiry",e);
        }
    }

    @Override
    public List<AllCustomerEnquiryResponseDto> getAllEnquiries() {
        return customerEnquiryDao.getAllCustomerEnquiryDetails();
    }

    @Override
    public List<AllCustomerEnquiryResponseDto> getEnquiryByCustomerName(SearchByCustomerNameRequestDto customerName) {
        return customerEnquiryDao.searchByCustomerName(customerName);
    }

    @Override
    public List<AllCustomerEnquiryResponseDto> getEnquiryByDateRange(SearchByDateRequestDto dateRange) {
        return customerEnquiryDao.searchByDate(dateRange);
    }
}

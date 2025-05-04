package com.conway.reference.cw_enquiry_controller.dao.impl;

import com.conway.reference.cw_enquiry_controller.constant.SqlQueries;
import com.conway.reference.cw_enquiry_controller.dao.CustomerEnquiryDao;
import com.conway.reference.cw_enquiry_controller.dto.AllCustomerEnquiryResponseDto;
import com.conway.reference.cw_enquiry_controller.dto.CustomerEnquiryRequestDto;
import com.conway.reference.cw_enquiry_controller.dto.SearchByCustomerNameRequestDto;
import com.conway.reference.cw_enquiry_controller.model.Product;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class CustomerEnquiryDaoImpl implements CustomerEnquiryDao {

    private final EntityManager entityManager;

    @Override
    @Transactional
    public Long addCustomerEnquiry(CustomerEnquiryRequestDto customerEnquiryRequestDto) {
        BigDecimal nextVal = (BigDecimal) entityManager
                .createNativeQuery(SqlQueries.FETCH_ENQUIRY_ID_QUERY)
                .getSingleResult();
        Long enquiryId = nextVal.longValue();
        entityManager.createNativeQuery(SqlQueries.CUSTOMER_ENQUIRY_INSERT_QUERY)
                .setParameter("enquiryId", enquiryId)
                .setParameter("referenceType", customerEnquiryRequestDto.getReferenceType())
                .setParameter("customerName", customerEnquiryRequestDto.getCustomerName())
                .setParameter("customerAddress", customerEnquiryRequestDto.getCustomerAddress())
                .setParameter("contactPersonName", customerEnquiryRequestDto.getContactPersonName())
                .setParameter("contactNumber", customerEnquiryRequestDto.getContactNumber())
                .setParameter("emailId", customerEnquiryRequestDto.getEmailId())
                .setParameter("gstNumber", customerEnquiryRequestDto.getGstNumber())
                .setParameter("remarks", customerEnquiryRequestDto.getRemarks())
                .setParameter("quotationGiven", customerEnquiryRequestDto.isQuotationGiven() ? "Y" : "N")
                .setParameter("followUpRequired", customerEnquiryRequestDto.isFollowUpRequired() ? "Y" : "N")
                .executeUpdate();
        return enquiryId;
    }

    @Override
    @Transactional
    public void addEnquiredProducts(Long enquiryId, List<Long> productIds) {
        for (Long productId : productIds) {
            entityManager.createNativeQuery(SqlQueries.ENQUIRY_PRODUCTS_INSERT_QUERY)
                    .setParameter("enquiryId", enquiryId)
                    .setParameter("productId", productId)
                    .executeUpdate();
        }
    }

    @Override
    public Long getProductId(Product product) {
        BigDecimal productId = (BigDecimal) entityManager.createNativeQuery(SqlQueries.FETCH_PRODUCT_ID_QUERY)
                .setParameter("modelV", product.getModel())
                .setParameter("optionV", product.getOption())
                .setParameter("typeV", product.getType())
                .getSingleResult();
        return productId.longValue();
    }

    @Override
    @Transactional
    public List<AllCustomerEnquiryResponseDto> getAllCustomerEnquiryDetails() {
        List<AllCustomerEnquiryResponseDto> result = entityManager
                .createNativeQuery(SqlQueries.FETCH_ALL_CUSTOMER_ENQUIRY_QUERY, "CustomerEnquiryResultSetMapping")
                .getResultList();
        return result;
    }

    @Override
    public List<AllCustomerEnquiryResponseDto> searchByCustomerName(SearchByCustomerNameRequestDto customerName) {
        List<AllCustomerEnquiryResponseDto> result = entityManager
                .createNativeQuery(SqlQueries.FETCH_ENQUIRY_BY_CUSTOMER_NAME, "CustomerEnquiryResultSetMapping").setParameter("customerName", "%" + customerName.getCustomerName() + "%")
                .getResultList();
        return result;
    }
}

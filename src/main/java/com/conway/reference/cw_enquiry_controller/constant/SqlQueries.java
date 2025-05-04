package com.conway.reference.cw_enquiry_controller.constant;

public class SqlQueries {
    public static final String CUSTOMER_ENQUIRY_INSERT_QUERY = """
        INSERT INTO CUSTOMER_ENQUIRY (
                ENQUIRY_ID,
                REFERENCE_TYPE, CUSTOMER_NAME, CUSTOMER_ADDRESS,
                CONTACT_PERSON_NAME, CONTACT_NUMBER, EMAIL_ID,
                GST_NUMBER, REMARKS, QUOTATION_GIVEN, FOLLOW_UP_REQUIRED
            ) VALUES (:enquiryId, :referenceType, :customerName, :customerAddress,
            :contactPersonName, :contactNumber, :emailId, :gstNumber, :remarks,
            :quotationGiven, :followUpRequired)
    """;
    public static final String FETCH_ENQUIRY_ID_QUERY = """
        SELECT CUSTOMER_ENQUIRY_SEQ.NEXTVAL FROM dual
    """;

    public static final String ENQUIRY_PRODUCTS_INSERT_QUERY = """
        INSERT INTO ENQUIRY_PRODUCTS (ENQUIRY_ID, PRODUCT_ID)
                                VALUES (:enquiryId, :productId)
    """;

    public static final String FETCH_PRODUCT_ID_QUERY = """
        SELECT PRODUCT_ID
        FROM MAS_PRODUCT
        WHERE MODEL = :modelV
        AND OPTION_CODE = :optionV
        AND TYPE = :typeV
    """;

    public static final String FETCH_ALL_CUSTOMER_ENQUIRY_QUERY = """
        SELECT\s
            CE.ENQUIRY_ID,
            CE.REFERENCE_TYPE,
            CE.CUSTOMER_NAME,
            CE.CUSTOMER_ADDRESS,
            CE.CONTACT_PERSON_NAME,
            CE.CONTACT_NUMBER,
            CE.EMAIL_ID,
            MP.MODEL,
            MP.OPTION_CODE,
            MP.TYPE,
            CE.GST_NUMBER,
            CE.REMARKS,
            CE.QUOTATION_GIVEN,
            CE.FOLLOW_UP_REQUIRED,
            EP.CREATED_DATE AS ENQUIRED_ON
        FROM
            CUSTOMER_ENQUIRY CE
        JOIN ENQUIRY_PRODUCTS EP ON EP.ENQUIRY_ID = CE.ENQUIRY_ID
        LEFT JOIN MAS_PRODUCT MP ON MP.PRODUCT_ID = EP.PRODUCT_ID
        ORDER BY ENQUIRED_ON DESC
    """;

    public static final String FETCH_ENQUIRY_BY_CUSTOMER_NAME = """
        SELECT
                    CE.ENQUIRY_ID,
                    CE.REFERENCE_TYPE,
                    CE.CUSTOMER_NAME,
                    CE.CUSTOMER_ADDRESS,
                    CE.CONTACT_PERSON_NAME,
                    CE.CONTACT_NUMBER,
                    CE.EMAIL_ID,
                    MP.MODEL,
                    MP.OPTION_CODE,
                    MP.TYPE,
                    CE.GST_NUMBER,
                    CE.REMARKS,
                    CE.QUOTATION_GIVEN,
                    CE.FOLLOW_UP_REQUIRED,
                    EP.CREATED_DATE AS ENQUIRED_ON
                FROM
                    CUSTOMER_ENQUIRY CE
                JOIN ENQUIRY_PRODUCTS EP ON EP.ENQUIRY_ID = CE.ENQUIRY_ID
                LEFT JOIN MAS_PRODUCT MP ON MP.PRODUCT_ID = EP.PRODUCT_ID
                WHERE
                    CUSTOMER_NAME LIKE :customerName
                ORDER BY ENQUIRED_ON DESC
    """;

    public static final String FETCH_ENQUIRY_BETWEEN_DATE_RANGE = """
        SELECT
            CE.ENQUIRY_ID,
            CE.REFERENCE_TYPE,
            CE.CUSTOMER_NAME,
            CE.CUSTOMER_ADDRESS,
            CE.CONTACT_PERSON_NAME,
            CE.CONTACT_NUMBER,
            CE.EMAIL_ID,
            MP.MODEL,
            MP.OPTION_CODE,
            MP.TYPE,
            CE.GST_NUMBER,
            CE.REMARKS,
            CE.QUOTATION_GIVEN,
            CE.FOLLOW_UP_REQUIRED,
            EP.CREATED_DATE AS ENQUIRED_ON
        FROM
            CUSTOMER_ENQUIRY CE
        JOIN ENQUIRY_PRODUCTS EP ON EP.ENQUIRY_ID = CE.ENQUIRY_ID
        LEFT JOIN MAS_PRODUCT MP ON MP.PRODUCT_ID = EP.PRODUCT_ID
        WHERE
            TRUNC(EP.CREATED_DATE) BETWEEN :fromDate AND :toDate
        ORDER BY ENQUIRED_ON ASC
    """;
}

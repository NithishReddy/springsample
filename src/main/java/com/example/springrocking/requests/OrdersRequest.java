package com.example.springrocking.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrdersRequest {
    //(request_id,user_id,ff_order_id,coupon_code,email_encrypted,mobile_encrypted,pg_amount,pg_url,fulfillment_service_id,external_user_id,user_email_encrypted) values('request_id', 123, 1, "ABC", "EMAIL", "MOBILE", 1, "abc.com",9,"1223","USER EMAIL")

    @JsonProperty("id")
    private int id;

    @JsonProperty("requestId")
    private String requestId;

    @JsonProperty("userId")
    private int userId;

    @JsonProperty("ffOrderId")
    private int ffOrderId;

    @JsonProperty("couponCode")
    private String couponCode;

    @JsonProperty("emailEncrypted")
    private String emailEncrypted;

    @JsonProperty("mobileEncrypted")
    private String mobileEncrypted;

    @JsonProperty("pgAmount")
    private Double pgAmount;

    @JsonProperty("pgUrl")
    private String pgUrl;

    @JsonProperty("fulfillmentServiceId")
    private int fulfillmentServiceId;

    @JsonProperty("externalUserId")
    private String externalUserId;


    @JsonProperty("userEmailEncrypted")
    private String userEmailEncrypted;



    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getFfOrderId() {
        return this.ffOrderId;
    }

    public void setFfOrderId(int ffOrderId) {
        this.ffOrderId = ffOrderId;
    }

    public String getCouponCode() {
        return this.couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    public String getEmailEncrypted() {
        return this.emailEncrypted;
    }

    public void setEmailEncrypted(String emailEncrypted) {
        this.emailEncrypted = emailEncrypted;
    }

    public String getMobileEncrypted() {
        return this.mobileEncrypted;
    }

    public void setMobileEncrypted(String mobileEncrypted) {
        this.mobileEncrypted = mobileEncrypted;
    }

    public Double getPgAmount() {
        return this.pgAmount;
    }

    public void setPgAmount(Double pgAmount) {
        this.pgAmount = pgAmount;
    }

    public String getPgUrl() {
        return this.pgUrl;
    }

    public void setPgUrl(String pgUrl) {
        this.pgUrl = pgUrl;
    }

    public int getFulfillmentServiceId() {
        return this.fulfillmentServiceId;
    }

    public void setFulfillmentServiceId(int fulfillmentServiceId) {
        this.fulfillmentServiceId = fulfillmentServiceId;
    }

    public String getExternalUserId() {
        return this.externalUserId;
    }

    public void setExternalUserId(String externalUserId) {
        this.externalUserId = externalUserId;
    }

    public String getUserEmailEncrypted() {
        return this.userEmailEncrypted;
    }

    public void setUserEmailEncrypted(String userEmailEncrypted) {
        this.userEmailEncrypted = userEmailEncrypted;
    }

   

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", requestId='" + getRequestId() + "'" +
            ", userId='" + getUserId() + "'" +
            ", ffOrderId='" + getFfOrderId() + "'" +
            ", couponCode='" + getCouponCode() + "'" +
            ", emailEncrypted='" + getEmailEncrypted() + "'" +
            ", mobileEncrypted='" + getMobileEncrypted() + "'" +
            ", pgAmount='" + getPgAmount() + "'" +
            ", pgUrl='" + getPgUrl() + "'" +
            ", fulfillmentServiceId='" + getFulfillmentServiceId() + "'" +
            ", externalUserId='" + getExternalUserId() + "'" +
            ", userEmailEncrypted='" + getUserEmailEncrypted() + "'" +
            "}";
    }
    


}


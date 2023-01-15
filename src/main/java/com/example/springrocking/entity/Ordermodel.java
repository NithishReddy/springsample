package com.example.springrocking.entity;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

import jakarta.persistence.*;


@Entity
@Table(name="orders")
public class Ordermodel {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id", unique = true)
    private int id;

    @Column(name="request_id", nullable = false, length = 255)
    private String requestId;

    @Column(name="user_id", nullable = false)
    private int userId;

    @Column(name="ff_order_id", nullable = true)
    private int ffOrderId;
    
    @Column(name="coupon_code", length = 255, nullable = true)
    private String couponCode;

    @Column(name="email_encrypted", length = 255)
    private String emailEncrypted;

    @Column(name="mobile_encrypted", length = 255)
    private String mobileEncrypted;

    @Column(name="pg_amount")
    private Double pgAmount;

    @Column(name="pg_url")
    private String pgUrl;

    @Column(name="fulfillment_service_id")
    private int fulfillmentServiceId;

    @Column(name="external_user_id")
    private String externalUserId;

    @Column(name="user_email_encrypted")
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
package com.talde1.commerceapp.model;

import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.time.LocalDateTime;

@Entity(tableName = "bill", indices = @Index(value = {"id"}, unique = true))
public class Bill {

    @PrimaryKey(autoGenerate = false)
    int id;
    int partnerId;
    String billId;
    String invoiceStatus;
    double amountUnpaid;
    String deliveryStatus;
    LocalDateTime dateOrder;
    double amountUntaxed;
    Double amountTax;
    String productName;
    double qtyInvoiced;

    public Bill(int id, int partnerId, String billId, String invoiceStatus, double amountUnpaid, String deliveryStatus, LocalDateTime dateOrder,
                double amountUntaxed, Double amountTax, String productName, double qtyInvoiced) {
        this.id = id;
        this.partnerId = partnerId;
        this.billId = billId;
        this.invoiceStatus = invoiceStatus;
        this.amountUnpaid = amountUnpaid;
        this.deliveryStatus = deliveryStatus;
        this.dateOrder = dateOrder;
        this.amountUntaxed = amountUntaxed;
        this.amountTax = amountTax;
        this.productName = productName;
        this.qtyInvoiced = qtyInvoiced;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public String getInvoiceStatus() {
        return invoiceStatus;
    }

    public void setInvoiceStatus(String invoiceStatus) {
        this.invoiceStatus = invoiceStatus;
    }

    public double getAmountUnpaid() {
        return amountUnpaid;
    }

    public int getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(int partnerId) {
        this.partnerId = partnerId;
    }

    public void setAmountUnpaid(double amountUnpaid) {
        this.amountUnpaid = amountUnpaid;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public LocalDateTime getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(LocalDateTime dateOrder) {
        this.dateOrder = dateOrder;
    }

    public double getAmountUntaxed() {
        return amountUntaxed;
    }

    public void setAmountUntaxed(double amountUntaxed) {
        this.amountUntaxed = amountUntaxed;
    }

    public Double getAmountTax() {
        return amountTax;
    }

    public void setAmountTax(Double amountTax) {
        this.amountTax = amountTax;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getQtyInvoiced() {
        return qtyInvoiced;
    }

    public void setQtyInvoiced(double qtyInvoiced) {
        this.qtyInvoiced = qtyInvoiced;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "billId='" + billId + '\'' +
                ", invoiceStatus='" + invoiceStatus + '\'' +
                ", amountUnpaid=" + amountUnpaid +
                ", deliveryStatus='" + deliveryStatus + '\'' +
                ", dateOrder=" + dateOrder +
                ", amountUntaxed=" + amountUntaxed +
                ", amountTax=" + amountTax +
                ", productName='" + productName + '\'' +
                ", qtyInvoiced=" + qtyInvoiced +
                '}';
    }
}

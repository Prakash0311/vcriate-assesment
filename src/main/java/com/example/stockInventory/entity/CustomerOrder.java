package com.example.stockInventory.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "customer_order")
public class CustomerOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long customerId;
    private LocalDateTime orderDate;
    private String status;

    // Default constructor
    public CustomerOrder() {
    }

    // Parameterized constructor
    public CustomerOrder(Long customerId, LocalDateTime orderDate, String status) {
        this.customerId = customerId;
        this.orderDate = orderDate;
        this.status = status;
    }

    // Getter and setter methods
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "CustomerOrder{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", orderDate=" + orderDate +
                ", status='" + status + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        CustomerOrder that = (CustomerOrder) o;

        if (!id.equals(that.id))
            return false;
        if (!customerId.equals(that.customerId))
            return false;
        if (!orderDate.equals(that.orderDate))
            return false;
        return status.equals(that.status);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + customerId.hashCode();
        result = 31 * result + orderDate.hashCode();
        result = 31 * result + status.hashCode();
        return result;
    }
}

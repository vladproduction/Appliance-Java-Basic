package com.vladproduction.appliances.model;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Objects;

public class Order {

    private long id;
    private long employeeId;
    private long clientId;
    private Map<Appliance, BigDecimal> appliances;

    public Order() {

    }

    public Order(long id, long employeeId, long clientId) {
        this.id = id;
        this.employeeId = employeeId;
        this.clientId = clientId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id && employeeId == order.employeeId && clientId == order.clientId;
    }

    public BigDecimal getTotalPrice(){
        return appliances.values().stream()
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, employeeId, clientId);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", employeeId=" + employeeId +
                ", clientId=" + clientId +
                '}';
    }
}

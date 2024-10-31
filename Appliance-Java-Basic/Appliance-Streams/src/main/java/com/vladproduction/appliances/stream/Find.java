package com.vladproduction.appliances.stream;

import com.vladproduction.appliances.model.Employee;
import com.vladproduction.appliances.model.Manufacturer;
import com.vladproduction.appliances.model.Order;

import java.util.List;

public interface Find {
    Manufacturer findManufacturerById(long id);

    Manufacturer findManufacturerByName(String name);

    List<Order> findOrderByEmployee(Employee employee);

    Order findCheapestOrder();

    Order findMostExpensiveOrder();
}

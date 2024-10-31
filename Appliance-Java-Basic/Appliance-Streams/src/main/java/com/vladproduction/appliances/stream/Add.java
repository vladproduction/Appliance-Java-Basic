package com.vladproduction.appliances.stream;

import com.vladproduction.appliances.model.*;

public interface Add {
    void addClient(Client client);

    void addEmployee(Employee employee);

    void addAppliance(Appliance appliance);

    void addOrder(Order order);

    void addManufacturer(Manufacturer manufacturer);
}

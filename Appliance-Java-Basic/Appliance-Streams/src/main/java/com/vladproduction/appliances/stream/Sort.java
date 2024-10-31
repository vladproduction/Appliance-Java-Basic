package com.vladproduction.appliances.stream;

import com.vladproduction.appliances.model.Appliance;
import com.vladproduction.appliances.model.Manufacturer;
import com.vladproduction.appliances.model.Order;

import java.util.List;

public interface Sort {
    List<Manufacturer> sortManufacturersByName();

    List<Order> sortOrderByClientId();

    List<Appliance> sortAppliancesByCategory();

    List<Order> sortOrderByAmount();
}

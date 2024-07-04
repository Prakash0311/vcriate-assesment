package com.example.stockInventory.service;

import com.example.stockInventory.entity.Item;
import com.example.stockInventory.entity.CustomerOrder;
import com.example.stockInventory.entity.Supplier;
import com.example.stockInventory.repository.ItemRepository;
import com.example.stockInventory.repository.CustomerOrderRepository;
import com.example.stockInventory.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private CustomerOrderRepository orderRepository;

    @Autowired
    private SupplierRepository supplierRepository;

    // Method to generate stock report
    public String generateStockReport() {
        List<Item> items = itemRepository.findAll();
        StringBuilder report = new StringBuilder("Stock Report:\n");
        report.append("ID\tName\tQuantity\tPrice\n");
        for (Item item : items) {
            report.append(item.getId())
                    .append("\t")
                    .append(item.getName())
                    .append("\t")
                    .append(item.getQuantity())
                    .append("\t")
                    .append(item.getPrice())
                    .append("\n");
        }
        return report.toString();
    }

    // Method to generate order report
    public String generateOrderReport() {
        List<CustomerOrder> orders = orderRepository.findAll();
        StringBuilder report = new StringBuilder("Order Report:\n");
        report.append("ID\tCustomer ID\tOrder Date\tStatus\n");
        for (CustomerOrder order : orders) {
            report.append(order.getId())
                    .append("\t")
                    .append(order.getCustomerId())
                    .append("\t")
                    .append(order.getOrderDate())
                    .append("\t")
                    .append(order.getStatus())
                    .append("\n");
        }
        return report.toString();
    }

    // Method to generate supplier report
    public String generateSupplierReport() {
        List<Supplier> suppliers = supplierRepository.findAll();
        StringBuilder report = new StringBuilder("Supplier Report:\n");
        report.append("ID\tName\tContact Info\n");
        for (Supplier supplier : suppliers) {
            report.append(supplier.getId())
                    .append("\t")
                    .append(supplier.getName())
                    .append("\t")
                    .append(supplier.getContactInfo())
                    .append("\n");
        }
        return report.toString();
    }
}

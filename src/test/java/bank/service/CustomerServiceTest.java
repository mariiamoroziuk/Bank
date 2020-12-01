package bank.service;

import bank.dao.CustomerDao;
import bank.model.Customer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class CustomerServiceTest {
//    public CustomerDao cd;
//    public CustomerService cs;
//
//    @BeforeEach
//    void init (){
//        cd = new CustomerDao();
//        cs = new CustomerService(cd);
//    }
//
//    @Test
//    void createCustomer() {
//        Customer c = cs.createCustomer("SAM", "email", 28);
//        assertEquals(new Customer("SAM", "email", 28), c);
//        assertEquals(new Customer("SAM", "email", 28), cd.findAll().get(0));
//    }
//
//
//    @Test
//    void updateCustomer() {
//        Customer c = cs.createCustomer("SAM", "email", 28);
//        c.setAge(29);
//        cs.updateCustomer(c);
//        assertEquals(new Customer("SAM", "email", 29), c);
//        assertEquals(new Customer("SAM", "email", 29), cd.findAll().get(0));
//        assertTrue(cs.readAllCustomers().size() == 1);
//    }
//
//    @Test
//    void deleteCustomer() {
//        Customer c = cs.createCustomer("SAM", "email", 28);
//        boolean b = cs.deleteCustomer(c.getId());
//        assertTrue(b);
//        assertTrue(cs.readAllCustomers().size() == 0);
//    }
}
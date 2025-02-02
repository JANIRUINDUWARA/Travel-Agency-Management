package com.example.CustomerMicroservice.service;

import com.example.CustomerMicroservice.data.Customer;
import com.example.CustomerMicroservice.data.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
   private CustomerRepository passengerRepository;

    public List<Customer> getAllCustomers(){
        return  passengerRepository.findAll();
    }

    public Customer getcustomerById(int id){
        Optional<Customer> product=passengerRepository.findById(id);
        return product.orElse(null);
    }

    public Optional<Customer> getPassengerByEmail(String email){
        return passengerRepository.findByEmail(email);
    }

    public Customer createCustomer(Customer passenger){
        return passengerRepository.save(passenger);
    }

    public Customer updateCustomer(int id, Customer passenger){
        return passengerRepository.save(passenger);
    }

    public String deleteCustomer(int id){
        passengerRepository.deleteById(id);
        return "Successfully Deleted!";
    }

    public boolean authenticate(String email, String password) {
        Optional<Customer> passenger = passengerRepository.findByEmail(email);
        return passenger.isPresent() && passenger.get().getPassword().equals(password);
    }
}
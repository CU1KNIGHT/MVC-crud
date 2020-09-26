package com.mahmoud.java.controller;

import com.mahmoud.java.entity.Customer;
import com.mahmoud.java.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @GetMapping("/list")
    public String listCustomer( Model theModel){
        //get customers from the dao
        List<Customer> customerList=customerService.getCustomers();
        theModel.addAttribute("customers",customerList);
        return "list-customers";
    }
    @GetMapping("/second")
    public String second(){
        return "second";
    }
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model modelData){
        //create model attribute to bind form data
        Customer customerPerson= new Customer();
        //                    ( name                       , value        )
        modelData.addAttribute("customer",customerPerson);
        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute ("customer") Customer customer){
        //save the Customer using our service
        customerService.saveCustomer(customer);
        return "redirect:/customer/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") int idFormUpdate,Model model){
        //get the customer form service
        Customer customer= customerService.getCustomer(idFormUpdate);
        //set customer as a model attribute to pre-populate the form
        model.addAttribute("customer",customer);
        //send over to our form
        return "customer-form";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("customerId") int id){
        //delete the customer
        customerService.deleteCustomer(id);
        return "redirect:/customer/list";
    }
 @GetMapping("/search")
// searchName is same as
    public String searchCustomers(@RequestParam("searchName") String searchName,Model model){
        //search customer from the service
     List<Customer> customers= customerService.searchCustomers(searchName);

     //add the customers to the model
     model.addAttribute("customers",customers);
     return "list-customers";
 }
}

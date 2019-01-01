package com.developersboard.onlinebankingsystem.controller;

import com.developersboard.onlinebankingsystem.backend.domain.Customer;
import com.developersboard.onlinebankingsystem.backend.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    private static final org.slf4j.Logger LOGGER =
            org.slf4j.LoggerFactory.getLogger(CustomerController.class);

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    // get all customers
    @GetMapping("")
    public String getAllCustomers(Model model) {
        model.addAttribute("customers", customerService.getAllUser());
        // return "customer/list";
        return "customers";
    }

    @GetMapping("/new")
    public String newCustomerForm(Model model) {
        model.addAttribute("customer", new Customer()); //add form-backing bean
        return "customer/new";
    }

    @PostMapping("/new")
    public String saveNewCustomer(@Valid @ModelAttribute("customer") Customer customer, Model model) {

        if (customerService.customerExist(customer)) {

            if (customerService.checkEmailExist(customer.getEmail())) {
                model.addAttribute("emailExists", true);
            }
            if (customerService.checkUsernameExist(customer.getUsername())) {
                model.addAttribute("usernameExists", true);
            }

            return "customer/new";

        } else {
            customerService.createCustomer(customer); // finally, create the customer
            //LOGGER.info("Creating customer: " + customer); // causing stackOverFlow error : null , might be toString()
            return "redirect:/customers";
        }

    }

    // get a single customer
    @GetMapping("/{id}")
    public String viewCustomer(Model model, @PathVariable long id) throws IllegalAccessException {
        model.addAttribute("aCustomer", customerService.getCustomerById(id));
        return "customer/view";
    }

    // get a single customer
    @GetMapping("/{id}/edit")
    public String editCustomer(Model model, @PathVariable("id") Long id) throws IllegalAccessException {
        model.addAttribute("customer", customerService.getCustomerById(id));
        return "customer/edit";
    }

//
//    // get a single customer
//    @PutMapping("/{id}")
//    public String updateCustomer(Model model, @PathVariable long id,
//    @ModelAttribute("customer") Customer customer) throws IllegalAccessException {
//        customerService.updateUserInfo(customer);
//        model.addAttribute("customer", customerService.getCustomerById(customer.getId()));
//        return "redirect:/customer/" + id;
//    }
//
//    @DeleteMapping("/{id}")
//    public String deleteCustomer(Model model, @PathVariable("id") Long id) throws IllegalAccessException {
//        customerService.deleteCustomerById(id);
//        return "redirect:/customer";
//    }

    /**
     * TODO:
     * On click, take customer filled form and create a new customer
     * mandated fields: firstName, lastName, email-address, password(should not be stored in DB)
     *
     * @return
     */


    @RequestMapping("/signUpSuccessful")
    public String viewRegisterSuccessful(Model model) {

        return "signUpSuccessfulPage";
    }


}

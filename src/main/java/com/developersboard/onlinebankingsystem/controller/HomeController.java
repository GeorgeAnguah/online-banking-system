package com.developersboard.onlinebankingsystem.controller;

import com.developersboard.onlinebankingsystem.backend.domain.CheckingAccount;
import com.developersboard.onlinebankingsystem.backend.domain.Customer;
import com.developersboard.onlinebankingsystem.backend.domain.SavingsAccount;
import com.developersboard.onlinebankingsystem.backend.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.security.Principal;

@Controller
public class HomeController {

    private CustomerService customerService;

    public HomeController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @RequestMapping({"", "/", "/index"})
    public String index() {
        return "index";
    }


    @GetMapping("/signup")
    public String signup(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "signup";
    }

    /**
     * Create customer
     *
     * @param customer, gets populated customer field from view
     * @param model
     * @return successful signup msg or error msg
     */
    @PostMapping("/signup")
    public String submit(@Valid @ModelAttribute("customer") Customer customer, Model model) {

        // TODO
        /*
         *  validate customer fields : email, username
         *  if customer does not exist
         *  then call customerService to create a new customer
         */

        if (customerService.customerExist(customer)) {

            if (customerService.checkEmailExist(customer.getEmail())) {
                model.addAttribute("emailExists", true);
            }
            if (customerService.checkUsernameExist(customer.getUsername())) {
                model.addAttribute("usernameExists", true);
            }

            return "/signup";

        } else {
            customerService.createCustomer(customer); // finally, create the customer
            return "redirect:/login";
        }
    }


    // principal defines a customer who has been authenticated with username and password
    @RequestMapping("/onlineBanking")
    public String onlineBanking(Principal principal, Model model) {
        Customer customer = customerService.getCustomerByUsername(principal.getName());
        CheckingAccount checkingAccount = customer.getCheckingAccount();
        SavingsAccount savingsAccount = customer.getSavingsAccount();

        model.addAttribute("checkingAccount", checkingAccount);
        model.addAttribute("savingAccount", savingsAccount);

        return "onlineBanking";
    }
}
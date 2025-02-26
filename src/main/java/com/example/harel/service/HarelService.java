package com.example.harel.service;

import com.example.harel.entity.Customers;
import com.example.harel.entity.Policies;
import com.example.harel.exception.CustomerNotFoundException;
import com.example.harel.exception.PolicyAllReadyExistsException;
import com.example.harel.exception.PolicyNotFoundException;
import com.example.harel.repository.CustomersRepository;
import com.example.harel.repository.PoliciesRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class HarelService {

    private CustomersRepository customersRepository;
    private PoliciesRepository policiesRepository;


    public Optional<Policies> getPolicy(int policyId){
        Optional<Policies> policy = policiesRepository.findById(policyId);
        if(!policy.isPresent()){
            throw new PolicyNotFoundException("policy", "policy ID" , String.valueOf(policyId));
        }
        return policy;
    }

    @Transactional
    public void savePolicy(@Valid Policies policy) {
        Optional<Policies> policyOpt = policiesRepository.findByPolicyNumber(policy.getPolicyNumber());
        if (policyOpt.isPresent()){
            throw new PolicyAllReadyExistsException(policy.getPolicyNumber() + " allready exist in the data base");
        }
        Optional<Customers> customerOpt = customersRepository.findById(policy.getCustomer().getId());
        if(!customerOpt.isPresent()){
            throw new CustomerNotFoundException("customer", "customer ID" , String.valueOf(policy.getCustomer().getId()));
        }
        Customers customer = new Customers();
        mapCustomerOptToCustomer(customer,customerOpt);
        policy.setCustomer(customer);
        policiesRepository.save(policy);
    }

    private void mapCustomerOptToCustomer(Customers customer, Optional<Customers> customerOpt) {
        customer.setId(customerOpt.stream().toList().get(0).getId());
    }


    public List<Customers> findAll() {
        return customersRepository.findAll();
    }
}

package com.acme.view;

import com.acme.domain.Customer;
import org.jboss.logging.Logger;
import org.jboss.seam.forge.persistence.PersistenceUtil;
import org.jboss.seam.transaction.Transactional;

import javax.ejb.Stateful;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Transactional
@Named
@Stateful
@RequestScoped
public class CustomerBean extends PersistenceUtil {
    private List<Customer> list = null;
    private Customer customer = new Customer();
    private long id = 0;

    @Inject
    private Logger log;


    public void load() {
        customer = findById(Customer.class, id);
    }

    public String create() {
        create(customer);
        log.info("############### new Customer created");
        return "view?faces-redirect=true&id=" + customer.getId();
    }

    public String delete() {
        delete(customer);
        return "list?faces-redirect=true";
    }

    public String save() {
        save(customer);
        return "view?faces-redirect=true&id=" + customer.getId();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
        load();
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Customer> getList() {
        if (list == null) {
            list = findAll(Customer.class);
        }
        return list;
    }

    public void setList(List<Customer> list) {
        this.list = list;
    }
}

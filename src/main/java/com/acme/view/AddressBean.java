package com.acme.view;

import com.acme.domain.Address;
import org.jboss.seam.forge.persistence.PersistenceUtil;
import org.jboss.seam.transaction.Transactional;

import javax.ejb.Stateful;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.List;

@Transactional
@Named
@Stateful
@RequestScoped
public class AddressBean extends PersistenceUtil {
    private List<Address> list = null;
    private Address address = new Address();
    private long id = 0;

    public void load() {
        address = findById(Address.class, id);
    }

    public String create() {
        create(address);
        return "view?faces-redirect=true&id=" + address.getId();
    }

    public String delete() {
        delete(address);
        return "list?faces-redirect=true";
    }

    public String save() {
        save(address);
        return "view?faces-redirect=true&id=" + address.getId();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
        load();
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Address> getList() {
        if (list == null) {
            list = findAll(Address.class);
        }
        return list;
    }

    public void setList(List<Address> list) {
        this.list = list;
    }
}

package com.mahmoud.java.dao;

import com.mahmoud.java.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDAOimpl implements CustomerDAO {
    // need to inject the session factory
    //<!--    sessionFactory in dispatcher-servlet.xml is same of sessionFactory Field in CustomerDAImplementation class-->
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List <Customer> getCustomers () {
        // get the current hibernate session

        Session currentSession = sessionFactory.getCurrentSession();
        // create a query

        Query <Customer> customerQuery = currentSession.createQuery("from Customer", Customer.class);
        //execute query and get the result list
        List <Customer> customers = customerQuery.getResultList();
        // return the results
        return customers;
    }

    @Override
    public void saveCustomer (Customer customer) {
        //get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        //save the customer..finally
        currentSession.saveOrUpdate(customer);
    }

    @Override
    public Customer getCustomer (int id) {
        //get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        //now retrieve / read from database using the primary key
        Customer customer = currentSession.get(Customer.class, id);
        return customer;
    }

    @Override
    public void deleteCustomer (int id) {
        //get current hibernate session
        Session currentSession= sessionFactory.getCurrentSession();
        //now retrieve / read form database using the primary key
        Query query= currentSession.createQuery("delete from  Customer where id=:customerId");
        query.setParameter("customerId",id);
        query.executeUpdate();
    }

    @Override
    public List searchCustomers (String searchName) {
        //get the current hibernate sesion
        Session currentSession= sessionFactory.getCurrentSession();
        Query query=null;
        //
        // only search by name if theSearchName is not empty
        //
        if(searchName != null && searchName.trim().length()>0){
            // search for firstName or lastName ... case insensitive
            query =currentSession.createQuery("from Customer where lower(firstName) like:NameToSearch or lower(lastName) like: NameToSearch ", Customer.class);
            query.setParameter("NameToSearch","%"+ searchName.toLowerCase()+"%");
        }else             // theSearchName is empty ... so just get all customers
            query=currentSession.createQuery("from  Customer ",Customer.class);
        // execute query and get result list
        // return the results

        return query.getResultList();
    }
}

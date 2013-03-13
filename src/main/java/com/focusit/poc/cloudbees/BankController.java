/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.focusit.poc.cloudbees;

import java.util.List;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.joda.time.DateTime;

/**
 *
 * @author Julien
 */
@Path("/bank")
@Stateless
@Produces(MediaType.APPLICATION_JSON)
public class BankController {

    @Inject
    private EntityManager em;

    @GET
    public List<Transaction> getTransactions() {
        return em.createQuery("from Transaction", Transaction.class).getResultList();
    }

    @POST
    // curl -d amount=199.99 -d date=2013-01-01 http://localhost:8080/poc-jee6/rest/bank
    public Transaction create(@FormParam("amount") final Double amount, @FormParam("date") final String date) {
        final Transaction tx = Transaction.create(amount, DateTime.parse(date).toDate());
        em.persist(tx);

        return tx;
    }
}

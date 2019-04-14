package ro.sda.travel.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sda.travel.core.entity.Payment;
import ro.sda.travel.core.service.PaymentService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Service
@Path("/payment")
public class PaymentRestService {

    @Autowired
    private PaymentService paymentService;

    @Path("/find-all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Payment> findAll() {
        return paymentService.getAllPayment();
    }

    @Path("/find/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Payment findPaymentById(@PathParam("id") int id) {
        return paymentService.getPaymentById(id);
    }

    @Path("/delete")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public void deletePayment(@QueryParam("deleteId") int id) {
        paymentService.deletePayment(id);
    }

    @Path("/create")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Payment createPayment(Payment payment) {
        return paymentService.createPayment(payment);
    }

}

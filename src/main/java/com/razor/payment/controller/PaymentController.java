package com.razor.payment.controller;

//import org.springframework.boot.web.servlet.filter.OrderedRequestContextFilter;
import com.razor.payment.payload.OrderRequest;
import com.razorpay.*;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PaymentController {

    //http:localhost:8080/api/create-order

    @PostMapping("/create-order")
public Order createOrder(@RequestBody OrderRequest order) throws Exception {


    RazorpayClient razorpay = new RazorpayClient("rzp_test_fc3dWbRl5jTxyK", "nQTi3ByJuvkrvNGv3pyMiJ9X");

    JSONObject orderRequest = new JSONObject();
    orderRequest.put("amount", order.getAmount()*100);
    orderRequest.put("currency", "INR");
    orderRequest.put("receipt", "receipt#1");
    JSONObject notes = new JSONObject();
    notes.put("notes_key_1", "Tea, Earl Grey, Hot");
    notes.put("notes_key_1", "Tea, Earl Grey, Hot");
    orderRequest.put("notes", notes);


        Order orderResponse = razorpay.orders.create(orderRequest);

    return orderResponse;

 }


}

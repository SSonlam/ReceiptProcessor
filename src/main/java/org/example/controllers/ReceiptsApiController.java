package org.example.controllers;

import org.example.services.ReceiptsService;
import org.openapitools.api.ReceiptsApi;
import org.openapitools.model.GetPoints200Response;
import org.openapitools.model.ProcessReceipts200Response;
import org.openapitools.model.Receipt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api")
public class ReceiptsApiController implements ReceiptsApi {

    private final ReceiptsService receiptsService;

    @Autowired
    public ReceiptsApiController(ReceiptsService receiptsService) {
        this.receiptsService = receiptsService;
    }

    @Override
    @GetMapping("/receipts/{id}/points")
    public ResponseEntity<GetPoints200Response> getPoints(String id) {
        GetPoints200Response getPoints200Response = new GetPoints200Response();
        getPoints200Response.setPoints(receiptsService.getPoints(UUID.fromString(id)));
        return ResponseEntity.ok(getPoints200Response);
    }

    @Override
    @PostMapping("/receipts/process")
    public ResponseEntity<ProcessReceipts200Response> processReceipts(@RequestBody Receipt receipt) {
        var id = receiptsService.processReceipt(receipt);
        ProcessReceipts200Response response = new ProcessReceipts200Response();
        response.setId(id.toString());
        return ResponseEntity.ok(response);
    }
}
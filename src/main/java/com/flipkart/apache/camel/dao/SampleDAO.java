package com.flipkart.apache.camel.dao;

import com.flipkart.apache.camel.model.api.SandboxServerRequest;
import com.flipkart.apache.camel.model.api.SandboxServerResponse;
import com.flipkart.apache.camel.model.db.TransactionAudit;

public class SampleDAO implements DAO {


    public TransactionAudit getAuditDetails(String id) {

        TransactionAudit transactionAudit = new TransactionAudit();
        transactionAudit.setTxnId(id);
        transactionAudit.setRequest(new SandboxServerRequest().toString());
        transactionAudit.setResponse(new SandboxServerResponse().toString());
        return transactionAudit;

    }
}

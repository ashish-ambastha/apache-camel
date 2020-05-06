package com.flipkart.apache.camel.dao;

import com.flipkart.apache.camel.model.db.TransactionAudit;

public interface DAO {
    TransactionAudit getAuditDetails (String id);
}

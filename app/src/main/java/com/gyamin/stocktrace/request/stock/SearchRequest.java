package com.gyamin.stocktrace.request.stock;
import javax.validation.constraints.NotNull;

public class SearchRequest {
    private String section;
    private String issueCode;
    private String issueName;

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    @NotNull
    public String getIssueCode() {
        return issueCode;
    }

    public void setIssueCode(String issueCode) {
        this.issueCode = issueCode;
    }

    public String getIssueName() {
        return issueName;
    }

    public void setIssueName(String issueName) {
        this.issueName = issueName;
    }
}

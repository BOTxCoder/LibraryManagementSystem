package sample;

import java.time.LocalDate;

public class ModelTablePendingIssueRequest {
    private int membershipId;
    private String bookName;
    private LocalDate requestDate;
    private LocalDate requestFulfilledDate;

    public ModelTablePendingIssueRequest(int membershipId, String bookName, LocalDate requestDate, LocalDate requestFulfilledDate) {
        this.membershipId = membershipId;
        this.bookName = bookName;
        this.requestDate = requestDate;
        this.requestFulfilledDate = requestFulfilledDate;
    }

    public int getMembershipId() {
        return membershipId;
    }

    public void setMembershipId(int membershipId) {
        this.membershipId = membershipId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public LocalDate getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(LocalDate requestDate) {
        this.requestDate = requestDate;
    }

    public LocalDate getRequestFulfilledDate() {
        return requestFulfilledDate;
    }

    public void setRequestFulfilledDate(LocalDate requestFulfilledDate) {
        this.requestFulfilledDate = requestFulfilledDate;
    }
}

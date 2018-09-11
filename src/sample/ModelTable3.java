package sample;

import java.time.LocalDate;

public class ModelTable3 {
    private int serialNumber;
    private String bookName;
    private int membershipId;
    private LocalDate dateOfIssue;
    private LocalDate dateOfReturn;

    public ModelTable3(int serialNumber, String bookName, int membershipId, LocalDate dateOfIssue, LocalDate dateOfReturn) {
        this.serialNumber = serialNumber;
        this.bookName = bookName;
        this.membershipId = membershipId;
        this.dateOfIssue = dateOfIssue;
        this.dateOfReturn = dateOfReturn;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getMembershipId() {
        return membershipId;
    }

    public void setMembershipId(int membershipId) {
        this.membershipId = membershipId;
    }

    public LocalDate getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(LocalDate dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public LocalDate getDateOfReturn() {
        return dateOfReturn;
    }

    public void setDateOfReturn(LocalDate dateOfReturn) {
        this.dateOfReturn = dateOfReturn;
    }
}

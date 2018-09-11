package sample;

import java.time.LocalDate;

public class ModelTable4 {
    private int serialNo;
    private int membershipId;
    private String Name;
    private LocalDate dateOfIssue;
    private LocalDate dateOfReturn;
    private int fine;

    public ModelTable4(int serialNo, int membershipId, String name, LocalDate dateOfIssue, LocalDate dateOfReturn, int fine) {
        this.serialNo = serialNo;
        this.membershipId = membershipId;
        Name = name;
        this.dateOfIssue = dateOfIssue;
        this.dateOfReturn = dateOfReturn;
        this.fine = fine;
    }

    public int getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(int serialNo) {
        this.serialNo = serialNo;
    }

    public int getMembershipId() {
        return membershipId;
    }

    public void setMembershipId(int membershipId) {
        this.membershipId = membershipId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
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

    public int getFine() {
        return fine;
    }

    public void setFine(int fine) {
        this.fine = fine;
    }
}
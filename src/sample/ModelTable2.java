package sample;

import java.time.LocalDate;

public class ModelTable2 {
    private int membershipId;
    private int aadharNo;
    private String memberName;
    private String contactAddress;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status;
    private int contactNo;
    private int fine;

    public ModelTable2(int membershipId, int aadharNo, String memberName, String contactAddress, LocalDate startDate, LocalDate endDate, String status, int contactNo, int fine) {
        this.membershipId = membershipId;
        this.aadharNo = aadharNo;
        this.memberName = memberName;
        this.contactAddress = contactAddress;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.contactNo = contactNo;
        this.fine = fine;
    }

    public int getMembershipId() {
        return membershipId;
    }

    public void setMembershipId(int membershipId) {
        this.membershipId = membershipId;
    }

    public int getAadharNo() {
        return aadharNo;
    }

    public void setAadharNo(int aadharNo) {
        this.aadharNo = aadharNo;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getContactAddress() {
        return contactAddress;
    }

    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getContactNo() {
        return contactNo;
    }

    public void setContactNo(int contactNo) {
        this.contactNo = contactNo;
    }

    public int getFine() {
        return fine;
    }

    public void setFine(int fine) {
        this.fine = fine;
    }
}

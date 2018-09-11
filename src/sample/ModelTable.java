package sample;

import java.time.LocalDate;

public class ModelTable{
   int  serialNo;
   String bookName;
   String authorName;
   String status;
   String category;
   int cost;
   LocalDate procurementDate;

        public ModelTable(int serialNo, String bookName, String authorName, String status, String category, int cost, LocalDate procurementDate) {
            this.serialNo = serialNo;
            this.bookName = bookName;
            this.authorName = authorName;
            this.status = status;
            this.category = category;
            this.cost = cost;
            this.procurementDate = procurementDate;
        }

        public int getSerialNo() {
            return serialNo;
        }

        public void setSerialNo(int serialNo) {
            this.serialNo = serialNo;
        }

        public String getBookName() {
            return bookName;
        }

        public void setBookName(String bookName) {
            this.bookName = bookName;
        }

        public String getAuthorName() {
            return authorName;
        }

        public void setAuthorName(String authorName) {
            this.authorName = authorName;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public int getCost() {
            return cost;
        }

        public void setCost(int cost) {
            this.cost = cost;
        }

        public LocalDate getProcurementDate() {
            return procurementDate;
        }

        public void setProcurementDate(LocalDate procurementDate) {
            this.procurementDate = procurementDate;
        }
}

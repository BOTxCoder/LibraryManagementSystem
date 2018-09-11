package sample;

public class ModelTableAdminHome {
    private int codeNumberFrom;
    private int codeNumberTo;
    private String Category;

    public ModelTableAdminHome(int codeNumberFrom, int codeNumberTo, String category) {
        this.codeNumberFrom = codeNumberFrom;
        this.codeNumberTo = codeNumberTo;
        Category = category;
    }

    public int getCodeNumberFrom() {
        return codeNumberFrom;
    }

    public void setCodeNumberFrom(int codeNumberFrom) {
        this.codeNumberFrom = codeNumberFrom;
    }

    public int getCodeNumberTo() {
        return codeNumberTo;
    }

    public void setCodeNumberTo(int codeNumberTo) {
        this.codeNumberTo = codeNumberTo;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }
}



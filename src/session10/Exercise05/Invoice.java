package session10.Exercise05;

public class Invoice {
    private int id;
    private String invoiceCode;
    private float amount;

    public Invoice(int id, String invoiceCode, float amount) {
        this.id = id;
        this.invoiceCode = invoiceCode;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInvoiceCode() {
        return invoiceCode;
    }

    public void setInvoiceCode(String invoiceCode) {
        this.invoiceCode = invoiceCode;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Mã hóa đơn: " + invoiceCode + ", Số tiền: " + amount;
    }
}

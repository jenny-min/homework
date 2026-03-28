package session10.Exercise05;

import java.util.ArrayList;

public class InvoiceManager implements Manage<Invoice >{
    public ArrayList<Invoice> invoices;

    public InvoiceManager() {
        invoices = new ArrayList<>();
    }

    //Kiểm tra danh sách trống
    public boolean isEmpty() {
        return invoices.isEmpty();
    }

    @Override
    public void add(Invoice invoice) {
        invoices.add(invoice);
    }

    @Override
    public void update(int index, Invoice invoice) {
        if (index >= 0 && index < invoices.size()) {
            invoices.set(index, invoice);
        }
    }

    @Override
    public void delete(int index) {
        if (index >= 0 && index < invoices.size()) {
            invoices.remove(index);
        }
    }

    @Override
    public void display() {
        if (invoices.isEmpty()) {
            System.out.println("Danh sách hóa đơn trống!");
        } else {
            for (int i = 0; i < invoices.size(); i++) {
                System.out.println((i + 1) + ". " + invoices.get(i));
            }
        }
    }
}


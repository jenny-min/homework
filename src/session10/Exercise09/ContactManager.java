package session10.Exercise09;

import java.util.*;

public class ContactManager implements Manage<Contact>, InputData {
    private Set<Contact> contacts = new HashSet<>();

    //Thêm
    @Override
    public void add(Contact contact) {
        if (contacts.add(contact)) {   // add thành công
            contact.assignId();
            System.out.println("Thêm số điện thoại thành công!");
        } else {
            System.out.println("Số điện thoại đã tồn tại!");
        }
    }

    // Nhập danh bạ
    public void inputData(Scanner scanner) {
        int n = inputInt(scanner, "Nhập số liên lạc: ");

        for (int i = 0; i < n; i++) {
            System.out.println("Nhập liên lạc thứ " + (i + 1));

            String name = inputString(scanner, "Nhập tên người liên lạc: ");

            String phone;
            while (true) {
                phone = inputString(scanner, "Nhập số điện thoại: ");

                // validate số
                if (!phone.matches("\\d+")) {
                    System.out.println("Số điện thoại phải là số!");
                    continue;
                }

                break;
            }

            add(new Contact(name, phone));
        }
    }

    //Xóa
    @Override
    public void remove(String phoneNumber) {
        Contact temp = new Contact();
        temp.setPhoneNumber(phoneNumber);

        if (contacts.remove(temp)) {
            System.out.println("Xóa thành công!");
        } else {
            System.out.println("Không tìm thấy!");
        }
    }

    //Tìm kiếm theo SĐT
    @Override
    public boolean search(String phoneNumber) {
        Contact temp = new Contact();
        temp.setPhoneNumber(phoneNumber);

        if (contacts.contains(temp)) {
            for (Contact c : contacts) {
                if (c.getPhoneNumber().equals(phoneNumber)) {
                    System.out.println(c);
                    return true;
                }
            }
        }

        System.out.println("Không tìm thấy!");
        return false;
    }

    //Hiển thị
    @Override
    public void display() {
        if (contacts.isEmpty()) {
            System.out.println("Danh bạ trống!");
            return;
        }

        List<Contact> list = new ArrayList<>(contacts);

        // Sắp xếp theo ID
        list.sort(Comparator.comparing(Contact::getId));

        list.forEach(System.out::println);
    }

    //Phân trang
    public void displayPaging(Scanner scanner) {
        if (contacts.isEmpty()) {
            System.out.println("Danh bạ trống!");
            return;
        }

        List<Contact> list = new ArrayList<>(contacts);

        int pageSize = inputInt(scanner, "Nhập số phần tử mỗi trang: ");//Số phần tử mỗi trang
        int totalPage = (int) Math.ceil((double) list.size() / pageSize);//Số trang

        for (int page = 1; page <= totalPage; page++) {
            System.out.println("\nTrang " + page);

            int start = (page - 1) * pageSize;
            int end = Math.min(start + pageSize, list.size());

            for (int i = start; i < end; i++) {
                System.out.println(list.get(i));
            }

            if (page < totalPage) {
                System.out.print("Enter để sang trang tiếp theo");
                scanner.nextLine();
            }
        }
    }
}

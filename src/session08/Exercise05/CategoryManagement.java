package session08.Exercise05;
//Lớp này thực hiện implement từ  interface ICRUD và quản lý danh sách danh mục
public class CategoryManagement implements ICRUD {
    Category[] categories = new Category[100];//Mảng chứa danh mục
    private int count = 0; //Danh mục hiện tại bằng 0

    //Hiển thị
    @Override
    public Category[] findAll() {
        Category[] result = new Category[count];
        System.arraycopy(categories, 0, result, 0, count);
        return result;
    }

    //Thêm
    @Override
    public void addCategory(Category category) {
        if (count < categories.length) {
            categories[count++] = category;
        } else {
            System.out.println("Mảng đầy, không thể thêm danh mục");
        }
    }

    //Cập nhật
    @Override
    public void updateCategory(Category category) {
        for (int i = 0; i < count; i++) {
            if (categories[i].getId() == category.getId()) {
                categories[i] = category;
                return;
            }
        }
    }

    //Xóa
    @Override
    public void deleteById(int id) {
        for (int i = 0; i < count; i++) {
            if (categories[i].getId() == id) {//Tìm vị trí cần xóa
                for (int j = i; j < count -1; j++) {//Dồn mảng sang trái
                    categories[j] =categories[j + 1];
                }
                categories[--count] = null;//Giảm số lượng + xóa phần tử cuối
                System.out.println("Danh mục đã được xóa!");
                return;
            }
        }
        System.out.println("Danh mục không tồn tại!");
    }
}

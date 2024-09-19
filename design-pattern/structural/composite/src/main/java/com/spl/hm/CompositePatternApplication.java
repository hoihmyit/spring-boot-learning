package com.spl.hm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Hôih My
 * Gitlab: https://gitlab.com/my.hoih
 * @since 02/07/2021
 * <p>
 * Composite: A tree structure of simple and composite objects
 */
@SpringBootApplication
public class CompositePatternApplication {
    public static void main(String[] args) {
        SpringApplication.run(CompositePatternApplication.class, args);
    }

    /**
     * Ví dụ: Cài đặt Composite Pattern về chương trình quản lý một hệ thống tập tin.
     *  Một hệ thống tập tin là một cấu trúc cây có chứa các nhánh là các thư mục (folder – composite),
     *  cũng như các nút lá là các tệp (file – leaf). Một folder có thể chứa một hoặc nhiều file hoặc folder.
     *  Do đó, folder là một đối tượng phức tạp và file là một đối tượng đơn giản.
     *  File và Folder có nhiều thao tác và thuộc tính chung, chẳng hạn như: di chuyển (cut) , sao chép (copy), liệt kê (view) hoặc các thuộc tính thư mục như tên tệp và kích thước.
     * Với cấu trúc như vậy sẽ dễ dàng và thuận tiện hơn để quản lý file và folder thống nhất bằng cách xây dựng một Interface có đầy đủ các phương thức và thuộc tính chung cho cả file và folder.
     */
}

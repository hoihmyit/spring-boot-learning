package com.spl.hm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Hôih My
 * Gitlab: https://gitlab.com/my.hoih
 * @since 17/06/2021
 * <p>
 * Prototype: A fully initialized instance to be copied or cloned
 */
@SpringBootApplication
public class PrototypePatternApplication {
    public static void main(String[] args) {
        SpringApplication.run(PrototypePatternApplication.class, args);
    }

    /**
     * Prototype pattern có nhiệm vụ khởi tạo một đối tượng bằng cách clone một đối tượng đã tồn tại thay vì khởi tạo với từ khoá new.
     * Đối tượng mới là một bản sao có thể giống 100% với đối tượng gốc, chúng ta có thể thay đổi dữ liệu của nó mà không ảnh hưởng đến đối tượng gốc.
     * Prototype Pattern được dùng khi việc tạo một object tốn nhiều chi phí và thời gian trong khi bạn đã có một object tương tự tồn tại.
     * Trong Java cung cấp mẫu prototype pattern này bằng việc implement interface Cloneable và sử dụng method clone() để tạo object có đầy đủ thuộc tính của đối tượng ban đầu.
     *
     * Một Prototype Pattern gồm các thành phần cơ bản sau:
     * - Prototype : khai báo một class, interface hoặc abtract class cho việc clone chính nó.
     * - ConcretePrototype class : các lớp này thực thi interface (hoặc kế thừa từ lớp abstract) được cung cấp bởi Prototype để copy (nhân bản) chính bản thân nó.
     *   Các lớp này chính là thể hiện cụ thể phương thức clone(). Lớp này có thể không cần thiết nếu: Prototype là một class và nó đã implement việc clone chính nó.
     * - Client class : tạo mới object bằng cách gọi Prototype thực hiện clone chính nó.
     *
     * Ví dụ: Một công ty có cấu hình máy tính đều giống nhau cho tất cả nhân viên, bao gồm: Hệ điều hành (os), Phần mềm văn phòng (office), Phần mềm diệt virus (antivirus), Trình duyệt (Browser),
     * và một số phần mềm khác (others) tùy theo nhu cầu của mỗi nhân viên sẽ được cài đặt thêm. Việc cài đặt tất cả phần mềm trên rất tốn thời gian,
     * nên anh IT đã nghĩ ra một cách là sẽ tạo ra một bản chuẩn cho một máy tính và có thể clone() lại cấu hình đó cho một nhân viên khác mà không cần phải cài đặt lại từ đầu.
     */
}

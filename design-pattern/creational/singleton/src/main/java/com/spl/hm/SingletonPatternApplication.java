package com.spl.hm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Hôih My
 * Gitlab: https://gitlab.com/my.hoih
 * @since 22/06/2021
 * <p>
 * Singleton: A class of which only a single instance can exist
 */
@SpringBootApplication
public class SingletonPatternApplication {
    public static void main(String[] args) {
        SpringApplication.run(SingletonPatternApplication.class, args);

        /**
         * Singleton đảm bảo chỉ duy nhất một thể hiện (instance) được tạo ra và nó sẽ cung cấp cho bạn một method để có thể truy xuất được thể hiện duy nhất đó mọi lúc mọi nơi trong chương trình.
         * Sử dụng Singleton khi chúng ta muốn:
         * - Đảm bảo rằng chỉ có một instance của lớp.
         * - Việc quản lý việc truy cập tốt hơn vì chỉ có một thể hiện duy nhất.
         * - Có thể quản lý số lượng thể hiện của một lớp trong giớn hạn chỉ định.
         *
         * Có rất nhiều cách để implement Singleton Pattern. Nhưng dù cho việc implement bằng cách nào đi nữa cũng dựa vào nguyên tắc dưới đây cơ bản dưới đây:
         * - private constructor để hạn chế truy cập từ class bên ngoài.
         * - Đặt private static final variable đảm bảo biến chỉ được khởi tạo trong class.
         * -Có một method public static để return instance được khởi tạo ở trên.
         *
         * một số trường hợp sử dụng của Singleton Pattern thường gặp:
         * - Vì class dùng Singleton chỉ tồn tại 1 Instance (thể hiện) nên nó thường được dùng cho các trường hợp giải quyết các bài toán
         * cần truy cập vào các ứng dụng như: Shared resource, Logger, Configuration, Caching, Thread pool, ...
         * - Một số design pattern khác cũng sử dụng Singleton để triển khai: Abstract Factory, Builder, Prototype, Facade, ...
         * - Đã được sử dụng trong một số class của core java như: java.lang.Runtime, java.awt.Desktop.
         *
         * Những cách nào để implement Singleton Pattern:
         * 1. Eager initialization
         * - Singleton Class được khởi tạo ngay khi được gọi đến. Đây là cách dễ nhất nhưng nó có một nhược điểm mặc dù instance đã được khởi tạo mà có thể sẽ không dùng tới.
         *   Eager initialization là cách tiếp cận tốt, dễ cài đặt, tuy nhiên, nó dễ dàng bị phá vỡ bởi Reflection.
         * 2. Static block initialization
         * - Cách làm tương tự như Eager initialization chỉ khác phần static block cung cấp thêm lựa chọn cho việc handle exception hay các xử lý khác.
         * 3. Lazy Initialization
         * - Là một cách làm mang tính mở rộng hơn so với 2 cách làm trên và hoạt động tốt trong môi trường đơn luồng (single-thread).
         * - Cách này đã khắc phục được nhược điểm của cách Eager initialization, chỉ khi nào getInstance() được gọi thì instance mới được khởi tạo.
         *   Tuy nhiên, cách này chỉ sử dụng tốt trong trường hợp đơn luồng (single-thread), trường hợp nếu có nhiều luồng (multi-thread) cùng chạy và cùng gọi hàm getInstance()
         *   tại cùng một thời điểm thì có thể có nhiều hơn 1 thể hiện của instance. Để khắc phục nhược điểm này chúng ta sử dụng Thread Safe Singleton.
         * - Một nhược điểm nữa của Lazy Initialization cần quan tâm là: đối với thao tác create instance quá chậm thì người dùng có phải chờ lâu cho lần sử dụng đầu tiên.
         * 4. Thread Safe Singleton
         * - Cách đơn giản nhất là chúng ta gọi phương thức synchronized của hàm getInstance() và như vậy hệ thống đảm bảo rằng tại cùng một thời điểm chỉ có thể có 1 luồng
         *   có thể truy cập vào hàm getInstance() và đảm bảo rằng chỉ có duy nhất 1 thể hiện của class. Cách này có nhược điểm là một phương thức synchronized sẽ chạy rất chậm và tốn hiệu năng,
         *   bất kỳ Thread nào gọi đến đều phải chờ nếu có một Thread khác đang sử dụng.
         * 5. Double Check Locking Singleton
         * - Để implement theo cách này, chúng ta sẽ kiểm tra sự tồn tại thể hiện của lớp, với sự hổ trợ của đồng bộ hóa, hai lần trước khi khởi tạo. Phải khai báo volatile cho instance
         *   để tránh lớp làm việc không chính xác do quá trình tối ưu hóa của trình biên dịch.
         * 6. Bill Pugh Singleton Implementation
         * - Với cách làm này bạn sẽ tạo ra static nested class với vai trò 1 Helper khi muốn tách biệt chức năng cho 1 class function rõ ràng hơn. Đây là cách thường hay được sử dụng và có hiệu suất tốt (theo các chuyên gia đánh giá)
         * - Khi Singleton được tải vào bộ nhớ thì SingletonHelper chưa được tải vào. Nó chỉ được tải khi và chỉ khi phương thức getInstance() được gọi. Với cách này tránh được lỗi cơ chế khởi tạo instance của Singleton trong Multi-Thread,
         *   performance cao do tách biệt được quá trình xử lý. Do đó, cách làm này được đánh giá là cách triển khai Singleton nhanh và hiệu quả nhất.
         * 7. Phá vỡ cấu trúc Singleton Pattern bằng Reflection
         * - Reflection có thể được dùng để phá vỡ Pattern của Eager Initialization ở trên. Tương tự Eager Initialization, implement theo Bill Pugh Singleton cũng bị break bởi Reflection.
         * 8. Enum Singleton
         * - Khi dùng enum thì các params chỉ được khởi tạo 1 lần duy nhất, đây cũng là cách giúp bạn tạo ra Singleton instance.
         * - Enum có thể sử dụng như một Singleton, nhưng nó có nhược điểm là không thể extends từ một lớp được, nên khi sử dụng cần xem xét vấn đề này.
         * - Hàm constructor của enum là lazy, nghĩa là khi được sử dụng mới chạy hàm khởi tạo và nó chỉ chạy duy nhất một lần. Nếu muốn sử dụng như một eager singleton thì cần gọi thực thi trong một static block khi start chương trình.
         * - So sánh giữa 2 cách sử dụng enum initialization và static block initialization method, enum có một điểm rất mạnh khi giải quyết về vấn đề Serialization/ Deserialization.
         * 9. Serialization and Singleton
         * - Đôi khi trong các hệ thống phân tán (distributed system), chúng ta cần implement interface Serializable trong lớp Singleton để chúng ta có thể lưu trữ trạng thái của nó trong file hệ thống và truy xuất lại nó sau.
         */
    }
}

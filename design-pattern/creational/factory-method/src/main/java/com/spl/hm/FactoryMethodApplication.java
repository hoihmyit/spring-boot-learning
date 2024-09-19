package com.spl.hm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Hôih My
 * Gitlab: https://gitlab.com/my.hoih
 * @since 04/05/2021
 * <p>
 * Factory Method: Creates an instance of several derived classes
 */
@SpringBootApplication
public class FactoryMethodApplication {
    public static void main(String[] args) {
        SpringApplication.run(FactoryMethodApplication.class, args);
    }

    /**
     * Ví dụ: Tất cả hệ thống ngân hàng có cung cấp API để truy cập đến hệ thống của họ. Team được giao nhiệm vụ thiết kế một API để client có thể sử dụng dịch vụ của một ngân hàng bất kỳ.
     * Hiện tại, phía client chỉ cần sử dụng dịch vụ của 2 ngân hàng là VietcomBank và TPBank.
     * Tuy nhiên để dễ mở rộng sau này, và phía client mong muốn không cần phải thay đổi code của họ khi cần sử dụng thêm dịch vụ của ngân hàng khác.
     * Với yêu cầu như vậy, chúng ta có thể sử dụng một Pattern phù hợp là Factory Method Pattern.
     *
     * Chương trình được cài đặt theo Factory Pattern như sau:
     * Supper Class: public interface Bank: String getBankName();
     * Sub Classes: public class TPBank implements Bank và public class VietcomBank implements Bank.
     * Factory class: public class BankFactory.
     * Bank type: public enum BankType.
     * Client: public class Client.
     */
}

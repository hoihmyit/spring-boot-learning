package com.spl.hm;

import com.spl.hm.builderImmutable.BankAccount;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Hôih My
 * Gitlab: https://gitlab.com/my.hoih
 * @since 06/05/2021
 * <p>
 * Builder: Separates object construction from its representation
 */
@SpringBootApplication
public class BuilderPatternApplication {
    public static void main(String[] args) {

        // Ví dụ: sử dụng Builder cho việc gọi món tại một cửa hàng thức ăn nhanh.
        Order order = new FastFoodOrderBuilder()
                .orderType(OrderType.ON_SITE).orderBread(BreadType.OMELETTE)
                .orderSauce(SauceType.SOY_SAUCE).build();
        System.out.println(order);
        // Order{orderType=ON_SITE, breadType=OMELETTE, sauceType=SOY_SAUCE, vegetableType=null}


        // Ví dụ sử dụng Builder để tạo đối tượng Immutable
        BankAccount newAccount = new BankAccount
                .BankAccountBuilder("Hoih My", "0123456789")
                .withEmail("contact.hoih.my@gmail.com")
                .wantNewsletter(true)
                .build();
        System.out.println(newAccount);
        // BankAccount{name='Hoih My', accountNumber='0123456789', address='null', email='contact.hoih.my@gmail.com', newsletter=true, mobileBanking=false}
    }

    /**
     * Ví dụ sử dụng Builder để tạo đối tượng Immutable
     *
     * Một vài điểm quan trọng về implement class Builder:
     * - Tạo một static nested class (đây được gọi là builder class) và copy tất cả các tham số từ class bên ngoài vào.
     * - Chúng ta nên đặt tên class này theo định dạng: [tên class] + Builder. Ví dụ class là BankAccount thì builder class sẽ là BankAccountBuilder.
     * - Class Builder có một hàm khởi tạo public với tất cả các thuộc tính bắt buộc.
     * - Class Builder có các method setter() cho các tham số tùy chọn.
     * - Cung cấp method build() trong Class Builder để trả về đối tượng mà client cần.
     *
     * Ví dụ: Một tài khoản ngân hàng bao gồm các thông tin: Tên chủ tài khoản, số tài khoản, địa chỉ email, nhận thông báo, sử dụng mobile banking.
     * Một tài khoản được tạo phải có tên chủ tài khoản và số tài khoản. Các thông tin khác tùy theo nhu cầu của khách hàng có thể đăng ký sử dụng.
     */
}

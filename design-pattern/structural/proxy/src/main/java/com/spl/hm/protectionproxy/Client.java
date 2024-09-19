package com.spl.hm.protectionproxy;

public class Client {
    public static void main(String[] args) {
        UserService admin = new UserServiceProxy("hmy", "admin");
        admin.load();
        admin.insert();

        UserService customer = new UserServiceProxy("customer", "guest");
        customer.load();
        customer.insert();

        //Output
        //hmy loaded
        //hmy inserted
        //customer loaded
        //Exception in thread "main" java.lang.IllegalAccessError: Access denied
        //	at com.spl.hm.protectionproxy.UserServiceProxy.insert(UserServiceProxy.java:23)
        //	at com.spl.hm.protectionproxy.Client.main(Client.java:11)

        // Khi Client muốn gọi hàm insert(), trong Proxy luôn xác thực quyền của user trước khi thực hiện nó.
    }
}

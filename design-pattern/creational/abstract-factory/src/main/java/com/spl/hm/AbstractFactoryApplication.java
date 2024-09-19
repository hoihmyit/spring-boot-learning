package com.spl.hm;

import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Hôih My
 * Gitlab: https://gitlab.com/my.hoih
 * @since 05/05/2021
 * <p>
 * Abstract Factory: Creates an instance of several families of classes
 */
@SpringBootApplication
public class AbstractFactoryApplication {

    /**
     * Ví dụ: Một công ty đồ nội thất chuyên sản xuất ghế (Chair): ghế nhựa (PlasticChair) và ghế gỗ (WoodChair).
     * Với tình hình kinh doanh ngày càng thuận thợi nên công ty quyết định mở rộng thêm sản xuất bàn (Table).
     * Với lợi thế là đã có kinh nghiệm từ sản xuất ghế nên công ty vẫn giữ chất liệu là nhựa (PlasticTable) và gỗ (WoodTable) cho sản xuất bàn.
     * Tuy nhiên, quy trình sản xuất ghế/ bàn theo từng chất liệu (MaterialType) là khác nhau.
     * Nên công ty tách ra là nhà máy (Factory): 1 cho sản xuất vật liệu bằng nhựa (PlasticFactory), 1 cho sản xuất vật liệu bằng gỗ (WoodFactory),
     * nhưng cả 2 đều có thể sản xuất ghế và bàn (FurnitureAbstractFactory). Khi khách hàng cần mua một món đồ nào, khách hàng (Client) chỉ cần đến cửa hàng để mua (FurnitureFactory).
     * Khi đó ứng với từng hàng hóa và vật liệu sẽ được chuyển về phân xưởng tương ứng để sản xuất (createXXX) ra bàn (Table) và ghế (Chair).
     * <p>
     * Một Abstract Factory Pattern bao gồm các thành phần cơ bản sau:
     * - AbstractFactory: Khai báo dạng interface hoặc abstract class chứa các phương thức để tạo ra các đối tượng abstract.
     * - ConcreteFactory: Xây dựng, cài đặt các phương thức tạo các đối tượng cụ thể.
     * - AbstractProduct: Khai báo dạng interface hoặc abstract class để định nghĩa đối tượng abstract.
     * - Product: Cài đặt của các đối tượng cụ thể, cài đặt các phương thức được quy định tại AbstractProduct.
     * - Client: là đối tượng sử dụng AbstractFactory và các AbstractProduct.
     * <p>
     * Super Factory Class: FurnitureFactory
     * AbstractFactory: FurnitureAbstractFactory
     * ConcreteFactory: PlasticFactory and WoodFactory
     * AbstractProduct: Chair, Table
     * Product: PlasticChair, WoodChair, PlasticTable, WoodTable
     * Material type: MaterialType (PLASTIC, WOOD)
     * Client: AbstractFactoryApplication
     */

    public static void main(String[] args) {
        FurnitureAbstractFactory plasticFactory = FurnitureFactory.getFactory(MaterialType.PLASTIC);

        Chair plasticChair = plasticFactory.createChair();
        plasticChair.create(); // Create plastic chair!

        Table plasticTable = plasticFactory.createTable();
        plasticTable.create(); // Create plastic table!

        FurnitureAbstractFactory woodFactory = FurnitureFactory.getFactory(MaterialType.WOOD);

        Chair woodChair = woodFactory.createChair();
        woodChair.create(); // Create wood chair!

        Table woodTable = woodFactory.createTable();
        woodTable.create(); // Create wood table!
    }
}

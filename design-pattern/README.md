# Design Patterns

* Refer:
    - `https://sourcemaking.com/design_patterns`
    - `https://gpcoder.com/category/design-pattern/`

### Design pattern là gì?

* Design pattern là các giải pháp tổng thể đã được tối ưu hóa, được tái sử dụng cho các vấn đề phổ biến trong thiết kế
  phần mềm mà chúng ta thường gặp phải hàng ngày. Đây là tập các giải pháp đã được suy nghĩ, đã giải quyết trong tình
  huống cụ thể.

### Design pattern có tác dụng gì?

* Nó giúp bạn giải quyết vấn đề một cách tối ưu nhất, cung cấp cho bạn các giải pháp trong lập trình hướng đối tượng (
  Object Oriented Programing - OOP). Nó có thể được áp dụng trong hầu hết các ngôn ngữ lập trình OOP như: PHP, C#, Java,
  Python và nhiều ngôn ngữ khác.

### Tại sao phải sử dụng Design Pattern?

* Giúp sản phẩm của chúng ta linh hoạt, dễ dàng thay đổi và bảo trì hơn.
* Có một điều luôn xảy ra trong phát triển phần mềm, đó là sự thay đổi về yêu cầu. Lúc này hệ thống phình to, các tính
  năng mới được thêm vào trong khi performance cần được tối ưu hơn.
* Design pattern cung cấp những giải pháp đã được tối ưu hóa, đã được kiểm chứng để giải quyết các vấn đề trong software
  engineering. Các giải pháp ở dạng tổng quát, giúp tăng tốc độ phát triển phần mềm bằng cách đưa ra các mô hình test,
  mô hình phát triển đã qua kiểm nghiệm.
* Những lúc khi bạn gặp bất kỳ khó khăn đối với những vấn đề đã được giải quyết rồi, design patterns là hướng đi giúp
  bạn giải quyết vấn đề thay vì tự tìm kiếm giải pháp tốn kém thời gian.
* Giúp cho các lập trình viên có thể hiểu code của người khác một cách nhanh chóng (có thể hiểu là các mối quan hệ giữa
  các module chẳng hạn). Mọi thành viên trong team có thể dễ dàng trao đổi với nhau để cùng xây dựng dự án mà không tốn
  nhiều thời gian.

### Để học Design Pattern cần có gì?

* Design Pattern sử dụng nền tảng của lập trình hướng đối tượng nên áp dụng 4 đặc tính của OOP: Kế Thừa (Inheritance),
  Đa Hình (Polymorphism), Trừu Tượng (Abstraction), Đóng Gói (Encapsulation).
* Hiểu và ap dụng 3 khái niệm: abstract và interface.

# Phân loại

## Creational Patterns

### Factory Method

* Nhiệm vụ của Factory Pattern là quản lý và trả về các đối tượng theo yêu cầu, giúp cho việc khởi tạo đổi tượng một
  cách linh hoạt hơn.
* Chúng ta tạo đối tượng mà không để lộ logic tạo đối tượng ở phía người dùng và tham chiếu đến đối tượng mới được tạo
  ra bằng cách sử dụng một interface chung.
* Factory Pattern được sử dụng khi có một class cha (super-class) với nhiều class con (sub-class), dựa trên đầu vào và
  phải trả về 1 trong những class con đó.

#### Một Factory Pattern bao gồm các thành phần cơ bản sau:

* Super Class: môt supper class trong Factory Pattern có thể là một interface, abstract class hay một class thông
  thường.
* Sub Classes: các sub class sẽ implement các phương thức của supper class theo nghiệp vụ riêng của nó.
* Factory Class: một class chịu tránh nhiệm khởi tạo các đối tượng sub class dựa theo tham số đầu vào. Lưu ý: lớp này là
  Singleton hoặc cung cấp một public static method cho việc truy xuất và khởi tạo đối tượng. Factory class sử dụng
  if-else hoặc switch-case để xác định class con đầu ra.

#### Lợi ích của Factory Pattern là gì?

* Factory Pattern giúp giảm sự phụ thuộc giữa các module: cung cấp 1 hướng tiếp cận với Interface thay thì các
  implement. Giúp chuơng trình độc lập với những lớp cụ thể mà chúng ta cần tạo 1 đối tượng, code ở phía client không bị
  ảnh hưởng khi thay đổi logic ở factory hay sub class.
* Mở rộng code dễ dàng hơn: khi cần mở rộng, chỉ việc tạo ra sub class và implement thêm vào factory method.
* Khởi tạo các Objects mà che giấu đi xử lí logic của việc khởi tạo đấy. Người dùng không biết logic thực sực được khởi
  tạo bên dưới phương thức factory.
* Dễ dạng quản lý life cycle của các Object được tạo bởi Factory Pattern.
* Thống nhất về naming convention: giúp cho các developer có thể hiểu về cấu trúc source code.

### Abstract Factory

* Abstract Factory pattern là phương pháp tạo ra một Super-factory dùng để tạo ra các Factory khác. Hay còn được gọi là
  Factory của các Factory. Abstract Factory Pattern là một Pattern cấp cao hơn so với Factory Method Pattern.
* Trong Abstract Factory pattern, một interface có nhiệm vụ tạo ra một Factory của các object có liên quan tới nhau mà
  không cần phải chỉ ra trực tiếp các class của object. Mỗi Factory được tạo ra có thể tạo ra các object bằng phương
  pháp giống như Factory pattern.
* Hãy tưởng tượng, Abstract factory như là một nhà máy lớn chứa nhiều nhà máy nhỏ, trong các nhà máy đó có những xưởng
  sản xuất, các xưởng đó tạo ra những sản phẩm khác nhau.

#### Lợi ích của Abstract Factory Pattern là gì?

* Các lợi ích của Factory Pattern cũng tương tự như Factory Method Pattern như: cung cấp hướng tiếp cận với Interface
  thay thì các implement, che giấu sự phức tạp của việc khởi tạo các đối tượng với người dùng (client), độc lập giữa
  việc khởi tạo đối tượng và hệ thống sử dụng,...
* Giúp tránh được việc sử dụng điều kiện logic bên trong Factory Pattern. Khi một Factory Method lớn (có quá nhiều sử lý
  if-else hay switch-case), chúng ta nên sử dụng theo mô hình Abstract Factory để dễ quản lý hơn (cách phân chia có thể
  là gom nhóm các sub-class cùng loại vào một Factory).
* Abstract Factory Pattern là factory của các factory, có thể dễ dạng mở rộng để chứa thêm các factory và các sub-class
  khác.
* Dễ dàng xây dựng một hệ thống đóng gói (encapsulate): sử dụng được với nhiều nhóm đối tượng (factory) và tạo nhiều
  product khác nhau.

### Builder

* Builder pattern là mẫu thiết kế đối tượng được tạo ra để xây dựng một đôi tượng phức tạp bằng cách sử
  dụng các đối tượng đơn giản và sử dụng tiếp cận từng bước, việc xây dựng các đối tượng đôc lập với
  các đối tượng khác.
* Builder Pattern được xây dựng để khắc phục một số nhược điểm của Factory Pattern và Abstract Factory Pattern khi mà
  Object có nhiều thuộc tính.
* Có ba vấn đề chính với Factory Pattern và Abstract Factory Pattern khi Object có nhiều thuộc tính:
    - Quá nhiều tham số phải truyền vào từ phía client tới Factory Class.
    - Một số tham số có thể là tùy chọn nhưng trong Factory Pattern, chúng ta phải gửi tất cả tham số, với tham số tùy
      chọn nếu không nhập gì thì sẽ truyền là null.
    - Nếu một Object có quá nhiều thuộc tính thì việc tạo sẽ phức tạp.
* Chúng ta có thể xử lý những vấn đề này với một số lượng lớn các tham số bằng việc cung cấp một hàm khởi tạo với những
  tham số bắt buộc và các method getter/ setter để cài đặt các tham số tùy chọn. Vấn đề với hướng tiếp cận này là trạng
  thái của Object sẽ không nhất quán cho tới khi tất cả các thuộc tính được cài đặt một cách rõ ràng. Nếu cần xây dựng
  một đối tượng Immutable thì cách này cũng không thể thực hiện được.

#### Lợi ích của Builder Pattern là gì?

* Hỗ trợ, loại bớt việc phải viết nhiều constructor.
* Code dễ đọc, dễ bảo trì hơn khi số lượng thuộc tính (propery) bắt buộc để tạo một object từ 4 hoặc 5 propery.
* Giảm bớt số lượng constructor, không cần truyền giá trị null cho các tham số không sử dụng.
* Ít bị lỗi do việc gán sai tham số khi mà có nhiều tham số trong constructor: bởi vì người dùng đã biết được chính xác
  giá trị gì khi gọi phương thức tương ứng.
* Đối tượng được xây dựng an toàn hơn: bởi vì nó đã được tạo hoàn chỉnh trước khi sử dụng.
* Cung cấp cho bạn kiểm soát tốt hơn quá trình xây dựng: chúng ta có thể thêm xử lý kiểm tra ràng buộc trước khi đối
  tượng được trả về người dùng.
* Có thể tạo đối tượng immutable.
* Một số ví dụ sử dụng Builder Pattern trong JDK: java.lang.`StringBuilder`.append() và java.lang.`StringBuffer`
  .append().

#### Nhược điểm của Builder Pattern là gì?

* Nhược điểm là duplicate code khá nhiều: do cần phải copy tất cả các thuộc tính từ class Product sang class Builder.
* Tăng độ phức tạp của code (tổng thể) do số lượng class tăng lên.

#### Sử dụng Builder Pattern khi nào?

* Tạo một đối tượng phức tạp: có nhiều thuộc tính (nhiều hơn 4) và một số bắt buộc, một số không bắt buộc.
* Khi có quá nhiều hàm constructor, bạn nên nghĩ đến Builder.
* Muốn tách rời quá trình xây dựng một đối tượng phức tạp từ các phần tạo nên đối tượng.
* Muốn kiểm soát quá trình xây dựng.
* Khi người dùng (client) mong đợi nhiều cách khác nhau cho đối tượng được xây dựng.
* `Factory/ Abstract Factory Pattern` là câu trả lời cho **"WHAT"** và `Builder Pattern` là câu trả lời cho **"HOW"**.

### Prototype

### Singleton

## Structural Patterns

### Adapter

* Adapter Pattern là một trong những Pattern thuộc nhóm cấu trúc (Structural Pattern). Nó cho phép các inteface (giao
  diện)
  không liên quan tới nhau có thể làm việc cùng nhau. Đối tượng giúp kết nối các interface gọi là Adapter.
* Adapter Pattern giữ vai trò trung gian giữa hai lớp, chuyển đổi interface của một hay nhiều lớp có sẵn thành một
  interface khác, thích hợp cho lớp đang viết. Điều này cho phép các lớp có các interface khác nhau có thể dễ dàng giao
  tiếp tốt với nhau thông qua interface trung gian, không cần thay đổi code của lớp có sẵn cũng như lớp đang viết.
* Adapter Pattern còn gọi là Wrapper Pattern do cung cấp một interface “bọc ngoài” tương thích cho một hệ thống có sẵn,
  có dữ liệu và hành vi phù hợp nhưng có interface không tương thích với lớp đang viết.
* Ví dụ:
    - Cái phích cắm điện có 3 chân nhưng ổ điện chỉ có 2 lỗ thì phải dùng thêm 1 cái bộ chuyển để chuyển từ 3 chân sang
      2 chân bộ chuyển này cũng được gọi là Adapter.
    - Một ví dụ khác là laptop không sử dụng nguồn điện xoay chiều 224V, nên để laptop có thể sử dụng được nguồn điện
      224V cần có một adapter làm cầu nối trung gian để chuyển nguồn điện xoay chiều 224V thành nguồn điện 1 chiều 12V.

#### Một Adapter Pattern bao gồm các thành phần cơ bản sau:

* Adaptee: định nghĩa interface không tương thích, cần được tích hợp vào.
* Adapter: lớp tích hợp, giúp interface không tương thích tích hợp được với interface đang làm việc. Thực hiện việc
  chuyển đổi interface cho Adaptee và kết nối Adaptee với Client.
* Target: một interface chứa các chức năng được sử dụng bởi Client (domain specific).
* Client: lớp sử dụng các đối tượng có interface Target.

#### Cài đặt Adapter Pattern như thế nào?

* Có hai cách để thực hiện Adapter Pattern dựa theo cách cài đặt (implement) của chúng:
    - Object Adapter – Composition (Chứa trong): trong mô hình này, một lớp mới (Adapter) sẽ tham chiếu đến một (hoặc
      nhiều)
      đối tượng của lớp có sẵn với interface không tương thích (Adaptee), đồng thời cài đặt interface mà người dùng mong
      muốn (Target). Trong lớp mới này, khi cài đặt các phương thức của interface người dùng mong muốn, sẽ gọi phương
      thức cần thiết thông qua đối tượng thuộc lớp có interface không tương thích.
    - Class Adapter – Inheritance (Kế thừa) : trong mô hình này, một lớp mới (Adapter) sẽ kế thừa lớp có sẵn với
      interface không tương thích (Adaptee), đồng thời cài đặt interface mà người dùng mong muốn (Target). Trong lớp
      mới, khi cài đặt các phương thức của interface người dùng mong muốn, phương thức này sẽ gọi các phương thức cần
      thiết mà nó thừa kế được từ lớp có interface không tương thích.
* So sánh Class Adapter với Object Adapter:
    - Sự khác biệt chính là Class Adapter sử dụng Inheritance (kế thừa) để kết nối Adapter và Adaptee trong khi Object
      Adapter sử dụng Composition (chứa trong) để kết nối Adapter và Adaptee.
    - Trong cách tiếp cận Class Adapter, nếu một Adaptee là một class và không phải là một interface thì Adapter sẽ là
      một lớp con của Adaptee. Do đó, nó sẽ không phục vụ tất cả các lớp con khác theo cùng một cách vì Adapter là một
      lớp phụ cụ thể của Adaptee.
* Tại sao Object Adapter lại tốt hơn?
    - Nó sử dụng Composition để giữ một thể hiện của Adaptee, cho phép một Adapter hoạt động với nhiều Adaptee nếu cần
      thiết.

#### Lợi ích của Adapter Pattern là gì?

* Cho phép nhiều đối tượng có interface giao tiếp khác nhau có thể tương tác và giao tiếp với nhau.
* Tăng khả năng sử dụng lại thư viện với interface không thay đổi do không có mã nguồn.

* Bên cạnh những lợi ích trên, nó cũng nó một số khuyết điểm nhỏ sau:
    - Tất cả các yêu cầu được chuyển tiếp, do đó làm tăng thêm một ít chi phí.
    - Đôi khi có quá nhiều Adapter được thiết kế trong một chuỗi Adapter (chain) trước khi đến được yêu cầu thực sự.

#### Sử dụng Adapter Pattern khi nào?

* Adapter Pattern giúp nhiều lớp có thể làm việc với nhau dễ dàng mà bình thường không thể. Một trường hợp thường gặp
  phải và có thể áp dụng Adapter Pattern là khi không thể kế thừa lớp A, nhưng muốn một lớp B có những xử lý tương tự
  như lớp A. Khi đó chúng ta có thể cài đặt B theo Object Adapter, các xử lý của B sẽ gọi những xử lý của A khi cần.
* Khi muốn sử dụng một lớp đã tồn tại trước đó nhưng interface sử dụng không phù hợp như mong muốn.
* Khi muốn tạo ra những lớp có khả năng sử dụng lại, chúng phối hợp với các lớp không liên quan hay những lớp không thể
  đoán trước được và những lớp này không có những interface tương thích.
* Cần phải có sự chuyển đổi interface từ nhiều nguồn khác nhau.
* Khi cần đảm bảo nguyên tắc Open/Close trong một ứng dụng.

* Một vài class sử dụng Adapter Pattern:
    - java.util.Arrays#asList()
    - java.io.InputStreamReader(InputStream) (returns a Reader)
    - java.io.OutputStreamWriter(OutputStream) (returns a Writer)
    - javax.xml.bind.annotation.adapters.XmlAdapter#marshal() và #unmarshal()

### Bridge

* Ý tưởng của nó là tách tính trừu tượng (abstraction) ra khỏi tính hiện thực (implementation) của nó. Từ đó có thể dễ
  dàng chỉnh sửa hoặc thay thế mà không làm ảnh hưởng đến những nơi có sử dụng lớp ban đầu. Điều đó có nghĩa là, ban đầu
  chúng ta thiết kế một class với rất nhiều xử lý, bây giờ chúng ta không muốn để những xử lý đó trong class đó nữa. Vì
  thế, chúng ta sẽ tạo ra một class khác và move các xử lý đó qua class mới. Khi đó, trong lớp cũ sẽ giữ một đối tượng
  thuộc về lớp mới, và đối tượng này sẽ chịu trách nhiệm xử lý thay cho lớp ban đầu.
* Bridge Pattern khá giống với mẫu Adapter Pattern ở chỗ là sẽ nhờ vào một lớp khác để thực hiện một số xử lý nào đó.
  Tuy nhiên, ý nghĩa và mục đích sử dụng của hai mẫu thiết kế này hoàn toàn khác nhau:
    - Adapter Pattern hay còn gọi là Wrapper pattern được dùng để biến đổi một class/ interface sang một dạng khác có
      thể sử dụng được. Adapter Pattern giúp các lớp không tương thích hoạt động cùng nhau mà bình thường là không thể.
    - Bridge Pattern được sử dụng được sử dụng để tách thành phần trừu tượng (abstraction) và thành phần thực thi (
      implementation) riêng biệt.
    - Adapter Pattern làm cho mọi thứ có thể hoạt động với nhau sau khi chúng đã được thiết kế (đã tồn tại). Bridge
      Pattern nên được thiết kế trước khi phát triển hệ thống để Abstraction và Implementation có thể thực hiện một cách
      độc lập.

#### Một Bridge Pattern bao gồm các thành phần sau:

* Client: đại diện cho khách hàng sử dụng các chức năng thông qua Abstraction.
* Abstraction : định ra một abstract interface quản lý việc tham chiếu đến đối tượng hiện thực cụ thể (Implementor).
* Refined Abstraction (AbstractionImpl) : hiện thực (implement) các phương thức đã được định ra trong Abstraction bằng
  cách sử dụng một tham chiếu đến một đối tượng của Implementer.
* Implementor : định ra các interface cho các lớp hiện thực. Thông thường nó là interface định ra các tác vụ nào đó của
  Abstraction.
* ConcreteImplementor : hiện thực Implementor interface.

#### Lợi ích của Bridge Pattern là gì?

* Giảm sự phục thuộc giữa abstraction và implementation (loose coupling): tính kế thừa trong OOP thường gắn chặt
  abstraction và implementation lúc build chương trình. Bridge Pattern có thể được dùng để cắt đứt sự phụ thuộc này và
  cho phép chúng ta chọn implementation phù hợp lúc runtime.
* Giảm số lượng những lớp con không cần thiết: một số trường hợp sử dụng tính inheritance sẽ tăng số lượng subclass rất
  nhiều.
* Code sẽ gọn gàn hơn và kích thước ứng dụng sẽ nhỏ hơn: do giảm được số class không cần thiết.
* Dễ bảo trì hơn: các Abstraction và Implementation của nó sẽ dễ dàng thay đổi lúc runtime cũng như khi cần thay đổi
  thêm bớt trong tương lai.
* Dễ dàng mở rộng về sau: thông thường các ứng dụng lớn thường yêu cầu chúng ta thêm module cho ứng dụng có sẵn nhưng
  không được sửa đổi framework/ứng dụng có sẵn vì các framework/ứng dụng đó có thể được công ty nâng cấp lên version
  mới. Bridge Pattern sẽ giúp chúng ta trong trường hợp này.
* Cho phép ẩn các chi tiết implement từ client: do abstraction và implementation hoàn toàn độc lập nên chúng ta có thể
  thay đổi một thành phần mà không ảnh hưởng đến phía Client.

#### Sử dụng Bridge Pattern khi nào?

* Khi bạn muốn tách ràng buộc giữa Abstraction và Implementation, để có thể dễ dàng mở rộng độc lập nhau.
* Cả Abstraction và Implementation của chúng nên được mở rộng bằng subsclass.
* Sử dụng ở những nơi mà những thay đổi được thực hiện trong implement không ảnh hưởng đến phía client.

### Composite

* Composite Pattern là một sự tổng hợp những thành phần có quan hệ với nhau để tạo ra thành phần lớn hơn. Nó cho phép
  thực hiện các tương tác với tất cả đối tượng trong mẫu tương tự nhau.
* Composite Pattern được sử dụng khi chúng ta cần xử lý một nhóm đối tượng tương tự theo cách xử lý 1 object. Composite
  pattern sắp xếp các object theo cấu trúc cây để diễn giải 1 phần cũng như toàn bộ hệ thống phân cấp. Pattern này tạo
  một lớp chứa nhóm đối tượng của riêng nó. Lớp này cung cấp các cách để sửa đổi nhóm của cùng 1 object. Pattern này cho
  phép Client có thể viết code giống nhau để tương tác với composite object này, bất kể đó là một đối tượng riêng lẻ hay
  tập hợp các đối tượng.

#### Cài đặt Composite Pattern như thế nào?

* Một Composite Pattern bao gồm các thành phần cơ bản sau:
    - Base Component : là một interface hoặc abstract class quy định các method chung cần phải có cho tất cả các thành
      phần tham gia vào mẫu này.
    - Leaf : là lớp hiện thực (implements) các phương thức của Component. Nó là các object không có con.
    - Composite : lưu trữ tập hợp các Leaf và cài đặt các phương thức của Base Component. Composite cài đặt các phương
      thức được định nghĩa trong interface Component bằng cách ủy nhiệm cho các thành phần con xử lý.
    - Client: sử dụng Base Component để làm việc với các đối tượng trong Composite.

#### Lợi ích của Composite Pattern là gì?

* Cung cấp cùng một cách sử dụng đối với từng đối tượng riêng lẻ hoặc nhóm các đối tượng với nhau.

#### Sử dụng Composite Pattern khi nào?

* Composite Pattern chỉ nên được áp dụng khi nhóm đối tượng phải hoạt động như một đối tượng duy nhất (theo cùng một
  cách).
* Composite Pattern có thể được sử dụng để tạo ra một cấu trúc giống như cấu trúc cây.

### Data Access Object (DAO)

* DAO Pattern được sử dụng để phân tách logic lưu trữ dữ liệu trong một lớp riêng biệt. Theo cách này, các service được
  che dấu về cách các hoạt động cấp thấp để truy cập cơ sở dữ liệu được thực hiện.
* Nó còn được gọi là nguyên tắc Tách logic (Separation of Logic).
* Ý tưởng là thay vì có logic giao tiếp trực tiếp với cơ sở dữ liệu, hệ thống file, dịch vụ web hoặc bất kỳ cơ chế lưu
  trữ nào mà ứng dụng cần sử dụng, chúng ta sẽ để logic này sẽ giao tiếp với lớp trung gian DAO. Lớp DAO này sau đó giao
  tiếp với hệ thống lưu trữ, hệ quản trị CSDL như thực hiện các công việc liên quan đến lưu trữ và truy vấn dữ liệu (tìm
  kiếm, thêm, xóa, sửa,...).
* DAO Pattern dựa trên các nguyên tắc thiết kế abstraction và encapsulation. Nó bảo vệ phần còn lại của ứng dụng khỏi
  mọi thay đổi trong lớp lưu trữ, ví dụ: thay đổi database từ Oracle sang MySQL, thay đổi công nghệ lưu trữ từ file sang
  database.
* Trong Java, DAO được triển khai theo nhiều cách khác nhau như Java Persistence API, Enterprise Java Bean (EJP),
  Object-relational mapping (ORM) với các implement cụ thể như Hibernate, iBATIS, Spring JPA,...

#### Cài đặt DAO Pattern như thế nào?

* Các thành phần tham gia mẫu Data Access Object (DAO) Pattern:
    - BusinessObject: đại diện cho Client, yêu cầu truy cập vào nguồn dữ liệu để lấy và lưu trữ dữ liệu.
    - DataAccessObject (DAO): là một interface định nghĩa các phương thức trừu tượng việc triển khai truy cập dữ liệu cơ
      bản cho BusinessObject để cho phép truy cập vào nguồn dữ liệu (DataSource).
    - DataAccessObjectConcrete: cài đặt các phương thức được định nghĩa trong DAO, lớp này sẽ thao tác trực tiếp với
      nguồn dữ liệu (DataSource).
    - DataSource: là nơi chứa dữ liệu, nó có thể là database, xml, json, text file, webservice,...
    - TransferObject: là một POJO (Plain old Java object) object, chứa các phương thức get/set được sử dụng để lưu trữ
      dữ liệu và được sử dụng trong DAO class.

#### Lợi ích của DAO Pattern là gì?

* Giảm sự kết nối (loose coupling) giữa logic nghiệp vụ (Business) và logic lưu trữ (Persistence).
* Mẫu DAO cho phép đóng gói code để thực hiện thao tác CRUD, ngăn chặn việc implement riêng lẻ trong từng phần khác nhau
  của ứng dụng.
* Dễ mở rộng, bảo trì: tất cả các chi tiết lưu trữ được ẩn khỏi phần còn lại của ứng dụng. Do đó, những thay đổi có thể
  được thực hiện bằng cách chỉ sửa đổi một implement của DAO trong khi phần còn lại của ứng dụng không bị ảnh hưởng. DAO
  hoạt động như một trung gian giữa ứng dụng và cơ sở dữ liệu.
* Dễ hiểu: mọi người đều theo một quy chuẩn đã được định sẵn, nên dễ hiểu hơn, tiết kiệm được nhiều thời gian hơn.
* Trong một dự án lớn hơn, các nhóm khác nhau làm việc trên các phần khác nhau của ứng dụng, mẫu DAO cho phép phân tách
  rõ ràng các thành phần này.

#### Sử dụng DAO Pattern khi nào?

* Khi muốn thay đổi nguồn dữ liệu sau này, như chuyển từ cơ dữ liệu MySQL sang Oracle, SQL Server,...
* Khi muốn phân tách rõ ràng các thành phần của ứng dụng.

### Proxy

* Proxy có nghĩa là "ủy quyền" hay "đại diện". Mục đích xây dựng Proxy pattern cũng chính vì muốn tạo ra một đối tượng
  sẽ ủy quyền, thay thế cho một đối tượng khác. Proxy Pattern là mẫu thiết kế mà ở đó tất cả các truy cập trực tiếp đến
  một đối tượng nào đó sẽ được chuyển hướng vào một đối tượng trung gian (Proxy Class). Mẫu Proxy (người đại diện) đại
  diện cho một đối tượng khác thực thi các phương thức, phương thức đó có thể được định nghĩa lại cho phù hợp với mục
  đích sử dụng.

#### Phân loại Proxy

* Virtual Proxy: Tạo ra một đối tượng trung gian mỗi khi có yêu cầu tại thời điểm thực thi ứng dụng, nhờ đó làm tăng
  hiệu suất của ứng dụng.
* Protection Proxy: Phạm vi truy cập của các client khác nhau sẽ khác nhau. Protection proxy sẽ kiểm tra các quyền truy
  cập của client khi có một dịch vụ được yêu cầu.
* Remote Proxy: Client truy cập qua Remote Proxy để chiếu tới một đối tượng được bảo về nằm bên ngoài ứng dụng (trên
  cùng máy hoặc máy khác).
* Monitor Proxy: Monitor Proxy sẽ thiết lập các bảo mật trên đối tượng cần bảo vệ, ngăn không cho client truy cập một số
  trường quan trọng của đối tượng. Có thể theo dõi, giám sát, ghi log việc truy cập, sử dụng đối tượng.
* Firewall Proxy: Bảo vệ đối tượng từ chối các yêu cầu xuất xứ từ các client không tín nhiệm.
* Cache Proxy: Cung cấp không gian lưu trữ tạm thời cho các kết quả trả về từ đối tượng nào đó, kết quả này sẽ được tái
  sử dụng cho các client chia sẻ chung một yêu cầu gửi đến. Loại Proxy này hoạt động tương tự như Flyweight Pattern.
* Smart Reference Proxy: Là nơi kiểm soát các hoạt động bổ sung mỗi khi đối tượng được tham chiếu.
* Synchronization Proxy: Đảm bảo nhiều client có thể truy cập vào cùng một đối tượng mà không gây ra xung đột.
* Copy-On-Write Proxy: Loại này đảm bảo rằng sẽ không có client nào phải chờ vô thời hạn. Copy-On-Write Proxy là một
  thiết kế rất phức tạp.

#### Cài đặt Proxy Pattern như thế nào?

* Proxy Pattern có những đặc điểm chung sau đây:
    - Cung cấp mức truy cập gián tiếp vào một đối tượng.
    - Tham chiếu vào đối tượng đích và chuyển tiếp các yêu cầu đến đối tượng đó.
    - Cả Proxy và đối tượng đích đều kế thừa hoặc thực thi chung một lớp giao diện. Mã máy dịch cho lớp giao diện thường
      “nhẹ” hơn các lớp cụ thể và do đó có thể giảm được thời gian tải dữ liệu giữa server và client.
* Các thành phần tham gia vào mẫu Proxy Pattern:
    - Subject: là một interface định nghĩa các phương thực để giao tiếp với client. Đối tượng này xác định giao diện
      chung cho RealSubject và Proxy để Proxy có thể được sử dụng bất cứ nơi nào mà RealSubject mong đợi.
    - Proxy: là một class sẽ thực hiện các bước kiểm tra và gọi tới đối tượng của class service thật để thực hiện các
      thao tác sau khi kiểm tra. Nó duy trì một tham chiếu đến RealSubject để Proxy có thể truy cập nó. Nó cũng thực
      hiện các giao diện tương tự như RealSubject để Proxy có thể được sử dụng thay cho RealSubject. Proxy cũng điều
      khiển truy cập vào RealSubject và có thể tạo hoặc xóa đối tượng này.
    - RealSubject: là một class service sẽ thực hiện các thao tác thực sự. Đây là đối tượng chính mà proxy đại diện.
    - Client: Đối tượng cần sử dụng RealSubject nhưng thông qua Proxy.

#### Lợi ích của Proxy Pattern là gì?

* Cải thiện Performance thông qua lazy loading, chỉ tải các tài nguyên khi chúng được yêu cầu.
* Nó cung cấp sự bảo vệ cho đối tượng thực từ thế giới bên ngoài.
* Giảm chi phí khi có nhiều truy cập vào đối tượng có chi phí khởi tạo ban đầu lớn.
* Dễ nâng cấp, bảo trì.

#### Sử dụng Proxy Pattern khi nào?

* Khi muốn bảo vệ quyền truy xuất vào các phương thức của object thực.
* Khi cần một số thao tác bổ sung trước khi thực hiện phương thức của object thực.
* Khi tạo đối tượng ban đầu là theo yêu cầu hoặc hệ thống yêu cầu sự chậm trễ khi tải một số tài nguyên nhất định (lazy
  loading).
* Khi có nhiều truy cập vào đối tượng có chi phí khởi tạo ban đầu lớn.
* Khi đối tượng gốc tồn tại trong môi trường từ xa (remote).
* Khi đối tượng gốc nằm trong một hệ thống cũ hoặc thư viện của bên thứ ba.
* Khi muốn theo dõi trạng thái và vòng đời đối tượng.

### Decorator

### Facade

### Flyweight

## Behavioral Patterns

### Interpreter

### Template Method

### Chain of Responsibility

### Command

### Iterator

### Mediator

### Memento

### Observer

### State

### Strategy

### Visitor

Refer: https://gpcoder.com/
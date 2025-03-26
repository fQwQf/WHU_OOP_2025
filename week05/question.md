# week05 作业

## 题目描述

设计一个简单的图书馆管理系统，要求如下：

1. 抽象类和接口：

- 创建一个抽象类 Item，表示图书馆的物品。
  - Item 包含抽象方法 borrow() 和 returnItem()，分别表示借出和归还操作。
  - Item 还包含一个方法 getItemDetails() 来显示物品的详细信息。
- 创建一个接口 Reservable，表示可预约的物品。
  - Reservable 包含方法 reserve()，用于预约物品。

2. 派生类构造函数和父类构造函数的关系：

- 从 Item 类派生出 Book 和 Magazine 类。
  - Book 类包含书名、作者、ISBN 等属性。
  - Magazine 类包含刊名、期号、出版日期等属性。
- 当创建 Book 或 Magazine 对象时，父类 Item 的构造函数应首先被调用。

3. 重写方法（包括协变返回的情况）：

- 在 Book 和 Magazine 类中重写 getItemDetails() 方法，使得 Book 的 getItemDetails() 方法返回 Book 类型，而 Magazine 的 getItemDetails() 方法返回 Magazine 类型。

4. 多态的启用和关闭：

- 在 Item 类中实现一个 final 方法 getIdentifier()，返回物品的唯一标识符（如 title ），不允许子类重写。
- 在 Magazine 类中实现 getPublicationDate() 方法，但允许子类重写。

5. 多态演示：

- 编写一个测试类 LibraryTest，包含一个方法 processItem(Item item)，根据 Item 的具体类型调用 borrow() 和 returnItem() 方法，并显示物品详细信息。
- 演示多态调用时的行为和 final 关键字的效果。
  
## 要求

1. 编写代码并运行，观察输出结果。特别注意构造函数的调用顺序和协变返回类型的效果。
2. 在代码中添加注释，说明每个关键部分的作用和结果。
3. 解释多态的效果，例如在 processItem() 方法中通过父类引用调用具体子类的方法。
4. 测试 final 关键字的效果，尝试在子类中重写 getIdentifier() 方法，并观察编译器的提示。

```java
                       +-------------------------+
                       |         <<abstract>>    |
                       |          Item           |
                       +-------------------------+
                       | - title: String         |
                       +-------------------------+
                       | + Item(String)          |
                       | + borrow(): void        |
                       | + returnItem(): void    |
                       | + getItemDetails(): Item|
                       | + getIdentifier(): String [final]|
                       +-------------------------+
                                ^
                                |
                                |
               +----------------+-----------------+
               |                                  |
               |                                  |
       +------------------+              +------------------------------------+
       |      Book        |              |    Magazine                        |
       +------------------+              +------------------------------------+
       | - author: String |              | - issueNumber: String              |
       | - ISBN: String   |              | - publicationDate: String          |
       +------------------+              +------------------------------------+
       | + Book(String, String, String)  | + Magazine(String, String, String) |
       | + borrow(): void                | + borrow(): void                   |
       | + returnItem(): void            | + returnItem(): void               |
       | + getItemDetails(): Book        | + getItemDetails(): Magazine       |
       | + reserve(): void               | + getPublicationDate(): String     |
       | + getISBN(): String             | + getIssueNumber(): String         |
       +------------------+              +------------------------------------+
                  |
                  +------------------------------------------+
                  |                  <<interface>>           |
                  |                  Reservable              |
                  |                                          |
                  | + reserve(): void                        |
                  +------------------------------------------+
```

```java
// 测试类 LibraryTest
class LibraryTest {
    public static void processItem(Item item) {
        item.borrow();  // 调用多态方法
        item.getItemDetails();  // 调用协变返回类型方法
        item.returnItem();
        
        if (item instanceof Reservable) {
            ((Reservable) item).reserve();
        }

        // 显示物品标识符
        System.out.println(item.getIdentifier());
    }

    public static void main(String[] args) {
        // 创建 Book 对象
        Book book = new Book("The Great Gatsby", "F. Scott Fitzgerald", "1234567890");
        
        // 创建 Magazine 对象
        Magazine magazine = new Magazine("National Geographic", "2022-09", "September 2022");

        System.out.println("\nProcessing Book:");
        processItem(book);  // 处理 Book 对象

        System.out.println("\nProcessing Magazine:");
        processItem(magazine);  // 处理 Magazine 对象

        // 测试 final 方法效果
        System.out.println("\nIdentifier of the book: " + book.getIdentifier());
        System.out.println("Identifier of the magazine: " + magazine.getIdentifier());
    }
}
```

```text
Item constructor called.
Book constructor called.

Processing Book:
Borrowing the book: The Great Gatsby
Book: The Great Gatsby, Author: F. Scott Fitzgerald, ISBN: 1234567890
Returning the book: The Great Gatsby
Reserving the book: The Great Gatsby
Item Identifier: The Great Gatsby

Item constructor called.
Magazine constructor called.

Processing Magazine:
Borrowing the magazine: National Geographic
Magazine: National Geographic, Issue Number: 2022-09, Publication Date: September 2022
Returning the magazine: National Geographic
Item Identifier: National Geographic

Identifier of the book: Item Identifier: The Great Gatsby
Identifier of the magazine: Item Identifier: National Geographic
```

## 提交

1. 各类的代码截图（以此为主）
2. 运行结果截图（辅助证实）

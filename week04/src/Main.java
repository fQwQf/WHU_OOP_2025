//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {
// 创建DynamicArray实例
        DynamicArray dynamicArray = new DynamicArray();

// 添加元素
        dynamicArray.add(1);
        dynamicArray.add(2);
        dynamicArray.add(3);
        System.out.println("After adding elements: ");
        printDynamicArray(dynamicArray);

// 删除元素
        dynamicArray.remove(1); // 删除索引为1的元素，即元素2
        System.out.println("After removing element at index 1: ");
        printDynamicArray(dynamicArray);

// 再次添加元素，观察动态扩容
        dynamicArray.add(4);
        dynamicArray.add(5);
        System.out.println("After adding more elements: ");
        printDynamicArray(dynamicArray);

// 获取并打印特定索引的元素
        System.out.println("Element at index 2: " dynamicArray.get(2));

// 打印当前数组的大小和容量
        System.out.println("Size: " dynamicArray.size());
        System.out.println("Capacity: " dynamicArray.capacity());
    }
}
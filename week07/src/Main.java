import java.util.*;

public class Main {


    public static void main(String[] args) {

        // 初始化数据
        List<Student> students = Arrays.asList(
                new Student(1, "Alice", 85.0, "Computer Science"),
                new Student(2, "Bob", 45.0, "Mathematics"),
                new Student(3, "Charlie", 78.5, "Physics"),
                new Student(4, "David", 59.0, "Computer Science"),
                new Student(5, "Eve", 93.0, "Mathematics"),
                new Student(6, "Frank", 70.0, "Physics"),
                new Student(2, "Duplicate Bob", 45.0, "Mathematics"),
                new Student(7, "Grace", 88.5, "Computer Science")
        );

        // 步骤1：存储并打印初始数据
        System.out.println("Initial List of Students:");
        students.forEach(System.out::println);

        // 步骤2：去重并筛选及格学生
        HashSet<Student> uniqueStudents = new HashSet<>(students);
        HashSet<Student> passed = new HashSet<>();
        for (Student s : uniqueStudents) {
            if (s.getScore() >= 60) passed.add(s);
        }
        System.out.println("\nPassed Students (After Removing Duplicates):");
        passed.forEach(System.out::println);

        // 步骤3：按专业分组
        HashMap<String, List<Student>> grouped = new HashMap<>();
        grouped.put("Computer Science", new ArrayList<Student>());
        grouped.put("Mathematics", new ArrayList<Student>());
        grouped.put("Physics", new ArrayList<Student>());
        for (Student s : uniqueStudents) {
            grouped.get(s.getMajor()).add(s);
        }
        System.out.println("\nStudents Grouped by Major:");
        for (Map.Entry<String, List<Student>> entry : grouped.entrySet()){
            System.out.println("Major: " + entry.getKey());
            for (Student i : entry.getValue()){
                System.out.println(i.toString());
            }
        }

        // 步骤4：计算平均成绩
        System.out.print("\nAverage Score by Major:");
        for (Map.Entry<String, List<Student>> entry : grouped.entrySet()){
            System.out.print("\nMajor: " + entry.getKey() + ", Average Score: ");
            double total = 0;
            for (Student i : entry.getValue()){
                total += i.getScore();
            }
            System.out.print(total/entry.getValue().size());
        }

        // 步骤5：排序
        List<Student> sorted = new ArrayList<>(uniqueStudents);
        sorted.sort(new StudentComparator());
        System.out.println("\n\nStudents Sorted by Score (Descending):");
        sorted.forEach(System.out::println);

        // 步骤6：查找与更新
        Map<Integer, Student> map = new HashMap<>();
        for (Student s : uniqueStudents){
            map.put(s.getId(), s);
        }
        int[] searchIds = {5, 100};
        System.out.println("\nUpdated consequence:");
        for (int id : searchIds) {
            if (map.containsKey(id)) {
                Student s = map.get(id);
                s.setScore(95);
                System.out.println("Updated: " + s);
            } else {
                System.out.println("Student with ID " + id + " not found.");
            }
        }

        // 步骤7：全局统计
        // 要实现降序最简单的方法就是颠倒大小比较，所以这里变成了min
        // 🤣👉🤡
        Student max = Collections.min(uniqueStudents, new StudentComparator());
        int passedCount = 0;
        for (Student s : uniqueStudents){
            if(s.getScore() >= 60){
                passedCount += 1 ;
            }
        }
        System.out.println("\nGlobal Statistics:");
        System.out.println("Highest Scoring Student: " + max);
        System.out.println("Number of Passed Students: " + passedCount);
        System.out.println("Number of Failed Students: " + (uniqueStudents.size() - passedCount));
    }
}
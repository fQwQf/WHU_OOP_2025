import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaTest {

    //-----------------------1.函数式编程-----------------------------------------
    @Test
    public void showFuncProgramming() throws Exception {

        class FuncImpl implements FuncProgramming{

            @Override
            public void dosth() {

            }
        }
        FuncProgramming fp=new FuncImpl();//1

        FuncProgramming fp0=new FuncProgramming(){

            @Override
            public void dosth() {

            }
        };//2
        FuncProgramming funcProgramming = ()-> System.out.println("hello world");//3
        funcProgramming.dosth();
        System.out.println(funcProgramming.getClass().getName());


        System.out.println("================================================");
        showcase(()-> System.out.println("hello world"));


    }

    //template method
    private void showcase(FuncProgramming funcProgramming){
        funcProgramming.dosth();//__
        System.out.println("hello again");
    }

    //-----------------------2.Lambda基本语法-----------------------------------------
    @Test
    public void syntaxLambda() throws Exception {
        int localv=0;
        Syntax01NoArgsNoRet syntax01NoArgsNoRet=
                ()-> System.out.println("hello");



        Syntax02OneArgNoRet syntax02OneArgNoRet= i-> System.out.println(i);
        Syntax02OneArgNoRet syntax02OneArgNoRet2= System.out::println;
//        Syntax02OneArgNoRet syntax02OneArgNoRet3= i->method1(i);
//        Syntax02OneArgNoRet syntax02OneArgNoRet04= this::method1;

        Syntax03MultiArgsNoRet syntax03MultiArgsNoRet = (a,b)-> System.out.println(a+b);
        syntax03MultiArgsNoRet.dosth(1,"abc");

        Syntax04MultiArgsOneRet syntax04MultiArgsOneRet = (a,b)-> {
            System.out.println("hello");
            return String.valueOf(a+b);};
        System.out.println(syntax04MultiArgsOneRet.dosth(1,202));


//        参数类型可以省略，如果需要省略，每个参数的类型都要省略。
//        参数的小括号里面只有一个参数，那么小括号可以省略
//        如果方法体当中只有一句代码，那么大括号可以省略
//        如果方法体中只有一条语句，其是return语句，那么大括号可以省略，且去掉return关键字。


        //类型推断
        //静态方法的使用

        Syntax02OneArgNoRet syntax02OneArgNoRet00= i-> System.out.println(i);//System.out::println;
        Syntax02OneArgNoRet syntax02OneArgNoRet11= i->method1(i);
        Syntax02OneArgNoRet syntax02OneArgNoRet12= this::method1;
        //变量捕获
        Syntax02OneArgNoRet syntax02OneArgNoRet33= i-> System.out.println(localv);
    }
    private void method1(int i){

    }
    private void method2(int i,String s){

    }

    //-----------------------3.Lambda应用方式-----------------------------------------
    @Test
    public void fullUsageLambda() throws Exception {
        //step1 ---------定义函数式接口-----------
//        @FunctionalInterface
//        interface FuncProgramming
//        {
//            void dosth();
//        }

        //step2 ---------定义一个高阶函数，以函数式接口为参数
        // ------类似于 Template Method Design Pattern-----
//        private void showcase(FuncProgramming funcProgramming){
//             template logic
//            funcProgramming.dosth();  ______
//            System.out.println("hello again");
//        }

        //step3 ---------调用上述函数，传递一个Lambda表达式作为参数----------
//        showcase(()-> System.out.println("hello world"));

    }



    //-----------------------4.预定义函数式接口-----------------------------------------
    @Test
    public void predefinedFunctionalInterfacesInJava() throws Exception {

//        java.util.function 包下最基本的四个函数式接口

        //1111111111111111111111111111111111111111111
        Function<Integer,String> function=i-> String.valueOf(i+1);
//        Function<String,Boolean> function1=i-> false;

        Predicate<Integer> predicate=i-> i==10;

        Consumer<Integer> consumer=i-> System.out.println(i);

        Supplier<Integer> supplier=()-> (int)(Math.random()*100);


//      还有很多其他的接口可供使用


    }

    private boolean somefunction(Supplier<Integer> supplier, Predicate<Integer> predicate) {
        return predicate.test(supplier.get());
    }

    private void test(){
        System.out.println(somefunction(() -> (int) (Math.random() * 100), i -> i == 10));
    }

    @Test
    public void test123(){
        System.out.println(validate("abc", s -> s.length() >= 3, s -> s.length() < 5));
    }

    private boolean validate(String s,Predicate<String>... predicate){

        for (Predicate<String> p : predicate) {
            if (!p.test(s)) {
                return false;
            }
        }
        return true;

    }

    //-----------------------5.预定义处理模板-----------类似于Method Template Design Pattern------------------------------
    @Test
    public void predefinedTemplate() throws Exception {
        Consumer<Integer> consumer;

        //比如Stream的foreach


    }

    //-----------------------6.编写一个处理流的完整示例-----------
    List<String> stringList= List.of(new String[]{"abc", "def", "asdfa", "ab928347982347"});
    @Test
    public void dealWithCollections() throws Exception {
        List<String> strings = filterString(s -> s.length() > 3);
        System.out.println(strings);
    }




    private List<String> filterString(Predicate<String> stringPredicate){
        List<String> tmpList = new ArrayList<String>();
        for (String s : stringList) {

            s = s.replaceAll("\\d+", "");
            if (stringPredicate.test(s)){//______
                tmpList.add(s);
            }
        }
        return tmpList;
    }


    //-----------------------6.直接使用Stream API 完成相同的任务-------
    @Test
    public void useStreamAPI(){
        System.out.println(stringList.stream()
                                .filter(s -> s.length() >3)
                                .filter(s -> s.length() >3)
                                .filter(s -> s.length() >3)
                                .filter(s -> s.length() >3)
                .filter(s -> s.replaceAll("\\d+", "").length() > 3)
                .count());
        System.out.println("================");
        stringList.stream().filter(s -> {
            s = s.replaceAll("\\d+", "");
            return s.length() > 3;
        }).forEach(System.out::println);


        System.out.println("================");
        stringList.stream()
                .map(s->s.replaceAll("\\d+", ""))
                .filter(s->s.length()>3)
                .forEach(System.out::println);


    }
}

@FunctionalInterface
interface FuncProgramming
{
    void dosth();
}

@FunctionalInterface
interface Syntax01NoArgsNoRet
{
    void dosth();
}

@FunctionalInterface
interface Syntax02OneArgNoRet
{
    void dosth(int i);
}
@FunctionalInterface
interface Syntax03MultiArgsNoRet
{
    void dosth(int i, String s);
}
@FunctionalInterface
interface Syntax04MultiArgsOneRet
{
    String dosth(int i,int j);
}

@FunctionalInterface
interface Syntax05OneArgOneRet
{
    String dosth(int i);
}



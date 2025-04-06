import java.util.*;

public class StudentComparator implements Comparator<Student>{
    @Override
    public int compare(Student s1, Student s2) {
        if(s1.getScore()==s2.getScore()){
            return s1.getName().compareTo(s2.getName());
        }else{
            return (int)(s2.getScore()-s1.getScore());
        }
    }
}

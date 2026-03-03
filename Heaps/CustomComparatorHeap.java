
import java.util.Arrays;

public class CustomComparatorHeap {
  private static class Student implements Comparable<Student> {
    String s;
    int roll;
    double cgpa;
    Student(String s,int roll,double cgpa){
      this.s=s;
      this.cgpa=cgpa;
      this.roll=roll;
    }
    public String toString(){
      return s+" "+roll+" "+cgpa;
    }
    public int compareTo(Student s){
      // return (int)(this.cgpa-s.cgpa);
      return Double.compare(s.cgpa, this.cgpa);
    }

  }
  public static void main(String[] args) {
    Student s1=new Student("ankesh", 52, 9);
    Student s2=new Student("akash", 8, 7.8);
    Student s3=new Student("vishal", 90, 8);
    Student s4=new Student("vikas", 45, 6);
    Student s5=new Student("pradeep",35,6.8);
    Student[] s={s1,s2,s3,s4,s5};
    // Arrays.sort(s,(a,b)->a.s.compareTo(b.s));
    Arrays.sort(s);
    for (Student student : s) {
      System.out.println(student);
    }
  }
}

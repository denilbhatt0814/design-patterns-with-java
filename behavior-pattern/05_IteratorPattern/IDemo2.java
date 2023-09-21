import java.util.ArrayList;
import java.util.List;

class Student {
    int rollNo;
    String name;
    double percentage;

    public Student(int rn, String n) {
        rollNo = rn;
        name = n;
    }

    public double getPercentage() {
        return percentage;
    }
}

class StudentCollection {
    List<Student> ls = new ArrayList<Student>();

    public void addStudent(Student s) {
        ls.add(s);
    }

    public void removeStudent(Student s) {
        ls.remove(s);
    }

    public StudentIterator getIterator(String choice) {
        if (choice.equalsIgnoreCase("std")) {
            return new StandardIterator();
        } else if (choice.equalsIgnoreCase("%")) {
            return new PercentageIterator();
        }
        return null;
    }

    private class StandardIterator implements StudentIterator {
        int position;

        public boolean hasNext() {
            if (position < ls.size()) {
                return true;
            } else {
                return false;
            }
        }

        public Student next() {
            Student s = ls.get(position);
            position++;
            return s;
        }
    }

    private class PercentageIterator implements StudentIterator {
        int position;

        public boolean hasNext() {
            while (position < ls.size()) {
                Student s = ls.get(position);
                if (s.getPercentage() >= 70) {
                    return true;
                } else {
                    position++;
                }
            }
            return false;
        }

        public Student next() {
            Student s = ls.get(position);
            position++;
            return s;
        }
    }
}

interface StudentIterator {
    public boolean hasNext();

    public Student next();
}

public class IDemo2 {
    public static void main(String[] args) {
        StudentCollection s = new StudentCollection();

        Student s1 = new Student(101, "St1");
        s1.percentage = 80.0;
        Student s2 = new Student(102, "St2");
        s2.percentage = 65.0;
        Student s3 = new Student(103, "St3");
        s3.percentage = 90.0;

        s.addStudent(s1);
        s.addStudent(s2);
        s.addStudent(s3);

        System.out.println("std iterator");
        StudentIterator it = s.getIterator("std");
        while (it.hasNext()) {
            Student st = it.next();
            System.out.println(st.rollNo + " " + st.name + " " + st.percentage);
        }

        it = s.getIterator("%");
        System.out.println("% iterator");
        while (it.hasNext()) {
            Student st = it.next();
            System.out.println(st.rollNo + " " + st.name + " " + st.percentage);
        }
    }
}

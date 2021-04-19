package com.janhen.structures.hashtable;

public class Student {
    int grade;
    int cls;
    String firstName;
    String lastName;

    public Student(int grade, int cls, String fistName, String lastName) {
        this.grade = grade;
        this.cls = cls;
        this.firstName = fistName;
        this.lastName = lastName;
    }

    @Override
    public int hashCode() {
        int B = 31;
        int hash = 0;
        hash = hash * B + grade;
        hash = hash * B + cls;
        hash = hash * B + firstName.toLowerCase().hashCode();            /* 手动控制大小写不敏感 */
        hash = hash * B + firstName.toLowerCase().hashCode();
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;

        if (this.getClass() != o.getClass())
            return false;

        Student another = (Student) o;

        return this.grade == another.grade &&
          this.cls == another.cls &&
          this.firstName.equalsIgnoreCase(another.firstName) &&
          this.lastName.equalsIgnoreCase(another.lastName);
    }
}

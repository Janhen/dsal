package com.janhen.structures.hashTable;

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
    /*
    字符串大小写
     */
    public int hashCode() {
        // carry
        int B = 31;

        int hash = 0;
        hash = hash * B + grade;
        hash = hash * B + cls;
        hash = hash * B + firstName.toLowerCase().hashCode();
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
                this.firstName.toLowerCase().equals(another.firstName.toLowerCase()) &&
                this.lastName.equalsIgnoreCase(another.lastName);
    }
}

package ua.opnu;

import java.util.ArrayList;

class Student {
    private final String name;
    private final int year;
    private final ArrayList<String> courses;

    // Конструктор
    public Student(String name, int year) {
        if (year < 1 || year > 4) {
            throw new IllegalArgumentException("Year must be between 1 and 4");
        }
        this.name = name;
        this.year = year;
        this.courses = new ArrayList<>();
    }

    // Додає дисципліну
    public void addCourse(String courseName) {
        if (courseName != null && !courseName.isEmpty()) {
            courses.add(courseName);
        }
    }

    // Видаляє всі дисципліни
    public void dropAll() {
        courses.clear();
    }

    // Кількість дисциплін
    public int getCourseCount() {
        return courses.size();
    }

    // Ім'я студента
    public String getName() {
        return name;
    }

    // Рік навчання
    public int getYear() {
        return year;
    }

    // Сума грошей за навчання
    public int getTuition() {
        return year * 20000;
    }
}

public class Main {
    public static void main(String[] args) {
        // Створюємо студента
        Student student = new Student("Олександра", 2);

        // Додаємо курси
        student.addCourse("Математика");
        student.addCourse("Програмування");
        student.addCourse("Фізика");

        // Виводимо інформацію
        System.out.println(student.getName() + ": кількість вивчаємих дисциплін - " + student.getCourseCount());
        System.out.println(student.getName() + ": рік навчання - " + student.getYear());
        System.out.println(student.getName() + ": заплатив за навчання - " + student.getTuition());
    }
}


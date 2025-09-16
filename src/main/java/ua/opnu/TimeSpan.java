package ua.opnu;

public class TimeSpan {
    private int hours;
    private int minutes;

    // Конструктор
    TimeSpan(int hours, int minutes) {
        if (hours < 0 || minutes < 0 || minutes > 59) {
            // якщо аргументи неправильні, ставимо 0
            this.hours = 0;
            this.minutes = 0;
        } else {
            this.hours = hours;
            this.minutes = minutes;
        }
    }

    // Повертає тільки години
    int getHours() {
        return hours;
    }

    // Повертає тільки хвилини
    int getMinutes() {
        return minutes;
    }

    // Додає години і хвилини
    void add(int hours, int minutes) {
        if (hours < 0 || minutes < 0 || minutes > 59) {
            // якщо аргументи неправильні, нічого не робимо
            return;
        }

        this.hours += hours;
        this.minutes += minutes;

        // якщо хвилини >= 60, переводимо в години
        if (this.minutes >= 60) {
            this.hours += this.minutes / 60;
            this.minutes = this.minutes % 60;
        }
    }

    // Додає інший інтервал
    void addTimeSpan(TimeSpan timespan) {
        add(timespan.getHours(), timespan.getMinutes());
    }

    // Загальна кількість годин у дробовому вигляді
    double getTotalHours() {
        return hours + minutes / 60.0;
    }

    // Загальна кількість хвилин
    int getTotalMinutes() {
        return hours * 60 + minutes;
    }

    // Віднімає інший інтервал
    void subtract(TimeSpan span) {
        int totalMinutesThis = getTotalMinutes();
        int totalMinutesOther = span.getTotalMinutes();

        if (totalMinutesOther > totalMinutesThis) {
            // якщо віднімати більше, нічого не робимо
            return;
        }

        int diff = totalMinutesThis - totalMinutesOther;
        this.hours = diff / 60;
        this.minutes = diff % 60;
    }

    // Масштабує інтервал у factor разів
    void scale(int factor) {
        if (factor <= 0) {
            // якщо factor <= 0, нічого не робимо
            return;
        }

        int total = getTotalMinutes() * factor;
        this.hours = total / 60;
        this.minutes = total % 60;
    }
}

package algorithm;

import java.util.PriorityQueue;

public class PriorityQueueComparator {
    public static void main(String[] args) {
        PriorityQueue<Person> people = new PriorityQueue<>((o1, o2) -> {
            if (o1.age == o2.age) {
                return o1.name.compareTo(o2.name);
            }

            return o2.age - o1.age;
        });

        people.add(new Person("정홍길", 20));
        people.add(new Person("청정수", 22));
        people.add(new Person("정감수", 20));

        while (!people.isEmpty()) {
            Person cur = people.poll();

            System.out.println(cur);
        }
    }

    private static class Person {
        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                   "name='" + name + '\'' +
                   ", age=" + age +
                   '}';
        }
    }
}

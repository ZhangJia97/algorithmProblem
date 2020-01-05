package 程序员代码面试指南;

import 程序员代码面试指南.Q4.Cat;
import 程序员代码面试指南.Q4.Dog;
import 程序员代码面试指南.Q4.Pet;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zhangjia
 * @title Q4_猫狗队列
 * @date 2020/1/3 20:52
 * @description //todo
 */
public class Q4_猫狗队列 {

    private int dogSize = 0;
    private int catSize = 0;
    private Queue<Pet> queue = new LinkedList<>();

    public void add(Pet pet) {
        if ("cat".equals(pet.getType())) {
            catSize++;
        } else {
            dogSize++;
        }
        queue.add(pet);
    }

    public Pet pollAll() {
        if (isEmpty()) {
            throw new RuntimeException("queue is empty");
        }
        Pet pet = queue.poll();
        if ("cat".equals(pet.getType())) {
            catSize--;
        } else {
            dogSize--;
        }
        return pet;
    }

    private Pet poll(String type) {
        Pet pet = queue.poll();
        if (type.equals(pet.getType())) {
            return pet;
        }
        Pet result = poll(type);
        queue.offer(pet);
        return result;
    }

    public Pet pollDog() {
        if (isDogEmpty()) {
            throw new RuntimeException("dog is empty");
        }
        dogSize--;
        return poll("dog");
    }

    public Pet pollCat() {
        if (isCatEmpty()) {
            throw new RuntimeException("cat is empty");
        }
        catSize--;
        return poll("cat");
    }

    public boolean isEmpty() {
        return catSize + dogSize == 0;
    }

    public boolean isDogEmpty() {
        return dogSize == 0;
    }

    public boolean isCatEmpty() {
        return catSize == 0;
    }

    public static void main(String[] args) {
        Q4_猫狗队列 q4_猫狗队列 = new Q4_猫狗队列();
        Cat cat1 = new Cat("c1");
        Cat cat2 = new Cat("c2");
        Cat cat3 = new Cat("c3");
        Cat cat4 = new Cat("c4");
        Dog dog1 = new Dog("d1");
        Dog dog2 = new Dog("d2");
        Dog dog3 = new Dog("d3");
        Dog dog4 = new Dog("d4");
        q4_猫狗队列.add(cat1);
        System.out.println(q4_猫狗队列.isDogEmpty());
        System.out.println(q4_猫狗队列.isCatEmpty());
        System.out.println(q4_猫狗队列.pollCat());
        System.out.println(q4_猫狗队列.isCatEmpty());
        q4_猫狗队列.add(cat2);
        q4_猫狗队列.add(dog1);
        q4_猫狗队列.add(dog4);
        q4_猫狗队列.add(cat3);
        q4_猫狗队列.add(dog2);
        q4_猫狗队列.add(cat4);
        q4_猫狗队列.add(dog3);
        while (!q4_猫狗队列.isCatEmpty()) {
            System.out.println(q4_猫狗队列.pollCat());
        }
        System.out.println("-------");
        while (!q4_猫狗队列.isDogEmpty()) {
            System.out.println(q4_猫狗队列.pollDog());
        }

    }

}

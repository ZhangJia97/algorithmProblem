package 程序员代码面试指南.Q4;

/**
 * @author zhangjia
 * @title Pet
 * @date 2020/1/3 21:08
 * @description //todo
 */
public class Pet{
    private String type;

    private String name;

    public Pet(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
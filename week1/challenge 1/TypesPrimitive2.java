import java.util.ArrayList;
import java.util.List;

public class TypesPrimitive2 {
    public static void main(String[] args) {
        // Primitive data types
        byte b = 100; // 1 byte
        short s = 10000; // 2 bytes
        int i = 100000; // 4 bytes
        long l = 100000L; // 8 bytes
        float f = 10.5f; // 4 bytes
        double d = 20.5; // 8 bytes
        char c = 'A'; // 2 bytes
        boolean bool = true; // 1 bit

        List<Object> list = new ArrayList<>();
        list.add(b);
        list.add(s);
        list.add(i);
        list.add(l);
        list.add(f);
        list.add(d);
        list.add(c);
        list.add(bool);

        for (Object obj : list) {
            System.out.println("Value: " + obj);
        }

        System.out.println("Byte: " + b);
        System.out.println("Short: " + s);
        System.out.println("Integer: " + i);
        System.out.println("Long: " + l);
        System.out.println("Float: " + f);
        System.out.println("Double: " + d);
        System.out.println("Character: " + c);
        System.out.println("Boolean: " + bool);
    }
}
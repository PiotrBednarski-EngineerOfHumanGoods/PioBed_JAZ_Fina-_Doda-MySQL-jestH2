package pl.pjatk.piobed.zjazd1.component;

import org.springframework.stereotype.Component;

@Component
public class MyFirstComponent {

    public MyFirstComponent() {
        System.out.println("Hello from MyFirstComponent");
    }

    public void printHelloMessage() {
        System.out.println("MyFirstComponent - printHelloMessage");
    }
}

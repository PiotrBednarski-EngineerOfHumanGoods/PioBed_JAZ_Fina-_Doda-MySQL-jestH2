package pl.pjatk.piobed.zjazd1.component;

import org.springframework.stereotype.Component;

@Component
public class MySecondComponent {

    private final MyFirstComponent myFirstComponent;

    public MySecondComponent(MyFirstComponent myFirstComponent) {
        this.myFirstComponent = myFirstComponent;
        System.out.println("Hello from MySecondComponent");
        this.myFirstComponent.printHelloMessage();
    }

    public void printSecondMessage() {
        System.out.println("MySecondComponent - printSecondMessage");
    }
}

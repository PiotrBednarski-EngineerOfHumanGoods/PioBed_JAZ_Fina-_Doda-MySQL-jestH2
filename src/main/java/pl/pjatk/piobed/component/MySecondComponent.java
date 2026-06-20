package pl.pjatk.piobed.component;

import org.springframework.stereotype.Component;

/**
 * Drugi komponent - demonstruje wstrzykiwanie zależności przez konstruktor.
 *
 * Spring widzi że konstruktor wymaga MyFirstComponent, więc najpierw tworzy
 * MyFirstComponent (singleton), a następnie przekazuje go do tego konstruktora.
 *
 * To podstawowy mechanizm DI (Dependency Injection) - klasa nie tworzy zależności
 * sama (new MyFirstComponent()) tylko deklaruje że jej potrzebuje.
 */
@Component
public class MySecondComponent {

    private final MyFirstComponent myFirstComponent;

    public MySecondComponent(MyFirstComponent myFirstComponent) {
        this.myFirstComponent = myFirstComponent;
        System.out.println("Hello from MySecondComponent");
        this.myFirstComponent.printFirstMessage();
    }

    public void printSecondMessage() {
        System.out.println("MySecondComponent - printSecondMessage");
    }
}

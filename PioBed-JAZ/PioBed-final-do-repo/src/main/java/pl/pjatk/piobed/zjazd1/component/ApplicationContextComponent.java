package pl.pjatk.piobed.zjazd1.component;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextComponent implements CommandLineRunner {

    private final ApplicationContext applicationContext;

    public ApplicationContextComponent(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public void run(String... args) {
        MyFirstComponent firstComponent = applicationContext.getBean("myFirstComponent", MyFirstComponent.class);
        MySecondComponent secondComponent = applicationContext.getBean("mySecondComponent", MySecondComponent.class);

        firstComponent.printHelloMessage();
        secondComponent.printSecondMessage();
    }
}

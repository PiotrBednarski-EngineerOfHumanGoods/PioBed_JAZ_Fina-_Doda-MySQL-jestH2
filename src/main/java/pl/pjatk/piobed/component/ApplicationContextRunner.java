package pl.pjatk.piobed.component;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Pobiera beany bezpośrednio z ApplicationContext (kontekstu Springa)
 * zamiast wstrzykiwać je przez konstruktor.
 *
 * To alternatywny (rzadziej używany) sposób dostępu do beana - mamy referencję
 * do całego kontenera i prosimy go o konkretny bean po nazwie / typie.
 *
 * CommandLineRunner.run() uruchamia się raz, po starcie aplikacji.
 */
@Component
public class ApplicationContextRunner implements CommandLineRunner {

    private final ApplicationContext applicationContext;

    public ApplicationContextRunner(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public void run(String... args) {
        MyFirstComponent firstComponent = applicationContext.getBean("myFirstComponent", MyFirstComponent.class);
        MySecondComponent secondComponent = applicationContext.getBean("mySecondComponent", MySecondComponent.class);

        firstComponent.printFirstMessage();
        secondComponent.printSecondMessage();
    }
}

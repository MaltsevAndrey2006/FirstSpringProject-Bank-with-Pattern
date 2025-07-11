package andrey.dev;

import andrey.dev.APP.APP;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ApplicationConfig.class);
        APP app = context.getBean(APP.class);
        app.start();

    }
}
package andrey.dev.APP;

import andrey.dev.Controller.ControllerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class APP {
    private final ControllerService controllerService;

    @Autowired
    public APP(ControllerService controllerService) {
        this.controllerService = controllerService;
    }

    public void start() {
        while (true) {
            controllerService.menu();
        }
    }
}

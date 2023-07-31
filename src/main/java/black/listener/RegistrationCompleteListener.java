package black.listener;

import black.events.RegistrationCompleteEvent;
import org.springframework.context.ApplicationListener;

public class RegistrationCompleteListener implements ApplicationListener<RegistrationCompleteEvent> {


    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        // create verification token
    }
}

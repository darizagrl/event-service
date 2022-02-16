package event;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/events")
public class EventServiceController {

    @PostMapping()
    public ResponseEntity<Event> createEvent() {
        return ResponseEntity.ok(new Event());
    }

}

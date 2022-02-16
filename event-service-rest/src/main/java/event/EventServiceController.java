package event;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController("/events")
public class EventServiceController {

    @PostMapping()
    public ResponseEntity<Event> createEvent() {
        return ResponseEntity.ok(new Event());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Event> updateEvent(@PathVariable String id) {
        return ResponseEntity.ok(new Event());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Event> getEvent(@PathVariable String id) {
        return ResponseEntity.ok(new Event());
    }

    @DeleteMapping("/{id}")
    public String deleteEvent(@PathVariable String id) {
        return "deleted successfully";
    }

    @GetMapping()
    public ResponseEntity<List<Event>> getAllEvents() {
        return ResponseEntity.ok(new ArrayList<>());
    }

    @GetMapping("/titles/{title}")
    public ResponseEntity<List<Event>> getAllEventsByTitle(@PathVariable String title) {
        return ResponseEntity.ok(new ArrayList<>());
    }

}

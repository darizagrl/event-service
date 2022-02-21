package event;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
@RequiredArgsConstructor
public class EventServiceController {

    private final EventService service;

    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<Event> createEvent(@RequestBody Event event) {
        return ResponseEntity.ok(service.createEvent(event));
    }

    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<Event> updateEvent(@PathVariable Integer id, @RequestBody Event event) {
        return ResponseEntity.ok(service.updateEvent(event));
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<Event> getEvent(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getEvent(id));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public HttpStatus deleteEvent(@PathVariable Integer id) {
        service.deleteEvent(id);
        return HttpStatus.NO_CONTENT;
    }

    @GetMapping()
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<List<Event>> getAllEvents() {
        return ResponseEntity.ok(service.getAllEvents());
    }

    @GetMapping()
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<List<Event>> getAllEventsByTitle(@RequestParam String title) {
        return ResponseEntity.ok(service.getAllEventsByTitle(title));
    }

}

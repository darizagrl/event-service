package event;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api
@RestController
@RequestMapping("/events")
@RequiredArgsConstructor
public class EventServiceController {

    private final EventService service;

    @ApiOperation("Create a new event")
    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<Event> createEvent(@RequestBody Event event) {
        return ResponseEntity.ok(service.createEvent(event));
    }

    @ApiOperation("Update an existing event")
    @PutMapping()
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<Event> updateEvent(@RequestBody Event event) {
        return ResponseEntity.ok(service.updateEvent(event));
    }

    @ApiOperation("Get an event by id")
    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<Event> getEvent(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getEvent(id));
    }

    @ApiOperation("Delete an event")
    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public HttpStatus deleteEvent(@PathVariable Integer id) {
        service.deleteEvent(id);
        return HttpStatus.NO_CONTENT;
    }

    @ApiOperation("Get all events")
    @GetMapping()
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<List<Event>> getAllEvents(@RequestParam(required = false)
                                                    @ApiParam(name = "title", type = "String",
                                                            value = "Title of the event") String title) {
        if (title != null) {
            return ResponseEntity.ok(service.getAllEventsByTitle(title));
        }
        return ResponseEntity.ok(service.getAllEvents());
    }

}

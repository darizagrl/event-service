package event;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@Api(value = "events", tags = "event")
@RestController
@RequestMapping("/events")
@RequiredArgsConstructor
public class EventServiceController {

    private final EventService service;

    @ApiOperation(value = "Add a event", nickname = "createEvent", notes = "Endpoint for creating a new event",
            response = Event.class, tags = {"event"}, produces = "application/json", consumes = "application/json")
    @ApiResponse(code = 201, message = "The event was successfully created", response = Event.class)
    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<Event> createEvent(@ApiParam(value = "Event object that needs to be added", required = true)
                                             @RequestBody Event event) {
        return ResponseEntity.ok(service.createEvent(event));
    }

    @ApiOperation(value = "Update an existing event", nickname = "updateEvent", notes = "Endpoint for updating an existing event",
            response = Event.class, tags = {"event"}, produces = "application/json", consumes = "application/json")
    @ApiResponse(code = 200, message = "The event was successfully updated", response = Event.class)
    @PutMapping()
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<Event> updateEvent(@ApiParam(value = "Event object that needs to be updated", required = true) @RequestBody Event event) {
        return ResponseEntity.ok(service.updateEvent(event));
    }

    @ApiOperation(value = "Returns an event by id", nickname = "getEvent", notes = "Endpoint for receiving an event by id",
            response = Event.class, tags = {"event"}, produces = "application/json")
    @ApiResponse(code = 200, message = "successful operation", response = Event.class)
    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<Event> getEvent(@ApiParam(value = "ID of event to return", required = true)
                                          @PathVariable Integer id) {
        return ResponseEntity.ok(service.getEvent(id));
    }

    @ApiOperation(value = "Deletes an event", nickname = "deleteEvent", notes = "Endpoint for event deletion", tags = {"event"})
    @ApiResponse(code = 204, message = "The event was successfully deleted")
    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public HttpStatus deleteEvent(@ApiParam(value = "id", required = true) @PathVariable Integer id) {
        service.deleteEvent(id);
        return HttpStatus.NO_CONTENT;
    }

    @ApiOperation(value = "Return events list", nickname = "getAllEvents", notes = "Endpoint for receiving a list event",
            tags = {"event"}, produces = "application/json")
    @ApiResponse(code = 200, message = "successful operation", response = Event.class, responseContainer = "List")
    @GetMapping()
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<List<Event>> getAllEvents(@ApiParam(value = "Title of events to return")
                                                    @RequestParam(required = false) String title) {
        if (title != null) {
            return ResponseEntity.ok(service.getAllEventsByTitle(title));
        }
        return ResponseEntity.ok(service.getAllEvents());
    }

}

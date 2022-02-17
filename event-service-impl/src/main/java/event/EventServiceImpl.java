package event;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Slf4j
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository repository;

    @Override
    public Event createEvent(Event event) {
        return repository.save(event);
    }

    @Override
    public Event updateEvent(Event event) {
        return repository.save(event);
    }

    @Override
    public Event getEvent(Integer id) {
        return repository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public void deleteEvent(Integer id) {
        repository.deleteById(id);

    }

    @Override
    public List<Event> getAllEvents() {
        return repository.findAll();
    }

    @Override
    public List<Event> getAllEventsByTitle(String title) {
        return repository.findEventsByTitle(title);
    }
}

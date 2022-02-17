package event;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class Event {

    private Integer id;

    private String title;

    private String place;

    private String speaker;

    private String eventType;

    private LocalDateTime dateTime;

}

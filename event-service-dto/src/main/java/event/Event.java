package event;


import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "events")
public class Event {

    @ApiModelProperty(value = "id of the event", name = "id", dataType = "Integer", example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @ApiModelProperty(value = "title of the event", name = "title", dataType = "String", example = "Atlas")
    @Column(name = "title")
    private String title;

    @ApiModelProperty(value = "location of the event", name = "place", dataType = "String", example = "Garden")
    @Column(name = "place")
    private String place;

    @ApiModelProperty(value = "speaker at the event", name = "speaker", dataType = "String", example = "Ostrovsky")
    @Column(name = "speaker")
    private String speaker;

    @ApiModelProperty(value = "type of the event", name = "eventType", dataType = "String", example = "Lecture")
    @Column(name = "event_type")
    private String eventType;

    @ApiModelProperty(value = "date and time of the event", name = "dateTime", dataType = "date-time", example = "2022-02-21T19:00:0")
    @Column(name = "date_time")
    private LocalDateTime dateTime;

}

package me.erano.com.domain.policy;

import me.erano.com.domain.entity.Event;
import me.erano.com.domain.value.Activity;
import me.erano.com.domain.value.EventId;
import me.erano.com.domain.value.Protocol;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;

public class SplitEventParser implements EventParser{
    @Override
    public Event parseEvent(String event) {
        var fields = Arrays.asList(event.split(" "));

        var timestamp = LocalDateTime.parse(fields.get(0), formatter).atOffset(ZoneOffset.UTC);
        var id = EventId.of(fields.get(1));
        var protocol = Protocol.valueOf(fields.get(2));
        var activity = new Activity(fields.get(3), fields.get(5));

        return new Event(timestamp,id, protocol, activity);
    }
}

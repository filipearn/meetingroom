package one.innovation.digital.meetingroom.mapper;

import javax.annotation.processing.Generated;
import one.innovation.digital.meetingroom.dto.request.RoomDTO;
import one.innovation.digital.meetingroom.dto.request.RoomDTO.RoomDTOBuilder;
import one.innovation.digital.meetingroom.model.Room;
import one.innovation.digital.meetingroom.model.Room.RoomBuilder;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-08-03T09:18:09-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 16.0.1 (Private Build)"
)
public class RoomMapperImpl implements RoomMapper {

    @Override
    public Room toModel(RoomDTO roomDTO) {
        if ( roomDTO == null ) {
            return null;
        }

        RoomBuilder room = Room.builder();

        room.date( roomDTO.getDate() );
        room.id( roomDTO.getId() );
        room.name( roomDTO.getName() );
        room.startHour( roomDTO.getStartHour() );
        room.endHour( roomDTO.getEndHour() );

        return room.build();
    }

    @Override
    public RoomDTO toDTO(Room room) {
        if ( room == null ) {
            return null;
        }

        RoomDTOBuilder roomDTO = RoomDTO.builder();

        roomDTO.id( room.getId() );
        roomDTO.name( room.getName() );
        roomDTO.date( room.getDate() );
        roomDTO.startHour( room.getStartHour() );
        roomDTO.endHour( room.getEndHour() );

        return roomDTO.build();
    }
}

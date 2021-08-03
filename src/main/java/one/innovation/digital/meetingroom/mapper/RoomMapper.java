package one.innovation.digital.meetingroom.mapper;

import one.innovation.digital.meetingroom.dto.request.RoomDTO;
import one.innovation.digital.meetingroom.model.Room;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoomMapper {

    RoomMapper INSTANCE = Mappers.getMapper(RoomMapper.class);

    @Mapping(target = "date", source = "date", dateFormat = "yyyy-MM-dd")
    Room toModel(RoomDTO roomDTO);

    RoomDTO toDTO(Room room);
}

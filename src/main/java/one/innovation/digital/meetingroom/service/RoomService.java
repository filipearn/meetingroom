package one.innovation.digital.meetingroom.service;

import one.innovation.digital.meetingroom.dto.request.RoomDTO;
import one.innovation.digital.meetingroom.dto.response.MessageResponseDTO;
import one.innovation.digital.meetingroom.exception.ResourceNotFoundException;
import one.innovation.digital.meetingroom.mapper.RoomMapper;
import one.innovation.digital.meetingroom.model.Room;
import one.innovation.digital.meetingroom.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    private RoomMapper roomMapper = RoomMapper.INSTANCE;

    public MessageResponseDTO createRoom(@RequestBody RoomDTO roomDTO) {
        Room RoomToSave = roomMapper.toModel(roomDTO);

        Room savedRoom = roomRepository.save(RoomToSave);
        return createMethodResponse(savedRoom, "Created Room '%s %s' with ID: %d");
    }

    public MessageResponseDTO updateRoom(Long id, RoomDTO roomDTO) throws ResourceNotFoundException {
        verifyIfExists(id);

        Room RoomToUpdate = roomMapper.toModel(roomDTO);

        Room savedRoom = roomRepository.save(RoomToUpdate);
        return createMethodResponse(savedRoom, "Updated Room '%s %s' with ID: %d");
    }

    public List<RoomDTO> listAll(){
        List<Room> allPeople = roomRepository.findAll();
        return allPeople.stream()
                .map(roomMapper::toDTO)
                .collect(Collectors.toList());
    }

    public RoomDTO listById(Long id) throws ResourceNotFoundException {
        Room Room = verifyIfExists(id);

        return roomMapper.toDTO(Room);
    }

    public Map<String, Boolean> deleteById(Long id) throws ResourceNotFoundException {
        verifyIfExists(id);

        roomRepository.deleteById(id);

        Map<String, Boolean> response = new HashMap<>();

        response.put("deleted", Boolean.TRUE);
        return response;
    }

    private MessageResponseDTO createMethodResponse(Room savedRoom, String s) {
        return MessageResponseDTO
                .builder()
                .message(String.format(s,
                        savedRoom.getName(),
                        savedRoom.getDate().toString(),
                        savedRoom.getStartHour(),
                        savedRoom.getEndHour(),
                        savedRoom.getId()))
                .build();
    }

    private Room verifyIfExists(Long id) throws ResourceNotFoundException {
        return roomRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }
}

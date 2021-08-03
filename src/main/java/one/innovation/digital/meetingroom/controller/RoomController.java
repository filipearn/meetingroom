package one.innovation.digital.meetingroom.controller;

import one.innovation.digital.meetingroom.dto.request.RoomDTO;
import one.innovation.digital.meetingroom.dto.response.MessageResponseDTO;
import one.innovation.digital.meetingroom.exception.ResourceNotFoundException;
import one.innovation.digital.meetingroom.model.Room;
import one.innovation.digital.meetingroom.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/rooms")
public class RoomController {

    @Autowired
    RoomService roomService;

    @GetMapping("/")
    public List<RoomDTO> getAllRooms() {
        return roomService.listAll();
    }

    @GetMapping("/{id}")
    public RoomDTO getRoomById(@PathVariable Long id) throws ResourceNotFoundException {
        return roomService.listById(id);
    }

    @PostMapping()
    public MessageResponseDTO createRoom (@Valid @RequestBody RoomDTO roomDTO){
        return roomService.createRoom(roomDTO);
    }

    @PutMapping("/{id}")
    public MessageResponseDTO updateRoom(@PathVariable Long id, @Valid @RequestBody RoomDTO roomDTO) throws ResourceNotFoundException {
        return roomService.updateRoom(id, roomDTO);
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteRoom(@PathVariable Long id) throws ResourceNotFoundException {
        return roomService.deleteById(id);
    }
}

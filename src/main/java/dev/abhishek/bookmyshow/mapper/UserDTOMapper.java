package dev.abhishek.bookmyshow.mapper;

import dev.abhishek.bookmyshow.dto.CreateUserReqDTO;
import dev.abhishek.bookmyshow.dto.CreateUserRespDTO;
import dev.abhishek.bookmyshow.dto.TicketRespDTO;
import dev.abhishek.bookmyshow.entity.Ticket;
import dev.abhishek.bookmyshow.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserDTOMapper {
    public  static User getUser(CreateUserReqDTO createUserReqDTO){
        User user = new User();
        user.setUsername(createUserReqDTO.getName());
        user.setEmail(createUserReqDTO.getEmail());
        user.setPassword(createUserReqDTO.getPassword());
        return user;
    }
    public static CreateUserRespDTO getCreateUserRespDTO(User user){
        CreateUserRespDTO createUserRespDTO = new CreateUserRespDTO();
        createUserRespDTO.setId(user.getId());
        createUserRespDTO.setName(user.getUsername());
        createUserRespDTO.setEmail(user.getEmail());
        if(user.getTickets() != null){
            List<TicketRespDTO> tickets = new ArrayList<>();
           for(Ticket ticket : user.getTickets()){
               tickets.add(TicketDTOMapper.getTicketRespDTO(ticket));
           }
        }
        return createUserRespDTO;
    }

}

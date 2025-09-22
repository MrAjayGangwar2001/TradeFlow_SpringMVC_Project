package com.Portfolio.app.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Portfolio.app.Dto.UserDto;
import com.Portfolio.app.Model.UserModel;
import com.Portfolio.app.Repository.UserRepo;

@Service
public class UserService {

    @Autowired
    private UserRepo urepo;

    public UserDto PostData(UserDto userDto) {
        UserModel um = new UserModel();

        um.setName(userDto.getName());
        um.setEmail(userDto.getEmail());

        urepo.save(um);

        UserDto udto = new UserDto(um.getId(), um.getName(), um.getEmail());

        return udto;

    }

    public List<UserDto> GetAllData(){

        List<UserModel> um = urepo.findAll();

        List<UserDto> ud = um.stream().map((x) -> new UserDto(x.getId(), x.getName(), x.getEmail())).toList();

        return ud;
    }

    public UserDto GetById(Long id) throws Exception {
        Optional<UserModel> um = urepo.findById(id);

        if (um.isPresent()) {
            UserModel umd = um.get();

            UserDto user = new UserDto(umd.getId(), umd.getName(), umd.getEmail());

            return user;
        }else{
            throw new Exception("We can not find id");
        }
    }

    public String DeleteById(Long id) throws Exception{
        Optional<UserModel> um = urepo.findById(id);

        if (um.isPresent()) {
            UserModel umd = um.get();

            urepo.delete(umd);

            return "You data id : "+id+" Has been Deleted.f";
        }else{
            throw new Exception("User Id Nhi mili!");
        }
    }

    public UserDto UpdateDataById(UserDto userDto, Long id) throws Exception{


        Optional<UserModel> um = urepo.findById(id);

        if (um.isPresent()) {
            UserModel umdl = um.get();

            umdl.setName(userDto.getName());
            umdl.setEmail(userDto.getEmail());

            urepo.save(umdl);

            UserDto ud = new UserDto(umdl.getId(), umdl.getName(), umdl.getEmail());

            return ud;
        } else {
            throw new Exception("Sorry!, We couldn't Find the id : "+ id);
        }
    }
}

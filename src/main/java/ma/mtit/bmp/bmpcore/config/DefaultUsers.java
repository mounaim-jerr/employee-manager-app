package ma.mtit.bmp.bmpcore.config;

import ma.mtit.bmp.bmpcore.enums.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@Component
public class DefaultUsers {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PasswordEncoder encoder;
@PostConstruct
    public User admin(){
    Role adminRole = Role.ADMIN;
    List<User> user = userRepo.findByRole(adminRole);
    if (user.isEmpty()){
        User admin = new User();
        admin.setRole(Role.ADMIN);
        admin.setPassword(encoder.encode("1234"));
        admin.setEmail("admin@gmail.com");
       return userRepo.save(admin);

    }

    else {
        return user.get(0);
    }
    }
    @PostConstruct
    public User doctor(){
        Role adminRole = Role.DOCTOR;
        List<User> user = userRepo.findByRole(adminRole);
        if (user.isEmpty()){
            User doctor = new User();
            doctor.setRole(Role.DOCTOR);
            doctor.setPassword(encoder.encode("doctor"));
            doctor.setEmail("doctor@gmail.com");
            return userRepo.save(doctor);

        }

        else {
            return user.get(0);
        }
    }
    @PostConstruct
    public User nurse(){
        Role adminRole = Role.NURSE;
        List<User> user = userRepo.findByRole(adminRole);
        if (user.isEmpty()){
            User nurs = new User();
            nurs.setRole(Role.NURSE);
            nurs.setPassword(encoder.encode("nurs"));
            nurs.setEmail("nurs@gmail.com");
            return userRepo.save(nurs);


        }
        else {
            return user.get(0);
        }


    }
    @PostConstruct
    public User recep(){
        Role adminRole = Role.RECEP;
        List<User> user = userRepo.findByRole(adminRole);
        if (user.isEmpty()){
            User recep = new User();
            recep.setRole(Role.RECEP);
            recep.setPassword(encoder.encode("recep"));
            recep.setEmail("recep@gmail.com");
            return userRepo.save(recep);

        }
        else {
            return user.get(0);
        }
    }

}

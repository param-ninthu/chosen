package dev.chosen.chosen.service;

import dev.chosen.chosen.model.User;
import dev.chosen.chosen.repo.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import static com.mongodb.internal.connection.tlschannel.util.Util.assertTrue;

@Service
public class RegisterService {
    @Autowired
    private RegisterRepository registerRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public User createUser(User userData) throws Exception{
        if(registerRepository.findUserByUsername(userData.getUsername()) != null){
            throw new Exception("User with username" + userData.getUsername() + " exists already");
        }

//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
//        String hashedPassword = encoder.encode(userData.getPassword());
//        assertTrue(encoder.matches(userData.getPassword(), hashedPassword));
//
//        userData.setPassword(hashedPassword);

        return registerRepository.save(userData);
    }
}

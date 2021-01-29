package br.com.gabriel.hruser.resources;


import br.com.gabriel.hruser.entities.User;
import br.com.gabriel.hruser.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){

        User obj = userRepository.findById(id).get();
        return ResponseEntity.ok(obj);

    }

    @GetMapping(value = "/search")
    public ResponseEntity<User> findSearch(@RequestParam String email){

        User obj = userRepository.findByEmail(email).get();
        return ResponseEntity.ok(obj);

    }
}

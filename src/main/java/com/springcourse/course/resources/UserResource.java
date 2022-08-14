package com.springcourse.course.resources;

import com.springcourse.course.entities.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<Usuario> findAll() {
        Usuario u = new Usuario(1L, "Wagner", "wagner@gmail.com", "9999999", "12345");
        System.out.println(u);
        return ResponseEntity.ok().body(u);
    }

}

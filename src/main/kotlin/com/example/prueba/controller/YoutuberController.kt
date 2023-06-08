package com.example.prueba.controller

import com.example.prueba.model.Youtuber
import com.example.prueba.service.YoutuberService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/youtuber")
class YoutuberController {

    lateinit var youtuberService: YoutuberService

    @GetMapping
    fun list(): ResponseEntity<*> {
        return ResponseEntity(youtuberService.list(), HttpStatus.OK)
    }

    @PostMapping
    fun save(@RequestBody @Valid youtuber: Youtuber): ResponseEntity<Youtuber> {
        return ResponseEntity(youtuberService.save(youtuber), HttpStatus.OK)
    }

    @PutMapping
    fun update(@RequestBody youtuber: Youtuber): ResponseEntity<Youtuber> {
        return ResponseEntity(youtuberService.update(youtuber), HttpStatus.OK)
    }

    @PatchMapping
    fun updateName(@RequestBody youtuber: Youtuber): ResponseEntity<Youtuber> {
        return ResponseEntity(youtuberService.updateName(youtuber), HttpStatus.OK)
    }
}
   // @GetMapping("/")
   // fun listPlayerWorldCup(): List<Youtuber> {
      // return youtuberService.listPlayerWorldCup()



package com.example.prueba.controller

import com.example.prueba.model.Video
import com.example.prueba.service.VideoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/video")
class VideoController {

    @Autowired
    lateinit var videoService: VideoService

    @GetMapping
    fun list(): ResponseEntity<*> {
        return ResponseEntity(videoService.list(), HttpStatus.OK)

    }

    @PostMapping
    fun save(@RequestBody video: Video): ResponseEntity<Video> {
        return ResponseEntity(videoService.save(video), HttpStatus.OK)
    }

    @PutMapping
    fun update(@RequestBody video: Video): ResponseEntity<Video> {
        return ResponseEntity(videoService.update(video), HttpStatus.OK)
    }

    @PatchMapping
    fun updateName(@RequestBody video: Video): ResponseEntity<Video> {
        return ResponseEntity(videoService.updateName(video), HttpStatus.OK)
    }


}
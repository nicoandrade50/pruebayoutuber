package com.example.prueba.service

import com.example.prueba.model.Youtuber
import com.example.prueba.repository.YoutuberRepository
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.server.ResponseStatusException

@Controller
class YoutuberService {

    @Autowired
    lateinit var youtuberRepository: YoutuberRepository

    fun list(): List<Youtuber> {
        return youtuberRepository.findAll()

    }

    @PostMapping
    fun save(@RequestBody @Valid youtuber: Youtuber): Youtuber {

        return youtuberRepository.save(youtuber)

    }

    @PutMapping
    fun update(youtuber: Youtuber): Youtuber {
        try {
            youtuberRepository.findById(youtuber.id)

                    ?: throw Exception("ID no existe")

            return youtuberRepository.save(youtuber)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    @PatchMapping

    fun updateName(youtuber: Youtuber): Youtuber {
        try {
            val response = youtuberRepository.findById(youtuber.id)
                    ?: throw Exception("Id Existe")
            response.apply {

            }
            return youtuberRepository.save(youtuber)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }
}

package com.example.prueba.repository

import com.example.prueba.model.Youtuber
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository

interface YoutuberRepository: JpaRepository<Youtuber, Long> {

    fun findById(id: Long?): Youtuber?

    //@Query(nativeQuery = true)
    //fun findAvailableWorldCup(): List<Player>

}
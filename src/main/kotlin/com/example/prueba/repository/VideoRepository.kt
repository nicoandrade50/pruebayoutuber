package com.example.prueba.repository

import com.example.prueba.model.Video
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param


interface VideoRepository: JpaRepository<Video, Long> {

    fun findById(id: Long?): Video?


    @Query(nativeQuery = true)//Va a leer jpa-named.....
    fun getTotalAdmonition(@Param("youtuber_id") playerId: Long?): Double?

}
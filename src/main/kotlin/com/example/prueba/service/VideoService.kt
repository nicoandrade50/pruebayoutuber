package com.example.prueba.service

import com.example.prueba.model.Video
import com.example.prueba.repository.VideoRepository
import com.example.prueba.repository.YoutuberRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.server.ResponseStatusException


@Service
class VideoService {


    @Autowired
    lateinit var videoRepository: VideoRepository

    @Autowired
    lateinit var youtuberRepository: YoutuberRepository


    fun list (): List<Video> {
        return videoRepository.findAll()

    }

    @PutMapping
    fun update(video: Video): Video {
        try {
            videoRepository.findById(video.id)
                    ?: throw Exception("ID no existe")

            return videoRepository.save(video)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    @PatchMapping
    fun updateName(video: Video): Video {
        try {
            val response = videoRepository.findById(video.id)
                    ?: throw Exception("Id no Existe")
            response.apply {
                //Video = Video.dateMatch
            }
            return videoRepository.save(video)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    @PostMapping
    fun save(video: Video): Video {
        try{
            val responseYoutuber = youtuberRepository.findById(video.youtuberId)
                    ?: throw Exception("Id no Existe")

            val responseVideo=videoRepository.save(video)

            //val totalVideo = getTotalVideo (video.youtuberId)


            //youtuberRepository.save(responseYoutuber.apply { fairplay = totalVideo})

            return responseVideo
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    //fun getTotalAdmonition (playerId: Long?): Double?{
       // return videoRepository.getTotalAdmonition(playerId)
    }

 }
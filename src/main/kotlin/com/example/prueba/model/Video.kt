package com.example.prueba.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.validation.constraints.NotBlank

@Entity
@Table (name="video")
class Video {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    @NotBlank(message="Campo obligatorio") //validate
    var title: String? = null
    @NotBlank(message="Campo obligatorio")  //validate
    var duration: Double? = null
    @Column(name = "youtuber_id")
    var youtuberId: Long? = null

}

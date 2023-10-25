package com.board.back.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import lombok.Data

@Entity
data class SimpleBoard {

    // TODO
    // need to resolve error check

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private var id: Long? = null;

    @Column
    private var name: String? = null;


}
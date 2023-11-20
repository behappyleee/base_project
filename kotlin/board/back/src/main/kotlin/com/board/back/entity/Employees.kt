package com.board.back.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
class Employees(
        @Id val userId: String

) {
//    constructor() : this() {
//
//    }
}
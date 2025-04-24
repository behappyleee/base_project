package com.study.bean_test

import jakarta.servlet.http.HttpServletRequest
import org.springframework.core.io.ByteArrayResource
import org.springframework.core.io.ClassPathResource
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class TestController{

    @GetMapping("/test")
    fun hello(): String {
        Objects.requireNonNull(Thread.currentThread().name)
        println("Hello This is In Controller !!")
//        throw RuntimeException("This is In Controller Exception Test !!!", IllegalArgumentException("This is Illegal Argument Exceiption !!"))
        return "Hello World This is kotlin world !!!!"
    }

    @GetMapping("/file")
    fun fileDownloadTest(
        httpServletRequest: HttpServletRequest,
    ): ResponseEntity<ByteArrayResource> {

        println("REMOTE USER ${httpServletRequest.remoteUser}")

        Collections.emptyList<String>()

        val classPathResource = ClassPathResource("static/sample_excel.xlsx")


        return if (classPathResource.exists()) {
            val fileBytes = classPathResource.inputStream.readBytes()
            val resource = ByteArrayResource(fileBytes)
            ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=sample_excel.xlsx")
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource)
        } else {
            ResponseEntity.notFound().build()
        }
    }
}

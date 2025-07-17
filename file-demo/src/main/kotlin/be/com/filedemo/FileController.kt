package be.com.filedemo

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@RestController
class FileController(
    private val fileService: FileService,
) {
    @PostMapping("/upload")
    fun upload(
        @RequestParam(value = "file", required = true) file: MultipartFile,
    ) {
        fileService.fileUpload(
            file = file,
        )
    }

    companion object {
        private val logger = LoggerFactory.getLogger(FileController::class.java)
    }
}

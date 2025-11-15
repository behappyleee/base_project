package be.com.filedemo

import java.nio.file.Path
import java.nio.file.Paths
import kotlin.text.Charsets.UTF_8
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile


@Service
class FileService {

    fun fileUpload(file: MultipartFile) {
        logger.info("FileSize : {} ", file.size)
        logger.info("FileByte : {} ", file.bytes)
        logger.info("FileName : {} ", file.name)
        logger.info("FileResources : {} ", file.resource)

        logger.info("File Read : {} ", file.bytes.toString())

        val fileBytes = file.bytes.toString(UTF_8)
        logger.info("FileBytes Decode : {} ", fileBytes)

        val fileBytesUTF8 = String(file.bytes, UTF_8)
        logger.info("File Bytes Read UTF 8 : {} ", fileBytesUTF8)

        try {
            val path = basePath.toAbsolutePath()
            logger.info("File Path : {}", path)
        } catch (e: Exception) {

        }
    }

    companion object {
        private val logger = LoggerFactory.getLogger(FileService::class.java)
        private val basePath: Path = Paths.get("uploaded.txt")
        private val copyPath: Path = Paths.get("copied.txt")
    }
}

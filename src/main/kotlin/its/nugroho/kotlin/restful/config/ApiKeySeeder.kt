package its.nugroho.kotlin.restful.config

import its.nugroho.kotlin.restful.entity.ApiKey
import its.nugroho.kotlin.restful.repository.ApiKeyRepository
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

@Component
class ApiKeySeeder(val apiKeyRepository: ApiKeyRepository) : ApplicationRunner {

    val apiKeyDummy = "0A1B2C"

    override fun run(args: ApplicationArguments?) {
        if (!apiKeyRepository.existsById(apiKeyDummy)) {
            val entity = ApiKey(id = apiKeyDummy)
            apiKeyRepository.save(entity)
        }
    }
}
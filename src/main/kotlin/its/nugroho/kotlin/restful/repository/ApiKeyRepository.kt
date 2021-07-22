package its.nugroho.kotlin.restful.repository

import its.nugroho.kotlin.restful.entity.ApiKey
import org.springframework.data.jpa.repository.JpaRepository

interface ApiKeyRepository : JpaRepository<ApiKey, String> {
}
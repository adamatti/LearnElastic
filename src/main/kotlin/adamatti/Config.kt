package adamatti

import org.elasticsearch.client.Client
import org.elasticsearch.common.settings.Settings
import org.elasticsearch.common.transport.TransportAddress
import org.elasticsearch.transport.client.PreBuiltTransportClient
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.elasticsearch.core.ElasticsearchOperations
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories
import java.net.InetAddress

@Configuration
@EnableElasticsearchRepositories(basePackages = ["adamatti.repos"])
open class Config {
    @Bean
    open fun client(): Client {
        val settings = Settings.builder()
            .put("cluster.name", "docker-cluster")
            .build()

        return PreBuiltTransportClient(settings).also {
            it.addTransportAddress(TransportAddress(InetAddress.getByName("localhost"), 9300))
            println ("Client created")
        }
    }

    @Bean
    open fun elasticsearchTemplate(client: Client): ElasticsearchOperations = ElasticsearchTemplate(client)

}
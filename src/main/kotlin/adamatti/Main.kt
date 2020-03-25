@file:JvmName("Main")
package adamatti

import adamatti.repos.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.annotation.Id
import org.springframework.data.elasticsearch.annotations.Document
import java.util.*

@SpringBootApplication
open class Main (
    @Autowired val personRepository: PersonRepository
) {
    fun run (){
        personRepository.save(
            Person(UUID.randomUUID().toString(), "Sample")
        )

        personRepository.findAll().forEach {
            println("${it.id} - ${it.name}")
        }
        println ("Run")
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val context = runApplication<Main>(*args)
            context.getBean(Main::class.java).run()
            println ("Done")
        }
    }
}

@Document(indexName = "sampleapp", type = "persons")
open class Person (
    @Id var id:String? = null,
    var name: String? = null
)
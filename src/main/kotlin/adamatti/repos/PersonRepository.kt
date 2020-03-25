package adamatti.repos

import adamatti.Person
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository

interface PersonRepository: ElasticsearchRepository<Person, String> {

}
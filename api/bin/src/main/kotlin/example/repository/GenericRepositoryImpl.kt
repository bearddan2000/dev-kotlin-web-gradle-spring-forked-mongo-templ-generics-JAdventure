package example.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Criteria;

import org.springframework.stereotype.Repository;

@Repository
class GenericRepositoryImpl<T> : GenericRepository<T>{

  @Autowired
  lateinit var mongoTemplate: MongoTemplate

  override fun findAll(c: Class<T>): List<T> {
    val query: Query = Query()
    val list = mongoTemplate.find(query, c);
    return list;
  }

  // https://phauer.com/2018/kotlin-mongodb-perfect-match/
  override fun findByField(c: Class<T>, f: String, v: String): Any
  {
    val query: Query = Query().addCriteria(Criteria.where(f).isEqualTo(v))
    // val query: Query = Query().addCriteria(T::name isEqualTo value);
    val list = mongoTemplate.find<T>(query);
    return list.first();
  }
}

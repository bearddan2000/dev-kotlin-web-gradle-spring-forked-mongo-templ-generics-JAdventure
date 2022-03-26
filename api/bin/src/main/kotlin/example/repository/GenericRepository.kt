package example.repository;

interface GenericRepository<T>{

  fun findAll(c: Class<T>): List<T>;

  fun findByField(c: Class<T>, field: String, value: String): T;
}

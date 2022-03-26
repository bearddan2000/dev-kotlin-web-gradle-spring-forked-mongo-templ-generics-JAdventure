package example.service;

interface GenericService<T>{

  fun findAll(c: Class<T>): List<T>;

  fun findByField(c: Class<T>, field: String, value: String): T;
}

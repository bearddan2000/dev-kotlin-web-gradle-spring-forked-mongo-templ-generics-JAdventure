package example.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "locations")
data class Location(

  @Id
  var id: String

  , var danger: Int
  , var title: String
  , var description: String
  , var locationType: String
  , @Indexed var coordinate: String
  , var npcs: List<String>
  , var items: List<String>
){

  override fun toString(): String {
    var sb = StringBuilder()
    sb.append("{")
    sb.append(" 'id': '" + id + "'")
    sb.append(", 'danger': " + danger)
    sb.append(", 'title': '" + title + "'")
    sb.append(", 'description': '" + description + "'")
    sb.append(", 'locationType': '" + locationType + "'")
    sb.append(", 'coordinate': '" + coordinate + "'")
    sb.append(", 'items': [" + items.fold() + "]")
    sb.append(", 'npcs': [" + npcs.fold() + "]")
    sb.append("}")
    return sb.toString()
  }

  public inline fun List<String>.fold(): String = this.joinToString { it -> "\'${it}\'" }

}

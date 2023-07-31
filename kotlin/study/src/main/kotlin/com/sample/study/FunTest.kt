import lombok.Getter
import lombok.Setter

fun main() {
    print("Hello kotlin World !");

    var person1 = Person();
    var person2 = Person();

    person1.age;
    person2.name;
}

@Getter
@Setter
class Person {
    var name: String = "Test";
    var age : Int = 26;
}







// Базовый класс Учащийся
open class Student(val name: String){
    open fun getInfo(): String{
        return name
    }
}


// Производный класс Школьник
class Schoolchild(name: String, val grade: Int) : Student(name){
    override fun getInfo(): String {
        return "Школьник: Имя - $name, класс - $grade"
    }
}

// Производный класс Студент
class UniversityStudent(name: String, val course: Int) : Student(name){
    override fun getInfo(): String {
        return "Студент: Имя - $name, курс - $course"
    }
}

// Класс Конференция
class Conference {
    private val participants = ArrayList<Student>()

    fun getParticipants() {
        for (part in participants) {
            println(part.getInfo())
        }
    }

    fun addParticipant(participant: Student) {
        participants.add(participant)
    }

    fun countParticipants() {
        var schoolchildren = 0
        var students = 0

        for (participant in participants) {
            when {
                participant is Schoolchild -> schoolchildren++
                participant is UniversityStudent -> students++
            }
        }
        println("Кол-во школьников - $schoolchildren, кол-во студентов - $students")
    }
}

fun main() {
    val conference = Conference()

    // Добавляем участников
    conference.addParticipant(Schoolchild("Иван", 5))
    conference.addParticipant(UniversityStudent("Анна", 2))
    conference.addParticipant(Schoolchild("Мария", 7))
    conference.addParticipant(UniversityStudent("Петр", 1))

    // Получаем статистику
    conference.getParticipants()
    conference.countParticipants()
}
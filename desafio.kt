enum class Level { BASIC , INTERMEDIATE, ADVANCED }

enum class LevelExperience {BEGINNER,INTERMEDIATE, ADVANCED,PRO}

class Experience(experience: Int)
{
    var xp = experience
    //declaring a function to determine a level
    
    fun ExperienceLevel() {
        
    val level = when (xp) 
    {
        in 500..1499 -> LevelExperience.BEGINNER
        in 1500..4500 -> LevelExperience.INTERMEDIATE
        in 4599..6500 -> LevelExperience.ADVANCED
        in 6599..10000 -> LevelExperience.PRO
        else -> null // You can handle this case as needed
    }

    if (level != null)
        println("Experience level: $level")
     else
        println("You don't have enough experience for a level yet. Keep coding! ;)")
    
	}
}

data class UsersInfo(val name: String, val email: String, val password: String, val celnum: Long) //the user cant change the register name, but can update other info if its turns necessary

data class Course(val nameCourse: String, var content: String, var technology : String, var method : String , var level: Level )


//function that you can use to add more trainings
fun addCourse(nameCourse: String, content: String, technology: String, method: String, level: Level) : Course
{
    val course = Course(nameCourse, content, technology, method, level  )
    return course
}

//registering user
fun registerUser(name : String, email: String, password: String, cellnum: Long)  : UsersInfo
{
    val usersInfo = UsersInfo(name, email, password, cellnum)
    return usersInfo
}

//shows user information on their profiles
fun userProfile(name: String, email: String, habilities: String ) {
    println("Welcome to your profile $name!")
    println("Information:")
    println("Name: $name.  Email: $email. Habilities: $habilities .")

    //showing the user courses
    val training = Course( //inheriting information from Training
        nameCourse = "Bootcamp Kotlin",
        technology = "Kotlin, Android",
        content = "Fundamentals, Examples, Kotlin programming practice ",
        method = "100% Online",
        level = Level.BASIC
    )

    //obj of class Experience
    val exp = Experience(1000)
    //calling the function using the variable exp
    exp.ExperienceLevel()
    println("")

    //showing
    println("Your courses:")
    println("Course Name: ${training.nameCourse}")
    println("Technology: ${training.technology}")
    println("Course Content: ${training.content}")
    println("Teaching Method: ${training.method}")
    println("Level: ${training.level}")

}

fun main()
{
    //testing scenarios 
    // returning functions

    //user profile
    userProfile("milena", "milena@gmail", "Kotlin, Java, C#" )
    println("")

    //register
    val usersSubscribed: MutableList<UsersInfo> = mutableListOf()

    // Register users and add them to the list
    val user1 = registerUser("milena", "milena@gmail.com", "123caubdaip#", 11748856689)
    val user2 = registerUser("luana", "luana@hotmail.com", "hagdyasdb_", 23458721256)
    println()

    // Add registered users to the list
    usersSubscribed.add(user1)
    usersSubscribed.add(user2)


    //outputting all the users registered
    println("List of users subscribed:")
    for (user in usersSubscribed) {
        println("Name: ${user.name}, Email: ${user.email}")
    }
    println("")

    //registering new courses
    val addnewCourses : MutableList<Course> = mutableListOf()
    val course1 = addCourse("Web development", "Fundamentals, Examples, Exercises", "HTML - CSS - JS","100% online, videos and challenges", Level.BASIC )
	val course2 = addCourse("Java DevOPS", "Fundamental, Examples, Projects", "Java", "100% online, videos and challenges", Level.INTERMEDIATE  )
    //adding the course register
    addnewCourses.add(course1)
	addnewCourses.add(course2)

    //outputting all the courses registered
    println("List of courses registered: ")
    for (courses in addnewCourses)
    {
        println("Course name: ${courses.nameCourse} ,Content: ${courses.content}, Technology: ${courses.technology}, Methodology: ${courses.method}, Level:  ${courses.level}")
        println("")
    }

}
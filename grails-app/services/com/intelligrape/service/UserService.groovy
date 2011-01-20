package com.intelligrape.service

class UserService {

    static transactional = true

    def deleteUser(User user) throws  org.springframework.dao.DataIntegrityViolationException {
        user.delete()
    }

    def createAndSaveMultipleUsers(){
        (1..10).each{Integer i->
            createAndSaveUser("Name ${i}", "password", "password")
        }
    }

    def createAndSaveUser(String name, String password, String confirmPassword){
        User user = new User(name: name, password: password, confirmPassword: confirmPassword)
        saveUser(user)
    }

    def saveUser(User user){
        user.save(failOnError: true)
    }
}

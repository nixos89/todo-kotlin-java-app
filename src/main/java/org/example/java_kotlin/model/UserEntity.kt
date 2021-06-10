package org.example.java_kotlin.model

import javax.persistence.*

@Entity(name="users")
@Table(name="users")
class UserEntity(
    var login: String,
    var firstName: String,
    var lastName: String,
    var description: String? = null,
    @Id
    @SequenceGenerator(name="user_generator", sequenceName = "user_sequence", allocationSize = 1)
    @GeneratedValue(generator = "user_generator")
    var userId: Long? = null)
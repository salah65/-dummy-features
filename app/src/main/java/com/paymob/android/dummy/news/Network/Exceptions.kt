package com.example.nytimesapp.Network



class NotAuthorizedException(message: String) : Exception(message)
class NotFoundException(message: String) : Exception(message)

class InternalServerErrorException(message: String = "Something went wrong please try again later") :
    Exception(message)

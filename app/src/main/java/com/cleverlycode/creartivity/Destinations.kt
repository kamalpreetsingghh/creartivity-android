package com.cleverlycode.creartivity

interface Destinations {
    val route: String
}

object Auth: Destinations {
    override val route = "auth"
}

object SignUp: Destinations {
    override val route = "signup"
}

object Login: Destinations {
    override val route = "login"
}

object Home: Destinations {
    override val route = "home"
}

object Profile: Destinations {
    override val route = "profile"
}
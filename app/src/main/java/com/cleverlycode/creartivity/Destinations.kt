package com.cleverlycode.creartivity

interface Destinations {
    val route: String
}

object SignUp: Destinations {
    override val route = "SignUp"
}

object Login: Destinations {
    override val route = "Login"
}

object Home: Destinations {
    override val route = "Home"
}

object Profile: Destinations {
    override val route = "Profile"
}
package baster

import model.Profile

class Composer {

    fun compose(profile: Profile) =
        "Hola " + profile.name + ", he visto tu experiencia como " + profile.position + ". Ahora mismo" +
                " estamos buscando perfiles así en " + profile.location + " ¿te interesa?"

}
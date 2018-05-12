package baster

import model.Experience

class ExperienceMother {

    fun getExperience(): Experience =
            Experience(
                    "senior android engineer",
                    "idealista",
                    "2 años y 2 meses",
                    "Madrid",
                    "")

    fun getAnotherExperience(): Experience =
            Experience(
                    "android engineer",
                    "Blackphone",
                    "1 año y 7 meses",
                    "Madrid",
                    "Blackphone is the world's first smartphone to put privacy and control back in the hands of the user. It is headquartered in Geneva as a Silent Circle (a leading encrypted communications provider) product.\n" +
                            "\n" +
                            "Recognized with the Best of MWC 2014 Award by PC Magazine and Red herring Top 100 Europe. Named a Top 10 Breakthrough Technology in 2014 by MIT Technology Review. Fast Company's World Top 10 Innovative Companies of 2015.\n" +
                            "\n" +
                            "Member of the engineering group, framework team. Development of Android-based operating system called SilentOS on a range of devices. Participating on system core framework development and OS component extension. Focused on development for security, performance and stability"
            )

}
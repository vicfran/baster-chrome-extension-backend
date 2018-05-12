package baster

import composer.template.Body
import composer.template.Template
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import org.junit.jupiter.api.Assertions.assertEquals

class ComposerTest: StringSpec({

    "Compose full profile" {
        val expected = TemplateMother().getFullProfileTemplate()
        val generated = Composer().compose(ProfileMother().getFullProfile())

        assertTemplate(expected, generated)
    }

    "Compose profile with one experience" {
        val expected = TemplateMother().getProfileWithOneExperienceTemplate()
        val generated = Composer().compose(ProfileMother().getProfileWithOneExperience())

        assertTemplate(expected, generated)
    }

    "Compose profile without experiences" {
        val expected = TemplateMother().getProfileWithoutExperiencesTemplate()
        val generated = Composer().compose(ProfileMother().getProfileWithoutExperiences())

        assertTemplate(expected, generated)
    }

    "Compose profile without aptitudes" {
        val expected = TemplateMother().getProfileWithoutAptitudesTemplate()
        val generated = Composer().compose(ProfileMother().getProfileWithoutAptitudes())

        assertTemplate(expected, generated)
    }

    "Compose profile without recommendations" {
        val expected = TemplateMother().getProfileWithoutRecommendationsTemplate()
        val generated = Composer().compose(ProfileMother().getProfileWithoutRecommendations())

        assertTemplate(expected, generated)
    }

    "Compose profile without aptitudes neither recommendations" {
        val expected = TemplateMother().getProfileWithoutAptitudesNorRecommendationsTemplate()
        val generated = Composer().compose(ProfileMother().getProfileWithoutAptitudesNorRecommendations())

        assertTemplate(expected, generated)
    }

})

private fun assertTemplate(expected: Template, generated: Template) {
    assertStart(expected.start, generated.start)
    assertBody(expected.body, generated.body)
    assertEnd(expected.end, generated.end)
}

private fun assertStart(expected: String, generated: String) {
    generated shouldBe expected
}

private fun assertBody(expected: Body, generated: Body) {
    assertEquals(expected.parts.size, generated.parts.size)
    generated.parts.forEachIndexed { index, part ->
        part shouldBe expected.parts[index]
    }
}

private fun assertEnd(expected: String, generated: String) {
    generated shouldBe expected
}

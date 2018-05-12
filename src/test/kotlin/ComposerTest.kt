package baster

import composer.template.Body
import composer.template.Template
import org.junit.Assert.assertEquals
import org.junit.Test

class ComposerTest {

    @Test fun `Compose full profile`() {
        val template = TemplatesMother().getFullProfileTemplate()
        val actual = Composer().compose(ProfileMother().getFullProfile())

        assertTemplate(template, actual)
    }

    @Test fun `Compose profile with one experience`() {
        val template = TemplatesMother().getProfileWithOneExperienceTemplate()
        val actual = Composer().compose(ProfileMother().getProfileWithOneExperience())

        assertTemplate(template, actual)
    }

    @Test fun `Compose profile without experiences`() {
        val template = TemplatesMother().getProfileWithoutExperiencesTemplate()
        val actual = Composer().compose(ProfileMother().getProfileWithoutExperiences())

        assertTemplate(template, actual)
    }

    @Test fun `Compose profile without aptitudes`() {
        val template = TemplatesMother().getProfileWithoutAptitudesTemplate()
        val actual = Composer().compose(ProfileMother().getProfileWithoutAptitudes())

        assertTemplate(template, actual)
    }

    @Test fun `Compose profile without recommendations`() {
        val template = TemplatesMother().getProfileWithoutRecommendationsTemplate()
        val actual = Composer().compose(ProfileMother().getProfileWithoutRecommendations())

        assertTemplate(template, actual)
    }

    @Test fun `Compose profile without aptitudes neither recommendations`() {
        val template = TemplatesMother().getProfileWithoutAptitudesNorRecommendationsTemplate()
        val actual = Composer().compose(ProfileMother().getProfileWithoutAptitudesNorRecommendations())

        assertTemplate(template, actual)
    }

    private fun assertTemplate(expected: Template, actual: Template) {
        assertStart(expected.start, actual.start)
        assertBody(expected.body, actual.body)
        assertEnd(expected.end, actual.end)
    }

    private fun assertStart(expected: String, actual: String) {
        assertEquals(expected, actual)
    }

    private fun assertBody(expected: Body, actual: Body) {
        assertEquals(expected.parts.size, actual.parts.size)
        actual.parts.forEachIndexed { index, part ->
            assertEquals(expected.parts[index], part)
        }
    }

    private fun assertEnd(expected: String, actual: String) {
        assertEquals(expected, actual)
    }

}
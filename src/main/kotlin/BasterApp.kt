package baster

import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.CallLogging
import io.ktor.features.Compression
import io.ktor.features.ContentNegotiation
import io.ktor.features.DefaultHeaders
import io.ktor.gson.gson
import io.ktor.request.receive
import io.ktor.response.respondText
import io.ktor.routing.Routing
import io.ktor.routing.post
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import model.ProfileEntity

fun Application.module() {
    install(DefaultHeaders)
    install(CallLogging)
    install(Compression)
    install(ContentNegotiation) {
        gson {
            setPrettyPrinting()
        }
    }
    install(Routing, initRouting())
}

fun main(args: Array<String>) {
    embeddedServer(Netty, 8080, watchPaths = listOf("BasterAppKt"), module = Application::module).start(true)
}

private fun initRouting(): Routing.() -> Unit {
    return {
        post ("/") {
            val profileEntity = call.receive<ProfileEntity>()
            val profile = ProfileScraper().scrap(profileEntity)
            call.respondText { Composer().compose(Parser().parse(profile)).get() }
        }
    }
}

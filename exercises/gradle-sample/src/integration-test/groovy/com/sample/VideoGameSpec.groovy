package com.sample


import grails.testing.mixin.integration.Integration
import grails.transaction.*
import static grails.web.http.HttpHeaders.*
import static org.springframework.http.HttpStatus.*
import spock.lang.*
import geb.spock.*
import grails.plugins.rest.client.RestBuilder

@Integration
@Rollback
class VideoGameSpec extends GebSpec {
    //http://testerstories.com/2016/03/why-test-engineers-should-learn-geb-and-spock/
    //https://allegro.tech/2015/05/automated-tests-with-geb-spock-and-groovy.html

    def setupSpec(){
        System.setProperty("webdriver.chrome.driver", "/projects/chromedriver");
        baseUrl = 'http://ide2.vivasa.in:35434'
    }

    def cleanupSpec(){

    }

    def setup() {
    }

    def cleanup() {

    }

    void "Test the homepage"() {

        given: "I am at the game list page"
            go '/video-game'

        expect: "The title to be a known value"
            title == 'Vivasa Demo'

        when:
            to GameListPage
        then:
            currentUrl.endsWith("/game/index")
        and:
            title == 'Game List'

        when:
            createButton.click()
        then:
            at NewGamePage

        when:
            name = "${System.currentTimeMillis()}"
            publisher = "Ubisoft"
            platform = "X360"
            createButton.click()
        then:
            $('div.message').text().startsWith("Game")
            $('li.fieldcontain div',2).text() == 'Ubisoft'
    }

    RestBuilder restBuilder() {
        new RestBuilder()
    }
}

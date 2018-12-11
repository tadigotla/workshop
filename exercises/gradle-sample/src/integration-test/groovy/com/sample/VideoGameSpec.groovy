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

    }

    def cleanupSpec(){

    }

    def setup() {
        System.setProperty("geb.build.baseUrl", "http://ide2.vivasa.in:34979");
    }

    def cleanup() {
    }

    void "Test the homepage"() {
        given: "I am at the game list page"
            go '/game/index'

        expect: "The title to be a known value"
            $('h1').text() == 'Game List0'
    }

    void "TEst 2"(){

    }

    void "test 3"(){

    }


    RestBuilder restBuilder() {
        new RestBuilder()
    }
}

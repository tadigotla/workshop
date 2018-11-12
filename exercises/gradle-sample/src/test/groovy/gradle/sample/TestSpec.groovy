package gradle.sample

import org.grails.testing.GrailsUnitTest
import spock.lang.Specification
import com.sample.ExcelClient

class TestSpec extends Specification implements GrailsUnitTest {

    def setup() {
    }

    def cleanup() {
    }

    void "I want to validate if my ExcelClient reads the excel file correctly"() {
        when:"I call readExcel with my input"
            def result = ExcelClient.readExcel(new File("/projects/workshop/rich_text_stress.xlsx"))
        then:"The return value is not null"
            result != null
        and:"there is some valid data in the returned response"
            result.size() > 0
            result[0][0].getRawValue() == "normal"
    }
}